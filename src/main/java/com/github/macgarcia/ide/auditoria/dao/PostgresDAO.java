package com.github.macgarcia.ide.auditoria.dao;

/**
 *
 * @author macgarcia
 */
public class PostgresDAO implements GenericDAO {
    
    private String queryPostgres;

    public PostgresDAO(String queryPostgres) {
        this.queryPostgres = queryPostgres;
    }

    @Override
    public String getQuery() {
        return queryPostgres;
    }
    
    
    
}
