package modelos_tablas;

import analizador_lexico.Token;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloAnalizadorLexico extends AbstractTableModel {

    private final String[] columnasNombres;
    private final Object[][] data;

    public ModeloAnalizadorLexico() {
        columnasNombres = new String[]{"LEXEMA", "TOKEN", "VALIDACION"};
        data = new Object[25][4];
    }

    public ModeloAnalizadorLexico(List<Token> tokens) {
        columnasNombres = new String[]{"LEXEMA", "TOKEN", "VALIDACION"};
        data = new Object[tokens.size()][columnasNombres.length];

        // Llenar los datos de la tabla
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            data[i][0] = token.tipo;
            data[i][1] = token.valor;
            data[i][2] = token.validacion;
        }
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
