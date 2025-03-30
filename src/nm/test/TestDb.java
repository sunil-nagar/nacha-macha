package nm.test;

import java.sql.SQLException;

import nm.db.DbConnection;
import nm.db.DbService;
import nm.model.NachaFileHeader;

public class TestDb {

    public static void main(String[] args) throws SQLException {
        String dbfile = "/Users/nagars/Dev/nacha-macha/house.db";
        DbConnection dbconn = new DbConnection(dbfile);
        DbService dbService = new DbService(dbconn);
        NachaFileHeader header = new NachaFileHeader(1);
        dbService.createFileHeader(1, header);
    }
}
