package batalla;

import java.util.ArrayList;
import java.util.List;

import acciones.Accion;
import interfaces.Atacable;
import interfaces.Equipo;
import mensaje.MensajeBatalla;
import personaje.Personaje;

public class EquipoJugadores implements Equipo{

	private List<Personaje> equipo;


	/**
	 * Bueno alianza de personajes. 
	 * Se le debe pasar el nombre del equipo.
	 * @param nombreEquipo
	 * @author DrCoffee84
	 */

	public EquipoJugadores() {
		equipo = new ArrayList<Personaje>();

	}

	/**
	 * Agregar personaje, por ahora pense que puede tener un lider
	 * que es el que decide las batallas.
	 * igual posiblemente esto no exista en el futuro :).
	 * @param pj
	 * @author DrCoffee84
	 */
	public void agregar(Personaje pj){
		pj.setEquipo(this);
		equipo.add(pj);
	}

	/// Todo el codigo de aqui puede volar:


	public boolean isEmpty() {
		return equipo.isEmpty();
	}


	public void serAtacado(Atacable personaje) {
		if(  personaje.estaMuerto() ){
			this.equipo.remove(personaje);
		}
	}

	public Personaje get(int i) {
		return equipo.get(i);
	}

	public int size() {
		return equipo.size();
	}

	public List<Personaje> getEquipo() {
		return equipo;
	}


	public void atacar(Equipo victima) {

	}
	/*

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

	public List<Accion> pedirAccion(Equipo equipoElemigo) {
		Accion accion;
		List<Accion> acciones = new ArrayList<Accion>();
		for (Personaje pj : equipo) {

			accion = pj.pedirAccion(equipoElemigo);

			acciones.add(accion);
		}
		return acciones;	
	}


	/**
	 * 
	 */

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

	public Personaje getPersonaje(String nombre) {
		for (Personaje pj : equipo){
			if(pj.toString().equals(nombre)){
				return pj;
			}
		}
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

	@Override
	public void repartirBotin(int oro) {


	}

	@Override
	public void quitar(Personaje pj) {
		pj.salirEquipo();
		equipo.remove(pj);
	}

	@Override
	public List<Personaje> clonarLista() {

		return new ArrayList<Personaje>(equipo);
	}

	public List<Accion> pedirAccionTest(EquipoJugadores malos, List<MensajeBatalla> mensajes) {
		Accion accion;
		List<Accion> acciones = new ArrayList<Accion>();
		int i=0;
		for (Personaje pj : equipo) {
			accion = pj.pedirAccionTest(malos,mensajes.get(i)); //Solo es para el test.
			// Ya que cuadno un personaje pide accion, es en tiempo real y no llega como parametro.
			acciones.add(accion);
			i++;
		}
		return acciones;	
	}

	@Override
	public List<PersonajeSimple> obtenerEquipoSimple() {
		List<PersonajeSimple> personajesSimples = new ArrayList<>();
		for (Personaje pj : equipo) 
			personajesSimples.add(pj.getSimplificado());
		return personajesSimples;
	}
}
