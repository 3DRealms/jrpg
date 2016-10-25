package personaje;

public abstract class Habilidad {
	protected int costo;
	protected int nivel;
	protected int ataqueBasico;
	protected int ataqueFinal;
	protected String tipo;
	// Para que la habilidad afecte de otra manera, ahora le envio el estado, para que escale. (dependiendo la habilidad).
	// solo un estado modifica la habilidad. Pero ahora tambien el ataque magico o fisico del personaje.
	public abstract void afectar(Personaje personaje, int estado, int ataque);
	public int getCosto() {
		return costo;
	}
	public String getTipo(){
		return this.tipo;
	}

}
