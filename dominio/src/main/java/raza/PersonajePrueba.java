package raza;

import personaje.Personaje;

public class PersonajePrueba extends Personaje{

	public PersonajePrueba(String nombre) {
		super(nombre);
		this.ataque = 15;
		this.energiaBase = 100;
		this.saludBase = 120;
		this.defensaFisica = 0;
		this.defensaMagica = 0;
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


	public int getExperiencia() {
		return this.experiencia;
	}

	public int getNivel() {
		return this.nivel;
	}
}


