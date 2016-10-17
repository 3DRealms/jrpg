package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConAnilloDraupnir extends PersonajeEquipado {

	protected int ataque = 2;

	public ConAnilloDraupnir(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return ataque*super.obtenerPuntosDeAtaque();
	}
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa();
	}
	@Override
	public int getIntelecto(){
		return super.getIntelecto();
	}


}
