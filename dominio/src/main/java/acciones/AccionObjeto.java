package acciones;

import personaje.Personaje;

public class AccionObjeto extends Accion{

	public AccionObjeto(Personaje emisor, Personaje objetivo, String accion,
			String tipo) {
		super(emisor, objetivo, accion, tipo);
		velocidad = emisor.getVelLanzarItem(accion);
		
	}

	@Override
	public void ejecutar() {
			//"It's time to kick ass and chew bubblegum, and I'm out all of gum"
			emisor.lanzarItem(accion, objetivo);
	}
	
}