package raza;

import personaje.Personaje;

public class Orco extends Personaje {

	int cantidadDeAtaques;
	public Orco(String nombre) {
		super(nombre);
		this.ataque = 20;
		this.energiaBase = 70;
		this.saludBase = 130;
		this.defensaFisica = 15;
		this.defensaMagica = 5;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();

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
		return calcularPuntosDeAtaque();
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
