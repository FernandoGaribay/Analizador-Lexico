package analizador_lexico;

import static analizador_lexico.Estado.ASIGNACION;
import static analizador_lexico.Estado.CADENA_CARACTERES;
import static analizador_lexico.Estado.COMENTARIO;
import static analizador_lexico.Estado.COMENTARIO_LINEA;
import static analizador_lexico.Estado.DECREMENTO;
import static analizador_lexico.Estado.IDENTIFICADOR;
import static analizador_lexico.Estado.INCREMENTO;
import static analizador_lexico.Estado.INICIO;
import static analizador_lexico.Estado.LLAVE;
import static analizador_lexico.Estado.NUMERO_DECIMAL;
import static analizador_lexico.Estado.NUMERO_ENTERO;
import static analizador_lexico.Estado.OPERADOR_ARITMETICO;
import static analizador_lexico.Estado.OPERADOR_LOGICO;
import static analizador_lexico.Estado.OPERADOR_RELACIONAL;
import static analizador_lexico.Estado.PALABRA_RESERVADA;
import static analizador_lexico.Estado.PARENTESIS;
import automatas.Asignacion;
import automatas.Identificador;
import automatas.NumeroEntero;
import automatas.OperadorAritmetico;
import automatas.OperadorLogico;
import automatas.OperadorRelacional;
import automatas.PalabraReservada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalizadorLexico {

    private static final HashMap<Character, Estado> ASIGNADOR = new HashMap<>();

    private List<Token> tokens;
    private Estado estadoActual;
    private StringBuilder tokenActual;

    static {
        ASIGNADOR.put('/', Estado.COMENTARIO);
        ASIGNADOR.put('a', Estado.PALABRA_RESERVADA);
        ASIGNADOR.put('>', Estado.OPERADOR_RELACIONAL);
        ASIGNADOR.put('<', Estado.OPERADOR_RELACIONAL);
        ASIGNADOR.put('!', Estado.OPERADOR_RELACIONAL);
        ASIGNADOR.put('=', Estado.OPERADOR_RELACIONAL);
        ASIGNADOR.put('&', Estado.OPERADOR_LOGICO);
        ASIGNADOR.put('|', Estado.OPERADOR_LOGICO);
        ASIGNADOR.put('!', Estado.OPERADOR_LOGICO);
        ASIGNADOR.put('+', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('-', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('*', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('/', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('%', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('1', Estado.NUMERO_ENTERO);
        ASIGNADOR.put('-', Estado.NUMERO_ENTERO);
    }

    public boolean analizar(String input) {
        boolean resultado = false;
        tokens = new ArrayList<>();
        tokenActual = new StringBuilder();
        estadoActual = Estado.INICIO;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isWhiteSpace(c)) {
                resultado = redireccionarAutomata(false);
            } else {
                tokenActual.append(c);
            }
        }

        return resultado;
    }

    private boolean redireccionarAutomata(boolean redireccionado) {
        boolean resultado = false;
        String word = "";

        if (!redireccionado) {
            char letra = 0;
            if (tokenActual.length() > 0) {
                letra = tokenActual.toString().charAt(0);
            }

            if (esLetra(letra)) {
                letra = 'a';
            } else if (isNumber(letra)) {
                letra = '1';
            }

            if (ASIGNADOR.get(letra) != null) {
                estadoActual = ASIGNADOR.get(letra);
            }
        }

        switch (estadoActual) {
            case PALABRA_RESERVADA:
                word = tokenActual.toString();
                resultado = PalabraReservada.validarPalabraReservada(word);

                if (resultado) {
                    reiniciarAutomata();
                    System.out.println("palabra reservada");
                    System.out.println(resultado);
                } else {
                    estadoActual = IDENTIFICADOR;
                    resultado = redireccionarAutomata(true);
                }
                break;
            case IDENTIFICADOR:
                word = tokenActual.toString();
                resultado = Identificador.validarIdentificador(word);

                reiniciarAutomata();
                System.out.println(resultado);
                break;
            case OPERADOR_RELACIONAL:
                word = tokenActual.toString();
                resultado = OperadorRelacional.validarOperadorRelacional(word);

                if (resultado) {
                    reiniciarAutomata();
                    System.out.println(resultado);
                } else {
                    estadoActual = ASIGNACION;
                    System.out.println("cambio de estado -> " + estadoActual);
                    resultado = redireccionarAutomata(true);
                }
                break;
            case OPERADOR_LOGICO:
                word = tokenActual.toString();
                resultado = OperadorLogico.validarOperadorLogico(word);

                if (resultado) {
                    reiniciarAutomata();
                    System.out.println(resultado);
                } else {
                    estadoActual = Estado.OPERADOR_RELACIONAL;
                    System.out.println("cambio de estado -> " + estadoActual);
                    resultado = redireccionarAutomata(true);
                }
                System.out.println(resultado);
                break;
            case OPERADOR_ARITMETICO:
                word = tokenActual.toString();
                resultado = OperadorAritmetico.validarOperadorAritmetico(word);

                reiniciarAutomata();
                System.out.println(resultado);
                break;
            case INCREMENTO:
                System.out.println("Estado actual: INCREMENTO");
                break;
            case DECREMENTO:
                System.out.println("Estado actual: DECREMENTO");
                break;
            case ASIGNACION:
                word = tokenActual.toString();
                resultado = Asignacion.validarAsignacion(word);

                reiniciarAutomata();
                System.out.println(resultado);
                break;
            case NUMERO_ENTERO:
                word = tokenActual.toString();
                resultado = NumeroEntero.validarNumeroEntero(word);

                if (resultado) {
                    reiniciarAutomata();
                }
                System.out.println(resultado);
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
        }
        return resultado;
    }

    private void reiniciarAutomata() {
        estadoActual = INICIO;
        tokens = new ArrayList<>();
        tokenActual = new StringBuilder();
    }

    public static boolean isWhiteSpace(char c) {
        return Character.isWhitespace(c);
    }

    public static boolean esSaltoLinea(char c) {
        return c == 10;
    }

    public static boolean esLetra(char c) {
        return Character.isLetter(c);
    }

    public static boolean esGuion(char c) {
        return c == '-';
    }

    public static boolean isNumber(char c) {
        return Character.isDigit(c);
    }

}
