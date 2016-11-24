package acciones;

import personaje.Personaje;

public class AccionGenerica extends Accion{

	public AccionGenerica(Personaje emisor, Personaje objetivo, String accion,
			String tipo) {
		super(emisor, objetivo, accion, tipo);
		velocidad = 0;
		
	}

	@Override
	public void ejecutar() {
	}
	
}