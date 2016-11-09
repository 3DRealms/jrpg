package mapagrafico.dijkstra;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Nodo> nodos;
	/*
	 *  00 	01	02	03	04
	 *  10 	x 	12	13	14  // EJ: 00 -> 01, 10
	 *	20	21	22	23	24
	 *	30	31	x	33	34
	 *	40	41	42	43	44
	 *
	 */

	public Grafo(MatrizBoolean obstaculos) {
		this.nodos  = new ArrayList<Nodo>();
		int k = 0;
		Nodo actual;


		for (int i = 0; i < obstaculos.getFilas(); i++) {    	// Recorro la matriz (filas)
			for (int j = 0; j < obstaculos.getFilas(); j++) {	// Recorro la matriz (columna)

				k = Nodo.calcularID(i, j);  // ID de cada nodo, seria las coordenadas pero juntitas tipo (1,4) = 14.

				if( obstaculos.get(i,j) )
					continue; // es un goto :v 
				actual = new Nodo(k);
				obstaculos.obtenerVecinosNodo(i, j,actual);

				nodos.add(actual);
			}	
		}
	}

	public String toString() {
		String aux = "";
		for (Nodo n : nodos) {
			aux += n.toString()+"\n";
		}
		return aux;
	}



	/*		
	 * 	c = comienzo.
	 *  x = destino.
	 * 
	 *		c - 0 - 0 - 0 
	 * 		| X | X | X |
	 * 		0 - @ - 0 - @ 
	 * 		| X | X | X |
	 *		0 - @ - 0 - 0 
	 * 		| X | X | X |
	 * 		0 - @ - 0 - x 

	 */
	public static void main(String[] args) {
		int n = 4;
		boolean[][] obstaculos = new boolean[n][n];
		obstaculos[1][1] = true;
		obstaculos[1][2] = true;
		obstaculos[1][3] = true;
		obstaculos[3][1] = true;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if( i == 1 && j == 1)
					continue;
			} 
		}
	}

}




/*
public class Dijkstra {

	public static int [] dijkstra (int[] G, int comienzo) {
		final int [] distancia = new int [G.length];  // distancia mas corta para el comienzo
		final int [] precedente = new int [G.length];  // Nodo anterior de la ruta.
		final boolean [] visited = new boolean [G.length]; // al principio no visite ninguno(obvio no xD)

		for (int i=0; i<distancia.length; i++) {
			distancia[i] = Integer.MAX_VALUE;
		}
		distancia[comienzo] = 0;

		for (int i=0; i<distancia.length; i++) {
			final int next = minVertex (distancia, visited);
			visited[next] = true;

			// The shortest path to next is dist[next] and via pred[next].
							//HARDCODEADO PARA NADA
			final int [] n = {0,0}; //; G.neighbors(next);

			for (int j=0; j<n.length; j++) {
				final int v = n[j];
				final int d = distancia[next];// + G.getWeight(next,v);
				if (distancia[v] > d) {
					distancia[v] = d;
					precedente[v] = next;
				}
			}
		}
		return precedente;  // (ignore pred[s]==0!)
	}

	private static int minVertex (int [] dist, boolean [] v) {
		int x = Integer.MAX_VALUE;
		int y = -1;   // graph not connected, or no unvisited vertices
		for (int i=0; i<dist.length; i++) {
			if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
		}
		return y;
	}

}
 */