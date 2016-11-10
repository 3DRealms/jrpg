package item;


import personaje.Personaje;

public class ItemMagica extends ItemLanzable {
	


	public ItemMagica(String key, int nivel, String nombre, String descripcion, int cantidadDeEfecto, String efecto,
			int cantidad, int velociad) {
		super(key, nivel, nombre, descripcion, cantidadDeEfecto, efecto, cantidad, velociad);
	}

	@Override
	public void afectar(Personaje victima) {
		victima.serAtacadoMagico(cantidadDeEfecto);
	}
	
}