package nm.test;

import java.sql.SQLException;

import nm.db.DbConnection;
import nm.db.DbService;
import nm.model.NachaFileBatchHeader;
import nm.model.NachaFileHeader;
import nm.model.NachaFileTransaction;

public class TestDb {

    public static void main(String[] args) throws SQLException {
        String dbfile = "/Users/nagars/Dev/nacha-macha/house.db";
        DbConnection dbconn = new DbConnection(dbfile);
        DbService dbService = new DbService(dbconn);

        NachaFileHeader header = new NachaFileHeader(1);
        dbService.createFileHeader(1, header);

        NachaFileBatchHeader batchHeader = new NachaFileBatchHeader();
        dbService.createFileBatchHeader(1, 1, batchHeader);

        NachaFileTransaction transaction = new NachaFileTransaction();
        dbService.createFileTransaction(1, 1, transaction);

    }
}
