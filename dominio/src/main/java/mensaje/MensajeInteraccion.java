package mensaje;


public class MensajeInteraccion {
	
	
	public static final String MOVIMIENTO = "movimiento";
	public static final String ACCION = "accion";
	public static final String COMBATE = "combate";
	public static final String ARRANCOCOMBATE = "arrancoCombate";
	public static final String PARADO = "parado";
	public static final String ITEM = "item";
	
	public static final String ACTBATALLA = "actualizar";
	public static final String PEDIRACCION = "pediroAccion";
	public static final String FINBATALLA = "finBatalla";
	public static final String DESCONECTADO = "desconexion";
	
	protected String emisor;
	
	protected String tipo;

	public MensajeInteraccion(String que, String tipo) {
		this.emisor = que;
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
	public boolean isArrancoCombate(){
		return tipo.equals(MensajeInteraccion.ARRANCOCOMBATE);
	}
	
	public boolean isParado(){
		return tipo.equals(MensajeInteraccion.PARADO);
	}
	
	public boolean isActuliazacionBatalla(){
		return tipo.equals(MensajeInteraccion.ACTBATALLA);
	}
	
	public boolean isPedirAccion(){
		return tipo.equals(MensajeInteraccion.PEDIRACCION);
	}
	
	public boolean isFinBatalla(){
		return tipo.equals(MensajeInteraccion.FINBATALLA);
	}

	public boolean isDesconexion() {
		return tipo.equals(MensajeInteraccion.DESCONECTADO);
	}

	public boolean isItem() {
		return tipo.equals(MensajeInteraccion.ITEM);
	}

}
