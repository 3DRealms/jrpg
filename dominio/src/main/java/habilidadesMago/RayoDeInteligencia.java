package habilidadesMago;

import personaje.Habilidad;
import personaje.Personaje;

public class RayoDeInteligencia extends Habilidad {
	
	public RayoDeInteligencia(){
		this.costo = 15;
		this.ataqueBasico = 1;
		this.nivel = 100;
		this.tipo = "magico";
	}
	@Override
	public void afectar(Personaje victima, int estado,int ataqueMagico) {
		victima.serAtacadoMagico(ataqueBasico + (estado * ataqueMagico)/100);
	}


}
