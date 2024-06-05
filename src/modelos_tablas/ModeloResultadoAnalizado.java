package modelos_tablas;

import analizador_lexico.Token;
import java.util.List;
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

        // Inicialización de contadores
        int palabrasReservadas = 0;
        int identificadores = 0;
        int operadoresRelacionales = 0;
        int operadoresLogicos = 0;
        int operadoresAritmeticos = 0;
        int asignaciones = 0;
        int numerosEnteros = 0;
        int numerosDecimales = 0;
        int incremento = 0;
        int decremento = 0;
        int cadenaCaracteres = 0;
        int comentarios = 0;
        int comentariosLinea = 0;
        int parentesis = 0;
        int llaves = 0;
        int errores = 0;

        // Recorremos la lista de tokens para contar las ocurrencias
        for (Token token : tokens) {
            if(!token.validacion){
                errores++;
                continue;
            }
            switch (token.tipo) {
                case "PALABRA_RESERVADA":
                    palabrasReservadas++;
                    break;
                case "IDENTIFICADOR":
                    identificadores++;
                    break;
                case "OPERADOR_RELACIONAL":
                    operadoresRelacionales++;
                    break;
                case "OPERADOR_LOGICO":
                    operadoresLogicos++;
                    break;
                case "OPERADOR_ARITMETICO":
                    operadoresAritmeticos++;
                    break;
                case "ASIGNACION":
                    asignaciones++;
                    break;
                case "NUMERO_ENTERO":
                    numerosEnteros++;
                    break;
                case "NUMERO_DECIMAL":
                    numerosDecimales++;
                    break;
                case "INCREMENTO":
                    incremento++;
                    break;
                case "DECREMENTO":
                    decremento++;
                    break;
                case "CADENA_CARACTERES":
                    cadenaCaracteres++;
                    break;
                case "COMENTARIO":
                    comentarios++;
                    break;
                case "COMENTARIO_LINEA":
                    comentariosLinea++;
                    break;
                case "PARENTESIS":
                    parentesis++;
                    break;
                case "LLAVE":
                    llaves++;
                    break;
                case "DESCONOCIDO":
                    errores++;
                    break;
                default:
                    // No hacer nada para otros tipos de tokens
                    break;
            }
        }

        // Creación de la tabla
        data = new Object[][]{
            {"Palabras Reservadas", palabrasReservadas},
            {"Identificadores", identificadores},
            {"Operadores Relacionales", operadoresRelacionales},
            {"Operadores Lógicos", operadoresLogicos},
            {"Operadores Aritméticos", operadoresAritmeticos},
            {"Asignaciones", asignaciones},
            {"Número Enteros", numerosEnteros},
            {"Números Decimales", numerosDecimales},
            {"Incremento", incremento},
            {"Decremento", decremento},
            {"Cadena de caracteres", cadenaCaracteres},
            {"Comentario", comentarios},
            {"Comentario de Línea", comentariosLinea},
            {"Paréntesis", parentesis},
            {"Llaves", llaves},
            {"Errores", errores}
        };
        
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
