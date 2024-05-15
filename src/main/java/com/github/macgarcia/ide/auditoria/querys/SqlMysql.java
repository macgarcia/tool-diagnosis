package com.github.macgarcia.ide.auditoria.querys;

/**
 *
 * @author macgarcia
 */
public final class SqlMysql extends SqlCommon {
    
    public static final String QUERY_NAME_AND_COLUMNS_ALL_TABLES = 
            "  select t.table_name name, count(c.table_name) nr_columns "

            + "  from information_schema.tables t "
            + "  left join information_schema.columns c on(c.table_name = t.table_name) "

            + " where t.table_schema = ? "
            + "group by t.table_name";
    
}
