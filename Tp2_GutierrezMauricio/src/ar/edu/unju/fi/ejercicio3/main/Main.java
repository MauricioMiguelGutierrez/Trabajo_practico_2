package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
	public static void main(String[] args) {
		Provincia[] provincia = new Provincia[6];
		cargar(provincia);
		mostrar(provincia);
	}
	
	public static void cargar(Provincia[] provincia) {
		provincia[0] = Provincia.JUJUY;
		provincia[1] = Provincia.SALTA;
		provincia[2] = Provincia.TUCUMAN;
		provincia[3] = Provincia.CATAMARCA;
		provincia[4] = Provincia.LARIOJA;
		provincia[5] = Provincia.SANTIAGODELESTERO;
	}

	public static void mostrar(Provincia[] provincia) {
		for(int i = 0; i < provincia.length; i++) {
			System.out.println("Cantidad de Poblacion: "+provincia[i].getCantidadPoblacion());
			System.out.println("Superficie: "+provincia[i].getSuperficie());
			System.out.println("Desidad Poblacional "+provincia[i].densidad());
			System.out.println("");
		}
	}
}