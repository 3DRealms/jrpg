package mapa;

import java.awt.Graphics2D;

public class Tile {
	
	final static int ANCHO = 64;
	final static int ALTO = 32;
	int x;
	int y;
	int sprite;
	boolean obstaculo;
	
	public Tile(int x, int y, int sprite, boolean obstaculo) {
		
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.obstaculo = obstaculo;
	}
	public Tile(int x, int y, int sprite) {

		this.x = x;
		this.y = y;
		this.sprite = sprite;
	//	this.obstaculo = obstaculo;
	}

	public boolean getObstaculo() {
		return this.obstaculo;
	}
	
	public void dibujar(Graphics2D g2d) {
		g2d.drawImage( Mapa.getImage(sprite), (x - y) * (ANCHO / 2) ,  (x + y) * (ALTO / 2), null);
	}
 
}
