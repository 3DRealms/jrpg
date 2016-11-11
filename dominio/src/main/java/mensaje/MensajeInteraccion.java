package mensaje;


public class MensajeInteraccion {
	

	private String emisor;
	
	private String tipo;

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
		return tipo.equals("movimiento");
	}
	
	public boolean isAccion(){
		return tipo.equals("accion");
	}
	
	public boolean isCombate(){
		return tipo.equals("combate");
	}

	
	
	

}
