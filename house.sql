DELETE FROM file_header; 
DELETE FROM file_batch_header; 
DELETE FROM file_transaction; 
DELETE FROM file_batch_footer; 
DELETE FROM file_footer;  


SELECT COUNT(id) FROM file_transaction ft 


SELECT * FROM file_header

SELECT * FROM file_batch_header

SELECT * FROM file_transaction

SELECT * FROM file_batch_footer

SELECT * FROM file_footer

SELECT id, file_id 
FROM file_header 
WHERE record_type_code = '1' AND priority_code = '01' AND immediate_destination = ' 775037785' AND 
	immediate_origin = '1703555713' AND file_creation_date = '250421' AND file_creation_time = '0038' AND 
	file_id_modifier = 'B' AND record_size = '094' AND blocking_factor = '10' AND format_code = '1' 
	AND immediate_destination_name = 'Washington Bank        ' AND immediate_origin_name = 'Progressive            ' 



INSERT INTO file_header
  (id, file_id, record_type_code, priority_code, immediate_destination, immediate_origin, 
  file_creation_date, file_creation_time, file_id_modifier, record_size, blocking_factor, 
  format_code, immediate_destination_name, immediate_origin_name, reference_code)
VALUES(0, 0, '', '', '', '', '', '', '', '', '', '', '', '', '');


INSERT INTO file_batch_header
(id, file_id, file_batch_id, record_type_code, service_class_code, company_name, 
company_discretionary_data, company_identification, standard_entryclass_code, 
company_entry_description, company_descriptive_date, effective_entry_date, reserved, 
origin_status_code, originating_dfi_id, batch_number)
VALUES(0, 0, 0, '', '', '', '', '', '', '', '', '', '', '', '', '');


INSERT INTO file_transaction
(id, file_id, file_batch_id, record_type_code, transaction_code, receiving_dfi_id, 
check_digit, dfi_account_number, transaction_amount, identification_number, 
receiving_company_name, discretionary_data, addenda_record_indicator, trace_number)
VALUES(0, 0, 0, '', '', '', '', '', '', '', '', '', '', '');


INSERT INTO file_batch_footer
(id, file_id, file_batch_id, record_type_code, service_class_code, entry_addenda_count, 
entry_hash, total_debit_entry, total_credit_entry, company_identification, 
message_authentication_code, reserved, originating_dfi_id, batch_number)
VALUES(0, 0, 0, '', '', '', '', '', '', '', '', '', '', '');


INSERT INTO file_footer
(id, file_id, record_type_code, batch_count, block_count, entry_addenda_count, entry_hash,
total_debit_entry, total_credit_entry, reserved)
VALUES(0, 0, '', '', '', '', '', '', '', '');



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
					reference_code TEXT(8))
					
					
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
					batch_number TEXT(7))
					

CREATE TABLE IF NOT EXISTS file_transaction
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
					trace_number TEXT(15))
					
					
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
					batch_number TEXT(7))
					
					
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
					reserved TEXT(39))
