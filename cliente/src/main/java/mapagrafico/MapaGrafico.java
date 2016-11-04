package mapagrafico;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.ImageIcon;
import mapa.Punto;
import mensaje.MensajeMovimiento;
import personaje.Personaje;


public class MapaGrafico {

	private static Image[] spriteMapa;	
	protected int alto;
	protected int ancho;
	protected String nombre;
	protected String sprites;
	protected Tile[][] tiles;
	protected Map<String,Personaje> personajes;
	protected int id;


	public MapaGrafico(String nombre) {
		spriteMapa = new Image[6];
		this.nombre = nombre;
		File path = new File("src\\main\\resources\\mapas\\"+nombre+".txt");

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
		this.sprites=sc.next();
		cargarSprite();
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
		this.personajes=new HashMap<String,Personaje>();
	}

	private void cargarSprite() {
		if ( sprites.equals("exterior") ) 
			load("exterior");
		else if( sprites.equals("test"))
			load("test");
		else
			System.exit(1);
	}


	/**
	 * Aca alex tiene que hacer la hoja de sprite y ir cortandola.
	 * lo que yo pense (que ya esta casi echo)
	 * es tener una carpeta (o unos sprites) con distintos nombres para 
	 * distintos mapas.
	 * por ejemplo:
	 * exterior va a hacer un a hoja de sprite con todo los sprite del exterior
	 * 
	 * pero si el mapa tiene la palabra castillo.
	 * va a cargar la hoja de sprite de castillo.
	 * 
	 * pero como dije necesitamos los sprite y a alex que haga el corte
	 * si no lo dejamos como esta :D
	 * @param nombre
	 */
	private void load(String nombre) {
		spriteMapa[0] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\00.png");
		spriteMapa[1] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\01.png");
		spriteMapa[2] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\02.png");
		spriteMapa[3] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\03.png");
		spriteMapa[4] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\04.png");
		spriteMapa[5] = loadImage("src\\main\\resources\\mapas\\"+nombre+"\\05.png");
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
	public boolean posicionValida(Punto ubic){
		if(dentroDelMapa(ubic) && !hayObstaculo(ubic))
			return true;
		return false;

	}
	private boolean dentroDelMapa(Punto ubic) {
		return ubic.getX()>=0 && ubic.getY()>=0 && ubic.getX()<alto && ubic.getY()<ancho;
	}

	private boolean hayObstaculo(Punto ubic) {
		return tiles[ubic.getX()][ubic.getY()].getObstaculo();
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

	/**
	 * tengo que buscar la forma de dibujar solo la pantalla.
	 * 
	 * 			      (0,0)
	 * 			 (0,1)(1,1)(1,0)
	 *		(0,2)(1,2)(2,2)(2,1)(2,0)
	 *
	 */
	public void dibujar(Graphics2D g2d,int x,int y) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].dibujar(g2d,x,y);
			}
		}

	}

	public void mover(Graphics2D g2d,int x,int y) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].mover(g2d,x,y);
			}
		}

	}


}
