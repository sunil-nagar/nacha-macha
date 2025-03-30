package nm.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import nm.model.NachaFileBatchFooter;
import nm.model.NachaFileBatchHeader;
import nm.model.NachaFileFooter;
import nm.model.NachaFileHeader;
import nm.model.NachaFileTransaction;
// import nm.utils.Log;

public class DbInsertService {

	// private static final Log log = new Log(DbService.class);

	private DbConnection dbconn;

	public DbInsertService(DbConnection dbconn) {
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

	public int createFileBatchHeader(int fileId, int fileBatchId, NachaFileBatchHeader batchHeader)
			throws SQLException {
		String sql = """
				INSERT INTO file_batch_header
				(file_id, file_batch_id, record_type_code, service_class_code, company_name,
				company_discretionary_data, company_identification, standard_entryclass_code,
				company_entry_description, company_descriptive_date, effective_entry_date, reserved,
				origin_status_code, originating_dfi_id, batch_number)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);""";
		PreparedStatement pstmt = dbconn.connect().prepareStatement(sql);
		pstmt.setInt(1, fileId);
		pstmt.setInt(2, fileBatchId);
		pstmt.setString(3, batchHeader.getRecordTypeCode());
		pstmt.setString(4, batchHeader.getServiceClassCode());
		pstmt.setString(5, batchHeader.getCompanyName());
		pstmt.setString(6, batchHeader.getCompanyDiscretionaryData());
		pstmt.setString(7, batchHeader.getCompanyIdentification());
		pstmt.setString(8, batchHeader.getStandardEntryClassCode());
		pstmt.setString(9, batchHeader.getCompanyEntryDescription());
		pstmt.setString(10, batchHeader.getCompanyDescriptiveDate());
		pstmt.setString(11, batchHeader.getEffectiveEntryDate());
		pstmt.setString(12, batchHeader.getReserved());
		pstmt.setString(13, batchHeader.getOriginStatusCode());
		pstmt.setString(14, batchHeader.getOriginatingDFIId());
		pstmt.setString(15, batchHeader.getBatchNumber());
		return pstmt.executeUpdate();
	}

	public int createFileTransaction(int fileId, int fileBatchId, NachaFileTransaction transaction)
			throws SQLException {
		System.out.println(transaction);
		String sql = """
				INSERT INTO file_transaction
				(file_id, file_batch_id, record_type_code, transaction_code, receiving_dfi_id,
				check_digit, dfi_account_number, transaction_amount, identification_number,
				receiving_company_name, discretionary_data, addenda_record_indicator, trace_number)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);""";
		PreparedStatement pstmt = dbconn.connect().prepareStatement(sql);
		pstmt.setInt(1, fileId);
		pstmt.setInt(2, fileBatchId);
		pstmt.setString(3, transaction.getRecordTypeCode());
		pstmt.setString(4, transaction.getTransactionCode());
		pstmt.setString(5, transaction.getReceivingDFIId());
		pstmt.setString(6, transaction.getCheckDigit());
		pstmt.setString(7, transaction.getDfiAccountNumber());
		pstmt.setString(8, transaction.getTransactionAmount());
		pstmt.setString(9, transaction.getIdentificationNumber());
		pstmt.setString(10, transaction.getReceivingCompanyName());
		pstmt.setString(11, transaction.getDiscretionaryData());
		pstmt.setString(12, transaction.getAddendaRecordIndicator());
		pstmt.setString(13, transaction.getTraceNumber());
		return pstmt.executeUpdate();
	}

	public int createFileBatchFooter(int fileId, int fileBatchId, NachaFileBatchFooter batchFooter)
			throws SQLException {
		String sql = """
				INSERT INTO file_batch_footer
				(file_id, file_batch_id, record_type_code, service_class_code, entry_addenda_count,
				entry_hash, total_debit_entry, total_credit_entry, company_identification,
				message_authentication_code, reserved, originating_dfi_id, batch_number)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);""";
		PreparedStatement pstmt = dbconn.connect().prepareStatement(sql);
		pstmt.setInt(1, fileId);
		pstmt.setInt(2, fileBatchId);
		pstmt.setString(3, batchFooter.getRecordTypeCode());
		pstmt.setString(4, batchFooter.getServiceClassCode());
		pstmt.setString(5, batchFooter.getEntryAddendaCount());
		pstmt.setString(6, batchFooter.getEntryHash());
		pstmt.setString(7, batchFooter.getTotalDebitEntry());
		pstmt.setString(8, batchFooter.getTotalCreditEntry());
		pstmt.setString(9, batchFooter.getCompanyIdentification());
		pstmt.setString(10, batchFooter.getMessageAuthenticationCode());
		pstmt.setString(11, batchFooter.getReserved());
		pstmt.setString(12, batchFooter.getOriginatingDFIId());
		pstmt.setString(13, batchFooter.getBatchNumber());
		return pstmt.executeUpdate();
	}

	public int createFileFooter(int fileId, NachaFileFooter footer) throws SQLException {
		String sql = """
				INSERT INTO file_footer
				(file_id, record_type_code, batch_count, block_count, entry_addenda_count, entry_hash,
				total_debit_entry, total_credit_entry, reserved)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
				""";
		PreparedStatement pstmt = dbconn.connect().prepareStatement(sql);
		pstmt.setInt(1, fileId);
		pstmt.setString(2, footer.getRecordTypeCode());
		pstmt.setString(3, footer.getBatchCount());
		pstmt.setString(4, footer.getBlockCount());
		pstmt.setString(5, footer.getEntryAddendaCount());
		pstmt.setString(6, footer.getEntryHash());
		pstmt.setString(7, footer.getTotalDebitEntry());
		pstmt.setString(8, footer.getTotalCreditEntry());
		pstmt.setString(9, footer.getReserved());
		return pstmt.executeUpdate();
	}
}
