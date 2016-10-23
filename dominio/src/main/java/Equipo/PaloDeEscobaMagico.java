package Equipo;

import casta.Casta;
import personaje.Personaje;
import personaje.PersonajeEquipado;

public class PaloDeEscobaMagico extends PersonajeEquipado{
	protected int intelecto = 5;
	protected int ataque = 10;

	public PaloDeEscobaMagico(Personaje personaje) {
		super(personaje);
	}
	
	// Modificados:
	@Override
	public int getIntelecto(){
		return intelecto + super.getIntelecto();
	}
	@Override
	public int obtenerPuntosDeAtaque() {
		return ataque + super.obtenerPuntosDeAtaque();
	}
	
	// No modificados:
	@Override
	protected int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque();
	}
	@Override
	public int obtenerPuntosDeDefensaFisica() {
		return super.obtenerPuntosDeDefensaFisica();
	}
	@Override
	public int obtenerPuntosDeDefensaMagica() {
		return super.obtenerPuntosDeDefensaMagica();
	}
	//Gets no modificados:
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
		return "Palo De Escoba Magico";
	}
	public String verEquipo() {
		return super.verEquipo() + "\n" + this.toString();
	}


}
