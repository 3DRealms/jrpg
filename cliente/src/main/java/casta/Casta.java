package casta;

import java.util.Map;

import habilidades.Habilidad;
import personaje.Personaje;

public abstract class Casta  {
	protected Map<String, Habilidad> habilidades;
	public abstract void agregarHabilidad(String conjuro,  Habilidad habilidad);
	public abstract int getCantidadDeHabilidades();
	public abstract boolean lanzarHabilidad(String conjuro, Personaje personaje);
}
