package raza;

import personaje.Personaje;

public class Mognatal extends Personaje {

	public Mognatal() {
		this.saludBase = 120;
		this.energia = 100;
		this.saludActual = calcularSaludActual();
	}

	@Override
	protected boolean puedeAtacar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
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
