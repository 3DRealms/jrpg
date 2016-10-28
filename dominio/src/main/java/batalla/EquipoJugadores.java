package batalla;

import java.util.ArrayList;
import java.util.List;

import interfaces.Atacable;
import interfaces.Equipo;
import personaje.Personaje;

public class EquipoJugadores implements Equipo{

	private List<Personaje> equipo;
	private String nombreEquipo;

	/**
	 * Bueno alianza de personajes. 
	 * Se le debe pasar el nombre del equipo.
	 * @param nombreEquipo
	 * @author DrCoffee84
	 */
	public EquipoJugadores(String nombreEquipo) {
		equipo = new ArrayList<Personaje>();
		this.nombreEquipo = nombreEquipo;
	}
	/**
	 * Agregar personaje, por ahora pense que puede tener un lider
	 * que es el que decide las batallas.
	 * igual posiblemente esto no exista en el futuro :).
	 * @param pj
	 * @author DrCoffee84
	 */
	public void agregar(Personaje pj){
		equipo.add(pj);
	}

	/// Todo el codigo de aqui puede volar:
	@Override
	public String toString() {
		return nombreEquipo;
	}

	@Override
	public boolean isEmpty() {
		return equipo.isEmpty();
	}

	@Override
	public void serAtacado(Atacable personaje) {
		if(  personaje.estaMuerto() ){
			this.equipo.remove(personaje);
		}
	}
	@Override
	public Personaje get(int i) {
		return equipo.get(i);
	}
	@Override
	public int length() {
		return 0;
	}
	@Override
	public List<Personaje> getEquipo() {
		return equipo;
	}

	@Override
	public void atacar(Equipo victima) {

	}

	/*
	@Override
	public ArrayList<Personaje> clonar() {
		ArrayList<Personaje> clone = new ArrayList<Personaje>(equipo.size());
		for (Personaje item : equipo) 
			clone.add( item.clone() ); //Tengo que arreglar el clone de Personaje.
		return clone;
	}
	 */

	/**
	 * Le pide la acciones que va a realizar un equipo.
	 * sobre una batalla dada.
	 * @param equipo
	 * @return
	 */
	@Override
	public List<Accion> pedirAccion(Batalla batalla) {
		Accion accion;
		List<Accion> acciones = new ArrayList<Accion>();
		for (Personaje pj : equipo) {

			accion = pj.pedirAccion(null);

			acciones.add(accion);
		}
		return acciones;	
	}


	/**
	 * 
	 */
	@Override
	public void darExperiencia(int experiencia){
		// y le doy la experiencia al cada personaje del equipo ganador
		int expGanador = experiencia * getNivelPromedio();
		expGanador /= equipo.size();
		for (Personaje pj : equipo) {
			pj.subirExperencia(expGanador);
		}
	}

	private int getNivelPromedio() {
		int nivelPromedio = 0;
		for (Personaje pj : equipo) {
			nivelPromedio += pj.getNivel();
		}
		return nivelPromedio/equipo.size();
	}

	@Override
	public List<Equipo> perderItemsEquipo() {
		return null;
	}
	@Override
	public int quitarOro() {
		return 0;
	}
	@Override
	public void repartirBotin(List<Equipo> equipo, int oro) {
	}
	@Override
	public List<Personaje> clonar() {
		return null;
	}
}
