package automatas;

import analizador_lexico.AnalizadorLexico;
import java.util.HashMap;

public class Identificador {

    private static final HashMap<String, HashMap<Character, String>> transiciones;

    private static final String q0 = "q0";
    private static final String q1 = "q1";
    private static final String q2 = "q2";

    static {
        transiciones = new HashMap<>();

        HashMap<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('a', q1);
        q0Transitions.put('1', q2);
        q0Transitions.put('_', q1);
        transiciones.put(q0, q0Transitions);

        //Estado de aceptacion q1
        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('a', q1);
        q1Transitions.put('1', q1);
        q1Transitions.put('_', q1);
        transiciones.put(q1, q1Transitions);

        //Estado basura q2
        HashMap<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('a', q2);
        q2Transitions.put('1', q2);
        q2Transitions.put('_', q2);
        transiciones.put(q2, q2Transitions);

    }

    public static boolean validarIdentificador(String input) {
        String currentState = q0;
        System.out.println("λ -> " + currentState);

        // Iteramos sobre la entrada
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (AnalizadorLexico.esLetra(c)) {
                c = 'a';
            } else if (AnalizadorLexico.isNumber(c)) {
                c = '1';
            }

            if (!transiciones.get(currentState).containsKey(c)) {
                System.out.println("AUTOMATA COMENTARIO: (CARACTER DESCONOCIDO) -> " + c);
                return false;
            }
            currentState = transiciones.get(currentState).get(c);
            System.out.println(c + " -> " + currentState);
        }
        return currentState.equals(q1);
    }
}
