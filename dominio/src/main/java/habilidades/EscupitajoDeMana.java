package habilidades;

import personaje.Personaje;

public class EscupitajoDeMana extends Habilidad{
	public EscupitajoDeMana(){
		this.costo = 1;
		this.ataqueBasico = 1;
		this.nivel = 100;
		this.tipo = "magico";
	}

	@Override
	public void afectar(Personaje victima, int estado,int ataqueMagico) {
		victima.serAtacadoMagico(ataqueBasico+ataqueMagico);
	}

}
