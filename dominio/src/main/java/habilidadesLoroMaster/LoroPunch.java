package habilidadesLoroMaster;

import personaje.Habilidad;
import personaje.Personaje;

public class LoroPunch extends Habilidad {
	
	public LoroPunch(){
		this.costo = 50;
		this.ataqueBasico = 50;
		this.nivel = 5;
		this.tipo = "fisico";
	}
	@Override
	public void afectar(Personaje victima, int estado,int ataque) {
		victima.serAtacadoMagico(ataqueBasico+(estado*ataqueBasico)/100);
	}


}