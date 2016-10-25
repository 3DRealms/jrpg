package casta;

import java.util.HashMap;

import personaje.Habilidad;
import personaje.Personaje;


public class Mago extends Casta {
	
	//Aca cargar TODAS las habilidades del mago.
	public Mago(){
		habilidades = new HashMap<String, Habilidad>();
	}

	public int getEstado(Personaje pj){
		int intelecto = pj.getIntelecto(); 
		return intelecto;
		//Si es un Humano: 
		//return (int) (intelecto +intelecto*0.05); // +5% de intelecto.
	}
}
