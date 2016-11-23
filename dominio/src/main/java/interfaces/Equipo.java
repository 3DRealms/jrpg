package interfaces;

import java.util.List;
import acciones.Accion;
import batalla.PersonajeSimple;
import personaje.Personaje;

/**
 * Interface. que hace que una clase, sea un equipo de algo (npc o personaje)
 * @author Danie
 */
public interface Equipo {
	
	public void atacar(Equipo victima);
	/**
	 * Dice si hay por lo menos un personaje vivo en el equipo.
	 * devuelve falso si estan todos muertos.(o ya no estan).
	 * @param equipo
	 * @return
	 */
	public boolean isEmpty();
	public void serAtacado(Atacable Atacable);
	public int size();
	public Personaje get(int i);
	public Personaje getPersonaje(String i);
	public List<Personaje> getEquipo();
	public List<Accion> pedirAccion(Equipo equipoElemigo);
	public List<Equipo> perderItemsEquipo();
	public int quitarOro();
	public void repartirBotin( int oro );
	public void darExperiencia(int experiencia);
	public void quitar(Personaje personaje);
	public List<Personaje> clonarLista();
	public List<PersonajeSimple> obtenerEquipoSimple();
	public void agregar(Personaje pj);

}
