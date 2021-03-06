package raza;

import personaje.Personaje;

public class Mognatal extends Personaje {

	public Mognatal(String nombre) {
		super(nombre);
		this.ataqueFisico = 10;
		this.ataqueMagico = 20;
		this.energiaBase = 120;
		this.saludBase = 70;
		this.defensaFisica = 3;
		this.defensaMagica = 15;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();
		this.tipoRaza = "mognatal";
		this.sprite = "pelado"; // Por ahora asi.

	}

	public Mognatal(Personaje per) {
		super(per);
	}

	@Override
	public  int calcularSaludTotal(){
		return saludBase+getVitalidad()*3; // cada 5 puntos da 15 de vida.
	}
	@Override
	public int calcularEnergiaTotal(){
		return energiaBase+getDestreza()*5; // cada 5 puntos da 25 de energia.
	}
}
