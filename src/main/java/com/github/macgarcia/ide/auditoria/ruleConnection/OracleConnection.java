package com.github.macgarcia.ide.auditoria.ruleConnection;

import com.github.macgarcia.ide.auditoria.model.InfoDataBase;

/**
 *
 * @author macgarcia
 */
public class OracleConnection implements DataBaseConnection {
    
    private static final String URL = "jdbc:oracle:thin:@%s:%s:%s";
    
    private String url;
    private String user;
    private String pass;

    public OracleConnection() {}
    
    public OracleConnection(InfoDataBase info) {
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
