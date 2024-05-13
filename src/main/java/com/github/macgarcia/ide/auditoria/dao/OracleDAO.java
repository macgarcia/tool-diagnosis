package com.github.macgarcia.ide.auditoria.dao;

import com.github.macgarcia.ide.auditoria.model.InformationOfTable;
import com.github.macgarcia.ide.auditoria.ruleConnection.ConnectionControl;
import com.github.macgarcia.ide.auditoria.ruleConnection.SqlOracle;
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
public class OracleDAO {

    public List<InformationOfTable> getAllDataTables() throws SQLException {
        List<InformationOfTable> listDataOracle = new ArrayList<>();
        try (Connection con = ConnectionControl.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement(SqlOracle.QUERY_NAME_AND_COLUMNS_ALL_TABLES)) {
                try (ResultSet result = ps.executeQuery()) {
                    while (result.next()) {
                        InformationOfTable dataOracle = new InformationOfTable(result);
                        listDataOracle.add(dataOracle);
                    }
                }
            }
            for (InformationOfTable dataOracle : listDataOracle) {
                String query = String.format(SqlOracle.QUERY_COUNT_ROWS, dataOracle.getTableName());
                try (PreparedStatement ps2 = con.prepareStatement(query)) {
                    try (ResultSet result2 = ps2.executeQuery()) {
                        if (result2.next()) {
                            dataOracle.setQtdRow(result2.getLong(1));
                        }
                    }
                }
            }
        }
        return listDataOracle;
    }

}
