package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.List;

import mapa.Punto;

/**
 * Para mi todos el paso de nodo a nodo es de 1 siempre.
 * @author Danie
 */
public class Nodo {
	private int pos;
	List<Nodo> nodoAdyacentes;
	// esto capaz vuele.
	public Nodo(final int pos){
		this.pos = pos;
		nodoAdyacentes = new ArrayList<>();
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void agregarConexion(int calcularID) {
		nodoAdyacentes.add(new Nodo(calcularID));
	}	
}
