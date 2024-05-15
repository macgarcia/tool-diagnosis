package com.github.macgarcia.ide.auditoria.dao;

/**
 *
 * @author macgarcia
 */
public class OracleDAO implements GenericDAO {
    
    private String queryOracle;

    public OracleDAO(String queryOracle) {
        this.queryOracle = queryOracle;
    }

    @Override
    public String getQuery() {
        return queryOracle;
    }

}
