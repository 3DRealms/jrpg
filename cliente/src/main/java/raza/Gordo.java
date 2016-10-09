package raza;

import personaje.Personaje;

public class Gordo extends Personaje {
	
	int ataquesRecibidos;
	
	@Override
	protected void despuesDeAtacar() {
		saludBase++;
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return 10 + ataquesRecibidos;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	public void serAtacado(int danio) {
		super.serAtacado(danio);
		this.ataquesRecibidos++;
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
