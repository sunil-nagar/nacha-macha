package nm.db;

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

    public int insert(int fileId, int batchId, NachaFileLine fileLine) throws SQLException {
        if (fileLine instanceof NachaFileHeader)
            return dbInsertService.createFileHeader(fileId, (NachaFileHeader) fileLine);
        else if (fileLine instanceof NachaFileBatchHeader)
            return dbInsertService.createFileBatchHeader(fileId, batchId, (NachaFileBatchHeader) fileLine);
        else if (fileLine instanceof NachaFileTransaction)
            return dbInsertService.createFileTransaction(fileId, batchId, (NachaFileTransaction) fileLine);
        else if (fileLine instanceof NachaFileBatchFooter)
            return dbInsertService.createFileBatchFooter(fileId, batchId, (NachaFileBatchFooter) fileLine);
        else if (fileLine instanceof NachaFileFooter)
            return dbInsertService.createFileFooter(fileId, (NachaFileFooter) fileLine);
        return -1;

    }

}
