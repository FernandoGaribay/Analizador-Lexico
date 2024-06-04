
package automatas;

import java.util.HashMap;

public class Parenteresis {
    
    private static final HashMap<String, HashMap<Character, String>> transiciones;
    
    private static final String q0 = "q0";
    private static final String q1 = "q1";
    
    static {
        transiciones = new HashMap<>();
        
        HashMap<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('(', q1);
        q0Transitions.put(')', q1);
        transiciones.put(q0, q0Transitions);
        
        //Estado de Aceptacion q1
        HashMap<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('(', q1);
        q1Transitions.put(')', q1);
        transiciones.put(q1, q1Transitions);
    }
    
    public static boolean validarParenteresis(String input) {
        String currentState = q0;
        System.out.println("λ -> " + currentState);
        
        //funcion for:
        
        return currentState.equals(q1);
    }
}
