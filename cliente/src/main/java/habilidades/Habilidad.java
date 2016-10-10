package habilidades;

import personaje.Personaje;

public abstract class Habilidad {
	protected int costo;
	protected int ataqueBasico;
	protected int ataqueFinal;
	// Para que la habilidad afecte de otra manera, ahora le envio el estado, para que escale (dependiendo la habilidad).
	// solo un estado modifica la habilidad. 
	public abstract void afectar(Personaje personaje, int estado);
	public int getCosto() {
		return costo;
	}

}
