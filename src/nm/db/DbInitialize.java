package nm.db;

import java.sql.SQLException;
// import java.sql.Statement;

// import nm.utils.Log;

public class DbInitialize {

	// private static final Log log = new Log(DbInitialize.class);

	private DbConnection dbconn;

	public DbInitialize(DbConnection dbconn) throws Exception {
		this.dbconn = dbconn;
	}

	// ALTER TABLE NewTable ADD Column3 TEXT(5);
	public void createFileHeaderTable() throws SQLException, Exception {
		String sql = """
				CREATE TABLE IF NOT EXISTS file_header
					(id INTEGER PRIMARY KEY AUTOINCREMENT,
					file_id INTEGER,
					record_type_code TEXT(1),
					priority_code TEXT(2),
					immediate_destination TEXT(10),
					immediate_origin TEXT(10),
					file_creation_date TEXT(6),
					file_creation_time TEXT(4),
					file_id_modifier TEXT(1),
					record_size TEXT(3),
					blocking_factor TEXT(2),
					format_code TEXT(1),
					immediate_destination_name TEXT(23),
					immediate_origin_name TEXT(23),
					reference_code TEXT(8))""";
		dbconn.execute(sql);
	}

	public void createFileBatchHeaderTable() throws SQLException, Exception {
		String sql = """
				CREATE TABLE IF NOT EXISTS file_batch_header
					(id INTEGER PRIMARY KEY AUTOINCREMENT,
					file_id INTEGER,
					file_batch_id INTEGER,
					record_type_code TEXT(1),
					service_class_code TEXT(3),
					company_name TEXT(16),
					company_discretionary_data TEXT(20),
					company_identification TEXT(10),
					standard_entryclass_code TEXT(3),
					company_entry_description TEXT(10),
					company_descriptive_date TEXT(6),
					effective_entry_date TEXT(6),
					reserved TEXT(3),
					origin_status_code TEXT(1),
					originating_dfi_id TEXT(8),
					batch_number TEXT(7))""";
		dbconn.execute(sql);
	}

	public void createFileTransactionTable() throws SQLException, Exception {
		String sql = """
				CREATE TABLE IF NOT EXISTS transaction
					(id INTEGER PRIMARY KEY AUTOINCREMENT,
					file_id INTEGER,
					file_batch_id INTEGER,
					record_type_code TEXT(1),
					transaction_code TEXT(2),
					receiving_dfi_id TEXT(8),
					check_digit TEXT(1),
					dfi_account_number TEXT(17),
					transaction_amount TEXT(10),
					identification_number TEXT(15),
					receiving_company_name TEXT(22),
					discretionary_data TEXT(2),
					addenda_record_indicator TEXT(1),
					trace_number TEXT(15))""";
		dbconn.execute(sql);
	}

	public void createFileBatchFooterTable() throws SQLException, Exception {
		String sql = """
				CREATE TABLE IF NOT EXISTS file_batch_footer
					(id INTEGER PRIMARY KEY AUTOINCREMENT,
					file_id INTEGER,
					file_batch_id INTEGER,
					record_type_code TEXT(1),
					service_class_code TEXT(3),
					entry_addenda_count TEXT(6),
					entry_hash TEXT(10),
					total_debit_entry TEXT(12),
					total_credit_entry TEXT(12),
					company_identification TEXT(10),
					message_authentication_code TEXT(19),
					reserved TEXT(6),
					originating_dfi_id TEXT(8),
					batch_number TEXT(7))""";
		dbconn.execute(sql);
	}

	public void createFileFooterTable() throws SQLException, Exception {
		String sql = """
				CREATE TABLE IF NOT EXISTS file_footer
					(id INTEGER PRIMARY KEY AUTOINCREMENT,
					file_id INTEGER,
					record_type_code TEXT(1),
					batch_count TEXT(6),
					block_count TEXT(6),
					entry_addenda_count TEXT(8),
					entry_hash TEXT(10),
					total_debit_entry TEXT(12),
					total_credit_entry TEXT(12),
					reserved TEXT(39))""";
		dbconn.execute(sql);
	}

}
