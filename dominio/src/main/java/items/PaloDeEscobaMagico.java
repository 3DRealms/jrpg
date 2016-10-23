package items;

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
	public int obtenerPuntosDeDefensaFisica() {
		return super.obtenerPuntosDeDefensaFisica();
	}
	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return super.obtenerPuntosDeDefensaMagica();
	}
	@Override
	public String toString() {
		return "Palo De Escoba Magico";
	}
	public String verItems() {
		return super.verItems() + "\n" + this.toString();
	}


}
