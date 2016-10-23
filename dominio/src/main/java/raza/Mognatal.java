package raza;

import personaje.Personaje;

public class Mognatal extends Personaje {

	public Mognatal(String nombre) {
		super(nombre);
		this.ataque = 10;
		this.energiaBase = 120;
		this.saludBase = 70;
		this.defensaFisica = 3;
		this.defensaMagica = 15;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();
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
	public int obtenerPuntosDeDefensaFisica() {
		return defensaFisica;
	}

	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return defensaMagica;
	}
	@Override
	protected void despuesDeAtacar() {		
	}

	@Override
	protected boolean puedeAtacar() {
		return true;
	}


}
