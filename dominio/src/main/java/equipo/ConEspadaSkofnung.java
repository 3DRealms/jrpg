package equipo;

import interfaces.Atacable;
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
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + ataque;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque();
	}

	@Override
	public boolean puedeAtacar() {
		return super.puedeAtacar();
	}
	
	@Override
	public void atacar(Atacable atacado) {
		super.atacar(atacado);
	}


	

}
