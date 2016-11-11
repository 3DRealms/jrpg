package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AlgoritmoDelTacho {

	protected Nodo origen;
	protected Nodo actualW;
	protected Nodo proximoNodo;
	protected int distanciaActual;
	protected ArrayList<Nodo> predecesores = new ArrayList<Nodo>();
	protected ArrayList<Nodo> V = new ArrayList<Nodo>();
	protected ArrayList<Nodo> S = new ArrayList<Nodo>();
	private Map<Nodo, Integer> costoDesdeOrigen = new HashMap<Nodo,Integer >();

	public void calcularDijkstra(Grafo grafo, Nodo inicial) {

		origen = inicial;
		int distanciaC=1;

		cargarConjuntoV(grafo,inicial);
		actualW = inicial;

		while(!V.isEmpty()){
			for(Nodo vecino : actualW.nodosAdyacentes){
				if(V.contains(vecino)){

					if(costoDesdeOrigen.get(vecino) !=null)
						distanciaActual =  costoDesdeOrigen.get(vecino)+distanciaC ;
					else
						distanciaActual = distanciaC;

					if(costoDesdeOrigen.get(vecino)== null || distanciaActual < costoDesdeOrigen.get(vecino)){
						costoDesdeOrigen.replace(vecino, costoDesdeOrigen.get(vecino), distanciaActual);
						predecesores.add(actualW);
					} 
				}
			}

			V.remove(actualW);
			proximoNodo = minimoNoVisitado(V);

			if(proximoNodo == null)
				return;

			actualW = proximoNodo;
		}

	}

	public void cargarConjuntoV(Grafo grafo, Nodo inicial){
		//HACER UN GET PARA LA LISTA DE NODOS
		for(Nodo nodo: grafo.getListaNodos()){
			if(nodo != inicial)
				V.add(nodo.clone());
			costoDesdeOrigen.put(nodo, null);
		}

	}

	public Nodo minimoNoVisitado(ArrayList<Nodo> lista){	
		return null;
	}

	public ArrayList<Nodo> getPredecesores() {
		return predecesores;
	}
}

