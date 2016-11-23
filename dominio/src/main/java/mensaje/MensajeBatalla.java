package mensaje;

public class MensajeBatalla {
	
	String emisor;
	String objetivo;
	String accion;
	String tipo;
	
	final public static String HABILIDAD = "habilidad";
	final public static String DEFENDER = "defender";
	final public static String OBJETO = "objeto";
	final public static String HUIR = "huir";
	
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

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
	
	public MensajeBatalla(String emisor, String tipo) {
		this.emisor = emisor;
		this.objetivo = null;
		this.accion = null;
		this.tipo = tipo;
	}
	
	public String toString(){
		return "Emisor:"+emisor+" - Objetivo:"+objetivo+" - Accion:"+accion+" - Tipo:"+tipo;
	}

}
