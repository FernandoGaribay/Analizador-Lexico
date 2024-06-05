package analizador_lexico;

import static analizador_lexico.Estado.ASIGNACION;
import static analizador_lexico.Estado.CADENA_CARACTERES;
import static analizador_lexico.Estado.COMENTARIO;
import static analizador_lexico.Estado.COMENTARIO_LINEA;
import static analizador_lexico.Estado.DECREMENTO;
import static analizador_lexico.Estado.INCREMENTO;
import static analizador_lexico.Estado.LLAVE;
import static analizador_lexico.Estado.NUMERO_DECIMAL;
import static analizador_lexico.Estado.NUMERO_ENTERO;
import static analizador_lexico.Estado.OPERADOR_ARITMETICO;
import static analizador_lexico.Estado.OPERADOR_LOGICO;
import static analizador_lexico.Estado.OPERADOR_RELACIONAL;
import static analizador_lexico.Estado.PARENTESIS;
import automatas.CadenaDeCaracteres;
import automatas.Comentario;
import automatas.ComentarioDeLinea;
import automatas.Identificador;
import automatas.Incremento;
import automatas.Decremento;
import automatas.Asignacion;
import automatas.NumeroDecimal;
import automatas.Parenteresis;
import automatas.Llave;
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

    private ArrayList<Token> tokens;
    private Estado estadoActual;
    private StringBuilder tokenActual;

    static {
        ASIGNADOR.put('a', Estado.IDENTIFICADOR);
        ASIGNADOR.put('"', Estado.CADENA_CARACTERES);
        ASIGNADOR.put(')', Estado.PARENTESIS);
        ASIGNADOR.put('(', Estado.PARENTESIS);
        ASIGNADOR.put('}', Estado.LLAVE);
        ASIGNADOR.put('{', Estado.LLAVE);
        ASIGNADOR.put('=', Estado.ASIGNACION);
        ASIGNADOR.put('<', Estado.OPERADOR_RELACIONAL);
        ASIGNADOR.put('>', Estado.OPERADOR_RELACIONAL);
        ASIGNADOR.put('&', Estado.OPERADOR_LOGICO);
        ASIGNADOR.put('|', Estado.OPERADOR_LOGICO);
        ASIGNADOR.put('!', Estado.OPERADOR_LOGICO);
        ASIGNADOR.put('+', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('-', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('*', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('/', Estado.OPERADOR_ARITMETICO);
        ASIGNADOR.put('%', Estado.OPERADOR_ARITMETICO);
    }

    public void analizar(String input) {
        tokens = new ArrayList<>();
        tokenActual = new StringBuilder();
        estadoActual = Estado.INICIO;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (esSaltoLinea(c)) {
                System.out.println("salto");
            } else if (esEspacio(c)) {
                if (tokenActual.length() > 0) {
                    estadoActual = determinarEstado(tokenActual.toString());
                    System.out.println(estadoActual);

                    redireccionarAutomata();
                    tokenActual = new StringBuilder();
                }
            } else {
                tokenActual.append(c);
            }
        }
    }

    private Estado determinarEstado(String palabra) {
        char c = palabra.charAt(0);

        if (esLetra(c)) {
            return Estado.IDENTIFICADOR;
        } else if (iniciaCon(palabra, "/*")) {
            return Estado.COMENTARIO;
        } else if (iniciaCon(palabra, "//")) {
            return Estado.COMENTARIO_LINEA;
        } else if (iniciaCon(palabra, "++")) {
            return Estado.INCREMENTO;
        } else if (iniciaCon(palabra, "--")) {
            return Estado.DECREMENTO;
        } else if (iniciaCon(palabra, "==")) {
            return Estado.OPERADOR_RELACIONAL;
        } else if (iniciaCon(palabra, "!=")) {
            return Estado.OPERADOR_RELACIONAL;
        } else if (contieneCaracter(palabra, ".") && contieneNumeros(palabra)) {
            return Estado.NUMERO_DECIMAL;
        } else if (contieneNumeros(palabra)) {
            return Estado.NUMERO_ENTERO;
        }

        return ASIGNADOR.getOrDefault(c, Estado.DESCONOCIDO);
    }

    private void redireccionarAutomata() {
        String token = tokenActual.toString();

        if (token.isEmpty()) {
            return;
        }

        switch (estadoActual) {
            case IDENTIFICADOR:
                if (PalabraReservada.validar(token)) {
                    tokens.add(new Token(Estado.PALABRA_RESERVADA.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                } else if (Identificador.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case CADENA_CARACTERES:
                if (CadenaDeCaracteres.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case COMENTARIO:
                if (Comentario.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case COMENTARIO_LINEA:
                if (ComentarioDeLinea.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case INCREMENTO:
                if (Incremento.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case DECREMENTO:
                if (Decremento.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case ASIGNACION:
                if (Asignacion.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case NUMERO_DECIMAL:
                if (NumeroDecimal.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case NUMERO_ENTERO:
                if (NumeroEntero.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case PARENTESIS:
                if (Parenteresis.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case LLAVE:
                if (Llave.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case OPERADOR_RELACIONAL:
                if (OperadorRelacional.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case OPERADOR_LOGICO:
                if (OperadorLogico.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            case OPERADOR_ARITMETICO:
                if (OperadorAritmetico.validar(token)) {
                    tokens.add(new Token(estadoActual.toString(), token, true));
                    System.out.println(token + " -> VALIDADO\n");
                    return;
                }
                tokens.add(new Token(estadoActual.toString(), token, false));
                System.out.println(token + " -> INVALIDADO\n");
                break;
            default:
                tokens.add(new Token(estadoActual.toString(), token, false));
        }
    }

    public static boolean esEspacio(char c) {
        return Character.isWhitespace(c);
    }

    public static boolean esSaltoLinea(char c) {
        return c == '\n' || c == '\r';
    }

    public static boolean esLetra(char c) {
        return Character.isLetter(c);
    }

    public static boolean esNumero(char c) {
        return Character.isDigit(c);
    }

    public static boolean esIgualA(char c, char caracter) {
        return c == caracter;
    }

    public static boolean esEnRangoDe(char c, int incio, int fin, char... exepsiones) {
        for (char exepsion : exepsiones) {
            if (c == exepsion) {
                return false;
            }
        }

        int ascii = (int) c;
        return ascii >= incio && ascii <= fin;
    }

    public static boolean contieneNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contieneCaracter(String texto, String letra) {
        return texto.contains(letra);
    }

    public static boolean iniciaCon(String text, String prefix) {
        return text.startsWith(prefix);
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
