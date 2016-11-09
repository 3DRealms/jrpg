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
		predecesores.add(origen);
		
		while (!nodoMenorDistancia.equals(nodoDestino)) { 
			aux = nodoMenorDistancia.obtenerMenorAdyacente(nodoDestino, predecesores);
			//System.out.println(aux.getPunto());
			predecesores.add(aux);
			nodoMenorDistancia = aux.clone();
		}
	}
	
	
	public ArrayList<Nodo> getPredecesores() {
		return predecesores;
	}

}
