package componentes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivos {

    public static String leerArchivo(String filePath) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator());
            }
        }
        return contenido.toString();
    }

    public static void main(String[] args) {
        String rutaArchivo = "/home/fernando/Downloads/testAnalizadorLexico.txt";
        try {
            String contenido = leerArchivo(rutaArchivo);
            System.out.println(contenido);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
