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
	 * @param xNodo
	 * @param yNodo
	 */
	public void obtenerVecinosNodo(int xNodo, int yNodo,Nodo actual, Grafo g) {
		int i, j,xArista,yArista;
		Nodo aux;// recorro matriz de vecinos

		for (i = -1; i < 2; i++) {
			xArista = xNodo +i;
			for (j = -1; j < 2; j++) {
				yArista = yNodo + j;
				if ( esPosicionValida(xArista, yArista)) // descarto fuera de rango
				{
					if ((xArista != xNodo || yArista != yNodo)) // descarto la fila y columna dados

					{	
						//Si no hay obstaculo y si no hay alguno cerca (en diagonal) meto :*

						if( !mat[xArista][yArista] && !hayObstaculoCerca(xNodo,yNodo,xArista,yArista) ){  //Si no hay obstaculo

							aux = g.getNodoVisitante(xArista,yArista);
							if(aux==null){	
								aux = new Nodo(new Punto(xArista,yArista));
								actual.agregarConexion( aux ) ;
								g.setVisitados(aux, xArista, yArista);
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

		if( xArista-1==xNodo && yArista+1==yNodo && xNodo<filas && yNodo>=0)
			aux =  mat[xNodo+1][yNodo] 	|| 	mat[xNodo][yNodo-1];

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
	@Override
	public String toString() {
		String aux = "";
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				aux += this.get(i, j)+" ";
			}	
			aux+= "\n";
		}
		return aux;
	}

}
