package com.github.macgarcia.ide.auditoria.ruleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author macgarcia
 */
public interface DataBaseConnection {

    public String getUser();

    public String getPass();

    public String getUrl();

    default Connection getConnection() {
        try {
            return DriverManager.getConnection(this.getUrl(),this.getUser(),this.getPass());
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}
