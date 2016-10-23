package Equipo;

import casta.Casta;
import personaje.Personaje;
import personaje.PersonajeEquipado;

public class VaritaMagica extends PersonajeEquipado{
	protected int intelecto = 10;

	public VaritaMagica(Personaje personaje) {
		super(personaje);
	}
	//Modificados:
	@Override
	public int getIntelecto(){
		return intelecto + super.getIntelecto();
	}
	
	// No modificados:
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
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
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
	
	
	// ver:
	@Override
	public String toString() {
		return "Varita Magica";
	}
	public String verEquipo() {
		return super.verEquipo() + "\n" + this.toString();
	}


}
