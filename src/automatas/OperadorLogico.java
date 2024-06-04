package automatas;

import java.util.HashMap;

public class OperadorLogico {

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
        q0Transitions.put('&', q1);
        q0Transitions.put('|', q3);
        q0Transitions.put('!', q5);
        transiciones.put(q0, q0Transitions);

        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('&', q2);
        q1Transitions.put('|', q3);
        q1Transitions.put('!', q3);
        transiciones.put(q1, q1Transitions);

        //Estado de aceptacion q2
        HashMap<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('&', q6);
        q2Transitions.put('|', q6);
        q2Transitions.put('!', q6);
        transiciones.put(q2, q2Transitions);

        HashMap<Character, String> q3Transitions = new HashMap<>();
        q3Transitions.put('|', q4);
        q3Transitions.put('&', q5);
        q3Transitions.put('!', q5);
        transiciones.put(q3, q3Transitions);

        //Estado de aceptacion q4
        HashMap<Character, String> q4Transitions = new HashMap<>();
        q4Transitions.put('&', q6);
        q4Transitions.put('|', q6);
        q4Transitions.put('!', q6);
        transiciones.put(q4, q4Transitions);

        //Estado de aceptacion q5
        HashMap<Character, String> q5Transitions = new HashMap<>();
        q5Transitions.put('&', q6);
        q5Transitions.put('|', q6);
        q5Transitions.put('!', q6);
        transiciones.put(q5, q5Transitions);

        //Estado basura q6
        HashMap<Character, String> q6Transitions = new HashMap<>();
        q6Transitions.put('&', q6);
        q6Transitions.put('|', q6);
        q6Transitions.put('!', q6);
        transiciones.put(q6, q6Transitions);
    }

    public static boolean validarOperadorLogico(String input) {
        String currentState = q0;
        System.out.println("λ -> " + currentState);
        boolean estadosAceptacion = false;
        
        //Funcion for:
        

        if (currentState.equals(q2) || currentState.contains(q4) || currentState.contains(q5)) {
            estadosAceptacion = true;
        }
        
        return estadosAceptacion;
    }
}
