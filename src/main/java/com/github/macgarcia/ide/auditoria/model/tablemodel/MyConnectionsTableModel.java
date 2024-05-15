package com.github.macgarcia.ide.auditoria.model.tablemodel;

import com.github.macgarcia.ide.auditoria.model.InfoDataBase;
import com.github.macgarcia.ide.auditoria.utils.Archive;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author macgarcia
 */
public class MyConnectionsTableModel extends AbstractTableModel {
    
    private static final Integer NUMBER_OF_COLUMNS = 5;
    
    private List<InfoDataBase> infoDataBases;

    public MyConnectionsTableModel() {
        infoDataBases = new ArrayList<>();
        List<String> archivesJson = Archive.readArchives();
        archivesJson.forEach(json -> {
            InfoDataBase info = new Gson().fromJson(json, InfoDataBase.class);
            infoDataBases.add(info);
        });
    }
    
    @Override
    public int getRowCount() {
        return infoDataBases.size();
    }

    @Override
    public int getColumnCount() {
        return NUMBER_OF_COLUMNS;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "SGDB";
            case 1 -> "HOSTNAME";
            case 2 -> "PORT";
            case 3 -> "DATABASE";
            case 4 -> "USER";
            default -> "";
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final InfoDataBase info = infoDataBases.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> info.getSgdb();
            case 1 -> info.getHostname();
            case 2 -> info.getPort();
            case 3 -> info.getDatabase();
            case 4 -> info.getUser();
            default -> "";
        };
    }
    
    public InfoDataBase getInfoDataBase(int line) {
        return infoDataBases.get(line);
    }
    
}
