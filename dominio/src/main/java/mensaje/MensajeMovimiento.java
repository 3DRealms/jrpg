package mensaje;

import mapa.Punto;

public class MensajeMovimiento {
	
	private Punto pos;
	private String emisor;
	
	public MensajeMovimiento(Punto pos, String emisor) {
		this.pos = pos;
		this.emisor = emisor;
	}

	public Punto getPos() {
		return pos;
	}

	public String getEmisor() {
		return emisor;
	}
	
		

}
