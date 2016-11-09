package mapagrafico.dijkstra;

import java.util.ArrayList;

import mapa.Punto;

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
		Nodo actual;


		for (int i = 0; i < obstaculos.getFilas(); i++) {    	// Recorro la matriz (filas)
			for (int j = 0; j < obstaculos.getFilas(); j++) {	// Recorro la matriz (columna)

				if( obstaculos.get(i,j) )
					continue; // es un goto :v 
				actual = new Nodo(new Punto(i,j));
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

