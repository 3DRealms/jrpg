package mapa;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.ImageIcon;


import mensaje.MensajeMovimiento;
import personaje.Personaje;


public class Mapa {

	protected int alto;
	protected int ancho;
	protected String nombre;

	protected Map<String,Personaje> personajes;
	protected int id;


	public Mapa(String nombre, int id, int alto, int ancho) {
		this.nombre = nombre;
		this.id = id;
		this.ancho=ancho;;
		this.alto=alto;

		this.personajes=new HashMap<String,Personaje>();
	}



	public int getId() {
		return this.id;
	}
	public boolean posicionValida(Punto ubic){
		if(dentroDelMapa(ubic) && !hayObstaculo(ubic))
			return true;
		return false;

	}
	private boolean dentroDelMapa(Punto ubic) {
		return ubic.getX()>=0 && ubic.getY()>=0 && ubic.getX()<alto && ubic.getY()<ancho;
	}

	private boolean hayObstaculo(Punto ubic) {
		//return tiles[ubic.getX()][ubic.getY()].getObstaculo();
		return false;
	}

	public void agregarPersonaje(Personaje pj){
		personajes.put(pj.getNombre(), pj);
	}
	
	public boolean recibirMensajeMovmiento(MensajeMovimiento men){
		Personaje aMover = personajes.get(men.getEmisor());
		
		if(aMover.isPuedoMoverme()){
			aMover.setUbicacion(men.getPos());
			return true;
		}
		return false;
	}

	public Personaje getPersonaje(String per) {
		return personajes.get(per);
	}

	public void actualizar() {

	}


}
