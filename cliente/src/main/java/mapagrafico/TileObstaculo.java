package mapagrafico;

import java.awt.Graphics2D;

import sprites.Sprite;

public class TileObstaculo extends Tile{

	protected int anchoImagen;
	protected int altoImagen;


	public TileObstaculo(int x, int y, int sprite,int anchoImagen,int altoImagen) {
		super(x, y, sprite);
		this.anchoImagen = anchoImagen;
		this.altoImagen = altoImagen;
	}

	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		deltaX+=xLogica;
		deltaY+=yLogica;		
		xIsometrica = (deltaX - deltaY) * ( ANCHO / 2)- anchoImagen%64;
		yIsometrica = (deltaX + deltaY) * ( ALTO / 2) - altoImagen%32;
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
			yIsometrica++;
		}
		if(yIsometrica > ny){
			yIsometrica--;
		}

		g2d.drawImage( Sprite.getImagePiso(sprite), xIsometrica-anchoImagen%64, yIsometrica-altoImagen%32 , null);	
	}

}
