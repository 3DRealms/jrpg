package acciones;

import personaje.Personaje;

public class AccionHabilidad extends Accion{

	public AccionHabilidad(Personaje emisor, Personaje objetivo, String accion,
			String tipo) {
		super(emisor, objetivo, accion, tipo);
		velocidad = emisor.getVelLanzarHabilidad(accion);

	}

	@Override
	public void ejecutar() {
		//"It's time to kick ass and chew bubblegum, and I'm out all of gum"
		emisor.lanzarHabilidad(accion, objetivo);
	}

}
