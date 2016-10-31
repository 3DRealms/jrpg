package casta;

import java.util.Map;
import java.util.Set;
import personaje.Habilidad;
import personaje.Personaje;

public abstract class Casta  {

	protected Map<String, Habilidad> habilidades;
	
	public Habilidad getHabilidad(String h) {
		return habilidades.get(h);
	}
	
	
//	public abstract void libroHabilidades();
	
	
	///ESTAS dos pueden volar, si ya vienen cargado y el unico filtro es el nivel,
	// amenos que pueda elegir por nivel que habilidad quiero, en ese caso 
	// si necesito el agregar. Asi puedo hacerlo mas variado el juego.
	public void agregarHabilidad(String conjuro,  Habilidad habilidad) {
		this.habilidades.put(conjuro, habilidad);
	}	
	public int getCantidadDeHabilidades() {
		return this.habilidades.size();
	}	
	
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
	
	public Set<String> listaHabilidades() {
		return habilidades.keySet();
	}
}
