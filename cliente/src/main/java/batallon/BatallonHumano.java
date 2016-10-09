package batallon;

import java.util.LinkedList;

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
	public void atacar(Batallon victimas){
		int i = 0; //contador magic
		Personaje victima; 
		for (Personaje humano: this.batallon) {
			if( victimas.cantidad != 0) //Pregunto si hay alguien para atacar.
			{
				if( victimas.cantidad <= i )
					i=0; //si sobre paso la cantidad de victimas, reinicio el contador.
				victima = victimas.batallon.get( i ); //seleciono a la victima.
				humano.atacar( victima );      //ataco a la victima.
				victimas.serAtacado( victima ); //El batallon es atacado, (esto hace que si la victima este muerta se descuente).
				i++; //ataco al siguiente.
			}
		}
	}


}
