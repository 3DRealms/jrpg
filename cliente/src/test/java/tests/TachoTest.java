package tests;

import java.util.ArrayList;

import mapa.Punto;
import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Grafo;
import mapagrafico.dijkstra.MatrizBoolean;
import mapagrafico.dijkstra.Nodo;

import org.junit.Assert;
import org.junit.Test;

public class TachoTest {
	@Test
	public void caso1(){
		/**
		 * Matriz normal, deberia ir en diagonal del 1,1 al 3,3
		 */
		Nodo n1 = new Nodo(new Punto(1,1));
		Nodo n2 = new Nodo(new Punto(1,2));
		Nodo n3 = new Nodo(new Punto(1,3));
		Nodo n4 = new Nodo(new Punto(2,1));
		Nodo n5 = new Nodo(new Punto(2,2));
		Nodo n6 = new Nodo(new Punto(2,3));
		Nodo n7 = new Nodo(new Punto(3,1));
		Nodo n8 = new Nodo(new Punto(3,2));
		Nodo n9 = new Nodo(new Punto(3,3));

		n1.agregarConexion(n2);
		n1.agregarConexion(n4);
		n1.agregarConexion(n5);

		n2.agregarConexion(n1);
		n2.agregarConexion(n3);
		n2.agregarConexion(n4);
		n2.agregarConexion(n5);
		n2.agregarConexion(n6);

		n3.agregarConexion(n2);
		n3.agregarConexion(n5);
		n3.agregarConexion(n6);

		n4.agregarConexion(n1);
		n4.agregarConexion(n2);
		n4.agregarConexion(n5);
		n4.agregarConexion(n7);
		n4.agregarConexion(n8);

		n5.agregarConexion(n1);
		n5.agregarConexion(n2);
		n5.agregarConexion(n3);
		n5.agregarConexion(n4);
		n5.agregarConexion(n6);
		n5.agregarConexion(n7);
		n5.agregarConexion(n8);
		n5.agregarConexion(n9);


		n6.agregarConexion(n2);
		n6.agregarConexion(n3);
		n6.agregarConexion(n5);
		n6.agregarConexion(n8);
		n6.agregarConexion(n9);

		n7.agregarConexion(n4);
		n7.agregarConexion(n5);
		n7.agregarConexion(n8);

		n8.agregarConexion(n4);
		n8.agregarConexion(n7);
		n8.agregarConexion(n5);
		n8.agregarConexion(n6);
		n8.agregarConexion(n9);

		n9.agregarConexion(n5);
		n9.agregarConexion(n6);
		n9.agregarConexion(n8);


		AlgoritmoDelTacho p1 = new AlgoritmoDelTacho();

		p1.calcularDijkstra(n1, n9);
		
		ArrayList<Nodo> salidaEsperada = new ArrayList<Nodo>();
		salidaEsperada.add(new Nodo(new Punto(1,1)));
		salidaEsperada.add(new Nodo(new Punto(2,2)));
		salidaEsperada.add(new Nodo(new Punto(3,3)));
		Assert.assertTrue(compararListas(p1.getPredecesores(),salidaEsperada));
		

	}
	
