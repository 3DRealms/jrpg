package mensaje;

import mapa.Punto;

public class MensajeMovimiento extends MensajeInteraccion{
	
	protected Punto pos;

	protected String mapa;
	
	public Punto getPos() {
		return pos;
	}

	public String getEmisor() {
		return emisor;
	}

	public String getMapa() {
		return mapa;
	}

	public MensajeMovimiento(Punto pos, String emisor, String mapa) {
		super(emisor,"movimiento");
		this.pos = pos;
		this.mapa = mapa;
	}
	

		

}
