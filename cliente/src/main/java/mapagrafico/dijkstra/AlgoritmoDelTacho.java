package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class AlgoritmoDelTacho {
	/**
	 * Bienvenidos al algoritmo de Dijkstra, sin m
	 * recuestese, sus asientos flotaran suavemente.
	 * @param
	 */
	protected Nodo actualW;
	protected Nodo aux;
	protected Map<Nodo,Nodo> predecesores; 
	protected ArrayList<Nodo> pendientes; 
	protected ArrayList<Nodo> solucion; 
	private Map<Nodo, Integer> distancias = new HashMap<Nodo, Integer>(); 

	public void calcularDijkstra(Grafo grafo, Nodo inicial) {
		predecesores = new HashMap<Nodo,Nodo>();
		
		pendientes = new ArrayList<Nodo>();
		solucion = new ArrayList<Nodo>();

		distancias.put(inicial, 0); 
		pendientes.add(inicial);
	
		while (pendientes.size() > 0) { 
			actualW = obtenerMinimo(pendientes); 
			solucion.add(actualW); 
			pendientes.remove(actualW);  
			encontrarDistanciasMinimas(actualW);  

		}

	}

	public void encontrarDistanciasMinimas(Nodo actual) {

		for (Nodo vecino : actual.nodosAdyacentes) {
			if (!yaVisitado(vecino)) {
				if (obtenerDistancia(vecino) > obtenerDistancia(actual) + 1) {
					distancias.put(vecino, obtenerDistancia(actual) + 1);
					predecesores.put(vecino, actual);
					pendientes.add(vecino);
				}
			}

		}

	}

	public Nodo obtenerMinimo(ArrayList<Nodo> nodosAdy) {
		Nodo minimo = null;

		for (Nodo nodo : nodosAdy) {
			if (minimo == null) {
				minimo = nodo;
			} else if (obtenerDistancia(nodo) < obtenerDistancia(minimo))
				minimo = nodo;
		}
		return minimo;
	}

	private int obtenerDistancia(Nodo nodo) {
		Integer distancia = distancias.get(nodo);
		if (distancia == null)
			return Integer.MAX_VALUE;

		return distancia;
	}

	public Map<Nodo,Nodo> getPredecesores() {
		return predecesores;
	}

	public boolean yaVisitado(Nodo nodo) {
		return solucion.contains(nodo);
	}
	
	public LinkedList<Nodo> obtenerCamino(Nodo destino){
		LinkedList<Nodo> camino = new LinkedList<Nodo>();
		Nodo nodito = destino;
		if(predecesores.get(nodito)==null)
		return null;
		
		camino.add(nodito);
		while(predecesores.get(nodito)!=null){
			nodito = predecesores.get(nodito);
			camino.add(nodito);
			
		}
		
		Collections.reverse(camino);
		return camino;
	}
	
	public void mostrarCamino(Nodo destino){
		LinkedList<Nodo> camino = obtenerCamino(destino);
		if(camino==null)
			return;
		
		for (int i = 0; i < camino.size(); i++) {
			System.out.println(camino.get(i).getPunto());
		}
	}

}
