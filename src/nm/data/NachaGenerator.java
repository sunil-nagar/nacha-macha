package src.nm.data;

import java.io.IOException;

import src.nm.io.FileUtils;
import src.nm.model.NachaFileBatchFooter;
import src.nm.model.NachaFileBatchHeader;
import src.nm.model.NachaFileFooter;
import src.nm.model.NachaFileHeader;
import src.nm.model.NachaFileTransaction;

public class NachaGenerator {

    public static void main(String[] args) throws IOException {
        StringBuffer buffer = new StringBuffer();
        DataGenerator dataGenerator = new DataGenerator();
        for (int i = 0; i < 26; i++) {
            NachaFileHeader header = new NachaFileHeader(i);
            buffer.append(header.toString() + "\n");
            int batches = dataGenerator.number(2, 9);
            for (int j = 0; j < batches; j++) {
                NachaFileBatchHeader batchHeader = new NachaFileBatchHeader();
                buffer.append(batchHeader.toString() + "\n");
                int transactions = dataGenerator.number(99, 999);
                for (int k = 0; k < transactions; k++) {
                    NachaFileTransaction transaction = new NachaFileTransaction();
                    buffer.append(transaction.toString() + "\n");
                }
                NachaFileBatchFooter batchFooter = new NachaFileBatchFooter();
                buffer.append(batchFooter.toString() + "\n");
            }
            NachaFileFooter footer = new NachaFileFooter();
            buffer.append(footer.toString() + "\n");
        }
        //System.out.println(buffer);
        FileUtils.write("nacha-file-test-1.txt", buffer);
    }

}

