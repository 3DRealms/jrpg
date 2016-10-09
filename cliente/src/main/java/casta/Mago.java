package casta;

import java.util.HashMap;
import habilidades.Habilidad;
import personaje.Personaje;

public class Mago extends Casta {

	Personaje pj;
		public Mago(Personaje pj){
			this.pj = pj; // PUNTERO ERMOSO SIN H goto infinito y recursada.
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
		System.out.println("Mago lanza "+conjuro+".");
		if( pj.getEnergia() >= h.getCosto()){
			pj.consumirEnergia(h.getCosto());
			h.afectar(personaje,pj.getIntelecto());
			return true;
		}
		return false;			
	}


}
