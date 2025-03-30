package nm.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import nm.model.NachaFileHeader;
import nm.utils.Log;

public class DbService {

	private static final Log log = new Log(DbService.class);

	private DbConnection dbconn;

	public DbService(DbConnection dbconn) {
		this.dbconn = dbconn;
	}


	public int createFileHeader(int fileId, NachaFileHeader header) throws SQLException {
		String sql = """
			INSERT INTO file_header
				(file_id, record_type_code, priority_code, immediate_destination, immediate_origin,
				file_creation_date, file_creation_time, file_id_modifier, record_size, blocking_factor,
				format_code, immediate_destination_name, immediate_origin_name, reference_code)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);""";
		PreparedStatement pstmt = dbconn.connect().prepareStatement(sql);
		pstmt.setInt(1, fileId);
		pstmt.setString(2, header.getRecordTypeCode());
		pstmt.setString(3, header.getPriorityCode());
		pstmt.setString(4, header.getImmediateDestination());
		pstmt.setString(5, header.getImmediateOrigin());
		pstmt.setString(6, header.getFileCreationDate());
		pstmt.setString(7, header.getFileCreationTime());
		pstmt.setString(8, header.getFileIdModifier());
		pstmt.setString(9, header.getRecordSize());
		pstmt.setString(10, header.getBlockingFactor());
		pstmt.setString(11, header.getFormatCode());
		pstmt.setString(12, header.getImmediateDestinationName());
		pstmt.setString(13, header.getImmediateOriginName());
		pstmt.setString(14, header.getReferenceCode());		
		return pstmt.executeUpdate();
	}

}
