package mapagrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import juego.JuegoPanel;
import juego.JuegoPanel2;
import juego.Mouse;
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
	
	/*
	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;
	*/



	public TilePersonaje(int x, int y, int sprite,Personaje pj,Mouse mouse) {
		this.xCentro = 320;
		this.yCentro = 320;
		//this.sprite = sprite;
		this.pj = pj;
		this.nombre = pj.getNombre();	
		this.xInicio = this.xDestino = -x;  //alta logica wachin.
		this.yInicio = this.yDestino =  -y; 
		this.mouse = mouse;

		spritePJ = Sprite.loadImage("src\\main\\resources\\mapas\\"+nombre+"\\04.png");
		
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
		g.drawString("SALUD: "+pj.getSaludActual(), 320, 50);

	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();
		

		if (mouse.getRecorrido()) {
			
			setNuevoRecorrido(true);
			xDestino = xInicio - posMouse[0] + JuegoPanel.xOffCamara;
			yDestino = yInicio - posMouse[1] + JuegoPanel.yOffCamara;
			mouse.setRecorrido(false); 
			
			//esto es para animaciones no le des bola:
			/*
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;
			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < alto && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}
			 */
		//	enMovimiento = true;// Cuando llego a destino tengo que poner esto en false
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
	
	public void mover() {
		//me muevo de inicio  a fin.
		xInicio = xDestino;  
		yInicio = yDestino;	
		setNuevoRecorrido(false); // cuando me muevo ya no es nuevo recorrido.
	}

		
	public void setNuevoRecorrido(boolean bs){
		this.nuevoRecorrido = bs;
	}
	
	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;	
	}

}
