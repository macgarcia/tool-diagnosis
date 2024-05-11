package com.github.macgarcia.ide.auditoria.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author macgarcia
 */
@Getter
@Setter
@ToString
public class InfoDataBase {
    
    private Sgdb sgdb;
    private String hostname;
    private String port;
    private String database;
    private String user;
    private String pass;
    
}
