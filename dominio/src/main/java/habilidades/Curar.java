package habilidades;

import personaje.Habilidad;
import personaje.Personaje;

public class Curar extends Habilidad {
	
	public Curar(){
		this.costo = 20;
		this.ataqueBasico = 20;
		this.nivel = 5;
		this.tipo = "amistoso";
	}
	@Override
	public void afectar(Personaje victima, int estado,int ataque) {
		victima.serCurado(ataqueBasico+(estado*ataqueBasico)/100);
	}


}