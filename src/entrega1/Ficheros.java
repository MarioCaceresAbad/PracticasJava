package entrega1;



import java.util.ArrayList;
import java.util.List;
import us.lsi.tools.File2;

public class Ficheros {
	//Apartado 6
	public static Integer Palabras(String fichero, String sep, String cad) {
		int res = 0;
		//si esta vacio		
		List<String> lista = File2.lineasDeFichero(fichero);
		if (lista == null || lista.isEmpty()) {
            return 0;
		}
		if (cad == null || cad.isEmpty()) {
            return 0;
		}
		if (sep == null || sep.isEmpty()) {
            return 0;
		}
            
        //cadena dada
        String cadenamod = cad.toLowerCase();
        
         //palabra en el fichero
		for (String cadena:lista) {
			String[] palabras = cadena.split(sep);
			for (String palabra : palabras) {
				String palabra2 = palabra.toLowerCase();
				if (palabra2.contains(cadenamod)) {
					res++;
				} 
			}
		}
		return res;
	}	
	
	//Apartado 7
	public static List<String> Lineas(String fichero, String cad) {
		List<String> lista = File2.lineasDeFichero(fichero);
		List<String> lista2 = new ArrayList<String>();
		
		if (lista == null || lista.isEmpty()) {
            return null;
		}
		if (cad == null || cad.isEmpty()) {
            return null;
		}
		
		String cadenamod = cad.toLowerCase();
		for (String linea:lista) {
			String[] palabras = linea.split("  ");
			for (String palabra:palabras) {
				String palabra2 = palabra.toLowerCase();
				if (palabra2.contains(cadenamod)) {
					lista2.add(linea.trim());				
				}
			}
		}
		return lista2;
	}
	
	//Apartado 8
	public static List<String> PalabrasUnicas(String fichero) {
		List<String> lista = File2.lineasDeFichero(fichero);
		List<String> lista2 = new ArrayList<String>();
		
		if (lista == null || lista.isEmpty()) {
            return null;
		}
		
		for (String linea:lista) {
			String[] palabras = linea.split(" ");
			for (String palabra : palabras) {
				if (!lista2.contains(palabra)) {
					lista2.add(palabra);
				}
			}
		}
		return lista2;
	}
	
	//Apartado 9
	public static Double Longitud(String fichero, String sep) {
		double lin= 0.;
		double pal = 0.;
		List<String> lista = File2.lineasDeFichero(fichero);
		
		if (lista == null || lista.isEmpty() || sep == null || sep.isEmpty()) {
			return 0.;
		}
		
		for (String linea:lista) {
			lin++;
			String[] palabras = linea.split(sep);
			for (String palabra:palabras) {
				pal++;
			}
		}
		if (lin == 0. || pal == 0.) {
			return 0.;
		}
		return pal/lin;
	}

//Test	
	public static void main(String[] args) {
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(Palabras("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\lin_quijote.txt", " ", "Quijote")); //El fichero solo contiene una vez la palabra "Quijote" con la primera mayúscula.
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(Lineas("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\lin_quijote.txt", "Quijote"));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(PalabrasUnicas("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\archivo_palabras.txt"));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(Longitud("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\palabras_random.csv", ","));
		System.out.println(Longitud("C:\\Users\\mario\\Desktop\\datos-entregable-01 (3)\\vacio.csv", " "));
	}

}
