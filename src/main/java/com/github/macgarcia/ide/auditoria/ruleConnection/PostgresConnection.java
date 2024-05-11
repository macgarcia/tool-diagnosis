
package com.github.macgarcia.ide.auditoria.ruleConnection;

import com.github.macgarcia.ide.auditoria.model.InfoDataBase;
import java.net.URL;
import javax.sound.sampled.Port;

/**
 *
 * @author macgarcia
 */
public class PostgresConnection implements DataBaseConnection {
    
    private static final String URL = "jdbc:postgresql://%s:%s/%s";
    
    private String url;
    private String user;
    private String pass;

    public PostgresConnection() {}
    
    public PostgresConnection(InfoDataBase info) {
        this.url = String.format(URL, info.getHostname(), info.getPort(), info.getDatabase());
        this.user = info.getUser();
        this.pass = info.getPass();
    }
    
    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public String getUrl() {
        return url;
    }
    
}
