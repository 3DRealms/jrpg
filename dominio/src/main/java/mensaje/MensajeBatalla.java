package mensaje;

public class MensajeBatalla {
	
	String emisor;
	String objetivo;
	String accion;
	String tipo;
	
	public String getEmisor() {
		return emisor;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public String getAccion() {
		return accion;
	}

	public String getTipo() {
		return tipo;
	}

	public MensajeBatalla(String emisor, String objetivo, String accion, String tipo) {
		this.emisor = emisor;
		this.objetivo = objetivo;
		this.accion = accion;
		this.tipo = tipo;
	}

}
