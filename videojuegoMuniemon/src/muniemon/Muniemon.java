package muniemon;

public class Muniemon {
	private String nombre;
	private int vida;
	private int defensa;
	private Tipo tipo;
	private int ataque;
	private int velocidad;

	public Muniemon() {
		super();
	}

	public Muniemon(String nombre, int vida, int defensa, Tipo tipo,int ataque, int velocidad) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.defensa = defensa;
		this.tipo = tipo;
		this.ataque = ataque;
		this.velocidad = velocidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	    
	    public double obtenerMultiplicador(Tipo tipoAtacado) {
	        // Calcula el multiplicador de daño basado en los tipos
	        switch (tipo) {
	            case PLANTA:
	                return tipoAtacado == Tipo.AGUA ? 1.5 : 1.0;
	            case FUEGO:
	                return tipoAtacado == Tipo.PLANTA ? 1.5 : 1.0;
	            case AGUA:
	                return tipoAtacado == Tipo.FUEGO ? 1.5 : 1.0;
	            default:
	                return 1.0;
	        }
	    }

	    public void atacar(Muniemon muniemon) {
	        System.out.println(this.getNombre() + " ataca a " + muniemon.getNombre());
	        
	        if (muniemon.getVida() <= 0) {
	            System.out.println("No se puede atacar al muniemon porque está muerto");
	        } else {
	            // Obtener el multiplicador de daño basado en los tipos
	            double multiplicador = this.obtenerMultiplicador(muniemon.getTipo());
	            
	            // Calcular el daño basado en el ataque y el multiplicador
	            int danio = (int) (this.getAtaque() * multiplicador) - muniemon.getDefensa();
	            
	            if (danio > 0) {
	                System.out.println(muniemon.getNombre() + " ha sido atacado, el daño es de: " + danio);
	                int vidaFinal = muniemon.getVida() - danio;
	                muniemon.setVida(vidaFinal); // Actualizar la vida del muniemon atacado
	                
	                if (muniemon.getVida() <= 0) {
	                    System.out.println(muniemon.getNombre() + " fue derrotado");
	                } else {
	                    System.out.println("La vida de " + muniemon.getNombre() + " es: " + muniemon.getVida());
	                }
	            } else {
	                System.out.println("El ataque de " + this.getNombre() + " no inflige daño a " + muniemon.getNombre());
	            }
	        }
	    }
	}



