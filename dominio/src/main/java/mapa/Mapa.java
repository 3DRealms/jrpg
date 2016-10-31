package mapa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import personaje.Personaje;


public class Mapa {

	private static final int TILE_ANCHO = 32;
	private static final int TILE_ALTO = 32;
	
	private final int alto;
	private final int ancho;
	
	protected final String nombre;
	private final boolean[][] obstaculos;
	private final int cantidadObstaculos;
	private final int id;
	
	private ArrayList<Personaje> personajes;
	

	public Mapa(File path) throws FileNotFoundException{
		
		Scanner sc = new Scanner(path);
		this.id = sc.nextInt();
		this.ancho=sc.nextInt();
		this.alto=sc.nextInt();
		this.nombre=sc.nextLine();
		this.cantidadObstaculos = sc.nextInt();
		this.obstaculos = new boolean[ancho][alto];
		//this.obstaculos=new ArrayList<Obstaculo>( cantidadObstaculos );
		int x;
		int y;
		for (int i = 0; i < cantidadObstaculos ; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			obstaculos[x][y] = true;
		}
		
		sc.close();
		
		this.personajes=new ArrayList<Personaje>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean posicionValida(Ubicacion ubic){
		if(dentroDelMapa(ubic) && !hayObstaculo(ubic))
			return true;
		return false;
	}
	
	private boolean dentroDelMapa(Ubicacion ubic) {
		return ubic.getX()>=0 && ubic.getY()>=0 && ubic.getX()<alto && ubic.getY()<ancho;
	}
		
	/**
	 * Obtengo si hay un ostaculo en ese punto.
	 * @param ubic
	 * @return
	 */
	private boolean hayObstaculo(Ubicacion ubic) {
		return obstaculos[ubic.getX()][ubic.getY()];
	}
	

	public void agregarPersonaje(Personaje pj){
		personajes.add(pj);
	}

	public Personaje getPersonaje(int i) {
		return personajes.get(i);
	}
	
	/**
	 * Pasar datos de la camara par ano dibujar de mas.
	 */
	public void dibujar(){
		
	}
	public void actualizar() {
	}
	
	

}
