package habilidades;

import personaje.Personaje;

public class RayoDeInteligencia extends Habilidad {
	
	public RayoDeInteligencia(){
		this.costo = 15;
		this.ataqueBasico = 1;
	}
	@Override
	public void afectar(Personaje victima, int estado) {
		victima.serAtacado(ataqueBasico * estado);
	}

}
