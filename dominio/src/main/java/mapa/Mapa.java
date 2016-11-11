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
	protected int id;


	public Mapa(String nombre, int id, int alto, int ancho) {
		this.nombre = nombre;
		this.id = id;
		this.ancho=ancho;
		this.alto=alto;
		this.personajes=new HashMap<String,Personaje>();
	}


	public void actualizar() {

	}


}
