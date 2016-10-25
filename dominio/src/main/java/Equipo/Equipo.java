package Equipo;

public class Equipo {
	// es todo 0 
	protected int fuerza;  
	protected int intelecto;
	protected int destreza;
	protected int vitalidad;
	protected int ataqueFisico;  
	protected int ataqueMagico;  
	protected int defensaFisica;
	protected int defensaMagica;
	protected String descripcion = "Sin Equipo.";
	
	public int getFuerza() {
		return fuerza;
	}
	public int getIntelecto() {
		return intelecto;
	}
	public int getDestreza() {
		return destreza;
	}
	public int getVitalidad() {
		return vitalidad;
	}
	public int getAtaqueFisico() {
		return ataqueFisico;
	}
	public int getAtaqueMagico() {
		return ataqueMagico;
	}
	public int getDefensaFisica() {
		return defensaFisica;
	}
	public int getDefensaMagica() {
		return defensaMagica;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	@Override
	public String toString() {
		return "sinEquipo";
	}
	
}
