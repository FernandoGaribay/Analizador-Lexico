package automatas;

import java.util.HashMap;

public class Asignacion {

    private static final HashMap<String, HashMap<Character, String>> transiciones;

    private static final String q0 = "q0";
    private static final String q1 = "q1";
    private static final String q2 = "q2";

    static {
        transiciones = new HashMap<>();

        HashMap<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('=', q1);
        transiciones.put(q0, q0Transitions);

        //Estado de aceptacion q1
        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('=', q2);
        transiciones.put(q1, q1Transitions);

        //Estado basura q2
        HashMap<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('=', q2);
        transiciones.put(q2, q2Transitions);
    }

    public static boolean validarAsignacion(String input) {
        String currentState = q0;
        System.out.println("λ -> " + currentState);

        //Funcion for
        return currentState.equals(q1);
    }
}
