package mapagrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import juego.JuegoPanelTestBatalla;
import juego.Mouse;
import mapa.Punto;
import personaje.Personaje;
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
	private boolean meMuevoParaInfIzq;
	private boolean meMuevoParaSup;
	private boolean meMuevoParaInf;
	


	private boolean meMuevoParaDer;
	private boolean meMuevoParaIzq;
	private boolean meMuevoParaInfDer;
	private boolean meMuevoParaSupIzq;
	private boolean meMuevoParaSupDer;
	private boolean enMovimiento;
	private boolean parado;




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
		g.drawImage( spritePJ ,xCentro, yCentro, null);
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.GREEN);
		g.setFont(fuente);
		g.drawString(nombre, xCentro+10, yCentro);

	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();

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

	// Esto lo podria resolver con un 1 byte en c++ ¬¬
	public void paraDondeVoy(int xDestino2, int yDestino2) {
		meMuevoParaSup = false;
		meMuevoParaInf = false;
		meMuevoParaDer= false;
		meMuevoParaIzq = false;
		meMuevoParaInfDer = false;
		meMuevoParaInfIzq = false;
		meMuevoParaSupIzq = false;
		meMuevoParaSupDer = false;
		parado = false;

		if(xInicio ==  xDestino2 && yInicio == yDestino2){
			parado = true;
			return;
		}
		if(xInicio >  xDestino2 && yInicio == yDestino2){
			meMuevoParaIzq = true;
			return;
		}
		if(xInicio <  xDestino2 && yInicio == yDestino2){
			meMuevoParaDer = true;
			return;
		}
		if(xInicio ==  xDestino2 && yInicio < yDestino2){
			meMuevoParaInf = true;
			return;
		}
		if(xInicio ==  xDestino2 && yInicio > yDestino2){
			meMuevoParaSup = true;
			return;
		}
		if(xInicio <  xDestino2 && yInicio < yDestino2){
			meMuevoParaInfDer = true;
			return;
		}
		if(xInicio >  xDestino2 && yInicio < yDestino2){
			meMuevoParaInfIzq = true;
			return;
		}
		if(xInicio >  xDestino2 && yInicio > yDestino2){
			meMuevoParaSupIzq = true;
			return;
		}
		if(xInicio <  xDestino2 && yInicio > yDestino2){
			meMuevoParaSupDer = true;
			return;
		}

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


	public boolean isMeMuevoParaInfIzq() {
		return meMuevoParaInfIzq;
	}


	public boolean isMeMuevoParaSup() {
		return meMuevoParaSup;
	}


	public boolean isMeMuevoParaInf() {
		return meMuevoParaInf;
	}


	public boolean isMeMuevoParaDer() {
		return meMuevoParaDer;
	}


	public boolean isMeMuevoParaIzq() {
		return meMuevoParaIzq;
	}


	public boolean isMeMuevoParaInfDer() {
		return meMuevoParaInfDer;
	}


	public boolean isMeMuevoParaSupIzq() {
		return meMuevoParaSupIzq;
	}


	public boolean isMeMuevoParaSupDer() {
		return meMuevoParaSupDer;
	}

}
