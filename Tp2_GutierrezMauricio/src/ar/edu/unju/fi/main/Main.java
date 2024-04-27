package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.constantes.Categoria;
import ar.edu.unju.fi.constantes.OrigenFabricacion;
import ar.edu.unju.fi.model.Producto;

public class Main {

	private static void menu (int opcion) {
		
		System.out.println("Menu");
		System.out.println("1 – Crear Producto");
		System.out.println("2 – Mostrar productos");
		System.out.println("3 – Modificar producto (sólo puede modificar: descripción, precio unitario, origen fabricación \r\n"
				+ "o categoría)");
		System.out.println("4 – Salir");
		Scanner scanner = new Scanner(System.in);
		opcion = scanner.nextInt();	
		scanner.close();
	}
	private static void menuOpcionFabricacion (int opcion) {
		
		System.out.println("Menu");
		System.out.println("1 – Argentina");
		System.out.println("2 – China");
		System.out.println("3 – Brasil");
		System.out.println("4 – Uruguay");
		Scanner scanner = new Scanner(System.in);
		opcion = scanner.nextInt();	
		scanner.close();
	}
	
	private static void menuOpcionCategoria (int opcion) {
		
		System.out.println("Menu");
		System.out.println("1 – Telefonía");
		System.out.println("2 – Informática");
		System.out.println("3 –  Electro hogar");
		System.out.println("4 – Herramientas");
		Scanner scanner = new Scanner(System.in);
		opcion = scanner.nextInt();	
		scanner.close();
	}
	public static void main(String[] args) {
		
		
		int op=0 ;
		String codigo ,descripcion ,origenFabricacion, categoria;
		Float precioUnitario;
		
		
		List<Producto> productos = new ArrayList<>(); 
		do {
		menu(op);
		switch(op) {
		case 1:
			Producto producto = new Producto();
			System.out.println("");
			cargarDatos(producto);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
			default:
				
		}
		}while(op != 4);
	}
	private static void cargarDatos(Producto producto) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese codigo: ");
		producto.setCodigo(scanner.next());
		
		System.out.println("Ingrese descripcion: ");
		producto.setDescripcion(scanner.next());
		System.out.println("Ingrese precioUnitario: ");
		producto.setPrecioUnitario(scanner.nextFloat());
		int op =0;
		System.out.println("Ingrese Origen de fabricacion: ");
		menuOpcionFabricacion(op);
		switch(op) {
		case 1:
			producto.setOrigendeFabricacion(OrigenFabricacion.ARGENTINA);
			break;
		case 2:
			producto.setOrigendeFabricacion(OrigenFabricacion.CHINA);
			break;
		case 3:
			producto.setOrigendeFabricacion(OrigenFabricacion.BRASIL);
			break;
		case 4:
			producto.setOrigendeFabricacion(OrigenFabricacion.URUGUAY);
			break;
			default:
			System.out.println("no ingreso un valor valido, se selecciona Argentina por defecto");
			producto.setOrigendeFabricacion(OrigenFabricacion.ARGENTINA);
		}
		
		int opCategoria =0;
		System.out.println("Ingrese Categoria: ");
		menuOpcionCategoria (opCategoria);
		switch(opCategoria) {
		case 1:
			producto.setCategoria(Categoria.TELEFONIA);
			break;
		case 2:
			producto.setCategoria(Categoria.INFORMATICA);
			break;
		case 3:
			producto.setCategoria(Categoria.ELECTROHOGAR);
			break;
		case 4:
			producto.setCategoria(Categoria.HERRAMIENTAS);
			break;
			default:
			System.out.println("no ingreso un valor valido, se selecciona TELEFONIA por defecto");
			producto.setCategoria(Categoria.TELEFONIA);
		}
		
	}

}
