package casta;

import java.util.HashMap;
import habilidades.Habilidad;

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



}
