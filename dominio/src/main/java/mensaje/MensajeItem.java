package mensaje;

public class MensajeItem extends MensajeInteraccion {
	
	private String item;
	public MensajeItem(String que, String tipo,String item) {
		super(que, tipo);
		this.item = item;
	}

}
