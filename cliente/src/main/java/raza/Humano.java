package raza;

import personaje.Personaje;

public class Humano extends Personaje {

	public Humano() {
		this.energia = 100;
		this.saludActual = calcularSaludActual();
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return ataque;
	}

	@Override
	protected boolean puedeAtacar() {
		return true;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return defensa;
	}
	
}
