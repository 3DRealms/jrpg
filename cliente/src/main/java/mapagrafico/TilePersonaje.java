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


	private int movimiento;
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
	private int movimientoAnterior;




	public TilePersonaje(Punto p,Personaje pj,Mouse mouse) {
		this.xCentro = 320;
		this.yCentro = 320;
		//this.sprite = sprite;

		movimiento = 0;

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
		movimiento = 0;
		parado = false;

		//faltaria parado, estaba rancia
		/**
		 * Dani, me tiraste cualquier cosa en los nombres, nada se movia para los
		 * lados que decia -.-
		 * Se ya se me di cuenta, pero esta la estructura loco :v
		 */
		if (xInicio == xDestino2 && yInicio == yDestino2) { // parado
			parado = true;
			return; 
		}

		if (xInicio > xDestino2 && yInicio == yDestino2) { // sureste 
			movimiento = 1;
			return;
		}
		if (xInicio < xDestino2 && yInicio == yDestino2) {// noroeste
			movimiento = 2;
			return;
		}
		if (xInicio == xDestino2 && yInicio < yDestino2) {// noreste
			movimiento = 3;
			return;
		}
		if (xInicio == xDestino2 && yInicio > yDestino2) {// suroeste

			movimiento = 4;
			return;
		}
		if (xInicio < xDestino2 && yInicio < yDestino2) {// norte
			movimiento = 5;
			return;
		}
		if (xInicio > xDestino2 && yInicio < yDestino2) {// este se bugea 
			movimiento = 6;
			return;
		}
		if (xInicio > xDestino2 && yInicio > yDestino2) {// sur
			movimiento = 7;
			return;
		}
		if (xInicio < xDestino2 && yInicio > yDestino2) {// oeste
			movimiento = 8;
			return;
		}

	}

	public BufferedImage obtenerFrameActual() {
		if (movimiento == 7 && !parado)
			return animAbajo.getFrameActual();
		if (movimiento == 5 && !parado)
			return animArriba.getFrameActual();
		if (movimiento == 6 && !parado)
			return animDerecha.getFrameActual();
		if (movimiento == 8 && !parado)
			return animIzquierda.getFrameActual();
		if (movimiento == 3 && !parado)
			return this.animArribaDerecha.getFrameActual();
		if (movimiento == 1 && !parado)
			return this.animAbajoDerecha.getFrameActual();
		if (movimiento == 2 && !parado)
			return this.animArribaIzquierda.getFrameActual();
		if (movimiento == 4 && !parado)
			return this.animAbajoIzquierda.getFrameActual();
		
		if (movimientoAnterior == 7)
			return Sprite.pjAbajo[0];
		if (movimientoAnterior == 5)
			return Sprite.pjArriba[0];
		if (movimientoAnterior == 6)
			return Sprite.pjDerecha[0];
		if (movimientoAnterior == 8)
			return Sprite.pjIzquierda[0];
		if (movimientoAnterior == 3)
			return Sprite.pjArribaDerecha[0];
		if (movimientoAnterior == 1)
			return Sprite.pjAbajoDerecha[0];
		if (movimientoAnterior == 2)
			return Sprite.pjArribaIzquierda[0];
		if (movimientoAnterior == 4)
			return Sprite.pjAbajoIzquierda[0];


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

	public void parar() {
		movimientoAnterior = movimiento;
	//	movimiento = 0;
		parado = true;
	}




}
