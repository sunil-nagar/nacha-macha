package nm.fbqs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FBQueueSystem {

    private String originDir;
    private List<String> inboundQueue;
    private String current;

    public FBQueueSystem(String originDir) {
        this.originDir = originDir;
    }

    public void init() throws IOException {
        // copy files from source to inbound
        FileUtils.copyFiles(originDir, Config.INBOUND_DIR);
        // Create list of files to process
        this.inboundQueue = new ArrayList<String>(Arrays.asList(FileUtils.listFiles(Config.INBOUND_DIR)));
    }

    public String next() {
        System.out.println("next "+inboundQueue.size());
        if (inboundQueue.isEmpty()) 
            return null;
        current = inboundQueue.removeFirst();
        return current;
    }

    public void fail() throws IOException {
        FileUtils.moveFile(current, Config.FAILOVER_DIR);
    }

    public void complete() throws IOException {
        FileUtils.moveFile(current, Config.COMPLETE_DIR);
    }

    public boolean hasFailures() {
        return FileUtils.listFiles(Config.FAILOVER_DIR).length > 0;
    }

    public void initFailover() throws IOException {
        // copy files from source to inbound
        FileUtils.moveFiles(Config.FAILOVER_DIR, Config.INBOUND_DIR);
        // Create list of files to process
        this.inboundQueue = new ArrayList<String>(Arrays.asList(FileUtils.listFiles(Config.INBOUND_DIR)));

    }


}
