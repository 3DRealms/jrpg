package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.List;

import mapagrafico.dijkstra.Nodo;
import mapa.Punto;

/**
 * Para mi todos el paso de nodo a nodo es de 1 siempre.
 * 
 * @author Danie
 */
public class Nodo {
	private Punto pos;
	List<Nodo> nodosAdyacentes;

	// esto capaz vuele.
	public Nodo(final Punto pos) {
		this.pos = pos;
		nodosAdyacentes = new ArrayList<>();
	}


	public Punto getPunto() {
		return pos;
	}

	public void setPos(Punto pos) {
		this.pos = pos;
	}

	public void agregarConexion(Nodo pepe) {
		nodosAdyacentes.add(pepe);
	}

	public void agregarConexionPunto(Punto pepe) {
		nodosAdyacentes.add(new Nodo(pepe));
	}

	public double calcularDistanciaNodos(Nodo n2) {
		return this.getPunto().calcularDistancia(n2.getPunto());
	}

	@Override
	public String toString() {
		String aux = pos+": ";
		for (Nodo nodo : nodosAdyacentes)
			aux += nodo.pos.toString() + " ";
		return aux;
	}

	public Nodo clone() {
		Nodo n2 = new Nodo(this.getPunto());
		n2.nodosAdyacentes = new ArrayList<>();

		for (Nodo nodo : this.nodosAdyacentes) {
			n2.agregarConexion(nodo);
		}
		return n2;
	}



	public boolean equals(Nodo n2) {

		if (this.getPunto().equals(n2.getPunto()))
			return true;

		return false;
	}


	
	public boolean esAdyacente(Nodo n2){
		
		if(this.nodosAdyacentes.contains(n2))
			return true;
		
		if(n2.nodosAdyacentes.contains(this))
			return true;
		
		return false;
	}

	public int getPeso(Nodo vecino) {
		if( noEsDiagonal(vecino) )
			return 2;
		return 3;
	}

	private boolean noEsDiagonal(Nodo vecino) {
		return this.getPunto().getX() == vecino.getPunto().getX() || this.getPunto().getY() == vecino.getPunto().getY() ;
	}
	


}
