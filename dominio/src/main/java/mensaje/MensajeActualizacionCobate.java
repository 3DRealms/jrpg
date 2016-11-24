package mensaje;

public class MensajeActualizacionCobate extends MensajeInteraccion{
		
	private int vida;
	private int energia;
	
	private String mensaje;

	public int getVida() {
		return vida;
	}

	public int getEnergia() {
		return energia;
	}

	public String getMensaje() {
		return mensaje;
	}

	public MensajeActualizacionCobate(String emisor, String tipo) {
		super(emisor, tipo);
		// TODO Auto-generated constructor stub
	}
	
	

}
