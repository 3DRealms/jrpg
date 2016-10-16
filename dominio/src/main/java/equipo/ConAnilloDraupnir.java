package equipo;

import interfaces.Atacable;
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
	public void atacar(Atacable atacado) {
		super.atacar(atacado);
	}

	@Override
	protected void despuesDeAtacar() {
		super.despuesDeAtacar();
	}


}
