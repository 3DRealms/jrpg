package personaje;

public abstract class PersonajeEquipado extends Personaje {

	private Personaje pj;

	public PersonajeEquipado(Personaje personaje) {
		super();
		this.pj = personaje;
	}

	public int obtenerPuntosDeDefensa() {
		return pj.obtenerPuntosDeDefensa();
	}
	public int obtenerPuntosDeAtaque(){
		return pj.obtenerPuntosDeAtaque();
	}
	protected int calcularPuntosDeAtaque() {
		return pj.calcularPuntosDeAtaque() ;
	}
	public boolean puedeAtacar(){
		return pj.puedeAtacar();
	}
}
