package mapa;

import java.util.ArrayList;

import personaje.Personaje;
public class Mapa {
	private int largo;
	private int ancho;
	protected String descripcion;
	private ArrayList<Personaje> personajes;
	@SuppressWarnings("unused")
	private ArrayList<Obstaculo> ostaculos;

	public Mapa(int largo, int ancho,String descripcion){
		this.largo=largo;
		this.ancho=ancho;
		this.descripcion=descripcion;
		personajes=new ArrayList<Personaje>();
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
		// ver si no coliciona con un obstaculo;
		return false;
	}

	public void agregarPersonaje(Personaje pj){
		personajes.add(pj);
	}


}
