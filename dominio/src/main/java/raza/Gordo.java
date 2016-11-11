package raza;

import personaje.Personaje;

public class Gordo extends Personaje {

	int cantidadDeAtaques;
	public Gordo(String nombre) {
		super(nombre);
		this.ataqueFisico = 20;
		this.ataqueMagico = 10;
		this.energiaBase = 70;
		this.saludBase = 150;
		this.defensaFisica = 15;
		this.defensaMagica = 5;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();
		this.tipoRaza = "gordo";
	}
	
	@Override
	public  int calcularSaludTotal(){
		return saludBase+getVitalidad()*6; // cada 5 puntos da 25 de vida.
	}
	@Override
	public int calcularEnergiaTotal(){
		return energiaBase+getDestreza()*1; // cada 5 puntos da 15 de energia.
	}
}
