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
		
		n1.agregarConexion(n2.getPunto());
		n1.agregarConexion(n4.getPunto());
		n1.agregarConexion(n5.getPunto());
		
		n2.agregarConexion(n1.getPunto());
		n2.agregarConexion(n3.getPunto());
		n2.agregarConexion(n4.getPunto());
		n2.agregarConexion(n5.getPunto());
		n2.agregarConexion(n6.getPunto());
		
		n3.agregarConexion(n2.getPunto());
		n3.agregarConexion(n5.getPunto());
		n3.agregarConexion(n6.getPunto());
		
		n4.agregarConexion(n1.getPunto());
		n4.agregarConexion(n2.getPunto());
		n4.agregarConexion(n5.getPunto());
		n4.agregarConexion(n7.getPunto());
		n4.agregarConexion(n8.getPunto());
		
		n5.agregarConexion(n1.getPunto());
		n5.agregarConexion(n2.getPunto());
		n5.agregarConexion(n3.getPunto());
		n5.agregarConexion(n4.getPunto());
		n5.agregarConexion(n6.getPunto());
		n5.agregarConexion(n7.getPunto());
		n5.agregarConexion(n8.getPunto());
		n5.agregarConexion(n9.getPunto());
		
		
		n6.agregarConexion(n2.getPunto());
		n6.agregarConexion(n3.getPunto());
		n6.agregarConexion(n5.getPunto());
		n6.agregarConexion(n8.getPunto());
		n6.agregarConexion(n9.getPunto());
		
		n7.agregarConexion(n4.getPunto());
		n7.agregarConexion(n5.getPunto());
		n7.agregarConexion(n8.getPunto());
		
		n8.agregarConexion(n4.getPunto());
		n8.agregarConexion(n7.getPunto());
		n8.agregarConexion(n5.getPunto());
		n8.agregarConexion(n6.getPunto());
		n8.agregarConexion(n9.getPunto());
		
		n9.agregarConexion(n5.getPunto());
		n9.agregarConexion(n6.getPunto());
		n9.agregarConexion(n8.getPunto());
		
		AlgoritmoDelTacho p1 = new AlgoritmoDelTacho();
		
		p1.calcularDijkstra(n1, n9);
		
		
		
		
	}
}
