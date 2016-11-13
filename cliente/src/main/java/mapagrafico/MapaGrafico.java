	package mapagrafico;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;
import juego.Camara;
import juego.JuegoPanelTestBatalla;
import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Grafo;
import mapagrafico.dijkstra.MatrizBoolean;
import mapagrafico.dijkstra.Nodo;
import mensaje.MensajeMovimiento;
import personaje.Personaje;
import sprites.Sprite;


public class MapaGrafico {

	protected int id;
	protected int alto;
	protected int ancho;
	protected String nombre;


	// BUGERO
	protected int x;
	protected int y;

	protected boolean enMovimiento;


	protected String sprites;

	private static Image iluminacion;	
	private Tile[][] tiles;
	private TileObstaculo[][]  tilesObstaculo; 
	private boolean[][] obstaculos; 
	private TilePersonaje pj; // cliente
	private Map<String,Personaje> personajes; // esto server

	protected Camara cam;

	private int xDestino;
	private int yDestino;
	private int xAnterior;
	private int yAnterior;

	private Grafo grafoDeMapa;
	AlgoritmoDelTacho dijkstra;
	private List<Nodo> camino;
	private Nodo paso;
	private Nodo actual;
	private Nodo destino;

	
	public MapaGrafico(String nombre,TilePersonaje pj) {
		File path = new File("src\\main\\resources\\mapas\\"+nombre+".map");
		this.pj = pj;
		enMovimiento = false;
		xDestino = pj.getXDestino();
		yDestino = pj.getYDestino();
		xAnterior = -xDestino;
		yAnterior = -yDestino;
		dijkstra = new AlgoritmoDelTacho();
		this.nombre = nombre;

		Scanner sc = null;
		try {
			sc = new Scanner(path);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra el mapa "+nombre+".map\n Llamar al 0800-333-JUNIT\n"+e.toString());
			System.exit(0);
		}
		this.id = sc.nextInt();
		this.ancho=sc.nextInt();
		this.alto=sc.nextInt();
		this.sprites=sc.next();
		cargarSprite();

		this.tiles = new Tile[ancho][alto];
		this.tilesObstaculo  = new TileObstaculo[ancho][alto];
		this.obstaculos = new boolean[ancho][alto];
		/**
		 * no hace falta pero para que se entienda
		 */
		int sprite;
		for (int i = 0; i < ancho ; i++) {
			for (int j = 0; j < alto; j++) {
				sprite = sc.nextInt();
				tiles[i][j] = new Tile(i,j,sprite);
			}
		}
		int obstaculo;
		for (int i = 0; i < ancho ; i++) {
			for (int j = 0; j < alto; j++) {
				obstaculo = sc.nextInt();
				obstaculos[i][j] = obstaculo>=1?true:false;
				tilesObstaculo[i][j] = new TileObstaculo(i,j,obstaculo);
			}
		}

		sc.close();
		grafoDeMapa = new Grafo( new MatrizBoolean(obstaculos, ancho, alto) );
		camino = new LinkedList<Nodo>();
		this.personajes=new HashMap<String,Personaje>();
	}


	private void cargarSprite() {
		load(sprites);
		
		//debo cargar al pj aca tambien ( las animaciones).
		//Despues tendria que validar que encuentre el todo.
		/*
		if ( sprites.equals("exterior") ) 
			load("exterior");
		else if( sprites.equals("test"))
			load("test");
		else
			System.exit(1);
		 */
	}

	public boolean EnMovimiento() {
		return enMovimiento;
	}

	/**
	 * cambiar por hoja:
	 * @param nombre
	 */
	private void load(String nombre) {
		String recursos = "src\\main\\resources\\";
		Sprite.inicializar(recursos+"mapas\\"+nombre+"\\piso.png",recursos+"personajes\\pelado.png");
		iluminacion = Sprite.loadImage("src\\main\\resources\\mapas\\99.png");
	}

	public boolean posicionValida(int x, int y){
		return dentroDelMapa(-pj.getXDestino(),-pj.getYDestino()) && ! hayObstaculo(-pj.getXDestino(),-pj.getYDestino());
	}

	public boolean hayObstaculo(int x,int y){
		return obstaculos[x][y];
	}

