package mapagrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import juego.Camara;
import juego.Mouse;
import mapa.Punto;
import personaje.Personaje;
import sprites.Animacion;
import sprites.Sprite;

public class TilePersonaje {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private final int xCentro;
	private final int yCentro;
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
	private Camara camara;

	private int movimiento;
	private boolean enMovimiento;
	private boolean parado;
	private int movimientoAnterior;
	private Animacion[] animacionCaminado;




	public TilePersonaje(Punto p,Personaje pj,Mouse mouse,Camara camara) {
		this.xCentro = 320;
		this.yCentro = 320;
		//this.sprite = sprite;
		this.camara = camara;
		this.movimiento = 0;
		this.pj = pj;
		this.nombre = pj.getNombre();	
		this.xInicio = this.xDestino = -p.getX();  //alta logica wachin.
		this.yInicio = this.yDestino =  -p.getY(); 
		this.camara.setxActualPJ(xInicio);
		this.camara.setxActualPJ(yInicio);
		this.mouse = mouse;
		//Le paso el sprite del personaje :D ( hasta se puede cambiar 8| ) 
		inicializarAnimaciones("src\\main\\resources\\personajes\\"+pj.getSprite()+".png");

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
		g.drawImage( obtenerFrameActual() ,xCentro-25, yCentro-50, null);
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.GREEN);
		g.setFont(fuente);
		g.drawString(nombre, xCentro, yCentro - 25);

	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();

		actualizarAnimaciones();

		if (mouse.getRecorrido()) {
			setNuevoRecorrido(true);
			xDestino = xInicio - posMouse[0] + camara.getxOffCamara();
			yDestino = yInicio - posMouse[1] + camara.getyOffCamara();
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

	public void inicializarAnimaciones(String pathPJ) {
		Sprite spriteCaminando =  new Sprite(pathPJ);
		animacionCaminado = new Animacion[8];
		for (int i = 0; i < animacionCaminado.length; i++) {
			animacionCaminado[i] = new Animacion(100, spriteCaminando.getVectorSprite(i));
		}

	}

	public void actualizarAnimaciones() {
		for (int i = 0; i < 8; i++) {
			animacionCaminado[i].actualizar();
		}

	}

	// Esto lo podria resolver con un 1 byte en c++ ¬¬
	public void paraDondeVoy(int xDestino2, int yDestino2) {
		movimiento = 0;
		parado = false;

		//faltaria parado, estaba rancia
		/*
		 * Dani, me tiraste cualquier cosa en los nombres, nada se movia para los
		 * lados que decia -.-
		 * Se ya se me di cuenta, pero esta la estructura loco :v
		 */
		if (xInicio == xDestino2 && yInicio == yDestino2) { // parado
			parado = true;
			return; 
		}
		if (xInicio > xDestino2 && yInicio > yDestino2) {// sur
			movimiento = 6;
			return;
		}
		if (xInicio > xDestino2 && yInicio == yDestino2) { // sureste 
			movimiento = 5;
			return;
		}
		if (xInicio > xDestino2 && yInicio < yDestino2) {// este
			movimiento = 4;
			return;
		}
		if (xInicio == xDestino2 && yInicio < yDestino2) {// noreste
			movimiento = 3;
			return;
		}
		if (xInicio < xDestino2 && yInicio == yDestino2) {// noroeste
			movimiento = 1;
			return;
		}
		if (xInicio < xDestino2 && yInicio > yDestino2) {// oeste
			movimiento = 0;
			return;
		}
		if (xInicio == xDestino2 && yInicio > yDestino2) {// suroeste
			movimiento = 7;
			return;
		}
		if (xInicio < xDestino2 && yInicio < yDestino2) {// norte
			movimiento = 2;
			return;
		}



	}

	public BufferedImage obtenerFrameActual() {
		if (!parado)
			return animacionCaminado[movimiento].getFrameActual();
		return animacionCaminado[movimientoAnterior].getFrame(8);
	}


	public void setNuevoRecorrido(boolean bs){
		this.nuevoRecorrido = bs;
	}

	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;	
	}


	public boolean estaEnMovimiento() {
		return enMovimiento;
	}


	public void setEnMovimiento(boolean b) {
		this.enMovimiento = b;
	}

	public void parar() {
		movimientoAnterior = movimiento;
		parado = true;
	}



	public int getXCentro() {
		return xCentro;
	}
	public int getYCentro() {
		return yCentro;
	}


	public String getNombre() {
		return pj.getNombre();
	}



}
