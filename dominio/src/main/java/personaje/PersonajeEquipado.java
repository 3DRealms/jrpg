package personaje;

import casta.Casta;

public abstract class PersonajeEquipado extends Personaje {

	private Personaje pj;

	public PersonajeEquipado(Personaje personaje) {
		super(personaje.nombre);
		this.pj = personaje;
	}
	
	public int obtenerPuntosDeDefensaFisica() {
		return pj.obtenerPuntosDeDefensaFisica();
	}
	public int obtenerPuntosDeDefensaMagica() {
		return pj.obtenerPuntosDeDefensaMagica();
	}
	public int obtenerPuntosDeAtaque(){
		return pj.obtenerPuntosDeAtaque();
	}
	protected int calcularPuntosDeAtaque() {
		return pj.calcularPuntosDeAtaque() ;
	}
	
	// gets:
	
	@Override
	public Casta getCasta(){
		return pj.getCasta();
	}
	public int getIntelecto() {
		return pj.getIntelecto();
	}
	public int getEnergia() {
		return pj.getEnergia();
	}
	public int getVitalidad() {
		return pj.getVitalidad();
	}
	public int getDestreza() {
		return pj.getDestreza();
	}
	public int getFuerza() {
		return pj.getFuerza();
	}
	
	// Ver item:
	public String verEquipo(){
		return pj.verEquipo();
	}
	
	
	
}
