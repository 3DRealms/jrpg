package mapagrafico;

import java.awt.Color;
import java.awt.Graphics;

import juego.JuegoPanel;
import juego.Mouse;

@SuppressWarnings("unused")
public class TilePersonaje {
	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private int sprite;
	public final int xCentro;
	public final int yCentro;
	private String nombre;


	// Posiciones

	private int xInicio;
	private int yInicio;
	private int xFinal;
	private int yFinal;


	// Movimiento Actual
	private boolean enMovimiento;
	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;
	



	public TilePersonaje(int x, int y, int sprite,String nombre) {
		this.xCentro = 320;
		this.yCentro = 320;
		this.sprite = sprite;
		this.nombre = nombre;	
		this.xInicio = this.xFinal = -x;  //alta logica wachin.
		this.yInicio = this.yFinal =  -y; 
		// baicamente como le sumo (16,6) para que coicida con el 0,0 del mapa.

	}

	/**
	 * Ver si le mando las coordenadas donde  esto al personaje.
	 * @param g2d
	 * @param deltaX
	 * @param deltaY
	 */
	public void dibujarCentro(Graphics g, int deltaX, int deltaY) {
		g.drawImage( MapaGrafico.getImage(sprite), xCentro, yCentro, null);
		g.setColor(Color.GREEN);
		g.drawString(nombre, xCentro+17, yCentro);
	}

	public void actualizar(Mouse mouse) {
		int posMouse[] = mouse.getPos();

		if (mouse.getRecorrido()) {

			if( enMovimiento ){

				//Cancelar movimiento actual.
			}


			xFinal = xInicio - posMouse[0] + JuegoPanel.xOffSetCamara;;
			yFinal = yInicio - posMouse[1] + JuegoPanel.yOffCamara;


			//Esto podria suseder cuando termina el mov. (sino es al dope).
			xInicio = xFinal; 	// Las posiciones dan negativas nos e porque pero funca :D 
			yInicio = yFinal;	// solo conponer un - delante basta. 


			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;


			/*
			xInicio = x;
			yInicio = y;

			xFinal = posMouse[0]  - xInicio;
			yFinal = posMouse[1]  - yInicio;

			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			x += xFinal;
			y += yFinal;
			 */
			/* esto es para animaciones no le des bola
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
			mouse.setNuevoRecorrido(false); 
			enMovimiento = true;// Cuando llego a destino tengo que poner esto en false
		}

	}
	public int getxFinal() {
		return xFinal;
	}

	public int getyFinal() {
		return yFinal;
	}

}
