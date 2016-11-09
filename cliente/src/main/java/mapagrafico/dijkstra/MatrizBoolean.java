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
	public void obtenerVecinosNodo(int fil, int col,Nodo actual) {
		int i, j;

		for (i = -1; i < 2; i++) // recorro matriz de vecinos
		{
			for (j = -1; j < 2; j++) {
				if (esPosicionValida(fil + i, col + j, filas, columnas)) // descarto fuera de rango
				{
					if ((fil + i != fil || col + j != col)) // descarto la fila
															// y columna dados
					{
						if(! mat[i][j]){
							actual.agregarConexion(new Punto(i,j));
						}			
			}}
			}}
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
