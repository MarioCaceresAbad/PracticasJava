package entrega2;
import java.util.*;

record PriorityElement<E, P extends Comparable<P>>(E value, P priority) {}

class ColaPrioridad<E, P extends Comparable<P>> extends Cola<PriorityElement<E, P>> {
    public static <E, P extends Comparable<P>> ColaPrioridad<E, P> ofPriority() {
        return new ColaPrioridad<>();
    }

    @Override
    public void add(PriorityElement<E, P> element) {
        elementos.add(element);
        elementos.sort(Comparator.comparing(PriorityElement::priority));
    }

    public void add(E value, P priority) {
        add(new PriorityElement<>(value, priority));
    }

    public List<E> valuesAsList() {
        List<E> values = new ArrayList<>();
        for (PriorityElement<E, P> elem : elementos) {
            values.add(elem.value());
        }
        return values;
    }

    public void decreasePriority(E value, P newPriority) {
        elementos.removeIf(e -> e.value().equals(value));
        add(value, newPriority);
    }

    public E removeValue() {
        return remove().value();
    }

    public void addAllValues(List<E> values, P priority) {
        for (E value : values) {
            add(value, priority);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("----- Prueba de ColaPrioridad -----");

        // Crear una cola de prioridad
        ColaPrioridad<String, Integer> colaPrioridad = new ColaPrioridad<>();

        // Añadir elementos con prioridad
        System.out.println("\nAñadiendo elementos con prioridad:");
        colaPrioridad.add("Crítico", 1);
        colaPrioridad.add("Normal", 3);
        colaPrioridad.add("Urgente", 2);
        colaPrioridad.add("Bajo", 4);

        // Mostrar elementos ordenados por prioridad
        System.out.println("\nElementos en la cola por prioridad: " + colaPrioridad.valuesAsList());
        System.out.println("Elementos con sus prioridades: " + colaPrioridad.elements());
        System.out.println("Tamaño de la cola: " + colaPrioridad.size());

        // Cambiar la prioridad de "Normal" de 3 a 1
        System.out.println("\nCambiando la prioridad de 'Normal' de 3 a 1:");
        colaPrioridad.decreasePriority("Normal", 1);
        System.out.println("Elementos con prioridad actualizada: " + colaPrioridad.valuesAsList());

        // Desencolando elementos según prioridad
        System.out.println("\nDesencolando elementos por prioridad:");
        try {
            while (!colaPrioridad.isEmpty()) {
                System.out.println("Desencolado: " + colaPrioridad.removeValue());
                System.out.println("Cola restante: " + colaPrioridad.valuesAsList());
            }

            System.out.println("\n¿Está vacía? " + colaPrioridad.isEmpty());

            // Intentar eliminar de una cola vacía (debería lanzar excepción)
            System.out.println("\nIntentando desencolar de una cola vacía...");
            colaPrioridad.removeValue();
        } catch (NoSuchElementException e) {
            System.out.println("Excepción correctamente lanzada al intentar desencolar de una cola vacía: " + e.getMessage());
        }

        // Prueba con addAll
        System.out.println("\nPrueba con addAll:");
        List<String> tareas = Arrays.asList("Tarea A", "Tarea B", "Tarea C");
        colaPrioridad.addAllValues(tareas, 2);
        System.out.println("Elementos añadidos en lote con prioridad 2: " + colaPrioridad.valuesAsList());

        colaPrioridad.add("Tarea Urgente", 1);
        System.out.println("Después de añadir 'Tarea Urgente' con prioridad 1: " + colaPrioridad.valuesAsList());
    }
}
