package entrega3.test;
import us.lsi.biblioteca.*;

import java.util.*;

import entrega3.preguntas.PreguntasBiblioteca;

public class TestBiblioteca {
	public static void main(String[] args) {
		Biblioteca biblioteca = Biblioteca.of("Biblioteca","42007","biblioteca@gmail.com");
		PreguntasBiblioteca preguntas = new PreguntasBiblioteca(biblioteca);
		
		Map.Entry<Libro,Integer> libroMasPrestado = preguntas.masVecesPrestadoImperativo();
		System.out.println("El libro más prestado es: " + libroMasPrestado.getKey().titulo() + " con " + libroMasPrestado.getValue() + " préstamos.");
		Map.Entry<Libro,Integer> libroMasPrestado2 = preguntas.masVecesPrestadoImperativo();
		System.out.println("El libro más prestado es: " + libroMasPrestado2.getKey().titulo() + " con " + libroMasPrestado2.getValue() + " préstamos.");
		
		Map<String, Set<String>> librosPorAutor = preguntas.librosPorAutorImperativo(biblioteca.libros(), null);
		System.out.println("Los libros por autor son: "+ librosPorAutor);
		Map<String, Set<String>> librosPorAutor2 = preguntas.librosPorAutorFuncional(biblioteca.libros(), null);
		System.out.println("Los libros por autor son: "+ librosPorAutor2);
	}
}
