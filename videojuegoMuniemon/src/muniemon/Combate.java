package muniemon;

import java.util.Scanner;

public class Combate {

	private Muniemon muniemon1;
	private Muniemon muniemon2;

	public Combate(Muniemon muniemon1, Muniemon muniemon2) {
		super();
		this.muniemon1 = muniemon1;
		this.muniemon2 = muniemon2;
	}
	public Muniemon empezarCombate() {
	    Scanner sc = new Scanner(System.in);
	    int turno = 1;
	    Muniemon primerAtacante = null;
	    Muniemon segundoAtacante = null;
	    
	    if (this.muniemon1.getVida() <= 0 || this.muniemon2.getVida() <= 0) {
	        System.out.println("No se puede comenzar el combate porque uno de los Muniemon está muerto.");
	        return null;
	    }
	    
	    if (this.muniemon1.getVelocidad() > this.muniemon2.getVelocidad()) {
	        primerAtacante = muniemon1;
	        segundoAtacante = muniemon2;
	    } else {
	        primerAtacante = muniemon2;
	        segundoAtacante = muniemon1;
	    }
	    
	    while (primerAtacante.getVida() > 0 && segundoAtacante.getVida() > 0) {
	        System.out.println("Turno: " + turno++);
	        System.out.println("Vida de " + primerAtacante.getNombre() + ": " + primerAtacante.getVida());
	        System.out.println("Vida de " + segundoAtacante.getNombre() + ": " + segundoAtacante.getVida());
	        System.out.println("Pulse enter para continuar con el combate");
	        sc.nextLine();
	        
	        primerAtacante.atacar(segundoAtacante);
	        System.out.println("Vida de " + segundoAtacante.getNombre() + " después del ataque: " + segundoAtacante.getVida());
	        
	        if (segundoAtacante.getVida() <= 0) {
	            break;
	        }
	        
	        segundoAtacante.atacar(primerAtacante);
	        System.out.println("Vida de " + primerAtacante.getNombre() + " después del contraataque: " + primerAtacante.getVida());
	        
	        if (primerAtacante.getVida() <= 0) {
	            break;
	        }
	    }
	    

	   if (primerAtacante.getVida() > 0) {
	        System.out.println("El ganador es: " + primerAtacante.getNombre());
	        return primerAtacante;
	    } else {
	        System.out.println("El ganador es: " + segundoAtacante.getNombre());
	        return segundoAtacante;  
	    }
	}
}