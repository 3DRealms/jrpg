package mensaje;


import item.Item;
import item.ItemEquipo;

public class MensajeItem extends MensajeInteraccion {
	
	private ItemEquipo item;
	public MensajeItem(String que, String tipo,ItemEquipo item) {
		super(que, tipo);
		this.item = item;
	}
	public ItemEquipo getItem() {
		return item;
	}

}
