package nm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nm.utils.Log;

public class DbBatch {

	private static final Log log = new Log(DbBatch.class);

	private int current;
	private int batchSize;

	private String sql;	
	private Connection conn;
	private PreparedStatement pstmt;

	public DbBatch(Connection conn, String sql, int batchSize) throws SQLException {
		this.current = 0;
		this.batchSize = batchSize;
		this.sql = sql;
		this.conn = conn;
		this.conn.setAutoCommit(false);
		this.pstmt = conn.prepareStatement(sql);
	}

	public PreparedStatement pstmt() {
		return pstmt;
	}

	public void addBatch() throws SQLException {
		log.debug("addBatch", sql, "current", current);
		pstmt.addBatch();
		current++;
		if (current % batchSize == 0)
			commit();
	}

	private void commit() throws SQLException {
		int[] result = pstmt.executeBatch();
		log.info("commit", sql, "inserted", result.length, "rows");
		conn.commit();
	}

	public void finalize() throws SQLException {
		log.info("finalize", sql);
		commit();
		pstmt.close();
		// conn.close();
	}

}
