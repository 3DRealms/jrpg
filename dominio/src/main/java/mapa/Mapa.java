package mapa;

import java.util.ArrayList;

import personaje.Personaje;
public class Mapa {
	private int largo;
	private int ancho;
	protected String descripcion;
	private ArrayList<Personaje> personajes;
	private ArrayList<Obstaculo> ostaculos;

	public Mapa(int largo, int ancho,String descripcion){
		this.largo=largo;
		this.ancho=ancho;
		this.descripcion=descripcion;
		personajes=new ArrayList<Personaje>();
		ostaculos=new ArrayList<Obstaculo>();
	}
	
	public boolean posicionValida(Ubicacion ubic){
		if(dentroDelMapa(ubic) && !hayObstaculo(ubic))
			return true;
		return false;

	}
	private boolean dentroDelMapa(Ubicacion ubic) {
		return ubic.getX()>=0 && ubic.getY()>=0 && ubic.getX()<=largo && ubic.getY()<=ancho;
	}
	private boolean hayObstaculo(Ubicacion ubic) {
		double distancia;
		for (Obstaculo osta : ostaculos ) {
			distancia = ubic.calcularDistancia(osta.getUbicacion());
			if( casiCero(distancia) )
				return true;
		}
		return false;
	}

	private boolean casiCero(double distancia) {
		return Math.abs(distancia) < 0.01;
	}

	public void agregarPersonaje(Personaje pj){
		personajes.add(pj);
	}


}
