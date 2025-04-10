package entrega2;
import java.util.*;

public class Pila<E> extends AgregadoLineal<E> {
    @Override
    public void add(E e) {
        elementos.add(0, e);
    }

    public E top() {
        if (isEmpty()) throw new NoSuchElementException("La pila está vacía.");
        return elementos.get(0);
    }
    
    public static void main(String[] args) {
        System.out.println("----- Prueba de Pila (LIFO) -----");

        // Crear una pila
        Pila<Double> pila = new Pila<>();

        // Añadir elementos
        System.out.println("\nAñadiendo elementos: 1.1, 2.2, 3.3");
        pila.add(1.1);
        pila.add(2.2);
        pila.add(3.3);

        // Mostrar elementos en la pila
        System.out.println("\nElementos en la pila: " + pila.elements());
        System.out.println("Tamaño de la pila: " + pila.size());
        System.out.println("Elemento en el tope: " + pila.top());

        // Desapilando elementos
        System.out.println("\nDesapilando elementos:");
        try {
            while (!pila.isEmpty()) {
                System.out.println("Desapilado: " + pila.remove());
                System.out.println("Pila restante: " + pila.elements());
            }

            System.out.println("\n¿Está vacía? " + pila.isEmpty());

            // Intentar acceder al tope de una pila vacía (debería lanzar excepción)
            System.out.println("\nIntentando acceder al tope de una pila vacía...");
            pila.top();
        } catch (NoSuchElementException e) {
            System.out.println("Excepción correctamente lanzada al intentar acceder al tope de una pila vacía: " + e.getMessage());
        }
    }

}
