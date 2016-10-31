package mensaje;

public class Mensaje {
	
	String remitente;
	String mensaje;
	
	public Mensaje(String remitente, String mensaje) {		
		this.remitente = remitente;
		this.mensaje = mensaje;
	}
	
	public Mensaje(String mensaje2) {
		this.remitente = "";
		this.mensaje = mensaje2;
	}

	public String toString(){
		return remitente + ": " + mensaje;
	}

	public String getRemitente() {
		return remitente;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	
	

}
