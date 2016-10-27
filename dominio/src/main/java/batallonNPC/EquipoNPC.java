package batallonNPC;

import java.util.List;

import batalla.Accion;
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
	@Override
	public int length() {
		return cantidad;
	}


	@Override
	public Personaje get(int i) {
		return batallon.get(i);
	}
	@Override
	public List<Personaje> getEquipo() {
		return  batallon;
	}
	@Override
	public List<Personaje> clonar() {
		return null;
	}
	@Override
	public List<Accion> pedirAccion(Batalla batalla) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> perderItemsEquipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int quitarOro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void repartirBotin(List<Equipo> equipo, int oro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darExperiencia(int experiencia) {
		// TODO Auto-generated method stub
		
	}
}
