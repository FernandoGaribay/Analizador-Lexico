
package automatas;

import analizador_lexico.AnalizadorLexico;
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
    
    public static boolean validar(String input) {
        String currentState = q0;
        System.out.println("λ -> " + currentState);
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
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
