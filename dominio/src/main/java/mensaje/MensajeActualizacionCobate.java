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

	public MensajeActualizacionCobate(String emisor, String tipo, int vida, int energia, String mensaje) {
		super(emisor, tipo);
		this.vida = vida;
		this.energia = energia;
		this.mensaje = mensaje;
	}

	

}
