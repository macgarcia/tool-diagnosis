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
    
    private static final Integer NUMBER_OF_COLUMNS = 4;
    
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
            case 0 -> "HOSTNAME";
            case 1 -> "PORT";
            case 2 -> "DATABASE";
            case 3 -> "USER";
            default -> "";
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final InfoDataBase info = infoDataBases.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> info.getHostname();
            case 1 -> info.getPort();
            case 2 -> info.getDatabase();
            case 3 -> info.getUser();
            default -> "";
        };
    }
    
    public InfoDataBase getInfoDataBase(int line) {
        return infoDataBases.get(line);
    }
    
}
