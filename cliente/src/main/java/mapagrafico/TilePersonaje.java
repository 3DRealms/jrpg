package mapagrafico;

import java.awt.Graphics;

import juego.Mouse;

@SuppressWarnings("unused")
public class TilePersonaje {
	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private int altoImagen;
	private int sprite;
	private final int xCentro;
	private final int yCentro;
	private String nombre;
	
	
	

	// Tamaño de la entidad
	private int ancho;
	private int alto;

	// Posiciones
	private int x;
	private int y;
	private float dx;
	private float dy;
	private int xInicio;
	private int yInicio;
	
	
	public int getxFinal() {
		return xFinal;
	}

	public int getyFinal() {
		return yFinal;
	}
	private int xFinal;
	private int yFinal;
	
	
	private float xOffset;
	private float yOffset;
	private int drawX;
	private int drawY;
	private int posMouse[];
	private float[] tile;

	// Calculo de movimiento
	private float difX;
	private float difY;
	private float relacion;

	// Posicion final
	private float auxX;
	private float auxY;

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
	}
	
	/**
	 * Ver si le mando las coordenadas donde  esto al personaje.
	 * @param g2d
	 * @param deltaX
	 * @param deltaY
	 */
	public void dibujarCentro(Graphics g, int deltaX, int deltaY) {
		g.drawImage( MapaGrafico.getImage(sprite), xCentro, yCentro, null);
		g.drawString(nombre, xCentro, yCentro+35);
	}
	
	public void getEntrada(Mouse mouse) {
		int posMouse[] = mouse.getPos();

		if (mouse.getRecorrido() ) {
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;

			
										//Mover Camara.
			System.out.println(xFinal + " "+ yFinal);
			
			
			xInicio = x;
			yInicio = y;
			
			xFinal = posMouse[0]  - xInicio;
			yFinal = posMouse[1]  - yInicio;
			
			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			x += xFinal;
			y += yFinal;

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
			enMovimiento = true;
		}
	}
}
