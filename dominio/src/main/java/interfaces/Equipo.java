package interfaces;

import java.util.List;

import batalla.Accion;
import batalla.Batalla;
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
	public int length();
	public Personaje get(int i);
	public List<Personaje> getEquipo();
	public List<Personaje> clonar();
	public List<Accion> pedirAccion(Batalla batalla);
	public List<Equipo> perderItemsEquipo();
	public int quitarOro();
	public void repartirBotin(List<Equipo> equipo, int oro);
	public void darExperiencia(int experiencia);
}
