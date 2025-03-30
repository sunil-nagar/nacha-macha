package nm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import nm.utils.Log;

public class DbConnection {

	private static final Log log = new Log(DbConnection.class);

	private String filename;
	private Connection conn;

	public DbConnection(String filename) throws SQLException {
		this.filename = filename;
	}

	public Connection connect() throws SQLException {
		log.debug("connect", "Connecting to", filename);
		if (conn == null) {
			String url = "jdbc:sqlite:" + filename;
			conn = DriverManager.getConnection(url);
		}
		return conn;
	}

}
