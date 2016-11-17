package tiles;
import java.awt.Graphics2D;

import sprites.Sprite;

public class TilePiso {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;

	protected int xLogica;		// posicion logica de la matriz.
	protected int yLogica;
	protected int xIsometrica; 	// posicion real que se va dibujar
	protected int yIsometrica;	
	protected int sprite;



	public TilePiso(int x, int y, int sprite) {
		this.xLogica = x;
		this.yLogica = y;
		this.sprite = sprite;
	}


	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		deltaX+=xLogica;
		deltaY+=yLogica;		
		xIsometrica = (deltaX - deltaY) * ( ANCHO / 2);
		yIsometrica = (deltaX + deltaY) * ( ALTO / 2) ;
		g2d.drawImage( Sprite.getImagePiso(sprite), 0, 0 , null);			
	}

	public void mover(Graphics2D g2d, int x2, int y2) {


		x2+=xLogica;
		y2+=yLogica;	

		int nx = (x2 - y2) * ( ANCHO / 2);
		int ny = (x2 + y2) * ( ALTO / 2);

		if(xIsometrica < nx){
			xIsometrica+=2;
		}
		if(xIsometrica > nx){
			xIsometrica-=2;
		}

		if(yIsometrica < ny){
			yIsometrica+=1;
		}
		if(yIsometrica > ny){
			yIsometrica-=1;
		}
		g2d.drawImage( Sprite.getImagePiso(sprite), xIsometrica, yIsometrica , null);	
	}
	
	public void mover2(Graphics2D g2d, int x2, int y2) {


		x2+=xLogica;
		y2+=yLogica;	

		int nx = (x2 - y2) * ( ANCHO / 2);
		int ny = (x2 + y2) * ( ALTO / 2);

		if(xIsometrica < nx){
			xIsometrica+=2;
		}
		if(xIsometrica > nx){
			xIsometrica-=2;
		}

		if(yIsometrica < ny){
			yIsometrica+=1;
		}
		if(yIsometrica > ny){
			yIsometrica-=1;
		}

	}

	public int getXIso() {
		return xIsometrica;
	}
	public int getYIso() {
		return yIsometrica;
	}
}
