
package entrega1;
import java.util.function.Function;
import java.io.*;
import java.util.*;


public class Funciones {
	
// Función 1
	public static Integer multiplicador(Integer n, Integer k) {
		Integer m = 1;
		for (int i = 0; i<k; i++) {
			m *= (n - i + 1);
		}
		return m;
	}
	
// Función 2
	public static Integer secuencia(Integer a1, Integer r, Integer k) {
		int producto = 1;  
        int termino = a1;  

        for (int i = 0; i < k; i++) {
            producto *= termino;  
            termino *= r;  
        }
           return producto;
	}

//Factorial
	public static Double factorial(Integer num) {
		Double resultado = 1.;
		for (int i = 1; i <= num; i++) {
			resultado *= i;
		}
		return resultado;	
	}

// Función 3
	public static Double númeroCombinatorio(int n, int k) {
        if (k > n) return 0.; 
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
	
// Función 4
	public static Double sumatorio(Integer n, Integer k) {
		Double S= 0.0;
		for (int i = 0; i <k; i++) {
			S += Math.pow(-1, i) * númeroCombinatorio(k + 1, i + 1)* Math.pow(k - i, n);
		}
		return S/factorial(k);
	}
	
// Función 5
	public static double métodoNewton(Function<Double, Double> f, Function<Double, Double> df, double a, double epsilon) {
        double x = a;
        while (Math.abs(f.apply(x)) > epsilon) {
            double fx = f.apply(x);
            double dfx = df.apply(x);
            if (dfx == 0) {
                throw new ArithmeticException("Derivada es cero, el método de Newton no puede continuar.");
            }
            x = x - fx / dfx;
        }
        return x;
    }
	
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
		System.out.println(multiplicador(4, 2));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(secuencia(3, 5, 2));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(númeroCombinatorio(4, 2));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(sumatorio(4, 2));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(métodoNewton(x -> 2 * Math.pow(x, 2), x -> 4 * x, 3, 0.001));
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
