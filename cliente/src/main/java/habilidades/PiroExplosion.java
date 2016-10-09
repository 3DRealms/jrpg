package habilidades;

import personaje.Personaje;

public class PiroExplosion extends Habilidad {
	
	public PiroExplosion(){
		this.costo = 35;
		this.ataqueBasico = 20;
	}
	@Override
	public void afectar(Personaje victima,int estado) {
		this.ataqueFinal = ataqueBasico+4*estado;
		victima.serAtacado(ataqueFinal);
		System.out.println(ataqueFinal+" puntos de daño a "+victima.toString());
	}

}
