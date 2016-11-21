package mensaje;

import batalla.EquipoSimple;

public class MensajeInicioCombate extends MensajeInteraccion{
	
	EquipoSimple equipo1;
	EquipoSimple equipo2;

	public MensajeInicioCombate(String emisor, EquipoSimple equipo1, EquipoSimple equipo2) {
		super(emisor, MensajeInteraccion.COMBATE);
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;	
	}
	
	public MensajeInicioCombate(String emisor) {
		super(emisor, MensajeInteraccion.COMBATE);
		this.equipo1 = null;
		this.equipo2 = null;	
	}

	public EquipoSimple getEquipo1() {
		return equipo1;
	}

	public EquipoSimple getEquipo2() {
		return equipo2;
	}

}
