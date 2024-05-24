package modelos_tablas;

import javax.swing.table.AbstractTableModel;

public class ModeloResultadoAnalizado extends AbstractTableModel {

    private final String[] columnasNombres;
    private final Object[][] data;

    public ModeloResultadoAnalizado() {
        columnasNombres = new String[]{"LINEA", "SINTAXIS", "DETALLE"};
        data = new Object[8][3];
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
