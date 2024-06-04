package automatas;

import java.util.HashMap;

public class ComentarioDeLinea {

    private static final HashMap<String, HashMap<Character, String>> transiciones;

    private static final String q0 = "q0";
    private static final String q1 = "q1";
    private static final String q2 = "q2";
    private static final String q3 = "q3";

    static {
        transiciones = new HashMap<>();

        HashMap<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('/', q1);
        q0Transitions.put('x', q3);
        transiciones.put(q0, q0Transitions);

        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('/', q2);
        q1Transitions.put('x', q3);
        transiciones.put(q1, q1Transitions);

        //Estado de Aceptacion q2
        HashMap<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('/', q2);
        q2Transitions.put('x', q2);
        transiciones.put(q2, q2Transitions);

        //Estado basura q3
        HashMap<Character, String> q3Transitions = new HashMap<>();
        q3Transitions.put('/', q3);
        q3Transitions.put('x', q3);
        transiciones.put(q3, q3Transitions);
    }

    public static boolean validarComentarioDeLinea(String input) {
        String currentState = q0;
        System.out.println("λ -> " + currentState);
        
        return currentState.equals(q2);
    }
}
