package habilidades;

import personaje.Personaje;

public abstract class Habilidad {
	protected int costo;
	protected int ataqueBasico;
	protected int ataqueFinal;
	//A cada habilidad que tiro le envio el estado la cual escala habilidad y dentro de afectar.
	public abstract void afectar(Personaje personaje);
	public int getCosto() {
		return costo;
	}

}
