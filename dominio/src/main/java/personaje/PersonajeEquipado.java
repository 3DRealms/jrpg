package personaje;

import interfaces.Atacable;

public abstract class PersonajeEquipado extends Personaje {

	private Personaje pj;

	public PersonajeEquipado(Personaje personaje) {
		super(personaje.nombre);
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
	public int getEnergia() {
		return pj.getEnergia();
	}
	public int getIntelecto() {
		return pj.getIntelecto();
	}
	@Override
	public  boolean lanzarHabilidad(String conjuro, Personaje personaje){
		return pj.lanzarHabilidad(conjuro, personaje);
	}

	@Override
	public void atacar(Atacable atacado) {
			pj.atacar(atacado);
	}
}
