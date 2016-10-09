package equipo;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEspadaSkofnung extends PersonajeEquipado {
	
	protected int ataque = 5;

	public ConEspadaSkofnung(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return ataque + super.obtenerPuntosDeAtaque();
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque();
	}

	@Override
	public boolean puedeAtacar() {
		return super.puedeAtacar();
	}


	

}
