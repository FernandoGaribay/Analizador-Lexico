package modelos_tablas;

import analizador_lexico.Token;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class ModeloResultadoAnalizado extends AbstractTableModel {

    private final String[] columnasNombres;
    private final Object[][] data;

    public ModeloResultadoAnalizado() {
        columnasNombres = new String[]{"TIPO", "CANTIDAD"};
        data = new Object[8][2];
    }

    public ModeloResultadoAnalizado(List<Token> tokens) {
        columnasNombres = new String[]{"TIPO", "CANTIDAD"};

        // Usamos un mapa para almacenar el recuento de tokens por tipo
        Map<String, Integer> countMap = new HashMap<>();
        for (Token token : tokens) {
            // Si el tipo ya está en el mapa, incrementa el contador
            // Si no, inicializa el contador en 1
            if (token.validacion) {
                countMap.put(token.tipo, countMap.getOrDefault(token.tipo, 0) + 1);
            }
        }

        // Tamaño de la tabla será igual al número de tipos de tokens
        data = new Object[countMap.size()][2];

        // Llenar los datos de la tabla
        int rowIndex = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String tipo = entry.getKey();
            int cantidad = entry.getValue();
            data[rowIndex][0] = tipo;
            data[rowIndex][1] = cantidad;
            rowIndex++;
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
