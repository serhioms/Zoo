
select * from(
SELECT t.table_name, c.column_name, max(c.data_length) max
FROM user_tab_cols c, all_tables t 
WHERE t.owner = 'CTRMSO' and t.table_name = c.table_name
and t.table_name not in ('RUN_INFORMATION_O','FILE_O','CONFIG_FILE','AUDIT_O','ERROR_F','CTRDB_METADATA_O','LOG_O','BAD_L','CONFIG_FILE_HISTORY','TEMP_GENERIC','EXCEPTION_O','ERROR_ATTRIBUTE_F','STANDARD_EXCEPTION_O')
and c.column_name not in ('HASH_D_VAL','REJECT_ERROR_MSG','EXCEPTION_DESC','KEY_CONTACT_PERSON_NAME')
group by t.table_name, c.column_name
) order by max desc;

select * from(
SELECT round(c.data_length+50,-2) data_length, count(*) count
FROM user_tab_cols c, all_tables t 
WHERE t.owner = 'CTRMSO' and t.table_name = c.table_name
and t.table_name not in ('RUN_INFORMATION_O','FILE_O','CONFIG_FILE','AUDIT_O','ERROR_F','CTRDB_METADATA_O','LOG_O','BAD_L','CONFIG_FILE_HISTORY','TEMP_GENERIC','EXCEPTION_O','ERROR_ATTRIBUTE_F','STANDARD_EXCEPTION_O')
and c.column_name not in ('HASH_D_VAL','REJECT_ERROR_MSG','EXCEPTION_DESC','KEY_CONTACT_PERSON_NAME')
group by round(c.data_length+50,-2)
) order by data_length desc;

select * from(
SELECT round(c.data_length+50,-2) data_length, count(*) count 
FROM user_tab_cols c, all_tables t
WHERE t.owner = 'CTRMSO' and t.table_name = c.table_name 
group by round(c.data_length+50,-2) 
)order by data_length desc;


SELECT ROUND(175+51,-2) "Round" FROM DUAL;
