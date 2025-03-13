package defensa1;
import java.io.*;
import java.util.*;

public class funcionesDedefensa {
    public static long productoImpares(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El número debe ser mayor que 0");
        }
        
        long producto = 1;
        int contador = 0;
        int numero = 1;
        
        while (contador < n) {
            producto *= numero;
            numero += 2;
            contador++;
        }
        
        return producto;
    }
    
    public static double sumaGeometricaAlternada(double a1, double r, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k debe ser mayor que 0");
        }
        if (a1 <= 0 || r <= 0) {
            throw new IllegalArgumentException("a1 y r deben ser positivos");
        }
        
        double suma = 0;
        for (int n = 0; n < k; n++) {
            suma += Math.pow(-1, n) * a1 * Math.pow(r, n);
        }
        
        return suma;
    }
    
    public static long combinatorioSinMultiplosDeTres(int n, int k) {
    	if (n < k || n < 0 || k < 0) {
            throw new IllegalArgumentException("n debe ser mayor o igual a k y ambos deben ser positivos");
        }
        
        long numerador = 1, denominador = 1;
        int countNumerador = 0, countDenominador = 0;
        
        // Calculamos el numerador (n! sin múltiplos de 3)
        for (int i = n; i > 0; i--) {
            if (i % 3 != 0) {  // Si no es múltiplo de 3
                numerador *= i;
                countNumerador++;
            }
            // Solo detenernos cuando hayamos añadido k elementos no múltiplos de 3
            if (countNumerador == k) {
                break;
            }
        }
        
        // Calculamos el denominador (k! sin múltiplos de 3)
        for (int i = k; i > 0; i--) {
            if (i % 3 != 0) {  // Si no es múltiplo de 3
                denominador *= i;
                countDenominador++;
            }
            // Solo detenernos cuando hayamos añadido k elementos no múltiplos de 3
            if (countDenominador == k) {
                break;
            }
        }
        
        return numerador / denominador;
    }
    
    public static List<String> filtrarLineasConsecutivas(String nombreArchivo, List<String> palabrasClave) {
        List<String> lineasFiltradas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                
                for (int i = 0; i < palabras.length - 1; i++) {
                    if (palabrasClave.contains(palabras[i]) && palabrasClave.contains(palabras[i + 1])) {
                        lineasFiltradas.add(linea);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return lineasFiltradas;
    }
    
    public static void main(String[] args) {
        int n = 5; // Ejemplo de uso
        try {
            long resultado = productoImpares(n);
            System.out.println("El producto de los primeros " + n + " números impares es: " + resultado);
            
            double a1 = 2.0, r = 3.0;
            int k = 4;
            double suma = sumaGeometricaAlternada(a1, r, k);
            System.out.println("La suma de la secuencia geométrica alternada es: " + suma);
            
            int nComb = 7, kComb = 3;
            long combinatorio = combinatorioSinMultiplosDeTres(nComb, kComb);
            System.out.println("El combinatorio sin múltiplos de 3 es: " + combinatorio);
            
            // Prueba de filtrarLineasConsecutivas
            List<String> palabrasClave = Arrays.asList("QUIJOTE", "INGENIOSO", "HIDALGO");
            List<String> lineas = filtrarLineasConsecutivas("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\lin_quijote.txt", palabrasClave);
            System.out.println("Líneas filtradas: " + lineas);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

