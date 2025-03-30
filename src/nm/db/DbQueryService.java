package nm.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import nm.utils.Log;

public class DbQueryService {

	private static final Log log = new Log(DbQueryService.class);

	private static final String SELECT_GROUP_USERCOUNT = "SELECT g.group_name, COUNT(u.uid), g.last_updated \n"
			+ "FROM users u, groups g, user_group ug \n" + "WHERE u.uid = ug.user_id  \n" + "AND g.id = ug.group_id \n"
			+ "AND UPPER(g.group_name) like UPPER(?) \n" + "GROUP BY g.group_name \n" + "ORDER BY COUNT(u.uid) DESC";

	private DbConnection dbconn;

	public DbQueryService(DbConnection dbconn) {
		this.dbconn = dbconn;
	}

	/*
	public ArrayList<GroupUserCount> selectGroupUserCount(String group) throws Exception {
		ArrayList<GroupUserCount> response = new ArrayList<GroupUserCount>();
		PreparedStatement pstmt = dbconn.connect().prepareStatement(SELECT_GROUP_USERCOUNT);
		String groupName = group.replace(".*", "%");
		pstmt.setString(1, groupName);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String g = rs.getString(1);
			int c = rs.getInt(2);
			String lu = rs.getString(3);
			GroupUserCount guc = new GroupUserCount(g, c, lu);
			response.add(guc);
		}
		if (response.size() == 0) {
			GroupUserCount guc = new GroupUserCount(group, -1, "");
			response.add(guc);
		}
		return response;
	}
		 */

}
