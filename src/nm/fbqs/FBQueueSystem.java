package nm.fbqs;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FBQueueSystem {

    private String originDir;
    private List<String> inboundQueue;
    private String current;

    public FBQueueSystem(String originDir) {
        this.originDir = originDir;
    }

    public String next() {
        if (inboundQueue.isEmpty()) return null;
        current = inboundQueue.removeFirst();
        return current;
    }

    public void fail() throws IOException {
        FileUtils.moveFile(current, Config.FAILOVER_DIR);
    }

    public void complete() throws IOException {
        FileUtils.moveFile(current, Config.FAILOVER_DIR);
    }

    public void init() throws IOException {
        // copy files from source to inbound
        FileUtils.copyFiles(originDir, Config.INBOUND_DIR);
        // Create list of files to process
        this.inboundQueue = Arrays.asList(FileUtils.listFiles(Config.INBOUND_DIR));
    }

}
