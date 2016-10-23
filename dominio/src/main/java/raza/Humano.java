package raza;

import personaje.Personaje;

public class Humano extends Personaje {

	public Humano(String nombre) {
		super(nombre);
		this.ataqueFisico = 15;
		this.ataqueMagico = 15;
		this.energiaBase = 100;
		this.saludBase = 100;
		this.defensaFisica = 5;
		this.defensaMagica = 7;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();
	}
	
	@Override
	public  int calcularSaludTotal(){
		return saludBase+getVitalidad()*4; // cada 5 puntos da 20 de vida.
	}
	@Override
	public int calcularEnergiaTotal(){
		return energiaBase+getDestreza()*4; // cada 5 puntos da 20 de energia.
	}
	@Override
	protected int calcularPuntosDeAtaque() {
		return ataqueFisico+getFuerza()*3;  // cada 5 puntos da 10 de ataque.
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
