package mapa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import personaje.Personaje;


public class Mapa {

	private int alto;
	private int ancho;
	protected String nombre;
	private ArrayList<Personaje> personajes;
	private boolean[][] obstaculos;
	private int cantidadObstaculos;
	private int id;
	
	

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
		//	obstaculos[x][y] = true;
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
	 * No se si sera optimo pero lo que hago
	 * es comparar todos los obstaculos contra la ubicacion actual.
	 * devuelve true si hay un obstaculo en esa ubicacion.
	 * @param ubic
	 * @return
	 */
	/*private boolean hayObstaculo(Ubicacion ubic){ //boscar forma optima :C
		for (Obstaculo osta : obstaculos ) {
			if( osta.getUbicacion().comparar(ubic) )
				return true;
		}
		return false;
	}*/
	
	
	private boolean hayObstaculo(Ubicacion ubic) {
//		return obstaculos[ubic.getX()][ubic.getY()];
		return false;
	}
	

	public void agregarPersonaje(Personaje pj){
		personajes.add(pj);
	}

	public Personaje getPersonaje(int i) {
		return personajes.get(i);
	}

	public void actualizar() {
		
	}

}
