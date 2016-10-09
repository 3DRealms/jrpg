package casta;

import java.util.HashMap;
import habilidades.Habilidad;
import personaje.Personaje;

public class Mago extends Casta {

	Personaje pj;
		public Mago(Personaje pj){
			this.pj = pj; //PUNTERO ERMOSO SIN H.
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
		Habilidad h = this.habilidades.get(conjuro);
		
		if( pj.getEnergia() >= h.getCosto()){
			h.afectar(personaje,pj.getIntelecto());
			pj.consumirEnergia(h.getCosto());
			return true;
		}
		return false;			
	}


}
