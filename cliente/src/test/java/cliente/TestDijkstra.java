package cliente;

import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Grafo;
import mapagrafico.dijkstra.MatrizBoolean;
import mapagrafico.dijkstra.Nodo;

import org.junit.Assert;
import org.junit.Test;


public class TestDijkstra {
	
	/**
	 * Testeos rancios
	 * 1 -> obstaculo
	 * 0 -> puede pasar
	 * x-> destino
	 * i-> salida
	 * Todavia no esta contemplado el caso de pasos en diagonal cerca de obstaculos
	 * en todo caso puedo crear un normalizador de obstaculos de mapa
	 * algun dia
	 * @param
	 */
	
	@Test
	public void prueba(){

		AlgoritmoDelTacho prueba = new AlgoritmoDelTacho();
		int n = 5;
		boolean[][] m = new boolean[n][n];
	
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);
		m[2][2]= true; 
		m[1][3]= true; 
	//	m[2][3] = true;
		Grafo g = new Grafo(obstaculos);
	//	System.out.println(obstaculos);
		/**
		 * despues hago los asserts no jodas gordo
		 */
		Nodo destino = g.getNodo(0, 1);
		prueba.calcularDijkstra(g, g.getNodo(4,4), destino);
		
		Assert.assertNotEquals(null, prueba.obtenerCamino( destino ) );
		
	}
	@Test
	public void prueba222(){
		
		AlgoritmoDelTacho prueba = new AlgoritmoDelTacho();
		int n = 5;
		boolean[][] m = new boolean[n][n];
		
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);
		m[2][2]= true; 
		m[1][3]= true; 
		//	m[2][3] = true;
		Grafo g = new Grafo(obstaculos);
		//	System.out.println(obstaculos);
		/**
		 * despues hago los asserts no jodas gordo
		 */
		Nodo destino = g.getNodo(0, 0);
		prueba.calcularDijkstra(g, g.getNodo(4,4), destino);
		
		Assert.assertNotEquals(null, prueba.obtenerCamino( destino ) );
		
	}
	
	/*
	@Test
	public void prueba2(){
		
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
		
		prueba.calcularDijkstra(g, g.getNodo(0, 0));
		//prueba.mostrarCamino(g.getNodo(4, 4));
		
		//System.out.println(prueba.predecesores);
		
		//System.out.println(prueba.obtenerCamino(g.getNodo(4, 4)));
		
		//System.out.println(g);
		
	}
	
	
	@Test
	public void prueba3(){
		
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
		
		prueba.calcularDijkstra(g, g.getNodo(0, 3));
		System.out.println(prueba.mostrarCamino(g.getNodo(3, 3)));
		
		//System.out.println(prueba.predecesores);
		
		//System.out.println(prueba.obtenerCamino(g.getNodo(4, 4)));
		
		//System.out.println(g);
		
	}
	
	@Test
	public void prueba4(){
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
		
		prueba.calcularDijkstra(g, g.getNodo(9, 1));
		prueba.mostrarCamino(g.getNodo(9, 9));
		
		//System.out.println(prueba.predecesores);
		
		//System.out.println(prueba.obtenerCamino(g.getNodo(4, 4)));
		
		//System.out.println(g);
		
	}

*/
}
