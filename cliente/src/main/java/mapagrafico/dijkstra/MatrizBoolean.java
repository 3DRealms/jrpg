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
						
						if( !mat[fila][columna] && !hayObstaculoCerca(fila,columna,fil,col) ){  //Si no hay obstaculo

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


	private boolean hayObstaculoCerca(int i,int j, int fil, int col) {

		boolean aux = false;
		if( fil-1==i && col-1==j && j<columnas && i<filas)
			aux = mat[i][j+1] || mat[i+1][j];
		
		if( fil-1==i && col+1==j && i<filas && j>=0)
			aux =  mat[i][j-1] || mat[i+1][j];
		
		if( fil+1==i && col-1==j && i>=0 && j>=0)
			aux =  mat[i-1][j] || mat[i][j-1];
		
		if( fil-1==i && col+1==j && i>=0 && j<columnas)
			aux =  mat[i-1][j] || mat[i][j+1];
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
