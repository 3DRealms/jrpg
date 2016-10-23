package Equipo;

import casta.Casta;
import personaje.Personaje;
import personaje.PersonajeEquipado;

public class EspadaSkofnung extends PersonajeEquipado {

	protected int ataque = 5;
	/**
	 * Aumenta el ataque en 5 puntos.
	 * @param personaje
	 */
	public EspadaSkofnung(Personaje personaje) {
		super(personaje);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + ataque;
	}
	
	// No modificados:
	@Override
	public int obtenerPuntosDeDefensaFisica(){
		return super.obtenerPuntosDeDefensaFisica();
	}
	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return super.obtenerPuntosDeDefensaMagica();
	}
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
		return "Espada Skofnung";
	}
	public String verEquipo() {
		return super.verEquipo() + "\n" + this.toString();
	}
}
