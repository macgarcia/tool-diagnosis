package com.github.macgarcia.ide.auditoria.dao;

import com.github.macgarcia.ide.auditoria.model.InformationOfTable;
import com.github.macgarcia.ide.auditoria.ruleConnection.ConnectionControl;
import com.github.macgarcia.ide.auditoria.querys.SqlMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macgarcia
 */
public class MysqlDAO implements GenericDAO {
    
    private String queryMysql;

    public MysqlDAO(String queryMysql) {
        this.queryMysql = queryMysql;
    }

    @Override
    public List<InformationOfTable> getInformationOfTable() throws SQLException {
        List<InformationOfTable> listDataMysql = new ArrayList<>();
        try (Connection con = ConnectionControl.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement(SqlMysql.QUERY_NAME_AND_COLUMNS_ALL_TABLES)) {
                ps.setString(1, ConnectionControl.getNameDatabase());
                try (ResultSet result = ps.executeQuery()) {
                    while (result.next()) {
                        InformationOfTable data = new InformationOfTable(result);
                        listDataMysql.add(data);
                    }
                }
            }
            for (InformationOfTable dataMysql : listDataMysql) {
                String query = String.format(SqlMysql.QUERY_COUNT_ROWS, dataMysql.getTableName());
                try (PreparedStatement ps2 = con.prepareStatement(query)) {
                    try (ResultSet result2 = ps2.executeQuery()) {
                        if (result2.next()) {
                            dataMysql.setQtdRow(result2.getLong(1));
                        }
                    }
                }
            }
        }
        return listDataMysql;
    }

    @Override
    public String getQuery() {
       return queryMysql;
    }
    
    
    
}
