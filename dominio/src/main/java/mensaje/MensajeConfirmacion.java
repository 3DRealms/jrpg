package mensaje;

public class MensajeConfirmacion {
	
	boolean confirmo;
	String mensaje;
	
	public MensajeConfirmacion(boolean confirmo, String mensaje) {		
		this.confirmo = confirmo;
		this.mensaje = mensaje;
	}
	
	public String toString(){
		return confirmo + ": " + mensaje;
	}

	public boolean isConfirmado() {
		return confirmo;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	
	

}
