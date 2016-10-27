package raza;

import personaje.Personaje;

public class PersonajePrueba extends Personaje{
	/**
	 * Personaje de prueba, tiene todos los atributos en 0
	 * y las defensas tambien en 0.
	 * salud 120 y energia 100.
	 * ataque de 15.
	 * @param nombre
	 */
	public PersonajePrueba(String nombre) {
		super(nombre);
		this.ataqueFisico = 15;
		this.energiaBase = 100;
		this.saludBase = 120;
		this.defensaFisica = 0;
		this.defensaMagica = 0;
		this.saludActual = calcularSaludTotal();
		this.energiaActual = calcularEnergiaTotal();
	}
	@Override
	public  int calcularSaludTotal(){
		return saludBase+getVitalidad()*4; // cada 5 puntos da 20 de vida.
	}
	@Override
	public int calcularEnergiaTotal(){
		return energiaBase+getDestreza()*2; // cada 5 puntos da 10 de energia.
	}
}


