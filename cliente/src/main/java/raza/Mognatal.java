package raza;

import personaje.Personaje;

public class Mognatal extends Personaje {

	public Mognatal(String nombre) {
		super(nombre);
		this.saludBase = 120;
		this.energia = 100;
		this.saludActual = calcularSaludActual();
	}

	@Override
	protected boolean puedeAtacar() {
		return false;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return ataque;
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
