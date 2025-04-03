package entrega2;
import java.util.*;

class ListaOrdenadaSinRepeticion<E> extends ListaOrdenada<E> {
    public ListaOrdenadaSinRepeticion(Comparator<E> comparator) {
        super(comparator);
    }

    public static <E> ListaOrdenadaSinRepeticion<E> of(Comparator<E> comparator) {
        return new ListaOrdenadaSinRepeticion<>(comparator);
    }

    @Override
    public void add(E e) {
        if (!elements().contains(e)) {
            super.add(e);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("----- Prueba de ListaOrdenadaSinRepeticion -----");

        // Crear una lista ordenada sin repetición con números enteros
        ListaOrdenadaSinRepeticion<Integer> lista = new ListaOrdenadaSinRepeticion<>(Integer::compareTo);

        // Añadir elementos (incluyendo duplicados)
        System.out.println("\nAñadiendo elementos: 5, 2, 8, 1, 3, 5, 2");
        lista.add(5);
        lista.add(2);
        lista.add(8);
        lista.add(1);
        lista.add(3);
        lista.add(5); // Duplicado
        lista.add(2); // Duplicado

        // Mostrar elementos (sin repetidos)
        System.out.println("Elementos en la lista: " + lista.elements());

        // Tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.size());
        System.out.println("Se esperan 5 elementos únicos ordenados");

        // Eliminar el primer elemento
        System.out.println("\nEliminando el primer elemento: " + lista.remove());

        // Mostrar elementos después de eliminar
        System.out.println("Elementos después de eliminar: " + lista.elements());

        // Añadir elementos en lote (incluyendo duplicados)
        List<Integer> lote = Arrays.asList(4, 6, 7, 4); // 4 repetido
        lista.addAll(lote);
        System.out.println("\nAñadiendo elementos en lote: 4, 6, 7, 4");

        // Mostrar elementos después de añadir en lote
        System.out.println("Elementos después de añadir lote: " + lista.elements());
        System.out.println("Se espera que el 4 aparezca solo una vez");
    }
}
