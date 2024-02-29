package muniemon;

import java.util.Scanner;

public class aplicacionMuniemon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al increible videojuego Muniemon");
		System.out.println("Seleccione la opcion que desee del siguiente menu");
		menu(sc);
		
	}
	public static void menu(Scanner sc) {
		Muniemon muniemon = null;
		int opcion = 0;
		do {	
		System.out.println("----------menú----------");
		System.out.println("1. Dar de alta Muniemon");
		System.out.println("2. Mostrar Muniemon");
		System.out.println("3. Salir del programa");
		opcion = sc.nextInt();
		switch(opcion) {
		case 1:
			muniemon = altaMuniemon(sc);
			break;
		case 2:
			mostrarMuniemon(muniemon);
			break;
		case 3:
			System.out.println("saliste del programa");
			break;
		default:
			System.out.println("opción no valida");
		   }	
		}while(opcion != 3);
		sc.close();
	}
	
	public static Muniemon altaMuniemon(Scanner sc) {

			System.out.println("introduzca el nombre de su Muniemon");
			sc.nextLine();
			String nombre = sc.nextLine();
			System.out.println("introduzca la vida de su Muniemon");
			int vida = sc.nextInt();
			System.out.println("introduzca la defensa de su Muniemon");
			int defensa = sc.nextInt();
			System.out.println("introduca el tipo de Muniemon");
			for(int i = 0; i < Tipo.values().length; i ++) {
				System.out.println(i+ "." + Tipo.values()[i]);
			}
			int seleccion = sc.nextInt();
			Tipo tipo = Tipo.values()[seleccion];
			System.out.println("El tipo del Muniemon es: " + tipo);
			Muniemon muniemon = new Muniemon(nombre, vida, defensa, tipo);
			return muniemon;
		   }

	public static void mostrarMuniemon(Muniemon muniemon) {
		  if (muniemon != null) {
	            System.out.println("Detalles del Muniemon:");
	            System.out.println("Nombre: " + muniemon.getNombre());
	            System.out.println("Vida: " + muniemon.getVida());
	            System.out.println("Defensa: " + muniemon.getDefensa());
	            System.out.println("Tipo: " + muniemon.getTipo());
	        } else {
	            System.out.println("No hay Muniemon para mostrar");
		}

	}

}
