package cliente;

import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Grafo;
import mapagrafico.dijkstra.MatrizBoolean;
import mapagrafico.dijkstra.Nodo;

import org.junit.Assert;
import org.junit.Test;


public class TestDijkstra {
	
	/**
	 * Ver documentacion
	 * @param
	 */
	
	@Test
	public void quePuedoIrDeUnPuntoAOtroSinObstaculos(){

		AlgoritmoDelTacho prueba = new AlgoritmoDelTacho();
		int n = 5;
		boolean[][] m = new boolean[n][n];
	
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);
		
		Grafo g = new Grafo(obstaculos);

		Nodo origen =  g.getNodo(4,4);
		Nodo destino = g.getNodo(0, 0);
		prueba.calcularDijkstra(g, origen, destino);
		
		Assert.assertNotEquals(null, prueba.obtenerCamino( destino ) );
		
	}
	

	@Test
	public void quePuedoSalirDelLaberintoS(){
		
//		i 0 0 0 0
//		1 1 1 1 0
//		0 0 0 0 0
//		0 1 1 1 1
//		0 0 0 0 x
		AlgoritmoDelTacho prueba = new AlgoritmoDelTacho();
		int n = 5;
		boolean[][] m = new boolean[n][n];
		m[1][0]= true; 
		m[1][1]= true; 
		m[1][2]= true; 
		m[1][3]= true; 
		
		m[3][1]= true; 
		m[3][2]= true; 
		m[3][3]= true; 
		m[3][4]= true; 
		
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);
		Grafo g = new Grafo(obstaculos);
		Nodo origen =  g.getNodo(0,0);
		Nodo destino = g.getNodo(4, 4);
		prueba.calcularDijkstra(g, origen, destino);

	}

	
	@Test
	public void quePuedoEsquivarObstaculosYLlegarADestino(){
		
//		i 0 0 0 0 0
//		0 0 0 1 1 0
//		0 1 1 1 1 0
//		0 0 0 0 0 0
//		0 0 0 0 0 0
//		0 0 0 0 0 x
		
		AlgoritmoDelTacho prueba = new AlgoritmoDelTacho();
		int n = 6;
		boolean[][] m = new boolean[n][n];
		m[1][3]= true; 
		m[1][4]= true; 
		
		m[2][1]= true; 
		m[2][2]= true; 
		m[2][3]= true; 
		m[2][4]= true; 
		
		
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);
		Grafo g = new Grafo(obstaculos);
		Nodo origen =  g.getNodo(0,0);
		Nodo destino = g.getNodo(5, 5);
		prueba.calcularDijkstra(g, origen, destino);
		Assert.assertNotEquals(null, prueba.obtenerCamino( destino ) );
		
	}

	@Test
	public void quePuedoSalirdeLaberintoComplejo(){
		AlgoritmoDelTacho prueba = new AlgoritmoDelTacho();
		int n = 11;
//		1 1 1 1 1 1 1 1 1 1 1
//		1 0 0 0 1 0 0 0 0 0 1
//		1 0 1 0 1 0 1 1 1 0 1
//		1 0 1 0 1 0 0 0 1 0 1
//		1 0 1 1 1 1 1 0 1 0 1
//		1 0 0 0 0 0 0 0 1 0 1
//		1 0 1 1 1 0 0 0 1 0 1
//		1 0 0 0 1 0 0 0 1 0 1
//		1 0 1 1 1 1 0 0 1 0 1
//		1 i 1 0 0 0 0 0 1 x 1
//		1 1 1 1 1 1 1 1 1 1 1
		boolean[][] m = new boolean[n][n];
		m[0][0]= true; 
		m[0][1]= true; 
		m[0][2]= true; 
		m[0][3]= true; 
		m[0][4]= true; 
		m[0][5]= true; 
		m[0][6]= true; 
		m[0][7]= true; 
		m[0][8]= true; 
		m[0][9]= true; 
		m[0][10]= true; 
		
		
		m[1][0]= true; 
		m[2][0]= true; 
		m[3][0]= true; 
		m[4][0]= true; 
		m[5][0]= true; 
		m[6][0]= true; 
		m[7][0]= true; 
		m[8][0]= true; 
		m[9][0]= true; 
		m[10][0]= true; 
		
		m[10][1]= true; 
		m[10][2]= true; 
		m[10][3]= true; 
		m[10][4]= true; 
		m[10][5]= true; 
		m[10][6]= true; 
		m[10][7]= true; 
		m[10][8]= true; 
		m[10][9]= true; 
			
		
		m[1][10]= true; 
		m[2][10]= true; 
		m[3][10]= true; 
		m[4][10]= true; 
		m[5][10]= true; 
		m[6][10]= true; 
		m[7][10]= true; 
		m[8][10]= true; 
		m[9][10]= true; 
		m[10][10]= true; 
		
		m[1][4]= true; 
		m[2][4]= true; 
		m[3][4]= true; 
		m[4][4]= true; 
		
		m[2][2]= true; 
		m[3][2]= true; 
		m[4][2]= true; 
		
		m[4][3]= true; 
		m[4][5]= true; 
		m[4][6]= true; 
		
		m[2][6]= true; 
		m[2][7]= true; 
		m[2][8]= true; 
		
		m[3][8]= true; 
		m[4][8]= true; 
		m[5][8]= true; 
		m[6][8]= true; 
		m[7][8]= true; 
		m[8][8]= true; 
		m[9][8]= true; 
		
		m[6][6]= true; 
		m[6][7]= true; 
		
		m[6][2]= true; 
		m[6][3]= true; 
		m[6][4]= true; 
		
		
		m[7][4]= true; 
		m[8][4]= true; 
		
		m[8][2]= true; 
		m[8][3]= true; 
		m[8][2]= true; 
		m[8][5]= true; 
		m[8][6]= true; 
		
		m[9][2]= true; 		
		
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);
		Grafo g = new Grafo(obstaculos);
		Nodo origen =  g.getNodo(9,1);
		Nodo destino = g.getNodo(1, 9);
		prueba.calcularDijkstra(g, origen, destino);
		Assert.assertNotEquals(null, prueba.obtenerCamino( destino ) );
	}
	
	
	@Test
	public void quePuedoPasarPorMapasGrandes(){

		AlgoritmoDelTacho prueba = new AlgoritmoDelTacho();
		int n = 100;
		boolean[][] m = new boolean[n][n];
	
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);
		
		Grafo g = new Grafo(obstaculos);

		Nodo origen =  g.getNodo(0,0);
		Nodo destino = g.getNodo(99, 99);
		
		long lastTime = System.nanoTime();
		
		prueba.calcularDijkstra(g, origen, destino);
		
		Assert.assertNotEquals(null, prueba.obtenerCamino( destino ) );
		
		long now = System.nanoTime();
		/**
		 * Esto depende de la pc, pero al parecer un mapa de 100x100 puede 
		 * resolverlo en un tiempo menor a 1,5 segundos.
		 * Más no le pidan pobrecito, se verá cuando implemente la cola de prioridades
		 * en un futuro, o haga un A*
		 */
		Assert.assertTrue(1.5>(now-lastTime)/1000000000);

		
	}

}