	private boolean dentroDelMapa(int x, int y) {
		return x>=0 && y>=0 && x<alto && y<ancho;
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
		if( pj.getNuevoRecorrido() && posicionValida(-pj.getXDestino(),-pj.getYDestino()) )	{
			dijkstra = new AlgoritmoDelTacho();
			actual = grafoDeMapa.getNodo(-xDestino, -yDestino);
			destino =  grafoDeMapa.getNodo(-pj.getXDestino(), -pj.getYDestino());			
			dijkstra.calcularDijkstra(grafoDeMapa, actual,destino);
			camino = dijkstra.obtenerCamino(destino);
			pj.setNuevoRecorrido(false);
		}

		if( !pj.enMovimiento() && camino != null && ! camino.isEmpty() ){
			moverUnPaso();
			/**
			 * 
			 *  Aca Braian,  se cambia el destino (osea el punto donde me dirigo)
			 *  No utilizo la clase punto porque me parece poco optimo llamarla 60 por segundo pero se puede construir aca y mandar 
			 *  esto no se va a ejecutar siempre,s olo cuando me estoy realmente moviendo.
			 *  
			 * 
			 */		
			pj.paraDondeVoy(xDestino, yDestino);
			pj.mover(xDestino,yDestino);	
		}
		
		if(	camino == null || camino.isEmpty()  ) //Fijarse para que pare justo cuando termina de dibujar.
			pj.parar();	
			
		
			
	}

	private void moverUnPaso() { // Esto tengo que ver, pero lo que hace es mover paso a paso por el camino del DI kjsoihyoas TRAMMMMMMMMMMM
		paso = camino.get(0);
		
		xAnterior = -xDestino;
		yAnterior = -yDestino;
	
		xDestino = -paso.getPunto().getX();
		yDestino = -paso.getPunto().getY();
		
		camino.remove(0);

	}


	/**
	 * tengo que buscar la forma de dibujar solo la pantalla.
	 *
	 * 			      (0,0)
	 * 			 (0,1)(1,1)(1,0)
	 *		(0,2)(1,2)(2,2)(2,1)(2,0)
	 */
	public void dibujar(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].dibujar(g2d,xDestino+JuegoPanelTestBatalla.xOffCamara,yDestino+JuegoPanelTestBatalla.yOffCamara);
				if( puedoDibujarPJ(g2d, i, j))
					pj.dibujarCentro(g2d);

				if( puedoDibujarObstaculo(i, j)  ){
					tilesObstaculo[i][j].dibujar(g2d,xDestino+ JuegoPanelTestBatalla.xOffCamara,yDestino+JuegoPanelTestBatalla.yOffCamara);
				}
			}
		}
	}

	public void mover(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		

		//Tiene que ser uno por uno entonces si cancelo termino el movimiento (sino se descuajaina todo).
		x = tiles[0][0].getXIso(); // puedo agarrar el centro. pero por ahora asi.
		y = tiles[0][0].getYIso();
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].mover(g2d,xDestino + JuegoPanelTestBatalla.xOffCamara,yDestino+JuegoPanelTestBatalla.yOffCamara);
				if( puedoDibujarPJ(g2d, i, j))
					pj.dibujarCentro(g2d);
				if( puedoDibujarObstaculo(i, j)  )
					tilesObstaculo[i][j].mover(g2d,xDestino+ JuegoPanelTestBatalla.xOffCamara,yDestino+JuegoPanelTestBatalla.yOffCamara);
			}
		}
		g2d.drawImage( iluminacion, 0, 0 , null);	
		termino();
	}


	private boolean puedoDibujarObstaculo(int i, int j) {
		return tilesObstaculo[i][j].sprite > 1; // Si es 0 no dibujo y si es uno TAMPOCO, porque seria un obstaculo trasparente.
	}

	private boolean puedoDibujarPJ(Graphics2D g2d, int i, int j) {
		return  i == -xDestino && j == -yDestino || i == xAnterior &&  j == yAnterior || i == -xDestino && j == yAnterior ||  i == xAnterior && j == -yDestino;
	}  
	/**
	 * Estrambolico, avisa cuando termino de moverse el personaje. deberia camiarlo ya que utiliza los tiles Graficos.
	 */
	private void termino() {
		if ( x == tiles[0][0].getXIso() && y == tiles[0][0].getYIso() )
			pj.setEnMovimiento(false);
		else 
			pj.setEnMovimiento(true);
;
	}
}
