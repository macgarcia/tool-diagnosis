package com.github.macgarcia.ide.auditoria.ruleConnection;

import com.github.macgarcia.ide.auditoria.model.InfoDataBase;
import com.github.macgarcia.ide.auditoria.model.Sgdb;
import static com.github.macgarcia.ide.auditoria.model.Sgdb.MYSQL;
import static com.github.macgarcia.ide.auditoria.model.Sgdb.ORACLE;
import static com.github.macgarcia.ide.auditoria.model.Sgdb.POSTGRES;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macgarcia
 */
public final class ConnectionControl {

    private static Connection connection;
    private static Sgdb sgdb;
    private static String nameDatabase;

    public static Connection startConnection(InfoDataBase info) {
        
        if (connection != null) {
            throw new RuntimeException("Close the active connection");
        }
        
        nameDatabase = info.getDatabase();
        sgdb = info.getSgdb();
        
        return switch (sgdb) {
            case ORACLE ->
                connection = new OracleConnection(info).getConnection();
            case POSTGRES ->
                connection = new PostgresConnection(info).getConnection();
            case MYSQL ->
                connection = new MysqlConnection(info).getConnection();
            default ->
                throw new RuntimeException("Database not suported.");
        };
    }

    public static Sgdb getSgdb() {
        return sgdb;
    }

    public static String getNameDatabase() {
        return nameDatabase;
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
    public static void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
