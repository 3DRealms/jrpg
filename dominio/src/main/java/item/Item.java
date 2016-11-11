package item;

public abstract class Item {
	protected int nivel;
	protected String nombre;
	protected String key;
	protected String descripcion = "sinItem";

	public Item(String key,int nivel, String nombre, String descripcion) {
		this.key = key;
		this.nivel = nivel;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
}
