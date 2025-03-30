package nm.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import nm.db.DbConnection;
import nm.db.DbInsertService;
import nm.db.DbService;
import nm.parse.NachaFileLine;
import nm.parse.NachaLineParser;

public class Test {

    public static void main(String[] args) throws SQLException {
        String dbfile = "/Users/nagars/Dev/nacha-macha/house.db";
        DbConnection dbconn = new DbConnection(dbfile);
        DbService dbService = new DbService(dbconn);

        String[] files = NachaParser.getFiles("20250330", "001");
        String nachaFileDir = "/Users/nagars/Dev/nacha-macha/testfiles/";
        for (int i = 0; i < 1; i++) {
            String filename = files[i];
            String filePath = nachaFileDir + "/" + filename;
            System.out.println("Reading " + filePath);
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int fileId = 1;
                int batchId = 1;
                while ((line = reader.readLine()) != null) {
                    NachaFileLine nachaFileLine = NachaLineParser.parse(line);
                    if (NachaFileLine.HEADER.equals(nachaFileLine.getType()))
                        fileId++;
                    if (NachaFileLine.BATCH_HEADER.equals(nachaFileLine.getType()))
                        batchId++;
                    dbService.insert(fileId, batchId, nachaFileLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
