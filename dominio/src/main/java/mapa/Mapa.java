package mapa;

import java.util.HashMap;
import java.util.Map;



import mensaje.MensajeMovimiento;
import personaje.Personaje;


public class Mapa {

	protected int alto;
	protected int ancho;
	protected String nombre;

	protected Map<String,Personaje> personajes;

	public Mapa(String nombre, int alto, int ancho) {
		
		this.nombre = nombre;
		this.ancho=ancho;
		this.alto=alto;
		this.personajes=new HashMap<String,Personaje>();
	}


	public void actualizar() {

	}
	
	public void agregarPersonaje(Personaje per, String nombre){
		personajes.put(nombre, per);
	}


}
