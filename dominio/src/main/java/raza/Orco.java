package raza;

import personaje.Personaje;

public class Orco extends Personaje {

	int cantidadDeAtaques;
	public Orco(String nombre) {
		super(nombre);
		this.ataqueFisico = 20;
		this.ataqueMagico = 10;
		this.energiaBase = 70;
		this.saludBase = 150;
		this.defensaFisica = 15;
		this.defensaMagica = 5;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();

	}

	@Override
	public  int calcularSaludTotal(){
		return saludBase+getVitalidad()*5; // cada 5 puntos da 25 de vida.
	}
	@Override
	public int calcularEnergiaTotal(){
		return energiaBase+getDestreza()*2; // cada 5 puntos da 10 de energia.
	}
	@Override
	protected int calcularPuntosDeAtaque() {
		return ataqueFisico+getFuerza()*3;    // cada 5 punto da 15 de ataque.
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
