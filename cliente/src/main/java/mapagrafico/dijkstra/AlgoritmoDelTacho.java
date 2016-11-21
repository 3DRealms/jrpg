package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class AlgoritmoDelTacho {
	/**
	 * Bienvenidos al algoritmo de Dijkstra, sin m.
	 * Recuestese, sus asientos flotaran suavemente.
	 * (Ahora sin bugs, y menos optimo)
	 * @param
	 */
	protected Nodo actualW;
	protected Nodo aux;
	protected Map<Nodo,Nodo> predecesores; 
	protected ArrayList<Nodo> pendientes; 
	protected ArrayList<Nodo> solucion; 
	private Map<Nodo, Integer> distancias = new HashMap<Nodo, Integer>(); 
	protected Grafo graf;

	public void calcularDijkstra(Grafo grafo, Nodo inicial,Nodo destino) {
		predecesores = new HashMap<Nodo,Nodo>();
		this.graf = grafo;
		pendientes = new ArrayList<Nodo>();
		solucion = new ArrayList<Nodo>();

		distancias.put(inicial, 0); 
		pendientes.add(inicial);
		

		while (pendientes.size() > 0) {
			actualW = obtenerMinimo(pendientes); 
			if(actualW == destino) // Ultra optimizacion :) 
				break;
			solucion.add(actualW); 
			pendientes.remove(actualW);  
			encontrarDistanciasMinimas(actualW);  

		}
		

	}

	public void encontrarDistanciasMinimas(Nodo actual) {
		
		//esto arreglo el tema de no encontrar camino en un laberinto
		Nodo aux = graf.getNodo(actual.getPunto().getX(), actual.getPunto().getY());
		
		for (Nodo vecino : aux.getNodosAdyacentes()) {
			if (!yaVisitado(vecino)) {
				if (obtenerDistancia(vecino) > obtenerDistancia(actual) + actual.getPeso(vecino)) {
					// CREO QUE ERA ESTOOOO  
					/**
					 * AL PARECER SE BORRABAN LAS CONEXIONES CON LOS NODOS DEL GRAFO
					 */
					Nodo pendiente  = graf.getNodo(vecino.getPunto().getX(), vecino.getPunto().getY());
					distancias.put(pendiente, obtenerDistancia(actual) + actual.getPeso(vecino));
					predecesores.put(pendiente, actual);
//					pendientes.add(vecino);  ranciooo
					pendientes.add(pendiente);
				}
			}
		}
	}

	public Nodo obtenerMinimo(ArrayList<Nodo> nodosAdy) {
		Nodo minimo = nodosAdy.get(0);

		for (Nodo nodo : nodosAdy) {
			if (obtenerDistancia(nodo) < obtenerDistancia(minimo)) 
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

	public String mostrarCamino(Nodo destino){
		LinkedList<Nodo> camino = obtenerCamino(destino);
		String aux = "";
		if(camino==null)
			return aux;

		for (int i = 0; i < camino.size(); i++) {
			aux += " " + camino.get(i).getPunto();
		}
		return aux;
	}

}