	@Test
	public void caso11(){
		/**
		 * matriz en C
		 * deberia pasar por 1,1 - 1,2 - 2,3 - 3,2 - 3,3
		 */
		Nodo n1 = new Nodo(new Punto(1,1));
		Nodo n2 = new Nodo(new Punto(1,2));
		Nodo n3 = new Nodo(new Punto(1,3));
//		Nodo n4 = new Nodo(new Punto(2,1));
//		Nodo n5 = new Nodo(new Punto(2,2));
		Nodo n6 = new Nodo(new Punto(2,3));
		Nodo n7 = new Nodo(new Punto(3,1));
		Nodo n8 = new Nodo(new Punto(3,2));
		Nodo n9 = new Nodo(new Punto(3,3));

		n1.agregarConexion(n2);


		n2.agregarConexion(n1);
		n2.agregarConexion(n3);
		n2.agregarConexion(n6);

		n3.agregarConexion(n2);
		n3.agregarConexion(n6);


		n6.agregarConexion(n3);
		n6.agregarConexion(n8);
		n6.agregarConexion(n9);


		n7.agregarConexion(n8);

		n8.agregarConexion(n7);
		n8.agregarConexion(n6);
		n8.agregarConexion(n9);

		n9.agregarConexion(n6);
		n9.agregarConexion(n8);


		AlgoritmoDelTacho p1 = new AlgoritmoDelTacho();

		
		ArrayList<Nodo> salidaEsperada = new ArrayList<Nodo>();
		salidaEsperada.add(new Nodo(new Punto(1,1)));
		salidaEsperada.add(new Nodo(new Punto(1,2)));
		salidaEsperada.add(new Nodo(new Punto(2,3)));
		salidaEsperada.add(new Nodo(new Punto(3,2)));
		salidaEsperada.add(new Nodo(new Punto(3,3)));
		Assert.assertTrue(compararListas(p1.getPredecesores(),salidaEsperada));


	}
	
	@Test
	public void caso2(){
		/**
		 * Matriz en c invertida
		 */
		Nodo n1 = new Nodo(new Punto(1,1));
		Nodo n2 = new Nodo(new Punto(1,2));
		Nodo n3 = new Nodo(new Punto(1,3));
		Nodo n4 = new Nodo(new Punto(2,1));
//		Nodo n5 = new Nodo(new Punto(2,2));
//		Nodo n6 = new Nodo(new Punto(2,3));
		Nodo n7 = new Nodo(new Punto(3,1));
		Nodo n8 = new Nodo(new Punto(3,2));
		Nodo n9 = new Nodo(new Punto(3,3));
		
		n1.agregarConexion(n2);
		n1.agregarConexion(n4);

		n2.agregarConexion(n1);
		n2.agregarConexion(n3);
		n2.agregarConexion(n4);

		n3.agregarConexion(n2);

		n4.agregarConexion(n1);
		n4.agregarConexion(n2);
		n4.agregarConexion(n7);
		n4.agregarConexion(n8);


		n7.agregarConexion(n4);
		n7.agregarConexion(n8);

		n8.agregarConexion(n4);
		n8.agregarConexion(n7);
		n8.agregarConexion(n9);

		n9.agregarConexion(n8);


		AlgoritmoDelTacho p1 = new AlgoritmoDelTacho();

		p1.calcularDijkstra(n3, n9);

		
		ArrayList<Nodo> salidaEsperada = new ArrayList<Nodo>();
		salidaEsperada.add(new Nodo(new Punto(1,3)));
		salidaEsperada.add(new Nodo(new Punto(1,2)));
		salidaEsperada.add(new Nodo(new Punto(2,1)));
		salidaEsperada.add(new Nodo(new Punto(3,2)));
		salidaEsperada.add(new Nodo(new Punto(3,3)));
		Assert.assertTrue(compararListas(p1.getPredecesores(),salidaEsperada));
		
	}
	
