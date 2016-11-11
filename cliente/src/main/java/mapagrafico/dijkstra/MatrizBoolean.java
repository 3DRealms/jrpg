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
				if ( esPosicionValida(fila, columna, filas, columnas)) // descarto fuera de rango
				{

					if ((fila != fil || columna != col)) // descarto la fila y columna dados
						
					{
						if( ! hayObstaculoCerca(fila,columna) ){  //Si no hay obstaculo
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


	private boolean hayObstaculoCerca(int i,int j) {
		return mat[i][j];
	}
	public boolean esPosicionValida(int pos_f, int pos_c, int filas,
			int columnas) {
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
