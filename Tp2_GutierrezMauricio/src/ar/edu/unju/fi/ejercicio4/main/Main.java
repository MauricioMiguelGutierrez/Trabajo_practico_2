package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;


public class Main {
	private static Scanner sc;
	private static List<Jugador> jugadores;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		jugadores = new ArrayList<>();
		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
				case 1: cargarJugador(); break;
				case 2: mostrar(); break;
				case 3: modificar(); break;
				case 4: eliminar(); break;
				case 5:System.out.println("Fin del programa");
				break;
			default:System.out.println("Opcion incorreta");
			}
		} while (opcion != 5);
		
	}
	
	public static int menu() {
		int respuesta;
			System.out.println("1_ Alta jugador: ");
			System.out.println("2_ Mostrar todos los jugadores: ");
			System.out.println("3_ Modificar la posicion de un jugador: ");
			System.out.println("4_Eliminar un jugador");
			System.out.println("5_ Salir: ");
			respuesta = validar("Elija una opcion: ");
		return respuesta;
	}
	
	public static int validar(String mensaje) {
		int numero=0;
		while(true) {
			try {
				System.out.println("\n"+mensaje);
				numero = sc.nextInt();
				if(numero >= 0) {
					return  numero;
				}
			}catch(Exception e) {
				System.out.println("Error valor ingresado incorrecto");
				sc.nextLine();
			}
		}	

	}
		
	public static double validarDouble(String mensaje) {
		double numero=0;
		while(true) {
			try {
				System.out.println("\n"+mensaje);
				numero = sc.nextDouble();
				if(numero >= 0) {
					return  numero;
				}
			}catch(Exception e) {
				System.out.println("Error valor ingresado incorrecto");
				sc.nextLine();
			}
		}	

	}

	public static void cargarJugador() {
		sc.nextLine();
		System.out.println("Ingrese el nombre: ");
		String nombre = sc.next();
		System.out.println("Ingrese el apellido: ");
		String apellido = sc.next();
		int dia = validar("Ingrese el dia de nacimiento: ");
		int mes = validar("Ingrese el mes de nacimiento: ");
		int anio = validar("Ingrese el año de nacimiento: ");
		System.out.println("Ingrese su nacionalidad: ");
		String nacionalidad = sc.next();
		double altura = validarDouble("Ingrese su estatura");
		double peso = validarDouble("Ingrese su peso");
		Posicion posicion = asignarPosicion("Posiciones");
		jugadores.add(new Jugador(nombre,apellido,LocalDate.of(anio, mes, dia),nacionalidad,altura,peso,posicion));
	}
	
	public static Posicion asignarPosicion(String mensaje) {
		while(true) {
			System.out.println("\n"+mensaje);
			int numero = menuPosicion();
			switch (numero) {
			case 1: return Posicion.DELANTERO;
			case 2: return Posicion.MEDIO;
			case 3: return Posicion.DEFENSA;
			case 4: return Posicion.ARQUERO;
			default: 
				System.out.println("Posicion ingresada incorrecta"); 
				sc.nextLine();
				break;
			}
		}
	}
	
	public static int menuPosicion() {
		System.out.println("1_ Delantero");
		System.out.println("2_ Medio");
		System.out.println("3_ Defensa");
		System.out.println("4_ Aquero");
		int numero = validar("Elija una opcion: ");
		return numero;
	}
	
	public static void mostrar() {
		System.out.println("##### Lista de Jugadores #####");
		jugadores.forEach(j->System.out.println(j));
	}
	
	public static int buscarJugador(String nombre, String apellido) {
		int i = 0;
		while(i < jugadores.size()) {
			if(jugadores.get(i).getNombre().equals(nombre) && jugadores.get(i).getApellido().equals(apellido)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public static void modificar() {
		System.out.println("Ingrese  su nombre: ");
		String nombre = sc.next();
		System.out.println("Ingrese su apellido: ");
		String apellido = sc.next();
		int encontrado = buscarJugador(nombre, apellido);
		if(encontrado != -1) {
			Posicion posicion = asignarPosicion("Modificacion de Posicion");
			jugadores.get(encontrado).setPosicion(posicion);
		}
		else {
			System.out.println("el jugador ingresado no existe");
		}
	}
	
	public static void eliminar() {
		Iterator<Jugador> iterator = jugadores.iterator();
		System.out.println("Ingrese el nombre: ");
		String nombre = sc.next();
		System.out.println("Ingrese el apellido");
		String apellido = sc.next();
		while(iterator.hasNext()) {
			Jugador jugador = iterator.next();
			if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
				iterator.remove();
			}
		}
	}
	
}