	@Test
	public void casoMatriz5x5enS(){
		/**
		 * Matriz 5x5 en S (ver nodos eliminados)
		 * deberia empezar en 1,4 y terminar en 5,1
		 */
		Nodo n1 = new Nodo(new Punto(1,1));
		Nodo n2 = new Nodo(new Punto(1,2));
		Nodo n3 = new Nodo(new Punto(1,3));
		Nodo n4 = new Nodo(new Punto(1,4));
		Nodo n5 = new Nodo(new Punto(1,5));
		Nodo n6 = new Nodo(new Punto(2,1));
//		Nodo n7 = new Nodo(new Punto(2,2));
//		Nodo n8 = new Nodo(new Punto(2,3));
//		Nodo n9 = new Nodo(new Punto(2,4));
//		Nodo n10 = new Nodo(new Punto(2,5));
		Nodo n11 = new Nodo(new Punto(3,1));
		Nodo n12 = new Nodo(new Punto(3,2));
		Nodo n13 = new Nodo(new Punto(3,3));
		Nodo n14 = new Nodo(new Punto(3,4));
		Nodo n15 = new Nodo(new Punto(3,5));
//		Nodo n16 = new Nodo(new Punto(4,1));
//		Nodo n17 = new Nodo(new Punto(4,2));
//		Nodo n18 = new Nodo(new Punto(4,3));
//		Nodo n19 = new Nodo(new Punto(4,4));
		Nodo n20 = new Nodo(new Punto(4,5));
		Nodo n21 = new Nodo(new Punto(5,1));
		Nodo n22 = new Nodo(new Punto(5,2));
		Nodo n23 = new Nodo(new Punto(5,3));
		Nodo n24 = new Nodo(new Punto(5,4));
		Nodo n25 = new Nodo(new Punto(5,5));
		
		n1.agregarConexion(n2);
		n1.agregarConexion(n6);

		
		n2.agregarConexion(n1);
		n2.agregarConexion(n3);
		n2.agregarConexion(n6);

		
		
		n3.agregarConexion(n2);
		n3.agregarConexion(n4);
		
		
		n4.agregarConexion(n3);
		n4.agregarConexion(n5);
		
		n5.agregarConexion(n4);
		
		n6.agregarConexion(n1);
		n6.agregarConexion(n2);
		n6.agregarConexion(n11);
		n6.agregarConexion(n12);
		
		n11.agregarConexion(n6);
		n11.agregarConexion(n12);
		
		n12.agregarConexion(n6);
		n12.agregarConexion(n11);
		n12.agregarConexion(n13);
		
		n13.agregarConexion(n14);
		n13.agregarConexion(n12);
		
		n14.agregarConexion(n13);
		n14.agregarConexion(n15);
		n14.agregarConexion(n20);

		n15.agregarConexion(n14);
		n15.agregarConexion(n20);

		n20.agregarConexion(n14);
		n20.agregarConexion(n15);
		n20.agregarConexion(n24);
		n20.agregarConexion(n25);

		n25.agregarConexion(n24);
		n25.agregarConexion(n20);

		n24.agregarConexion(n20);
		n24.agregarConexion(n25);
		n24.agregarConexion(n23);

		n23.agregarConexion(n22);
		n23.agregarConexion(n24);
		
		n22.agregarConexion(n21);
		n22.agregarConexion(n23);

		n21.agregarConexion(n22);

		
		AlgoritmoDelTacho p1 = new AlgoritmoDelTacho();

		ArrayList<Nodo> salidaEsperada = new ArrayList<Nodo>();
		salidaEsperada.add(new Nodo(new Punto(1,5)));
		salidaEsperada.add(new Nodo(new Punto(1,4)));
		salidaEsperada.add(new Nodo(new Punto(1,3)));
		salidaEsperada.add(new Nodo(new Punto(1,2)));
		salidaEsperada.add(new Nodo(new Punto(2,1)));
		salidaEsperada.add(new Nodo(new Punto(3,2)));
		salidaEsperada.add(new Nodo(new Punto(3,3)));
		salidaEsperada.add(new Nodo(new Punto(3,4)));
		salidaEsperada.add(new Nodo(new Punto(4,5)));
		salidaEsperada.add(new Nodo(new Punto(5,4)));
		salidaEsperada.add(new Nodo(new Punto(5,3)));
		salidaEsperada.add(new Nodo(new Punto(5,2)));
		salidaEsperada.add(new Nodo(new Punto(5,1)));
		Assert.assertTrue(compararListas(p1.getPredecesores(),salidaEsperada));

	}
	

	public boolean compararListas(ArrayList<Nodo> lista1, ArrayList<Nodo> lista2){
		int i=0;
		while(i< lista1.size()){
			if(!lista1.get(i).getPunto().comparar(lista2.get(i).getPunto()))
				return false;
			i++;
		}
		
		return true;
	}
	
}
