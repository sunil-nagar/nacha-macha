package nm.db;

import java.sql.SQLException;
import java.sql.Statement;

import nm.utils.Log;

public class DbInitialize {

	private static final Log log = new Log(DbInitialize.class);

	private DbConnection dbconn;

	public DbInitialize(DbConnection dbconn) throws Exception {
		this.dbconn = dbconn;
	}

	public void createUserTable() throws SQLException, Exception {
		String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, uid TEXT, email TEXT, last_updated TEXT)";
		execute(sql);
	}

	public void deleteUserTable() throws SQLException, Exception {
		String sql = "DELETE FROM users";
		execute(sql);
	}

	public void createGroupTable() throws SQLException, Exception {
		String sql = "CREATE TABLE IF NOT EXISTS groups (id INTEGER PRIMARY KEY AUTOINCREMENT, source TEXT, environment TEXT, group_name TEXT, last_updated TEXT)";
		execute(sql);
	}

	public void deleteGroupTable() throws SQLException, Exception {
		String sql = "DELETE FROM groups";
		execute(sql);
	}

	public void createUserGroupTable() throws SQLException, Exception {
		String sql = "CREATE TABLE IF NOT EXISTS user_group (user_id TEXT, group_id INTEGER)";
		execute(sql);
	}

	public void deleteUserGroupTable() throws SQLException, Exception {
		String sql = "DELETE FROM user_group";
		execute(sql);
	}

	private void execute(String sql) throws SQLException, Exception {
		log.debug("execute", sql);
		Statement stmt = this.dbconn.connect().createStatement();
		System.out.println("Executing " + sql);
		stmt.execute(sql);
		stmt.close();
	}

}
