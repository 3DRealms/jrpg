package itemEquipo;

import item.ItemEquipo;

public class VaritaMagica extends ItemEquipo{
	/**
	 * Aumenta en 10 el intelecto.
	 */
	public VaritaMagica() {
		intelecto = 10;
		this.descripcion = "Varita Magica\nClasica varita magica, perfecta para tus trucos de magia";
	}
	@Override
	public String toString() {
		return "armaIzq";
	}
}
