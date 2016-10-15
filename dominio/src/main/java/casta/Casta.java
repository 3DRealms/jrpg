package casta;

import java.util.Map;

import habilidades.Habilidad;

public abstract class Casta  {
	protected Map<String, Habilidad> habilidades;
	
	public Map<String, Habilidad> getHabilidades() {
		return habilidades;
	}
	
	public Habilidad getHabilidad(String h) {
		return habilidades.get(h);
	}
	public abstract void agregarHabilidad(String conjuro,  Habilidad habilidad);
	public abstract int getCantidadDeHabilidades();
}
