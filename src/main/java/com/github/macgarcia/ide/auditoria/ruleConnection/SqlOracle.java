package com.github.macgarcia.ide.auditoria.ruleConnection;

/**
 *
 * @author macgarcia
 */
public final class SqlOracle {
    
    public static final String QUERY_NAME_AND_COLUMNS_ALL_TABLES = 
            "select ut.table_name name "
            + "     , count(utc.column_name) nr_columns "

            + "  from user_tables ut "
            + "  left join user_tab_columns utc on (utc.table_name = ut.table_name) "

            + " group by ut.table_name";
    
    public static final String QUERY_COUNT_ROWS = 
            "select count(*) from %s";
    
}
