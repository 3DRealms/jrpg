package juego;

import mapa.Punto;

public class Camara {

	private float yOffset;
	private float xOffset;

	public Camara(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	/**
	 * hardcored
	 * @param e
	 */
	public void Centrar(Punto e) {
		xOffset = e.getX() -  JuegoPanel.ANCHO / 2 + 64 / 2;
		yOffset = e.getY() - JuegoPanel.ALTO / 2 +  32 / 2;
	}
	
	public void mover(float dx, float dy) {
		xOffset += dx;
		yOffset += dy;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
}