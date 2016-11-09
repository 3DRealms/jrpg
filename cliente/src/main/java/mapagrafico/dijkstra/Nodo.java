package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.List;

import mapa.Punto;

/**
 * Para mi todos el paso de nodo a nodo es de 1 siempre.
 * @author Danie
 */
public class Nodo {
	private Punto pos;
	List<Nodo> nodosAdyacentes;
	// esto capaz vuele.
	public Nodo(final Punto pos){
		this.pos = pos;
		nodosAdyacentes = new ArrayList<>();
	}

	public Punto getPos() {
		return pos;
	}

	public void setPos(Punto pos) {
		this.pos = pos;
	}

	public void agregarConexion(Punto id) {
		nodosAdyacentes.add(new Nodo(id));
	}	
	
	@Override
	public String toString() {
		String aux = "Nodo"+pos+": ";
		for(Nodo nodo : nodosAdyacentes)
			aux += nodo.pos.toString() + " ";
		return aux;
	}

}
