package casta;
import java.util.HashMap;

import habilidad.Habilidad;
import personaje.Personaje;
public class Guerrero extends Casta{
		
		public Guerrero(){
			habilidades = new HashMap<String, Habilidad>();
		}
		
		public int getEstado(Personaje pj){
			int fuerza = pj.getFuerza(); 
			return fuerza;
		}
		
}
