package nm.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import nm.utils.Log;

public class DbService {

	private static final Log log = new Log(DbService.class);

	/*
	public String createUserSql() {
		String sql = "INSERT INTO users(uid, email, last_updated) VALUES(?, ?, ?);";
		return sql;
	}

	public PreparedStatement createUserStatement(PreparedStatement pstmt, User u) throws SQLException {
		log.debug("createUserStatement", u);
		pstmt.setString(1, u.getUid());
		pstmt.setString(2, u.getEmail());
		pstmt.setString(3, u.getLastUpdated());
		return pstmt;
	}

	public String createGroupSql() {
		String sql = "INSERT INTO groups (source, environment, group_name, last_updated) VALUES(?, ?, ?, ?);";
		return sql;
	}

	public PreparedStatement createGroupStatement(PreparedStatement pstmt, Group g) throws SQLException {
		log.debug("createGroupStatement", g);
		pstmt.setString(1, g.getSource());
		pstmt.setString(2, g.getEnvironment());
		pstmt.setString(3, g.getGroupName());
		pstmt.setString(4, g.getLastUpdated());
		return pstmt;
	}

	public String createUserGroupSql() {
		String sql = "INSERT INTO user_group (user_id, group_id) VALUES(?, ?);";
		return sql;
	}

	public PreparedStatement createUserGroupStatement(PreparedStatement pstmt, String userId, int groupId)
			throws SQLException {
		log.debug("createUserGroupStatement", userId, groupId);
		pstmt.setString(1, userId);
		pstmt.setInt(2, groupId);
		return pstmt;
	}
		 */

	// public String createUserGroupFromGroupNameSql() {
	// String sql = "INSERT INTO user_group(user_id, group_id) VALUES(?, (SELECT id
	// FROM groups WHERE group_name = ?));";
	// return sql;
	// }

	// public PreparedStatement
	// createUserGroupFromGroupNameStatement(PreparedStatement pstmt, int userId,
	// String groupName) throws SQLException {
	// pstmt.setInt(1, userId);
	// pstmt.setString(2, groupName);
	// return pstmt;
	// }

}
