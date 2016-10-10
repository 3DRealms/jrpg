package equipo;

import interfaces.Atacable;
import personaje.Personaje;
import personaje.PersonajeEquipado;

public class PaloDeEscobaMagico extends PersonajeEquipado{
	protected int intelecto = 5;

	public PaloDeEscobaMagico(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int getIntelecto(){
		return intelecto + super.getIntelecto();
	}
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	@Override
	protected int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque();
	}
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa();
	}
	@Override
	public boolean puedeAtacar() {
		return super.puedeAtacar();
	}
	@Override
	public void atacar(Atacable atacado){
		super.atacar(atacado);
	}
	
	@Override
	public  boolean lanzarHabilidad(String conjuro, Personaje personaje){
		//return super.lanzarHabilidad(conjuro, personaje,getIntelecto());
		return super.lanzarHabilidad(conjuro, personaje);
	}

}
