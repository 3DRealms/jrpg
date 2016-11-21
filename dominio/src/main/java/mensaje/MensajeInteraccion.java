package mensaje;


public class MensajeInteraccion {
	
	
	public static final String MOVIMIENTO = "movimiento";
	public static final String ACCION = "accion";
	public static final String COMBATE = "combate";
	public static final String PARADO = "parado";
	
	protected String emisor;
	
	protected String tipo;

	public MensajeInteraccion(String emisor, String tipo) {
		this.emisor = emisor;
		this.tipo = tipo;
	}

	public String getEmisor() {
		return emisor;
	}

	public String getTipo() {
		return tipo;
	}
	
	public boolean isMovimiento(){
		return tipo.equals(MensajeInteraccion.MOVIMIENTO);
	}
	
	public boolean isAccion(){
		return tipo.equals(MensajeInteraccion.ACCION);
	}
	
	public boolean isCombate(){
		return tipo.equals(MensajeInteraccion.COMBATE);
	}
	
	public boolean isParado(){
		return tipo.equals(MensajeInteraccion.PARADO);
	}


	
	
	

}
