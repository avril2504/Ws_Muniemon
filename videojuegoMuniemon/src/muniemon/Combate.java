package muniemon;

import java.util.Scanner;

public class Combate {
	private static Scanner sc;
	private Muniemon muniemon1;
	private Muniemon muniemon2;

	public Combate(Muniemon muniemon1, Muniemon muniemon2) {
		super();
		this.muniemon1 = muniemon1;
		this.muniemon2 = muniemon2;
	}
	public Muniemon empezarCombate() {
		sc = new Scanner(System.in);
		int turno = 1;
		Muniemon primerAtacante = null;
		Muniemon segundoAtacante = null;
		if(this.muniemon1.getVelocidad() > this.muniemon2.getVelocidad()) {
			primerAtacante = muniemon1;
			segundoAtacante = muniemon2;
		}else {
			primerAtacante = muniemon2;
			segundoAtacante = muniemon1;
		}
		
		while(primerAtacante.getVida() > 0 && segundoAtacante.getVida() > 0) {
		System.out.println("Turno: " + turno++);
		System.out.println("Pulse enter para continuar con el combate");
		sc.nextLine();
		sc.nextLine();
		
		if(primerAtacante.getVida() <= 0 || segundoAtacante.getVida() <= 0) {
			break;
		}
		primerAtacante.atacar(segundoAtacante);
		if(primerAtacante.getVida() <= 0 || segundoAtacante.getVida() <= 0) {
			break;
		}
		segundoAtacante.atacar(primerAtacante);
		
		}
		if(primerAtacante.getVida() > 0) {
			System.out.println("El ganador es: " + primerAtacante.getNombre());
			return primerAtacante;
		}else {
			System.out.println("El ganador es: " + segundoAtacante.getNombre());
			return segundoAtacante;  
		}
	
	}

}
