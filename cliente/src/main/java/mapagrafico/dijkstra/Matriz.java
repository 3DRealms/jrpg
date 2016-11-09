package mapagrafico.dijkstra;

public class Matriz {

	private int[][]mat;
	private int filas;
	private int columnas;

	public Matriz(int[][] mat, int filas, int columnas) {
		this.mat = mat;
		this.filas = filas;
		this.columnas = columnas;
	}

	public void obtenerVecinos(int fil, int col) {
		int i, j;

		for (i = -1; i < 2; i++) // recorro matriz de vecinos
		{
			for (j = -1; j < 2; j++) {
				if (esPosicionValida(fil + i, col + j, filas, columnas)) // descarto fuera de rango
				{
					if ((fil + i != fil || col + j != col)) // descarto la fila
															// y columna dados
					{
						// Hacer lo que sea que haga con la i,j
					}
				}
			}
		}
	}

	public boolean esPosicionValida(int pos_f, int pos_c, int filas,
			int columnas) {
		return (pos_f >= 0 && pos_f < filas && pos_c >= 0 && pos_c < columnas);
	}

}
