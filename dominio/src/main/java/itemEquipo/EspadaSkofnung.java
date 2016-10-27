package itemEquipo;

import item.ItemEquipo;

public class EspadaSkofnung extends ItemEquipo {

	/**
	 * Aumenta el ataque en 15 puntos.
	 * @param personaje
	 */
	public EspadaSkofnung() {
		ataqueFisico = 15;
		this.descripcion = "Espada Skofnung\nfue la espada del rey danés Hrólfr Kraki: «La mejor de todas las espadas que se han usado en las tierras del norte»";
	}
	
	@Override
	public String toString() {
		return "armaDer";
	}

}
