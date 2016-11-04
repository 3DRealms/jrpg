package mapagrafico;

import java.awt.Graphics2D;



public class Tile {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private int altoImagen;
	private int x;
	private int y;
	private int px; // Pasar de coordenadas logicas a coordenadas reales
	private int py;	//
	private int sprite;
	private boolean obstaculo;

	public int getPx() {
		return px;
	}
	public int getPy() {
		return py;
	}


	public Tile(int x, int y, int sprite, boolean obstaculo) {

		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.obstaculo = obstaculo;
		altoImagen = ALTO;
	}
	public Tile(int x, int y, int sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		altoImagen = ALTO;
		//	this.obstaculo = obstaculo;
	}

	public Tile(int x, int y, int sprite,int altoImagen) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.altoImagen = altoImagen;
		//	this.obstaculo = obstaculo;
	}


	public boolean getObstaculo() {
		return this.obstaculo;
	}

	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		// 0,0 -> 0,0
		// 1,0 -> 0,16
		deltaX+=x;
		deltaY+=y;		
		px = (deltaX - deltaY) * ( ANCHO / 2);
		py = (deltaX + deltaY) * ( ALTO / 2) + ((altoImagen%ALTO - 1)*ALTO );
		g2d.drawImage( MapaGrafico.getImage(sprite), px, py , null);			

	}

	/**
	 * Ver si le mando las coordenadas donde  esto al personaje.
	 * @param g2d
	 * @param deltaX
	 * @param deltaY
	 */
	public void dibujarCentro(Graphics2D g2d, int deltaX, int deltaY) {
		g2d.drawString("DANI", 335, 310);
		g2d.drawImage( MapaGrafico.getImage(sprite), 320, 320 , null);
	}



	public void mover(Graphics2D g2d, int x2, int y2) {

		x2+=x;
		y2+=y;	

		int nx = (x2 - y2) * ( ANCHO / 2);
		int ny = (x2 + y2) * ( ALTO / 2);

		if(px < nx){
			px+=2;
		}
		if(px > nx){
			px-=2;
		}
		if(px == nx){
			//x = x2;
		}
		if(py < ny){
			py++;
		}
		if(py > ny){
			py--;
		}
		if(py == ny){
			//y = y2;
		}

		g2d.drawImage( MapaGrafico.getImage(sprite), px, py , null);	
	}

}
