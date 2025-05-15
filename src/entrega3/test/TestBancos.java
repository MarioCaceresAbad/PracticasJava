package entrega3.test;
import java.time.LocalDate;

import us.lsi.bancos.*;
import us.lsi.ejemplos_b1_tipos.Persona;
import java.util.Map;

import entrega3.preguntas.PreguntasBancos;

public class TestBancos {
	public static void main(String[] args) {
		
		Banco banco = Banco.of();
		PreguntasBancos preguntas = new PreguntasBancos(banco);
		LocalDate fecha = LocalDate.of(2000, 1, 1);
		
		Map<Persona,Double> prestamos = preguntas.valorTotalPrestamosImperativo(23,0.0,100000.0,fecha);
		System.out.println("Los préstamos suman: " + prestamos);
		Map<Persona,Double> prestamos2 = preguntas.valorTotalPrestamosFuncional(23,0.0,100000.0,fecha);
		System.out.println("Los préstamos suman: " + prestamos2);
		
		
	}
}
