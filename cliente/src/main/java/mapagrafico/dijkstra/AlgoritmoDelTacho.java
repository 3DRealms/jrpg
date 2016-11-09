package mapagrafico.dijkstra;

import java.util.ArrayList;

public class AlgoritmoDelTacho {

	protected Nodo origen;
	protected Nodo nodoMenorDistancia;
	protected Nodo aux;
	protected Nodo nodoDestino;
	protected int[] costos;
	protected ArrayList<Nodo> predecesores = new ArrayList<Nodo>();


	public void calcularDijkstra(Nodo origen, Nodo nodoDestino) {

		nodoMenorDistancia = origen;
		aux = nodoMenorDistancia.clone();

		while (!nodoMenorDistancia.equals(nodoDestino)) { //RANCIOO no me cambia el nodo :(
			aux = nodoMenorDistancia.obtenerMenorAdyacente(nodoDestino);
			predecesores.add(aux);
			nodoMenorDistancia = aux.clone();
		}
	}
	
	
	public ArrayList<Nodo> getPredecesores() {
		return predecesores;
	}

}
