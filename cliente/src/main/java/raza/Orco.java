package raza;

import personaje.Personaje;

public class Orco extends Personaje {

	int cantidadDeAtaques;

	@Override
	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return 10 + cantidadDeAtaques;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}
}
