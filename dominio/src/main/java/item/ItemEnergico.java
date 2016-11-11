package item;


import personaje.Personaje;

public class ItemEnergico extends ItemLanzable {
	

	public ItemEnergico(String key, int nivel, String nombre, String descripcion, int cantidadDeEfecto, String efecto,
			int cantidad, int velociad) {
		super(key, nivel, nombre, descripcion, cantidadDeEfecto, efecto, cantidad, velociad);
	}

	@Override
	public void afectar(Personaje victima) {
		victima.serEnergizado(cantidadDeEfecto);
	}






}