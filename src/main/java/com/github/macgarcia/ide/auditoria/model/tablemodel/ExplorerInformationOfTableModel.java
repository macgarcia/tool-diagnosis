package com.github.macgarcia.ide.auditoria.model.tablemodel;

import com.github.macgarcia.ide.auditoria.model.InformationOfTable;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.github.macgarcia.ide.auditoria.dao.GenericDAO;

/**
 *
 * @author macgarcia
 */
public class ExplorerInformationOfTableModel extends AbstractTableModel {

    private final Integer NUMBER_OF_COLUMNS = 3;

    private List<InformationOfTable> listInformationOfTable;

    public ExplorerInformationOfTableModel(GenericDAO dao) throws SQLException {
        getInformationOfTable(dao);
    }

    private void getInformationOfTable(GenericDAO dao) throws SQLException {
        listInformationOfTable = dao.getInformationOfTable();
        listInformationOfTable.sort(Comparator.comparing(InformationOfTable::getTableName));
    }

    @Override
    public int getRowCount() {
        return listInformationOfTable.size();
    }

    @Override
    public int getColumnCount() {
        return NUMBER_OF_COLUMNS;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "TABLE NAME";
            case 1 ->
                "QUANTITY COLUMNS";
            case 2 ->
                "QUANTITY ROWS";
            default ->
                "";
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final InformationOfTable data = listInformationOfTable.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                data.getTableName().toUpperCase();
            case 1 ->
                data.getQtdColumn();
            case 2 ->
                data.getQtdRow();
            default ->
                null;
        };
    }

    public InformationOfTable getDataOfTableOracle(int line) {
        return listInformationOfTable.get(line);
    }

}
