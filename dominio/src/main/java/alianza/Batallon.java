package alianza;

import java.util.List;

import interfaces.Atacable;
import interfaces.Grupo;
import personaje.Personaje;

public abstract class Batallon implements Grupo {
	int cantidad; //este cantidad es para hacer un for por batallon, asi yo tengo la cantidad que quiero meter de NPCs
	List<Personaje> batallon;

	public Batallon(int cant){
		this.cantidad = cant;
	}

	public boolean isEmpty(){
		return cantidad == 0;
	}

	/**
	 * Si el personaje esta muerto se lo bajo xD
	 * @author DrCoffee84
	 * @param cant
	 */
	public void serAtacado(Atacable personaje) {
		if(  personaje.estaMuerto() ){
			this.batallon.remove(personaje);
			cantidad--;
		}
	}
	@Override
	public int length() {
		return cantidad;
	}


	@Override
	public Personaje get(int i) {
		return batallon.get(i);
	}
	/**
	 * Partida entre npc para probar el algoritmo propuesto en clase.
	 * Solo que cada equipo ataca todo en un turno y depues lo otro
	 * @param b1
	 * @param b2
	 * @return
	 */
/*	public static String partidaEntreNPCs(Batallon b1, Batallon b2) {
		boolean fin = false;
		String ganador = "empate";
		while( !fin ){ 	
			
			b1.atacar(b2);
			if( b2.isEmpty() ){
				fin = true;
				ganador = b1.toString();
			}

			b2.atacar(b1);
			if( b1.isEmpty() ){
				fin = true;
				ganador = b2.toString();
			}
		}

		return ganador;
	}*/

}
