package Equipo;

import casta.Casta;
import personaje.Personaje;
import personaje.PersonajeEquipado;

public class AnilloDraupnir extends PersonajeEquipado {

	public AnilloDraupnir(Personaje personaje) {
		super(personaje);
	}
	protected int ataque = 2;

	@Override
	public int obtenerPuntosDeAtaque() {
		return ataque*super.obtenerPuntosDeAtaque();
	}
	
	// No modificado:
	@Override
	public int obtenerPuntosDeDefensaFisica() {
		return super.obtenerPuntosDeDefensaFisica();
	}
	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return super.obtenerPuntosDeDefensaMagica();
	}
	
	//gets:
	@Override
	public int getIntelecto(){
		return super.getIntelecto();
	}
	public int getEnergia() {
		return super.getEnergia();
	}
	public int getVitalidad() {
		return super.getVitalidad();
	}
	public int getDestreza() {
		return super.getDestreza();
	}
	public int getFuerza() {
		return super.getFuerza();
	}
	
	@Override
	public Casta getCasta(){
		return super.getCasta();
	}
	@Override
	public String toString() {
		return "Anillo Draupnir";
	}
	public String verEquipo() {
		return super.verEquipo()+ "\n" + this.toString();
	}

}
