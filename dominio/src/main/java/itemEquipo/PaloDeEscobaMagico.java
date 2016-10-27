package itemEquipo;

import item.ItemEquipo;

public class PaloDeEscobaMagico extends ItemEquipo{
	/**
	 * Sorprendete Palo de escoba magico que aumenta 5 del intelecto. :)
	 * mateca.
	 */
	public PaloDeEscobaMagico() {
		intelecto = 5;
		ataqueMagico = 10;	
		this.descripcion = "Palo de escoba magico\nSorprendete Palo de escoba magico que aumente el intelecto";
	}

	@Override
	public String toString() {
		return "armaDer";
	}
}
