package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static Scanner sc;
	private static List<Efemeride> efemerides;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		efemerides = new ArrayList<>();
		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
				case 1: crearEfemeride(); break;
				case 2: mostrar(); break;
				case 3: modificar(); break;
				case 4: eliminar(); break;
				case 5: System.out.println("Fin del programa");
				break;
			default:System.out.println("Opcion incorreta");
			}
		} while (opcion != 5);
	}
	
	public static int menu() {
		int respuesta;
			System.out.println("\n1_ Crear Efemeride: ");
			System.out.println("2_ Motrar Efemerides: ");
			System.out.println("3_ Modificar Efemerides: ");
			System.out.println("4_ Eliminar Efemeride: ");
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
	
	public static void crearEfemeride() {
		sc.nextLine();
		int codigo = validar("Ingrese el codigo: ");
		Mes meses = asignarMes("Ingrese el numero del mes: ");
		int dia = validar("Ingrese el dia; ");
		System.out.println("Ingrese el detalle: ");
		String detalle = sc.next();
		efemerides.add(new Efemeride(codigo,meses,dia,detalle));
	}
	
	public static Mes asignarMes(String mensaje) {
		while(true) {
			int numero = validar(mensaje);
			switch (numero) {
			case 1: return Mes.ENERO;
			case 2: return Mes.FEBRERO;
			case 3: return Mes.MARZO;
			case 4: return Mes.ABRIL;
			case 5: return Mes.MAYO;
			case 6: return Mes.JUNIO;
			case 7: return Mes.JULIO;
			case 8: return Mes.AGOSTO;
			case 9: return Mes.SEPTIEMBRE;
			case 10: return Mes.OCTUBRE;
			case 11: return Mes.NOVIEMBRE;
			case 12: return Mes.DICIEMBRE;
			default: 
				System.out.println("Mes ingresado incorrecto"); 
				sc.nextLine();
				break;
			}
		}
	}
	
	public static void mostrar() {
		System.out.println("##### Lista Efemeride #####");
		efemerides.forEach(e->System.out.println(e));
	}
	
	public static void modificar() {
		System.out.println("####### Modificar Efemeride ######");
		int codigo = validar("Ingrese codigo para modificar: ");
		int encontrado = buscarEfemeride(codigo);
		if(encontrado != -1) {
			Mes meses = asignarMes("Ingrese nuevo mes: ");
			int dia = validar("Ingrese nuevo dia: ");
			System.out.println("Ingrese nuevo detalle: ");
			String detalle = sc.next();
			efemerides.get(encontrado).setMeses(meses);
			efemerides.get(encontrado).setDia(dia);
			efemerides.get(encontrado).setDetalle(detalle);
		}else {
			System.out.println("El codigo ingresado no existe");
		}
		
	}
	
	public static int buscarEfemeride(int numero) {
		int i = 0;
		while(i < efemerides.size()) {
			if(efemerides.get(i).getCodigo() == numero) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static void eliminar() {
		int codigo = validar("Ingrese codigo para eliminar efemeride: ");
		int encontrado = buscarEfemeride(codigo);
		if(encontrado != -1) efemerides.remove(encontrado);
		else System.out.println("El codigo ingresado no existe");
	}

}