package personaje;

import casta.Casta;

public abstract class PersonajeEquipado extends Personaje {

	private Personaje pj;

	public PersonajeEquipado(Personaje personaje) {
		super(personaje.nombre);
		this.pj = personaje;
	}
	
	public int getIntelecto() {
		return pj.getIntelecto();
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
	public int getEnergia() {
		return pj.getEnergia();
	}
	public Casta getCasta(){
		return pj.getCasta();
	}

}
