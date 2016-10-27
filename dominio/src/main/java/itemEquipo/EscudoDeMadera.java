package itemEquipo;

import item.ItemEquipo;

public class EscudoDeMadera extends ItemEquipo {

	/**
	 * Escudo de madera.
	 * 	defensaFisica = 5;
	 *	defensaMagica = 5;
	 */
	public EscudoDeMadera() {
		defensaFisica = 5;
		defensaMagica = 5;
		this.descripcion = "Escudo de Madera\nY bueno, antes que el escudo de carton.";
	}

	@Override
	public String toString() {
		return "armaIzq";
	}


}
