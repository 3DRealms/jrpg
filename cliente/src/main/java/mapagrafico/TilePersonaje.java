package mapagrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import juego.JuegoPanelTestBatalla;
import juego.Mouse;
import mapa.Punto;
import personaje.Personaje;
import sprites.Animacion;
import sprites.Sprite;

public class TilePersonaje {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private static Image spritePJ;
	public final int xCentro;
	public final int yCentro;
	private String nombre;
	private Mouse mouse;
	// Posiciones
	Personaje pj;
	private int xInicio;
	private int yInicio;
	private int xDestino;
	private int yDestino;
	// Movimiento Actual
	private boolean nuevoRecorrido;


	private boolean horizontal;
	private boolean vertical;
	
	
	private boolean movDerecha;
	private boolean movAbajoIzquierda;
	private boolean movArribaDerecha;
	private boolean movArribaIzquierda;
	private boolean movAbajoDerecha;
	private boolean movArriba;
	private boolean movAbajo;
	private boolean movIzquierda;
	private boolean enMovimiento;
	private boolean parado;

	protected Animacion animAbajo;
	protected Animacion animArriba;
	protected Animacion animDerecha;
	protected Animacion animIzquierda;
	protected Animacion animAbajoIzquierda;
	protected Animacion animArribaIzquierda;
	protected Animacion animAbajoDerecha;
	protected Animacion animArribaDerecha;




	public TilePersonaje(Punto p,Personaje pj,Mouse mouse) {
		this.xCentro = 320;
		this.yCentro = 320;
		//this.sprite = sprite;
		this.pj = pj;
		this.nombre = pj.getNombre();	
		this.xInicio = this.xDestino = -p.getX();  //alta logica wachin.
		this.yInicio = this.yDestino =  -p.getY(); 
		this.mouse = mouse;
		//Aca va la raza
		spritePJ = Sprite.loadImage("src\\main\\resources\\personajes\\"+pj.getSprite()+".png");
		inicializarAnimaciones();
		this.nuevoRecorrido = false; // NO BORRAR.
		// baicamente como le sumo (16,6) para que coicida con el 0,0 del mapa.

	}


	/**
	 * Ver si le mando las coordenadas donde  esto al personaje.
	 * @param g2d
	 * @param deltaX
	 * @param deltaY
	 */
	public void dibujarCentro(Graphics g) {  // Aca puedo dibujar el HUD.
		g.drawImage( obtenerFrameActual() ,xCentro, yCentro, null);
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.GREEN);
		g.setFont(fuente);
		g.drawString(nombre, xCentro+10, yCentro);

	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();
		
		actualizarAnimaciones();
		
		if (mouse.getRecorrido()) {
			setNuevoRecorrido(true);
			xDestino = xInicio - posMouse[0] + JuegoPanelTestBatalla.xOffCamara;
			yDestino = yInicio - posMouse[1] + JuegoPanelTestBatalla.yOffCamara;
			mouse.setRecorrido(false); 
		}

	}


	/**
	 * Por un extraño motivo dan negativas :c
	 * @return
	 */
	public int getXDestino() {
		return xDestino;
	}

	public int getYDestino() {
		return yDestino;
	}

	public void mover(int xDestino2, int yDestino2) {
		xInicio = xDestino2;  
		yInicio = yDestino2;

	}
	
	public void inicializarAnimaciones() {
		animAbajo = new Animacion(150, Sprite.pjAbajo);
		animArriba = new Animacion(150, Sprite.pjArriba);
		animDerecha = new Animacion(150, Sprite.pjDerecha);
		animIzquierda = new Animacion(150, Sprite.pjIzquierda);
		animAbajoIzquierda = new Animacion(150, Sprite.pjAbajoIzquierda);
		animArribaIzquierda = new Animacion(150, Sprite.pjArribaIzquierda);
		animAbajoDerecha = new Animacion(150, Sprite.pjAbajoDerecha);
		animArribaDerecha = new Animacion(150, Sprite.pjArribaDerecha);
	}
	
	public void actualizarAnimaciones() {

		animArriba.actualizar();
		animAbajo.actualizar();
		animIzquierda.actualizar();
		animDerecha.actualizar();
		animAbajoIzquierda.actualizar();
		animArribaIzquierda.actualizar();
		animAbajoDerecha.actualizar();
		animArribaDerecha.actualizar();
	}

	// Esto lo podria resolver con un 1 byte en c++ ¬¬
	public void paraDondeVoy(int xDestino2, int yDestino2) {
		movAbajoIzquierda = false;
		movArribaDerecha = false;
		movArribaIzquierda = false;
		movAbajoDerecha = false;
		movArriba = false;
		movDerecha = false;
		movAbajo = false;
		movIzquierda = false;
		parado = false;
		
		//faltaria parado, estaba rancia
		/**
		 * Dani, me tiraste cualquier cosa en los nombres, nada se movia para los
		 * lados que decia -.-
		 * Se ya se me di cuenta, pero esta la estructura loco :v
		 */
		if (xInicio == xDestino2 && yInicio == yDestino2) { // sureste
			parado = true;
			return; 
		}
			
		if (xInicio > xDestino2 && yInicio == yDestino2) { // sureste
			movAbajoDerecha = true;
			return;
		}
		if (xInicio < xDestino2 && yInicio == yDestino2) {// noroeste
			movArribaIzquierda = true;
			return;
		}
		if (xInicio == xDestino2 && yInicio < yDestino2) {// noreste
			movArribaDerecha = true;
			return;
		}
		if (xInicio == xDestino2 && yInicio > yDestino2) {// suroeste
			movAbajoIzquierda = true;
			return;
		}
		if (xInicio < xDestino2 && yInicio < yDestino2) {// norte
			movArriba = true;
			return;
		}
		if (xInicio > xDestino2 && yInicio < yDestino2) {// este
			movDerecha = true;
			return;
		}
		if (xInicio > xDestino2 && yInicio > yDestino2) {// sur
			movAbajo = true;
			return;
		}
		if (xInicio < xDestino2 && yInicio > yDestino2) {// oeste
			movIzquierda = true;
			return;
		}

	}
	
	public BufferedImage obtenerFrameActual() {

		if (movAbajo)
			return animAbajo.getFrameActual();
		else if (movArriba)
			return animArriba.getFrameActual();
		else if (movDerecha)
			return animDerecha.getFrameActual();
		else if (movIzquierda)
			return animIzquierda.getFrameActual();
		else if (movArribaDerecha)
			return this.animArribaDerecha.getFrameActual();
		else if (this.movAbajoDerecha)
			return this.animAbajoDerecha.getFrameActual();
		else if (this.movArribaIzquierda)
			return this.animArribaIzquierda.getFrameActual();
		else if (this.movAbajoIzquierda)
			return this.animAbajoIzquierda.getFrameActual();


		return Sprite.pjAbajo[0];
	}


	public void setNuevoRecorrido(boolean bs){
		this.nuevoRecorrido = bs;
	}

	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;	
	}


	public boolean enMovimiento() {
		return enMovimiento;
	}


	public void setEnMovimiento(boolean b) {
		this.enMovimiento = b;
	}
	public boolean isHorizontal() {
		return horizontal;
	}


	public void parar() {
		movAbajoIzquierda = false;
		movArribaDerecha = false;
		movArribaIzquierda = false;
		movAbajoDerecha = false;
		movArriba = false;
		movDerecha = false;
		movAbajo = false;
		movIzquierda = false;
		parado = false;
		parado = true;
	}




}
