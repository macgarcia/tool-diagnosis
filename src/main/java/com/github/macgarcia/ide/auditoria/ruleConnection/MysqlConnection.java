package com.github.macgarcia.ide.auditoria.ruleConnection;

import com.github.macgarcia.ide.auditoria.model.InfoDataBase;

/**
 *
 * @author macgarcia
 */
public class MysqlConnection implements DataBaseConnection {

    private static final String URL = "jdbc:mysql://%s:%s/%s";

    private String url;
    private String user;
    private String pass;

    public MysqlConnection() {
    }

    public MysqlConnection(InfoDataBase info) {
        this.url = String.format(URL, info.getHostname(), info.getPort(), info.getDatabase());
        this.user = info.getUser();
        this.pass = info.getPass();
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPass() {
        return this.pass;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

}
