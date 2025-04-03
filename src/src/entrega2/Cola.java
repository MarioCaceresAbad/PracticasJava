package entrega2;
import java.util.*;

class Cola<E> extends AgregadoLineal<E> {
    public static <E> Cola<E> of() {
        return new Cola<>();
    }

    @Override
    public void add(E e) {
        elementos.add(e);
    }
    
    public static void main(String[] args) {
        System.out.println("----- Prueba de Cola (FIFO) -----");

        // Crear una cola de Strings
        Cola<String> cola = new Cola<>();

        // Añadir elementos a la cola
        System.out.println("\nAñadiendo elementos: 'primero', 'segundo', 'tercero'");
        cola.add("primero");
        cola.add("segundo");
        cola.add("tercero");

        // Mostrar elementos en la cola
        System.out.println("Elementos en la cola: " + cola.elements());
        System.out.println("Tamaño de la cola: " + cola.size());

        // Desencolando elementos
        System.out.println("\nDesencolando elementos:");
        try {
            System.out.println("Desencolado: " + cola.remove());
            System.out.println("Cola restante: " + cola.elements());

            System.out.println("Desencolado: " + cola.remove());
            System.out.println("Cola restante: " + cola.elements());

            System.out.println("Desencolado: " + cola.remove());
            System.out.println("Cola restante: " + cola.elements());

            System.out.println("\n¿Está vacía? " + cola.isEmpty());

            // Intentar eliminar de una cola vacía (debería lanzar excepción)
            System.out.println("\nIntentando desencolar de una cola vacía...");
            cola.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Excepción correctamente lanzada al intentar desencolar de una cola vacía: " + e.getMessage());
        }
    }
}
