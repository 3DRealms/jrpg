package raza;

import personaje.Personaje;

public class Orco extends Personaje {

	int cantidadDeAtaques;
	public Orco(String nombre) {
		super(nombre);
		this.saludBase = 120;
		this.energia = 100;
		this.saludActual = calcularSaludActual();

	}
	@Override
	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return ataque;
	}

	@Override
	protected boolean puedeAtacar() {
		return true;
		// esto is rancio		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return 0;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}

	
}
