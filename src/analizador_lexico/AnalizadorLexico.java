package analizador_lexico;

import automatas.Identificador;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {

    private List<Token> tokens;
    private Estado estadoActual;
    private StringBuilder tokenActual;

    public AnalizadorLexico() {

    }

    public boolean analizar(String input) {
        boolean resultado = false;
        tokens = new ArrayList<>();
        tokenActual = new StringBuilder();
        estadoActual = Estado.INICIO;
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            switch (estadoActual) {
                case INICIO:
                    if (isWhiteSpace(c)) {
                        continue;
                    } else if (esLetra(c)) {
                        estadoActual = Estado.IDENTIFICADOR;
                        tokenActual.append(c);
                    } else {
                        estadoActual = Estado.FIN;
                    }
                    break;
                case PALABRA_RESERVADA:
                    System.out.println("Estado actual: PALABRA_RESERVADA");
                    break;
                case IDENTIFICADOR:
                    if (isWhiteSpace(c) || !(i + 1 < input.length())) {
                        if (!isWhiteSpace(c)) {
                            tokenActual.append(c);
                        }
                        String word = tokenActual.toString();
                        resultado = Identificador.validarIdentificador(word);
                    }
                    tokenActual.append(c);
                    break;
                case OPERADOR_RELACIONAL:
                    System.out.println("Estado actual: OPERADOR_RELACIONAL");
                    break;
                case OPERADOR_LOGICO:
                    System.out.println("Estado actual: OPERADOR_LOGICO");
                    break;
                case OPERADOR_ARITMETICO:
                    System.out.println("Estado actual: OPERADOR_ARITMETICO");
                    break;
                case INCREMENTO:
                    System.out.println("Estado actual: INCREMENTO");
                    break;
                case DECREMENTO:
                    System.out.println("Estado actual: DECREMENTO");
                    break;
                case ASIGNACION:
                    System.out.println("Estado actual: ASIGNACION");
                    break;
                case NUMERO_ENTERO:
                    System.out.println("Estado actual: NUMERO_ENTERO");
                    break;
                case NUMERO_DECIMAL:
                    System.out.println("Estado actual: NUMERO_DECIMAL");
                    break;
                case CADENA_CARACTERES:
                    System.out.println("Estado actual: CADENA_CARACTERES");
                    break;
                case COMENTARIO:
                    break;
                case COMENTARIO_LINEA:
                    System.out.println("Estado actual: COMENTARIO_LINEA");
                    break;
                case PARENTESIS:
                    System.out.println("Estado actual: PARENTESIS");
                    break;
                case LLAVE:
                    System.out.println("Estado actual: LLAVE");
                    break;
                case FIN:
                    estadoActual = Estado.INICIO;
                    tokenActual = new StringBuilder();
                    System.out.println("Estado actual: FIN");
                    break;
                default:
                    System.out.println("Estado desconocido");
                    break;
            }

        }

        return resultado;
    }

    public static boolean isWhiteSpace(char c) {
        return Character.isWhitespace(c);
    }

    public static boolean esLetra(char c) {
        return Character.isLetter(c);
    }

    public static boolean isNumber(char c) {
        return Character.isDigit(c);
    }

}
