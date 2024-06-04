package automatas;

import java.util.HashMap;

public class CadenaDeCaracteres {

    private static final HashMap<String, HashMap<Character, String>> transiciones;

    private static final String q0 = "q0";
    private static final String q1 = "q1";
    private static final String q2 = "q2";
    private static final String q3 = "q3";
    private static final String q4 = "q4";

    static {
        transiciones = new HashMap<>();
        
        HashMap<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('"', q1);
        q0Transitions.put('x', q4);
        transiciones.put(q0, q0Transitions);
        
        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('x', q2);
        q1Transitions.put('"', q3);
        transiciones.put(q1, q1Transitions);
        
        HashMap<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('x', q2);
        q2Transitions.put('"', q3);
        transiciones.put(q2, q2Transitions);
        
        //Estado de aceptacion
        HashMap<Character, String> q3Transitions = new HashMap<>();
        q3Transitions.put('x', q4);
        q3Transitions.put('"', q4);
        transiciones.put(q3, q3Transitions);
        
        //Estado basura q4
        HashMap<Character, String> q4Transitions = new HashMap<>();
        q4Transitions.put('x', q4);
        q4Transitions.put('"', q4);
        transiciones.put(q4, q4Transitions);
    }
    
    public static boolean validarCadenaDeCaracteres(String input){
        String currentState = q0;
        System.out.println("λ -> " + currentState);
        
        //Funcion for:
        
        return currentState.equals(q3);
    }
}
