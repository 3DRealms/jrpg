package habilidad;


import personaje.Personaje;

public abstract class Habilidad {
	protected String nombre;
	protected String efecto;
	protected String descripcion;
	protected int costo;
	protected int nivel;
	protected int cantEfecto;
	protected int velocidad;
	
	
	// Para que la habilidad afecte de otra manera, ahora le envio el estado, para que escale. (dependiendo la habilidad).
	// solo un estado modifica la habilidad. Pero ahora tambien el ataque magico o fisico del personaje.
	public abstract void afectar(Personaje personaje, int estado, int ataque);

	public Habilidad() {
		this.nombre = null;
		this.efecto = null;
		this.descripcion = null;
		this.costo = 0;
		this.nivel = 0;
		this.cantEfecto = 0;
		this.velocidad = 0;
	}
	public Habilidad(String nombre, String efecto, String descripcion, int costo, int nivel, int cantEfecto,
			int velocidad) {

		this.nombre = nombre;
		this.efecto = efecto;
		this.descripcion = descripcion;
		this.costo = costo;
		this.nivel = nivel;
		this.cantEfecto = cantEfecto;
		this.velocidad = velocidad;
	}

	public String getNombre() {
		return nombre;
	}
	public String getEfecto() {
		return efecto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getCosto() {
		return costo;
	}
	public int getNivel() {
		return nivel;
	}
	public int getCantEfecto() {
		return cantEfecto;
	}
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * Lo hice igual para todos. 
	 * igual despues vemos, pero subia muy poquito  por nivel
	 * ahora sube un toque mas.
	 * insisto despues lo vemos bien :D
	 * @param estado
	 * @param ataque
	 * @return
	 */
	public int calcularFinal(int estado, int ataque) {
		return cantEfecto+(cantEfecto*estado+ataque)/100;
	}

}
