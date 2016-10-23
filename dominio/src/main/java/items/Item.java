package items;

import personaje.Personaje;

public abstract class Item {
	
	protected int cantidadDeEfecto; // total de daño, cura, mana, o lo que sea que modifique. 
	protected String nombre;
	protected String descripcion;
	protected String Efecto;
	protected int nivel;
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
		return this.nombre+"\n"+"Tipo "+this.Efecto+": "+this.cantidadDeEfecto+this.descripcion+"\nCantidad en mochila: "+this.cantidad+".";
	}

}
