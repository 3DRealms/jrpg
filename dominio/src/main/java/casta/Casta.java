package casta;

import java.util.Map;

import habilidades.Habilidad;
import personaje.Personaje;

public abstract class Casta  {
	protected Map<String, Habilidad> libroHabilidades;
	protected Map<String, Habilidad> habilidades;
	public Map<String, Habilidad> getHabilidades() {
		return habilidades;
	}
	
	public Habilidad getHabilidad(String h) {
		return habilidades.get(h);
	}
	public abstract void libroHabilidades();
	public abstract void agregarHabilidad(String conjuro,  Habilidad habilidad);
	public abstract int getCantidadDeHabilidades();
	
	/**
	 * El estado cambia segun la casta, 
	 * Mago: intelecto.
	 * Guerrero: Fuerza.
	 * LoroMaster: Destresa. 
	 * Bueno , con esto se puede jugar bastante, y agregar mas clases.
	 * @param pj
	 * @return
	 */
	public abstract int getEstado(Personaje pj);
}
