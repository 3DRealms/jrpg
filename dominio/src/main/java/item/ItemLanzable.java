package item;

import personaje.Personaje;

public abstract class ItemLanzable extends Item {
	
	protected int cantidadDeEfecto; // total de daño, cura, mana, o lo que sea que modifique. 
	protected String nombre;
	protected String efecto;
	protected int cantidad;

	protected int velociad;
	
	public abstract void afectar(Personaje personaje);
	public void usar() {
		this.cantidad--;
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
