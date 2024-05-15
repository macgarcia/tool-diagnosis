package com.github.macgarcia.ide.auditoria.dao;

import com.github.macgarcia.ide.auditoria.model.InformationOfTable;
import com.github.macgarcia.ide.auditoria.querys.SqlCommon;
import com.github.macgarcia.ide.auditoria.ruleConnection.ConnectionControl;
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
public interface GenericDAO {
    
    public String getQuery();
    
    default List<InformationOfTable> getInformationOfTable() throws SQLException {
        List<InformationOfTable> listData = new ArrayList<>();
        try (Connection con = ConnectionControl.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement(getQuery())) {
                if (this.getClass().equals(PostgresDAO.class) || this.getClass().equals(MysqlDAO.class)) {
                    ps.setString(1, ConnectionControl.getNameDatabase());
                }
                try (ResultSet result = ps.executeQuery()) {
                    while (result.next()) {
                        InformationOfTable data = new InformationOfTable(result);
                        listData.add(data);
                    }
                }
            }
            for (InformationOfTable data : listData) {
                String queryCount = String.format(SqlCommon.QUERY_COUNT_ROWS, data.getTableName());
                try (PreparedStatement ps2 = con.prepareStatement(queryCount)) {
                    try (ResultSet result2 = ps2.executeQuery()) {
                        if (result2.next()) {
                            data.setQtdRow(result2.getLong(1));
                        }
                    }
                }
            }
        }
        return listData;
    }
}
