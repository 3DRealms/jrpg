package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class EscudoSvalinn extends PersonajeEquipado {
	
	protected int defensa = 10;
	public EscudoSvalinn(Personaje personaje) {
		super(personaje);
	}
	
	@Override
	public int obtenerPuntosDeDefensaFisica(){
		return defensa + super.obtenerPuntosDeDefensaFisica();
	}
	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return defensa/2 + super.obtenerPuntosDeDefensaMagica();
	}
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	@Override
	public int getIntelecto(){
		return super.getIntelecto();
	}
	@Override
	public String toString() {
		return "Escudo Svalinn";
	}
	public String verItems() {
		return super.verItems() + "\n" + this.toString();
	}

}
