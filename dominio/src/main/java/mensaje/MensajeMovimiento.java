package mensaje;

import mapa.Punto;

public class MensajeMovimiento extends MensajeInteraccion{
	
	protected Punto pos;

	protected String mapa;
	
	protected String sprite;
	
	public Punto getPos() {
		return pos;
	}

	public String getEmisor() {
		return emisor;
	}

	public String getMapa() {
		return mapa;
	}
	
	public String getSprite(){
		return sprite;
	}

	public MensajeMovimiento(Punto pos, String emisor, String mapa, String sprite) {
		super(emisor,"movimiento");
		this.pos = pos;
		this.mapa = mapa;
		this.sprite = sprite;
	}
	

		

}
