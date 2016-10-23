package raza;

import personaje.Personaje;

public class Humano extends Personaje {

	public Humano(String nombre) {
		super(nombre);
		this.ataque = 15;
		this.energiaBase = 100;
		this.saludBase = 100;
		this.defensaFisica = 5;
		this.defensaMagica = 7;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();
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
	protected void despuesDeAtacar() {		
	}

	@Override
	public int obtenerPuntosDeDefensaFisica() {
		return defensaFisica;
	}

	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return defensaMagica;
	}

	
}
