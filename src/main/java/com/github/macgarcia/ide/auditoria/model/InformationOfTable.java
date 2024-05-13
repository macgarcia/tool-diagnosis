package com.github.macgarcia.ide.auditoria.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author macgarcia
 */
@Getter @Setter @ToString
public class InformationOfTable {
    
    private String tableName;
    private Long qtdRow;
    private Long qtdColumn;

    public InformationOfTable(ResultSet result) throws SQLException {
        this.tableName = result.getString("name");
        this.qtdColumn = result.getLong("nr_columns");
    }
    
}
