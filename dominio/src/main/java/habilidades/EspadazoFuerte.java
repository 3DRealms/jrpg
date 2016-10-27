package habilidades;

import personaje.Habilidad;
import personaje.Personaje;

public class EspadazoFuerte extends Habilidad{
	public EspadazoFuerte(){
		this.costo = 20;
		this.ataqueBasico = 15;
		this.nivel = 2;
		this.tipo = "fisico";
	}

	@Override
	public void afectar(Personaje victima, int estado,int ataqueFisico) {
		victima.serAtacadoFisico(ataqueBasico+ataqueFisico);
	}

}
