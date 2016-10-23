package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class EspadaSkofnung extends PersonajeEquipado {

	protected int ataque = 5;
	/**
	 * Aumenta el ataque en 5 puntos.
	 * @param personaje
	 */
	public EspadaSkofnung(Personaje personaje) {
		super(personaje);
	}
	@Override
	public int obtenerPuntosDeDefensaFisica(){
		return super.obtenerPuntosDeDefensaFisica();
	}
	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return super.obtenerPuntosDeDefensaMagica();
	}
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + ataque;
	}
	@Override
	public int getIntelecto(){
		return super.getIntelecto();
	}
	@Override
	public String toString() {
		return "Espada Skofnung";
	}
	public String verItems() {
		return super.verItems() + "\n" + this.toString();
	}
}
