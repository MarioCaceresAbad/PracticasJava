package entrega1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ficheros {	

// Función 6
	public static int contadorDePalabras(String fichero, String separador, String cad) {
        int contador = 0;
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(separador);
                for (String p : palabras) {
                    if (p.equals(cad)) {
                        contador++;
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return contador;
    }

// Función 7
	public static List<String> buscadorDePalabras(String fichero, String cad) {
        List<String> lineasCoincidentes = new ArrayList<>();      
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(cad)) {
                    lineasCoincidentes.add(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }        
        return lineasCoincidentes;
    }

// Función 8
	public static List<String> buscadorDePalabrasÚnicas(String fichero) throws IOException {
        Set<String> uniqueWords = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String line;       
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");  
            for (String word : words) {
                uniqueWords.add(word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")); 
            }
        }
        reader.close();
        return new ArrayList<>(uniqueWords);
    }

// Función 9
	public static double longitudMedia(String filename, String sep) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int totalLength = 0;
        int lineCount = 0;        
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(sep);
            totalLength += columns.length;  
            lineCount++;
        }
        reader.close();
        if (lineCount == 0) {
            return 0; 
        }
        return (double) totalLength / lineCount;
    }
	
//Test	
	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(contadorDePalabras("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\lin_quijote.txt", " ", "Quijote")); //El fichero solo contiene una vez la palabra "Quijote" con la primera mayúscula.
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(buscadorDePalabras("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\lin_quijote.txt", "Quijote"));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(buscadorDePalabrasÚnicas("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\archivo_palabras.txt"));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(longitudMedia("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\lin_quijote.txt", " "));
	}

}
