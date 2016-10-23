package interfaces;

import personaje.Personaje;
/**
 * Interface. que hace que una clase, sea un equipo de algo (npc o personaje)
 * @author Danie
 */
public interface Equipo {
	public void atacar(Equipo victima);
	public boolean isEmpty();
	public void serAtacado(Atacable Atacable);
	public int length();
	public Personaje get(int i);
	public Atacable obtenerProximaVictima();
}
