package casta;

import java.util.HashMap;
import habilidades.Habilidad;
import personaje.Personaje;


public class Mago extends Casta {
	
	public Mago(){
		habilidades = new HashMap<String, Habilidad>();
	}
	//Por ahora asi.
	public int getEstado(Personaje pj){
		int intelecto = pj.getIntelecto(); 
		return intelecto;
		//Si es un Humano: 
		//return (int) (intelecto +intelecto*0.05); // +5% de intelecto.
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
