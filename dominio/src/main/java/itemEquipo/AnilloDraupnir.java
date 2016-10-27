package itemEquipo;

import item.ItemEquipo;

public class AnilloDraupnir extends ItemEquipo {
	
	public AnilloDraupnir() {
		this.ataqueFisico = 15;
		this.descripcion = "Anillo de Dreupnir\nDada a Odín por el enano Brok, que la creo junto a su hermano Sindre. Ésta tenía el poder de hacer ocho copias de igual valor cada nueve noches. Más tarde Odín pone la argolla en la pira funeraria de Baldr, que luego se la devuelve por medio de Hermod.";
	}
	
	@Override
	public String toString() {
		return "anillo";
	}
	
}
