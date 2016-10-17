package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEscudoSvalinn extends PersonajeEquipado {
	
	protected int defensa = 10;
	public ConEscudoSvalinn(Personaje personaje) {
		super(personaje);
	}
	
	@Override
	public int obtenerPuntosDeDefensa(){
		return defensa + super.obtenerPuntosDeDefensa();
	}
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	@Override
	public int getIntelecto(){
		return super.getIntelecto();
	}
}
