package equipos;

import java.util.List;

import interfaces.Atacable;
import interfaces.Equipo;
import personaje.Personaje;

public class Alianza implements Equipo{
	
	List<Personaje> alianza;
	String nombreEquipo;
	
	public Alianza(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * El Equipo conformado por jugadores va tener que 
	 * atacar uno por vez en un turno de la partida
	 * cada jugador puede selecionar a quien va a atacar
	 * y [a futuro] se deberia poder saltear un turno o 
	 * elegir el orden de ataque.
	 * Ej: j1 j2 j3 j4 j5
	 * pero estrategicamente quiero que ataque en el otro orden
	 * j4 j5 j1 j3 j2.
	 *  
	 */
	@Override
	public void atacar(Equipo victima) {
		//aca tengo que tirar la magia, pero 
		for (int i = 0; i < alianza.size(); i++) {
			
		}
	}
	
	@Override
	public String toString() {
		return nombreEquipo;
	}

	@Override
	public boolean isEmpty() {
		return alianza.isEmpty();
	}
	@Override
	public void serAtacado(Atacable victima) {
		
	}
	@Override
	public int length() {
		return alianza.size();
	}
	@Override
	public Personaje get(int i) {
		return alianza.get(i);
	}
	@Override
	public Atacable obtenerProximaVictima() {
		return null;
	}

	
}
