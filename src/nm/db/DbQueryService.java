package nm.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.ArrayList;

import nm.model.NachaFileHeader;

// import nm.utils.Log;

public class DbQueryService {

	// private static final Log log = new Log(DbQueryService.class);

	private DbConnection dbconn;

	public DbQueryService(DbConnection dbconn) {
		this.dbconn = dbconn;
	}

	public int getFileId(NachaFileHeader header) throws SQLException {
		int fileId = -1;
		String sql = """
				SELECT id, file_id
				FROM file_header
				WHERE record_type_code = ? AND priority_code = ? AND immediate_destination = ? AND
					immediate_origin = ? AND file_creation_date = ? AND file_creation_time = ? AND
					file_id_modifier = ? AND record_size = ? AND blocking_factor = ? AND format_code = ?
					AND immediate_destination_name = ? AND immediate_origin_name = ?
								""";
		PreparedStatement pstmt = dbconn.connect().prepareStatement(sql);
		pstmt.setString(1, header.getRecordTypeCode());
		pstmt.setString(2, header.getPriorityCode());
		pstmt.setString(3, header.getImmediateDestination());
		pstmt.setString(4, header.getImmediateOrigin());
		pstmt.setString(5, header.getFileCreationDate());
		pstmt.setString(6, header.getFileCreationTime());
		pstmt.setString(7, header.getFileIdModifier());
		pstmt.setString(8, header.getRecordSize());
		pstmt.setString(9, header.getBlockingFactor());
		pstmt.setString(10, header.getFormatCode());
		pstmt.setString(11, header.getImmediateDestinationName());
		pstmt.setString(12, header.getImmediateOriginName());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			fileId = rs.getInt(1);
		}
		return fileId;
	}

	/*
	 * public ArrayList<GroupUserCount> selectGroupUserCount(String group) throws
	 * Exception {
	 * ArrayList<GroupUserCount> response = new ArrayList<GroupUserCount>();
	 * PreparedStatement pstmt =
	 * dbconn.connect().prepareStatement(SELECT_GROUP_USERCOUNT);
	 * String groupName = group.replace(".*", "%");
	 * pstmt.setString(1, groupName);
	 * ResultSet rs = pstmt.executeQuery();
	 * while (rs.next()) {
	 * String g = rs.getString(1);
	 * int c = rs.getInt(2);
	 * String lu = rs.getString(3);
	 * GroupUserCount guc = new GroupUserCount(g, c, lu);
	 * response.add(guc);
	 * }
	 * if (response.size() == 0) {
	 * GroupUserCount guc = new GroupUserCount(group, -1, "");
	 * response.add(guc);
	 * }
	 * return response;
	 * }
	 */

}
