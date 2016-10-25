package habilidadesMago;

import personaje.Habilidad;
import personaje.Personaje;

public class EscupitajoDeMana extends Habilidad{
	public EscupitajoDeMana(){
		this.costo = 5;
		this.ataqueBasico = 5;
		this.nivel = 1;
		this.tipo = "magico";
	}

	@Override
	public void afectar(Personaje victima, int estado,int ataqueMagico) {
		victima.serAtacadoMagico(ataqueBasico+ataqueMagico);
	}

}
