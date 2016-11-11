package item;

import personaje.Personaje;

public abstract class ItemLanzable extends Item {
	
	protected int cantidadDeEfecto; // total de daño, cura, mana, o lo que sea que modifique. 
	protected String efecto;
	protected int cantidad;
	protected int velociad;
	


	public ItemLanzable(String key, int nivel, String nombre, String descripcion, int cantidadDeEfecto, String efecto,
			int cantidad, int velociad) {
		super(key, nivel, nombre, descripcion);
		this.cantidadDeEfecto = cantidadDeEfecto;
		this.efecto = efecto;
		this.cantidad = cantidad;
		this.velociad = velociad;
	}

	public abstract void afectar(Personaje personaje);
	
	public void usar(Personaje personaje) {
		this.cantidad--;
		this.afectar(personaje);
	}
	public void aumentarCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
	public int getCantidad(){
		return this.cantidad;
	}

	@Override
	public String toString() {
		return this.nombre+"\n"+this.efecto+": "+this.cantidadDeEfecto+"\n"+this.descripcion+"\nCantidad en mochila: "+this.cantidad+".";
	}
	public int getVelocidad() {

		return this.velociad;
	}


}
