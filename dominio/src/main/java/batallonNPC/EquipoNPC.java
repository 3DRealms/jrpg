package batallonNPC;

import java.util.List;

import acciones.Accion;
import batalla.Batalla;
import interfaces.Atacable;
import interfaces.Equipo;
import personaje.Personaje;

public abstract class EquipoNPC implements Equipo {
	int cantidad; //este cantidad es para hacer un for por batallon, asi yo tengo la cantidad que quiero meter de NPCs
	List<Personaje> batallon;

	public EquipoNPC(int cant){
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

	public int size() {
		return cantidad;
	}


	public Personaje get(int i) {
		return batallon.get(i);
	}


	public List<Personaje> getEquipo() {
		return  batallon;
	}

	public List<Personaje> clonar() {
		return null;
	}

	public List<Accion> pedirAccion(Batalla batalla) {
		
		return null;
	}


	public List<Equipo> perderItemsEquipo() {
		
		return null;
	}


	public int quitarOro() {
		
		return 0;
	}


	public void repartirBotin(List<Equipo> equipo, int oro) {
		

	}


	public void darExperiencia(int experiencia) {
		

	}
	public void repartirBotin(int oro) {
		
	}
	public List<Accion> pedirAccion(Equipo equipoElemigo) {
		
		return null;
	}
}
