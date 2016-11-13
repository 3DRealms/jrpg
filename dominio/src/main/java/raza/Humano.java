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
		this.tipoRaza = "humano";
		this.sprite = "pelado"; // Por ahora asi.
	}
	
	public Humano(Personaje per) {
		super(per);
	}

	public Humano() {
		super();
	}

	@Override
	public  int calcularSaludTotal(){
		return saludBase+getVitalidad()*4; // cada 5 puntos da 20 de vida.
	}
	@Override
	public int calcularEnergiaTotal(){
		return energiaBase+getDestreza()*4; // cada 5 puntos da 20 de energia.
	}
	
}
