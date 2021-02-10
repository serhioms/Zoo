
select * from(
SELECT t.table_name, c.column_name, max(c.data_length) max
FROM user_tab_cols c, all_tables t 
WHERE t.owner = 'OWNER' and t.table_name = c.table_name
and t.table_name not in ('LIST', 'OF', 'EXCLUSIONS', 'TABLES')
and c.column_name not in ('LIST', 'OF', 'EXCLUSIONS', 'COLUMNS')
group by t.table_name, c.column_name
) order by max desc;

select * from(
SELECT round(c.data_length+50,-2) data_length, count(*) count
FROM user_tab_cols c, all_tables t 
WHERE t.owner = 'OWNER' and t.table_name = c.table_name
and t.table_name not in ('LIST', 'OF', 'EXCLUSIONS', 'TABLES')
and c.column_name not in ('LIST', 'OF', 'EXCLUSIONS', 'COLUMNS')
group by round(c.data_length+50,-2)
) order by data_length desc;

select * from(
SELECT round(c.data_length+50,-2) data_length, count(*) count 
FROM user_tab_cols c, all_tables t
WHERE t.owner = 'OWNER' and t.table_name = c.table_name 
group by round(c.data_length+50,-2) 
)order by data_length desc;

