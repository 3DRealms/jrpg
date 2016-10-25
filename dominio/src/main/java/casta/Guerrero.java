package casta;
import java.util.HashMap;

import personaje.Habilidad;
import personaje.Personaje;
public class Guerrero extends Casta{
		
		public Guerrero(){
			habilidades = new HashMap<String, Habilidad>();
		}
		
		public int getEstado(Personaje pj){
			int fuerza = pj.getFuerza(); 
			return fuerza;
			
			//Si es un Orco: 
			//return (int) (fuerza +fuerza*0.05); // +5% de fuerza.
		}
		
}
