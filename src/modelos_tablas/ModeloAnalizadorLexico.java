package modelos_tablas;

import javax.swing.table.AbstractTableModel;

public class ModeloAnalizadorLexico extends AbstractTableModel {

    private final String[] columnasNombres;
    private final Object[][] data;

    public ModeloAnalizadorLexico() {
        columnasNombres = new String[]{"LEXEMA", "TOKEN", "LINEA", "PALABRA"};
        data = new Object[25][4];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnasNombres.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnasNombres[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
