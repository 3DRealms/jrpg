package mapagrafico;

import java.awt.Graphics2D;



public class Tile {

	public int getPx() {
		return px;
	}
	public int getPy() {
		return py;
	}

	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private int x;
	private int y;
	private int px; // Pasar de coordenadas logicas a coordenadas reales
	private int py;	//
	private int sprite;
	private boolean obstaculo;

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

	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {

		deltaX+=x;
		deltaY+=y;		
		px = (deltaX - deltaY) * ( ANCHO / 2);
		py = (deltaX + deltaY) * ( ALTO / 2);
		System.out.println(px+" "+py);
		g2d.drawImage( MapaGrafico.getImage(sprite), px, py , null);			

	}

	public void dibujarCentro(Graphics2D g2d, int deltaX, int deltaY) {

		deltaX+=x;
		deltaY+=y;		
		px = (deltaX - deltaY) * ( ANCHO / 2);
		py = (deltaX + deltaY) * ( ALTO / 2);
		int saltox= px/10;
		int saltoy= py/10;
		int pxaux=px+saltox;
		int pyaux=py+saltoy;
		g2d.drawImage( MapaGrafico.getImage(sprite), pxaux, pyaux , null);
	}

	public void dibujarMover(Graphics2D g2d, int deltaX, int deltaY) {


		deltaX+=x;
		deltaY+=y;		
		px = (deltaX - deltaY) * ( ANCHO / 2);
		py = (deltaX + deltaY) * (64 / 2);
		g2d.drawImage( MapaGrafico.getImage(sprite), px, py , null);



	}

}
