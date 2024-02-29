package muniemon;

public class Muniemon {
	private String nombre;
	private int vida;
	private int defensa;
	private Tipo tipo;
	private int ataque;

	public Muniemon() {
		super();
	}

	public Muniemon(String nombre, int vida, int defensa, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.defensa = defensa;
		this.tipo = tipo;
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

	public void atacar(Muniemon muniemon) {
		System.out.println(this.getNombre() + "ataca a" + muniemon.nombre);
		if (muniemon.vida <= 0) {
			System.out.println("No se puede atacar al muniemon porque esta muerto");
		} else {
			int vidaFinal = 0;
			int danio = this.getAtaque() - muniemon.defensa;
			if (danio > 0) {
				System.out.println(muniemon.nombre + "ha sido atacado, el daño es de: " + danio);
				vidaFinal = muniemon.vida - danio;
				muniemon.vida = vidaFinal;
				if (muniemon.vida < 0) {
					System.out.println(muniemon.nombre + "fue derrotado");
				} else {
					System.out.println("la vida de " + muniemon.nombre + "es de: " + muniemon.vida);
				}
			}

		}

	}
}
