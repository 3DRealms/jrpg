package alianza;

import java.util.LinkedList;

import interfaces.Atacable;
import interfaces.Grupo;
import personaje.Personaje;
import raza.Humano;

public class BatallonHumano extends Batallon {

	public BatallonHumano(int cant) {
		super(cant);
		batallon =  new LinkedList<Personaje>();
		for (int i = 0; i < cant; i++) {	
			batallon.add(new Humano("genric "+i));
		}
	}


	// Asi ataca los humanos, uno a la vez.
	/**
	 * Cada uno ataca a uno.
	 * Sean H un equipo de humanos y 
	 * 		V un equipo de victimas
	 * H = {h1,h2,h3,h3,h5}
	 * V = {j1,j2,j3,j4}
	 * un atacar de batallon seria asi :
	 * h1 ataca a j1
	 * h2 ataca a j2
	 * h3 ataca a j3
	 * h4 ataca a j4
	 * h5 ataca a j1
	 * @param Grupo
	 * @author DrCoffee84
	 */
	public void atacar(Grupo victimas){

		int i = 0; //contador magic
		Personaje victima; 
		for (Personaje humano: this.batallon) {
			if( victimas.length() != 0) //Pregunto si hay alguien para atacar.
			{
				if( victimas.length() <= i )
					i=0; //si sobre paso la cantidad de victimas, reinicio el contador.
				victima = victimas.get( i ); //seleciono a la victima.
				humano.atacar( victima );      //ataco a la victima.
				victimas.serAtacado( victima ); //El batallon es atacado, (esto hace que si la victima este muerta se descuente).
				i++; //ataco al siguiente.
			}
		}
	}
	
	@Override
	public Atacable obtenerProximaVictima() {
		//	depurarBatallon();
		if(batallon.isEmpty()) {
			throw new RuntimeException("El batallón está vacío");
		}
		return batallon.get(0);
	}
	@Override
	public String toString() {
		return "humanos";
	}




}
