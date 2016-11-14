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
	protected Map<String,Punto> moviendoA;

	public Mapa(String nombre, int alto, int ancho) {
		this.nombre = nombre;
		this.ancho=ancho;
		this.alto=alto;
		this.personajes=new HashMap<String,Personaje>();
		this.moviendoA = new HashMap<String,Punto>();

	}


	public void actualizar() {

	}
	
	public void agregarPersonaje(Personaje per, String nombre){
		personajes.put(nombre, per);
		moviendoA.put(nombre, per.getUbicacion());
	}
	
	public void moverPersonaje(Personaje per, Punto point){
		moviendoA.put(per.getNombre(), point);
	}
	
	public void detenerPersonaje(Personaje per){
		per.setUbicacion(moviendoA.get(per.getNombre()));		
	}
	
	public Map<String,Personaje> obtenerPersonajes(){
		return personajes;
	}


	public static void enviarUbicacionDestino(Punto punto) {
		
	}


	public static void enviarQueLlegue() {
		
	}


}
