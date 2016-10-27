package habilidades;

import personaje.Habilidad;
import personaje.Personaje;

public class PiroExplosion extends Habilidad {
	
	public PiroExplosion(){
		this.costo = 35;
		this.ataqueBasico = 20;
		this.nivel = 3;
		this.tipo = "magico";
	}
	
	@Override
	public void afectar(Personaje victima, int estado, int ataque) {
		this.ataqueFinal = ataqueBasico+4*estado;
		victima.serAtacadoMagico(ataqueFinal);
	}
	

}
