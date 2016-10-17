package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class VaritaMagica extends PersonajeEquipado{
	protected int intelecto = 10;

	public VaritaMagica(Personaje personaje) {
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



}
