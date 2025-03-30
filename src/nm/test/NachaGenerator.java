package nm.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import nm.data.DataGenerator;
import nm.io.FileUtils;
import nm.model.NachaFileBatchFooter;
import nm.model.NachaFileBatchHeader;
import nm.model.NachaFileFooter;
import nm.model.NachaFileHeader;
import nm.model.NachaFileTransaction;

public class NachaGenerator {

    public static void main(String[] args) throws IOException {

        String nachaFileDir = "/Users/nagars/Dev/nacha-macha/testfiles/";
        String nachaFileName = "ACHFile-{date}-{run}-{modifier}.txt";

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate date = LocalDate.now();
        String textdate = date.format(formatter);

        String filebase = nachaFileDir + nachaFileName;
        filebase = filebase.replace("{date}", textdate);

        filebase = filebase.replace("{run}", "001");

        DataGenerator dataGenerator = new DataGenerator();
        for (int i = 0; i < 26; i++) {
            String filename = filebase.replace("{modifier}", dataGenerator.letter(i));
            System.out.println("Running modifier " + i + " " + filename);
            StringBuffer buffer = new StringBuffer();
            NachaFileHeader header = new NachaFileHeader(i);
            buffer.append(header.toString() + "\n");
            int batches = dataGenerator.number(20, 80);
            for (int j = 0; j < batches; j++) {
                NachaFileBatchHeader batchHeader = new NachaFileBatchHeader();
                buffer.append(batchHeader.toString() + "\n");
                int transactions = dataGenerator.number(7999, 9999);
                for (int k = 0; k < transactions; k++) {
                    NachaFileTransaction transaction = new NachaFileTransaction();
                    buffer.append(transaction.toString() + "\n");
                }
                NachaFileBatchFooter batchFooter = new NachaFileBatchFooter();
                buffer.append(batchFooter.toString() + "\n");
            }
            NachaFileFooter footer = new NachaFileFooter();
            buffer.append(footer.toString() + "\n");
            FileUtils.write(filename, buffer);
        }

    }

}
