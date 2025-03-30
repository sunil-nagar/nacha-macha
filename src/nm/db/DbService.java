package nm.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import nm.model.NachaFileBatchFooter;
import nm.model.NachaFileBatchHeader;
import nm.model.NachaFileFooter;
import nm.model.NachaFileHeader;
import nm.model.NachaFileTransaction;
import nm.parse.NachaFileLine;

public class DbService {

    private DbConnection dbconn;

    private DbInsertService dbInsertService;

    public DbService(DbConnection dbconn) {
        this.dbconn = dbconn;
        dbInsertService = new DbInsertService(dbconn);
    }

    public int reset() throws SQLException, Exception {
        dbconn.execute("DELETE FROM file_header;");
        dbconn.execute("DELETE FROM file_batch_header;");
        dbconn.execute("DELETE FROM file_transaction;");
        dbconn.execute("DELETE FROM file_batch_footer;");
        dbconn.execute("DELETE FROM file_footer;");
        return 0;
    }

    public PreparedStatement prepare(int fileId, int batchId, NachaFileLine fileLine) throws SQLException {
        if (fileLine instanceof NachaFileHeader)
            return dbInsertService.createFileHeader(fileId, (NachaFileHeader) fileLine);
        else if (fileLine instanceof NachaFileBatchHeader)
            return dbInsertService.createFileBatchHeader(fileId, batchId, (NachaFileBatchHeader) fileLine);
        else if (fileLine instanceof NachaFileBatchFooter)
            return dbInsertService.createFileBatchFooter(fileId, batchId, (NachaFileBatchFooter) fileLine);
        else if (fileLine instanceof NachaFileFooter)
            return dbInsertService.createFileFooter(fileId, (NachaFileFooter) fileLine);
        return null;

    }

    public PreparedStatement createFileTransactionPstmt() throws SQLException {
        return dbInsertService.createFileTransactionPstmt();
    }

    public void setFileTransactionPstmt(PreparedStatement transactionPstmt, int fileId, int batchId,
            NachaFileTransaction nachaFileLine) throws SQLException {
        dbInsertService.setFileTransactionPstmt(transactionPstmt, fileId, batchId, nachaFileLine);
    }

}
