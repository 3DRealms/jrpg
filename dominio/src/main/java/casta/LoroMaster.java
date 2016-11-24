package casta;

import java.util.HashMap;

import habilidad.Habilidad;
import habilidad.HabilidadFisica;
import personaje.Personaje;

public class LoroMaster  extends Casta{
	
	public LoroMaster(){
		habilidades = new HashMap<String, Habilidad>();
		habilidades.put("atacar", new HabilidadFisica("atacar", "fisica", "te pego", 0, 0, 30, 5));

	}
	
	public int getEstado(Personaje pj){
		int fuerza = pj.getDestreza(); 
		return fuerza;
		
	}
}
	