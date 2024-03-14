package muniemon;

import java.util.ArrayList;
import java.util.Scanner;

public class aplicacionMuniemon {

	private static Scanner sc;
	
	public static void main(String[] args) {
		System.out.println("Bienvenido al increible videojuego Muniemon");
		System.out.println("Seleccione la opcion que desee del siguiente menu");
		menu();
		
	}
	public static void menu() {
		sc = new Scanner(System.in);
		Muniemon muniemon = null;
		ArrayList<Muniemon> listaMuniemons = new ArrayList<>();
		
		int opcion = 0;
		do {	
		System.out.println("----------menú----------");
		System.out.println("1. Dar de alta Muniemon");
		System.out.println("2. Mostrar Muniemons");
		System.out.println("3. Empezar combate");
		System.out.println("4. Salir del programa");
		opcion = sc.nextInt();
		switch(opcion) {
		case 1:
			if(listaMuniemons.size() != 2) {
				muniemon = altaMuniemon();
				listaMuniemons.add(muniemon);
			}else {
				System.out.println("Solo se permiten 2 Muniemosn :)");
			}

			break;
		case 2:
			for(Muniemon m : listaMuniemons) {
				mostrarMuniemon(m);
			}
			break;
		case 3:
			Combate combate = new Combate(listaMuniemons.get(0), listaMuniemons.get(1));
			combate.empezarCombate();
			break;
		case 4:
			System.out.println("saliste del programa");
			break;
		default:
			System.out.println("opción no valida");
		   }	
		}while(opcion != 4);
		sc.close();
	}
	
	public static Muniemon altaMuniemon() {

			System.out.println("introduzca el nombre de su Muniemon");
			sc.nextLine();
			String nombre = sc.nextLine();
			System.out.println("introduzca la vida de su Muniemon");
			int vida = sc.nextInt();
			System.out.println("introduzca la defensa de su Muniemon");
			int defensa = sc.nextInt();
			System.out.println("Introduzca el ataque");
			int ataque = sc.nextInt();
			System.out.println("Introduzca la velocidad de su Muniemon");
			int velocidad = sc.nextInt();
			System.out.println("introduzca el tipo de Muniemon");
			for(int i = 0; i < Tipo.values().length; i ++) {
				System.out.println(i+ "." + Tipo.values()[i]);
			}
			int seleccion = sc.nextInt();
			Tipo tipo = Tipo.values()[seleccion];
			System.out.println("El tipo del Muniemon es: " + tipo);
			Muniemon muniemon = new Muniemon(nombre, vida, defensa, tipo, velocidad);
			return muniemon;
		   }

	public static void mostrarMuniemon(Muniemon muniemon) {
		  if (muniemon != null) {
	            System.out.println("Detalles del Muniemon:");
	            System.out.println("Nombre: " + muniemon.getNombre());
	            System.out.println("Vida: " + muniemon.getVida());
	            System.out.println("Defensa: " + muniemon.getDefensa());
	            System.out.println("Tipo: " + muniemon.getTipo());
	            System.out.println();
	        } else {
	            System.out.println("No hay Muniemon para mostrar");
		}

	}

}
