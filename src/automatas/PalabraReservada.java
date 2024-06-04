package automatas;

import java.util.HashMap;

public class PalabraReservada {

    private static final HashMap<String, Boolean> palabrasReservadas;

    static {
        palabrasReservadas = new HashMap<>();

        palabrasReservadas.put("if", true);
        palabrasReservadas.put("main", true);
        palabrasReservadas.put("else", true);
        palabrasReservadas.put("switch", true);
        palabrasReservadas.put("case", true);
        palabrasReservadas.put("default", true);
        palabrasReservadas.put("for", true);
        palabrasReservadas.put("do", true);
        palabrasReservadas.put("while", true);
        palabrasReservadas.put("break", true);
        palabrasReservadas.put("int", true);
        palabrasReservadas.put("String", true);
        palabrasReservadas.put("double", true);
        palabrasReservadas.put("char", true);
        palabrasReservadas.put("print", true);
    }

    public static boolean validarPalabraReservada(String input) {
        return palabrasReservadas.containsKey(input);
    }

}
