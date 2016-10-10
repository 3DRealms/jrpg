package casta;

import java.util.HashMap;
import habilidades.Habilidad;
import personaje.Personaje;

public class Mago extends Casta {

	public Mago(){
		habilidades = new HashMap<String, Habilidad>();
	}

	@Override
	public void agregarHabilidad(String conjuro,  Habilidad habilidad) {
		this.habilidades.put(conjuro, habilidad);
	}

	@Override
	public int getCantidadDeHabilidades() {
		return this.habilidades.size();
	}
	@Override
	public void lanzarHabilidad(String conjuro, Personaje personaje,int estado) {
		System.out.println("Mago lanza "+conjuro+".");
		this.habilidades.get(conjuro).afectar(personaje,estado);
	}


}
