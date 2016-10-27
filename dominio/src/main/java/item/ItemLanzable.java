package item;

import personaje.Personaje;

public abstract class ItemLanzable extends Item {
	
	protected int cantidadDeEfecto; // total de daño, cura, mana, o lo que sea que modifique. 
	protected String nombre;
	protected String Efecto;
	protected int cantidad;
	protected int limite;
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
	public int getLimite() {
		return this.limite;
	}
	@Override
	public String toString() {
		return this.nombre+"\n"+this.Efecto+": "+this.cantidadDeEfecto+"\n"+this.descripcion+"\nCantidad en mochila: "+this.cantidad+".";
	}

}
