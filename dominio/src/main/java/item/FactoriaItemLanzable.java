package item;


public class FactoriaItemLanzable {

	public static ItemLanzable getItemLanzable(String key, int nivel, String nombre, String descripcion, int cantidadDeEfecto, String efecto,
			int cantidad, int velociad){
		if (efecto.equals("curativa")) {
			return new ItemCurativa(key, nivel, nombre, descripcion,  cantidadDeEfecto,  efecto,
					 cantidad,  velociad);
		}
		if(efecto.equals("fisica")){
			return new ItemFisica(key, nivel, nombre, descripcion,  cantidadDeEfecto,  efecto,
					 cantidad,  velociad);
		}
		if(efecto.equals("magica")){
			return new ItemMagica(key, nivel, nombre, descripcion,  cantidadDeEfecto,  efecto,
					 cantidad,  velociad);
		}

		if(efecto.equals("energica")){
			return new ItemEnergico(key, nivel, nombre, descripcion,  cantidadDeEfecto,  efecto,
					 cantidad,  velociad);
		}
		return null;
	}

}
