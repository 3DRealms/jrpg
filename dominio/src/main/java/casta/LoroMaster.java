package casta;

import java.util.HashMap;

import personaje.Habilidad;
import personaje.Personaje;

public class LoroMaster  extends Casta{
	
	public LoroMaster(){
		habilidades = new HashMap<String, Habilidad>();
	}
	
	public int getEstado(Personaje pj){
		int fuerza = pj.getDestreza(); 
		return fuerza;
		
	}
}
	