package defensa2;
import java.util.*;

public class Test {
	 public static void main(String[] args) {
	        Cliente ana = Cliente.of("Ana", 5);
	        Cliente juan = Cliente.of("Juan", 2);
	        Cliente luis = Cliente.of("Luis", 7);

	        Compra c1 = Compra.of(ana, "Agenda personalizada", 25.5);
	        Compra c2 = Compra.of(juan, "Camiseta estampada", 60.0);
	        Compra c3 = Compra.of(ana, "Taza con foto", 15.0);
	        Compra c4 = Compra.of(luis, "Poster gigante", 80.0);

	        System.out.println("---- Prueba ClientesPorAntiguedad ----");
	        ClientesPorAntiguedad listaClientes = new ClientesPorAntiguedad();
	        listaClientes.add(luis);
	        listaClientes.add(ana);
	        listaClientes.add(juan);
	        System.out.println("Top 2 clientes por antigüedad: " + listaClientes.topClientes(2)); // Luis, Ana

	        System.out.println("\n---- Prueba HistorialCompras ----");
	        HistorialCompras historial = new HistorialCompras();
	        historial.add(c1);
	        historial.add(c2);
	        historial.add(c3);
	        historial.add(c4);

	        System.out.println("Total gastado por Ana: " + historial.totalGastadoPor(ana)); // 40.5
	        System.out.println("Compras mayores a 30€: " + historial.comprasMayoresA(30)); // c2, c4

	        System.out.println("\n---- Prueba ColaComprasPendientes ----");
	        ColaComprasPendientes cola = new ColaComprasPendientes();
	        cola.add(c1);
	        cola.add(c2);
	        cola.add(c3);
	        cola.add(c4);

	        System.out.println("Buscar compra con 'foto': " + cola.buscarCompraPorDescripcion("foto")); // c3
	        System.out.println("Filtrar compras de Ana con 'Taza': " + cola.filtrarPorClienteYProducto(ana, "Taza")); // c3

	        System.out.println("\n---- Prueba EstadisticasClientes ----");
	        List<Compra> todas = List.of(c1, c2, c3, c4);
	        Map<Cliente, List<Compra>> agrupadoImp = EstadisticasClientes.agruparComprasPorClienteImperativo(todas);
	        Map<Cliente, List<Compra>> agrupadoFunc = EstadisticasClientes.agruparComprasPorClienteFuncional(todas);

	        System.out.println("Agrupación imperativa:");
	        agrupadoImp.forEach((cliente, compras) ->
	            System.out.println(cliente + " -> " + compras));

	        System.out.println("Agrupación funcional:");
	        agrupadoFunc.forEach((cliente, compras) ->
	            System.out.println(cliente + " -> " + compras));
	    }
	}