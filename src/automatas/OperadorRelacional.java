package automatas;

import java.util.HashMap;

public class OperadorRelacional {

    private static final HashMap<String, HashMap<Character, String>> transiciones;

    private static final String q0 = "q0";
    private static final String q1 = "q1";
    private static final String q2 = "q2";
    private static final String q3 = "q3";
    private static final String q4 = "q4";

    static {
        transiciones = new HashMap<>();

        HashMap<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('>', q1);
        q0Transitions.put('<', q1);
        q0Transitions.put('=', q2);
        q0Transitions.put('!', q2);
        transiciones.put(q0, q0Transitions);

        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('=', q3);
        transiciones.put(q1, q1Transitions);

        HashMap<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('=', q3);
        transiciones.put(q2, q2Transitions);

        //Estado de aceptación
        HashMap<Character, String> q3Transitions = new HashMap<>();
        q3Transitions.put('<', q4);
        q3Transitions.put('>', q4);
        q3Transitions.put('=', q4);
        q3Transitions.put('!', q4);
        transiciones.put(q3, q3Transitions);

        //Estado basura
        HashMap<Character, String> q4Transitions = new HashMap<>();
        q4Transitions.put('<', q4);
        q4Transitions.put('>', q4);
        q4Transitions.put('=', q4);
        q4Transitions.put('!', q4);
        transiciones.put(q4, q4Transitions);

        /*
        public static boolean validarOperadorRelacional(String input) {
            String currentState = q0;
            System.out.println("λ -> " + currentState);
            
            for (int i = 0; i < input.length(); i++){
                char c = (analizador_lexico.)
            }
        }*/
    }

}
