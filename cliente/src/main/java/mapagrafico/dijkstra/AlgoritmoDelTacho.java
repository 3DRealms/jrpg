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

		double i = 0;
		nodoMenorDistancia = origen;
		aux = nodoMenorDistancia.clone();
		double distanciaActual = nodoMenorDistancia.getPunto()
				.calcularDistancia(nodoDestino.getPunto());

		while (distanciaActual != 0.0) { //RANCIOO no me cambia el nodo :(

			for (Nodo nodo : nodoMenorDistancia.nodosAdyacentes) {
				System.out.println(nodo);
				i = nodo.calcularDistanciaNodos(nodoDestino);	
				if (distanciaActual >= i) {
					distanciaActual = i;
					aux = nodo.clone();
				}
			}
			predecesores.add(aux);
			nodoMenorDistancia = aux.clone();
		}
	}
	public ArrayList<Nodo> getPredecesores() {
		return predecesores;
	}

}
