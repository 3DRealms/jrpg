package mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.List;

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
		String aux = "Nodo" + pos + ": ";
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

	public Nodo clone2() {
		Nodo nodo = new Nodo(this.getPunto());
		nodo.nodosAdyacentes.addAll(this.nodosAdyacentes);
		return nodo;
	}

	public boolean equals(Nodo n2) {

		if (this.getPunto().equals(n2.getPunto()))
			return true;

		return false;
	}

	public Nodo obtenerMenorAdyacente(Nodo destino, ArrayList<Nodo> predecesores) {

		if (this.nodosAdyacentes.isEmpty())
			return this;

		double i = 0;
		Nodo aux = this.clone();
		for(Nodo nodo: this.nodosAdyacentes){
			if (!predecesores.contains(nodo)) {
				i = nodo.calcularDistanciaNodos(destino);
				aux = nodo.clone();
			}
		}
		
		for (Nodo nodo : this.nodosAdyacentes) {
			if (!predecesores.contains(nodo)) {
				double x = nodo.calcularDistanciaNodos(destino);
				if (x <= i && !predecesores.contains(nodo)) {
					aux = nodo;
					i=x;
				}
			}
		}

		return aux;
	}
	



}
