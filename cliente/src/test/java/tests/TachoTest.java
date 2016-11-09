package tests;

import mapa.Punto;
import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Nodo;

import org.junit.Test;

public class TachoTest {
	@Test
	public void caso1(){
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
		
		for(Nodo nodo : p1.getPredecesores()){
			//System.out.println(nodo);
		}

	}
	
	@Test
	public void caso2(){
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
		
		for(Nodo nodo : p1.getPredecesores()){
			System.out.println(nodo);
		}
		
	}
}
