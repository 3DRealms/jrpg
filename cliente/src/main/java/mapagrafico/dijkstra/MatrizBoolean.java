package mapagrafico.dijkstra;

import mapa.Punto;

public class MatrizBoolean {

	private boolean[][]mat;
	private int filas;
	private int columnas;


	public MatrizBoolean(boolean[][] mat, int filas, int columnas) {
		this.mat = mat;
		this.filas = filas;
		this.columnas = columnas;

	}
	/**
	 * Verigica que los vecinos de i j sean validos 
	 * y no hay obstaculo, agrega como adyasente al nodo
	 * 
	 * @param fil
	 * @param col
	 */
	public void obtenerVecinosNodo(int fil, int col,Nodo actual, Grafo g) {
		int i, j,fila,columna;
		Nodo aux;// recorro matriz de vecinos

		for (i = -1; i < 2; i++) {
			fila = fil +i;
			for (j = -1; j < 2; j++) {
				columna = col + j;
				if ( esPosicionValida(fila, columna)) // descarto fuera de rango
				{
					if ((fila != fil || columna != col)) // descarto la fila y columna dados

					{	
							//Si no hay obstaculo y si no hay alguno cerca (en diagonal) meto :*
						
						if( !mat[fila][columna] && !hayObstaculoCerca(fil,col,fila,columna) ){  //Si no hay obstaculo
						
							aux = g.getNodoVisitante(fila,columna);
							if(aux==null){	
								aux = new Nodo(new Punto(fila,columna));
								actual.agregarConexion( aux ) ;
								g.setVisitados(aux, fila, columna);
							}
							else{
								actual.agregarConexion(aux);
							}

						}

					}
				}
			}
		}
	}

	/**
	 * 
	 * Le paso el nodo que evaluo 
	 * y les paso las coordenadas de la arista que quiero conectar
	 * @param xNodo
	 * @param yNodo
	 * @param xArista
	 * @param yArista
	 * @return
	 */
	private boolean hayObstaculoCerca(int xNodo,int yNodo, int xArista, int yArista) {

		boolean aux = false;
		if( xArista+1==xNodo && yArista+1==yNodo && xNodo>=0 && yNodo>=0)
			aux = mat[xNodo-1][yNodo]	|| 	mat[xNodo][yNodo-1];
		
		if( xArista+1==xNodo && yArista-1==yNodo && xNodo>=0 && yNodo<columnas)
			aux = mat[xNodo-1][yNodo] ||mat[xNodo][yNodo+1]	;
		
		if( xArista-1==xNodo && yArista+1==yNodo && xNodo<filas && yNodo>=0){
			aux =  mat[xNodo+1][yNodo] 	|| 	mat[xNodo][yNodo-1];

		}
		
		if( xArista-1==xNodo && yArista-1==yNodo && xNodo<filas && yNodo<columnas)
			aux =  mat[xNodo+1][yNodo] 	||	mat[xNodo][yNodo+1];
		return aux;
	}
	public boolean esPosicionValida(int pos_f, int pos_c) {
		return (pos_f >= 0 && pos_f < filas && pos_c >= 0 && pos_c < columnas);
	}
	public boolean get(int i,int j){
		return mat[i][j];
	}
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

}
