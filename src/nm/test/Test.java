package nm.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;

import nm.db.DbConnection;
import nm.db.DbService;
import nm.model.NachaFileTransaction;
import nm.parse.NachaFileLine;
import nm.parse.NachaLineParser;
import nm.utils.RandomException;
import nm.utils.Timer;

public class Test {

    public static void processFile(String filePath, DbConnection dbconn, DbService dbService) throws Exception {
        System.out.println("Processing file " + filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int fileId = 1;
            int batchId = 1;
            PreparedStatement transactionPstmt = dbService.createFileTransactionPstmt();
            while ((line = reader.readLine()) != null) {
                NachaFileLine nachaFileLine = NachaLineParser.parse(line);
                if (NachaFileLine.HEADER.equals(nachaFileLine.getType()))
                    fileId++;
                if (NachaFileLine.BATCH_HEADER.equals(nachaFileLine.getType()))
                    batchId++;
                if (nachaFileLine instanceof NachaFileTransaction) {
                    dbService.setFileTransactionPstmt(transactionPstmt, fileId, batchId,
                            (NachaFileTransaction) nachaFileLine);
                    transactionPstmt.addBatch();
                } else {
                    PreparedStatement pstmt = dbService.prepare(fileId, batchId, nachaFileLine);
                    pstmt.execute();
                }
            }
            RandomException.randomReject();
            transactionPstmt.executeBatch();
            dbconn.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Timer.start("main");
            String dbfile = "/Users/nagars/Dev/nacha-macha/house.db";
            DbConnection dbconn = new DbConnection(dbfile);
            dbconn.connect();
            dbconn.setAutoCommit(false);
            DbService dbService = new DbService(dbconn);
            Timer.start("reset");
            dbService.reset();
            Timer.stop("reset");
            String[] files = NachaParser.getFiles("20250330", "001");
            String nachaFileDir = "/Users/nagars/Dev/nacha-macha/testfiles/";
            for (int i = 0; i < files.length; i++) {
                Timer.start("file");
                String filename = files[i];
                String filePath = nachaFileDir + "/" + filename;
                processFile(filePath, dbconn, dbService);
                Timer.stop("file");
            }
            Timer.stop("main");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}