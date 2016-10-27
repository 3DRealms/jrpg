package itemEquipo;

import item.ItemEquipo;

public class AnilloDraupnir extends ItemEquipo {
	
	public AnilloDraupnir() {
		this.ataqueFisico = 15;
		this.descripcion = "Anillo de Dreupnir\nDada a Od�n por el enano Brok, que la creo junto a su hermano Sindre. �sta ten�a el poder de hacer ocho copias de igual valor cada nueve noches. M�s tarde Od�n pone la argolla en la pira funeraria de Baldr, que luego se la devuelve por medio de Hermod.";
	}
	
	@Override
	public String toString() {
		return "anillo";
	}
	
}
