package batallon;

import java.util.List;

import personaje.Personaje;

public abstract class Batallon {
	int cantidad;
	List<Personaje> batallon;


	public Batallon(int cant){
		this.cantidad = cant;
	}

	public void atacar(Batallon victima){

	}
	public boolean isEmpty(){
		return batallon.isEmpty();
	}

	public void serAtacado(Personaje personaje) {
		if(  personaje.estaMuerto() ){
			this.batallon.remove(personaje);
			cantidad--;
		}

	}
}
