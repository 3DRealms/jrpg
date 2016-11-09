package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Para mi todos el paso de nodo a nodo es de 1 siempre.
 * @author Danie
 */
public class Nodo {
	private int pos;
	List<Nodo> nodosAdyacentes;
	// esto capaz vuele.
	public Nodo(final int pos){
		this.pos = pos;
		nodosAdyacentes = new ArrayList<>();
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void agregarConexion(int calcularID) {
		nodosAdyacentes.add(new Nodo(calcularID));
	}	
	public static int calcularID(int i, int j) {
		return i*10+j;
	}
	
	@Override
	public String toString() {
		String aux = "Nodo"+pos+": ";
		for(Nodo a : nodosAdyacentes)
			aux += a.pos + " ";
		return aux;
	}

}
