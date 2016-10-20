package interfaces;

import personaje.Personaje;

public interface Equipo {
	public void atacar(Equipo victima);
	public boolean isEmpty();
	public void serAtacado(Atacable Atacable);
	public int length();
	public Personaje get(int i);
	public Atacable obtenerProximaVictima();
}
