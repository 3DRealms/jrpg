package acciones;

import personaje.Personaje;

public class AccionDefender extends Accion{

	public AccionDefender(Personaje emisor, Personaje objetivo, String accion,
			String tipo) {
		super(emisor, objetivo, accion, tipo);
		velocidad = emisor.getVelDefenderse();
		
	}

	@Override
	public void ejecutar() {
			//"It's time to kick ass and chew bubblegum, and I'm out all of gum"
			emisor.defenderse();
	}
	
}