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
	public boolean lanzarHabilidad(String conjuro, Personaje personaje) {
		//	Tengo que pensar alguna forma de conseguir las cosas del personaje. 

		Habilidad h = this.habilidades.get(conjuro);
		System.out.println("Mago lanza "+conjuro+".");
		if( getEnergia() >= h.getCosto()){
			consumirEnergia(h.getCosto());
			h.afectar(personaje,getIntelecto());
			return true;
		}
		return false;			
	}


}
