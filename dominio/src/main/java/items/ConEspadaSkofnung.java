package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEspadaSkofnung extends PersonajeEquipado {

	protected int ataque = 5;
	/**
	 * Aumenta el ataque en 5 puntos.
	 * @param personaje
	 */
	public ConEspadaSkofnung(Personaje personaje) {
		super(personaje);
	}
	@Override
	public int obtenerPuntosDeDefensa(){
		return super.obtenerPuntosDeDefensa();
	}
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + ataque;
	}
	@Override
	public int getIntelecto(){
		return super.getIntelecto();
	}

}
