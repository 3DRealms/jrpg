package item;


import personaje.Personaje;

public class ItemFisica extends ItemLanzable{




	public ItemFisica(String key, int nivel, String nombre, String descripcion, int cantidadDeEfecto, String efecto,
			int cantidad, int velociad) {
		super(key, nivel, nombre, descripcion, cantidadDeEfecto, efecto, cantidad, velociad);
	}

	@Override
	public void afectar(Personaje victima) {
		victima.serAtacadoFisico(cantidadDeEfecto);
	}

}
