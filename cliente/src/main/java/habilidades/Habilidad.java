package habilidades;

import personaje.Personaje;

public abstract class Habilidad {
	protected int costo;
	protected int ataqueBasico;
	//A cada habilidad que tiro le envio el estado la cual escala habilidad y dentro de afectar.
	public abstract void afectar(Personaje personaje,int estado);
	public int getCosto() {
		return costo;
	}
}
