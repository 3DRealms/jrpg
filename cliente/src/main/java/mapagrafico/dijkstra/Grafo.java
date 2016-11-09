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
	private Nodo[][] visitados; //Esta la creo para tener acceso directo y no me tarde siglos en buscar si ya tengo 

	public void setVisitados(Nodo actual,int i,int j) {
		this.visitados[i][j] = actual;
	}

	// nodo echo o no. (solo ocupa un 1mb si tengo 1000*1000)  36mb es mejor que esperar 1 siglo.
	public Grafo(MatrizBoolean obstaculos) {
		this.nodos  = new ArrayList<Nodo>();
		this.visitados = new Nodo[obstaculos.getFilas()][obstaculos.getColumnas()];
		Nodo actual;
		for (int i = 0; i < obstaculos.getFilas(); i++) {    	// Recorro la matriz (filas)
			for (int j = 0; j <  obstaculos.getColumnas(); j++) {	// Recorro la matriz (columna)
				if( obstaculos.get(i,j) )
					continue; // es un goto :v 
				actual = this.getNodoVisitante(i,j);
				if(actual == null){
					actual = new Nodo(new Punto(i,j));
					visitados[i][j] = actual;
				}
				obstaculos.obtenerVecinosNodo(i, j,actual,this);

				nodos.add(actual); 
			}	
		}
		//visitados = null; // Borro la matriz :)
	}

	public Nodo getNodoVisitante(int i,int j) {
		return visitados[i][j];
	}
	
	public Nodo getNodo(int i,int j) {
		for (Nodo n : nodos) {
		if(n.getPunto().comparar(new Punto(i,j)))
			return n;
		}
		return null;
	}
	
	public String toString() {
		String aux = "";
		for (Nodo n : nodos) {
			aux += n.toString()+"\n";
		}
		return aux;
	}



	/**	
	 * 	c = comienzo.
	 *  x = destino.
	 * 
	 *		0 - 0 - 0 - 0 
	 * 		| X | X | X |
	 * 		0 - 0 - 0 - 0 
	 * 		| X | X | X |
	 *		0 - 0 - 0 - 0 
	 * 		| X | X | X |
	 * 		0 - 0 - 0 - 0 
	 */
	public static void main(String[] args) {
		int n = 1000;
		boolean[][] m = new boolean[n][n];
		m[2][2] = true; //hay ostaculo
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);

		Grafo g = new Grafo(obstaculos);
		
		System.out.println("for "+g.getNodo(999, 999));
		System.out.println("matriz "+g.getNodoVisitante(999, 999));
	}

}

