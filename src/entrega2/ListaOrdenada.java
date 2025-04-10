package entrega2;
import java.util.*;

public class ListaOrdenada<E> extends AgregadoLineal<E> {
    private final Comparator<E> comparator;

    public ListaOrdenada(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public static <E> ListaOrdenada<E> of(Comparator<E> comparator) {
        return new ListaOrdenada<>(comparator);
    }

    private int indexOrder(E e) {
        int i = 0;
        while (i < elementos.size() && comparator.compare(elementos.get(i), e) < 0) {
            i++;
        }
        return i;
    }

    @Override
    public void add(E e) {
        elementos.add(indexOrder(e), e);
    }
    
    public static void main(String[] args) {
        System.out.println("----- Prueba de ListaOrdenada -----");

        // Crear una lista ordenada con números enteros
        ListaOrdenada<Integer> lista = new ListaOrdenada<>(Integer::compareTo);

        // Añadir elementos
        System.out.println("\nAñadiendo elementos: 5, 2, 8, 1, 3");
        lista.add(5);
        lista.add(2);
        lista.add(8);
        lista.add(1);
        lista.add(3);

        // Mostrar elementos
        System.out.println("Elementos en la lista: " + lista.elements());

        // Tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.size());

        // Eliminar el primer elemento
        System.out.println("\nEliminando el primer elemento: " + lista.remove());

        // Mostrar elementos después de eliminar
        System.out.println("Elementos después de eliminar: " + lista.elements());

        // Añadir elementos en lote
        List<Integer> lote = Arrays.asList(4, 6, 7);
        lista.addAll(lote);
        System.out.println("\nAñadiendo elementos en lote: 4, 6, 7");

        // Mostrar elementos después de añadir en lote
        System.out.println("Elementos después de añadir lote: " + lista.elements());

        // Eliminar todos los elementos
        System.out.println("\nEliminando todos los elementos: " + lista.removeAll());

        // Comprobar si la lista está vacía
        System.out.println("¿Está vacía? " + lista.isEmpty());

        // Prueba con Strings
        System.out.println("\n----- Prueba con Strings -----");
        ListaOrdenada<String> listaStrings = new ListaOrdenada<>(String::compareTo);
        listaStrings.add("banana");
        listaStrings.add("apple");
        listaStrings.add("cherry");
        listaStrings.add("date");

        // Mostrar elementos ordenados
        System.out.println("Elementos ordenados: " + listaStrings.elements());
    }
}

