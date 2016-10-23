package raza;

import personaje.Personaje;

public class PersonajePrueba extends Personaje{

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
	@Override
	protected int calcularPuntosDeAtaque() {
		return ataqueFisico+getFuerza();
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
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}



	

}


