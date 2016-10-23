package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class AnilloDraupnir extends PersonajeEquipado {

	protected int ataque = 2;

	public AnilloDraupnir(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return ataque*super.obtenerPuntosDeAtaque();
	}
	@Override
	public int obtenerPuntosDeDefensaFisica() {
		return super.obtenerPuntosDeDefensaFisica();
	}
	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return super.obtenerPuntosDeDefensaMagica();
	}
	@Override
	public int getIntelecto(){
		return super.getIntelecto();
	}
	@Override
	public String toString() {
		return "Anillo Draupnir";
	}
	public String verItems() {
		return super.verItems()+ "\n" + this.toString();
	}

}
