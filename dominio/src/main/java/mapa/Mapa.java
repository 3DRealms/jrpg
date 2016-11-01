package mapa;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import personaje.Personaje;


public class Mapa {
	private final static File map1 = new File("src\\main\\resources\\mapas\\map1.txt");
	private static Image[] spriteMapa = new Image[2];	

	protected int alto;
	protected int ancho;
	protected String nombre;
	protected Tile[][] tiles;
	protected ArrayList<Personaje> personajes;
	protected int id;


	public Mapa(String nombre) {
		this.nombre = nombre;
		File path = cargarMap();

		Scanner sc = null;
		try {
			sc = new Scanner(path);
		} catch (FileNotFoundException e) {
			// no se encutra el mapa -nombre-
			e.printStackTrace();
		}
		this.id = sc.nextInt();
		this.ancho=sc.nextInt();
		this.alto=sc.nextInt();
		this.nombre=sc.nextLine();
		this.tiles = new Tile[ancho][alto];
		/**
		 * no hace falta pero para que se entienda
		 */
		int sprite;
		//	boolean obs;
		for (int i = 0; i < ancho ; i++) {
			for (int j = 0; j < alto; j++) {
				sprite = sc.nextInt();
				tiles[i][j] = new Tile(i,j,sprite);
			}
		}
		sc.close();
		this.personajes=new ArrayList<Personaje>();
	}

	private File cargarMap() {
		if ( nombre.equals("map1") ) {
			load("map1");
			return  map1;
		}
		return null;
	}

	private void load(String nombre) {
		spriteMapa[0] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\pasto.png");
		spriteMapa[1] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\arbol.png");
	}

	public static Image loadImage(String path) {
		ImageIcon i = new ImageIcon(path);
		return i.getImage();
	}
	public static Image getImage(int sprite) {
		return spriteMapa[sprite];
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

	private boolean hayObstaculo(Ubicacion ubic) {
		return tiles[ubic.getX()][ubic.getY()].getObstaculo();
	}

	public void agregarPersonaje(Personaje pj){
		personajes.add(pj);
	}

	public Personaje getPersonaje(int i) {
		return personajes.get(i);
	}

	public void actualizar() {

	}

	public void dibujar(Graphics2D g2d) {

		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < ancho; j++) {
				tiles[i][j].dibujar(g2d);
			}}

	}
}
