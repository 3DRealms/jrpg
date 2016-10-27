package mapa;

import java.util.ArrayList;

import interfaces.Ubicable;
import personaje.Personaje;
public class MapaExploracion {
	private int largo;
	private int ancho;
	protected String descripcion;
	private ArrayList<Personaje> personajes;

	public MapaExploracion(int largo, int ancho,String descripcion){
		this.largo=largo;
		this.ancho=ancho;
		this.descripcion=descripcion;
		personajes=new ArrayList<Personaje>();
	}
	
	public boolean posicionValida(Ubicable obj) {
		//return punto.getX()>=0 && obj.getY()>=0 && obj.getX()<largo && obj.getY()<ancho;
		return obj.
	}
	public void agregarPersonaje(Personaje pj){
		personajes.add(pj);
	}


}
