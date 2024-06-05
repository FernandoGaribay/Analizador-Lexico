package automatas;

import analizador_lexico.AnalizadorLexico;
import java.util.HashMap;

public class OperadorAritmetico {

    private static final HashMap<String, HashMap<Character, String>> transiciones;

    private static final String q0 = "q0";
    private static final String q1 = "q1";
    private static final String q2 = "q2";
    private static final String q3 = "q3";
    private static final String q4 = "q4";
    private static final String q5 = "q5";
    private static final String q6 = "q6";

    static {
        transiciones = new HashMap<>();

        HashMap<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('+', q1);
        q0Transitions.put('-', q2);
        q0Transitions.put('*', q3);
        q0Transitions.put('/', q4);
        q0Transitions.put('%', q5);
        transiciones.put(q0, q0Transitions);

        //Estado de aceptacion q1
        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('+', q6);
        q1Transitions.put('-', q6);
        q1Transitions.put('*', q6);
        q1Transitions.put('/', q6);
        q1Transitions.put('%', q6);
        transiciones.put(q1, q1Transitions);

        //Estado de aceptacion q2
        HashMap<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('+', q6);
        q2Transitions.put('-', q6);
        q2Transitions.put('*', q6);
        q2Transitions.put('/', q6);
        q2Transitions.put('%', q6);
        transiciones.put(q2, q2Transitions);

        //Estado de aceptacion q3
        HashMap<Character, String> q3Transitions = new HashMap<>();
        q3Transitions.put('+', q6);
        q3Transitions.put('-', q6);
        q3Transitions.put('*', q6);
        q3Transitions.put('/', q6);
        q3Transitions.put('%', q6);
        transiciones.put(q3, q3Transitions);

        //Estado de aceptacion q4
        HashMap<Character, String> q4Transitions = new HashMap<>();
        q4Transitions.put('+', q6);
        q4Transitions.put('-', q6);
        q4Transitions.put('*', q6);
        q4Transitions.put('/', q6);
        q4Transitions.put('%', q6);
        transiciones.put(q4, q4Transitions);

        //Estado de aceptacion q5
        HashMap<Character, String> q5Transitions = new HashMap<>();
        q5Transitions.put('+', q6);
        q5Transitions.put('-', q6);
        q5Transitions.put('*', q6);
        q5Transitions.put('/', q6);
        q5Transitions.put('%', q6);
        transiciones.put(q5, q5Transitions);

        //Estado basura q6
        HashMap<Character, String> q6Transitions = new HashMap<>();
        q6Transitions.put('+', q6);
        q6Transitions.put('-', q6);
        q6Transitions.put('*', q6);
        q6Transitions.put('/', q6);
        q6Transitions.put('%', q6);
        transiciones.put(q6, q6Transitions);
    }
    
    public static boolean validarOperadorAritmetico(String input) {
        String currentState = q0;
        System.out.println("λ -> " + currentState);
        boolean estadosAceptacion = false;
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!transiciones.get(currentState).containsKey(c)) {
                System.out.println("AUTOMATA COMENTARIO: (CARACTER DESCONOCIDO) -> " + c);
                return false;
            }
            currentState = transiciones.get(currentState).get(c);
            System.out.println(c + " -> " + currentState);
        }
        
        if(!currentState.equals(q0) || !currentState.equals(q6)){
            estadosAceptacion = true;
        }
        
        return estadosAceptacion;
    }

}
