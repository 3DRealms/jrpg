package item;


import personaje.Personaje;

public class ItemCurativa extends ItemLanzable {
	





	public ItemCurativa(String key, int nivel, String nombre, String descripcion, int cantidadDeEfecto, String efecto,
			int cantidad, int velociad) {
		super(key, nivel, nombre, descripcion, cantidadDeEfecto, efecto, cantidad, velociad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afectar(Personaje victima) {
		victima.serCurado(cantidadDeEfecto);
	}








}