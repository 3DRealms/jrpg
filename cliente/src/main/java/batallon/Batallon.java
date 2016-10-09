package batallon;

import java.util.List;

import personaje.Personaje;

public abstract class Batallon {
	int cantidad;
	List<Personaje> batallon;

	public Batallon(int cant){
		this.cantidad = cant;
	}

	public abstract void atacar(Batallon victima);

	public String quienSoy() {
		switch (this.getClass().toString()) {
		case "class batallon.BatallonHumano":
			return "humanos";
		case "class batallon.BatallonOrco":
			return "orcos";
		}
		return "batallon";
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
