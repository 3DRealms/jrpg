package mapagrafico;
import java.awt.Graphics2D;

public class Tile {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;
		
	protected int xLogica;		// posicion logica de la matriz.
	protected int yLogica;
	protected int xIsometrica; 	// posicion real que se va dibujar
	protected int yIsometrica;	
	protected int sprite;
	protected int altoImagen;



	public Tile(int x, int y, int sprite) {
		this.xLogica = x;
		this.yLogica = y;
		this.sprite = sprite;
		this.altoImagen = Tile.ALTO;
	}
	public Tile(int x, int y, int sprite,int altoImagen) {
		this.xLogica = x;
		this.yLogica = y;
		this.sprite = sprite;
		this.altoImagen = altoImagen;
	}

	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		// 0,0 -> 0,0
		// 1,0 -> 0,16
		deltaX+=xLogica;
		deltaY+=yLogica;		
		xIsometrica = (deltaX - deltaY) * ( ANCHO / 2);
		yIsometrica = (deltaX + deltaY) * ( ALTO / 2);
		g2d.drawImage( MapaGrafico.getImage(sprite), 0, 0 , null);			
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
		g2d.drawImage( MapaGrafico.getImage(sprite), xIsometrica, yIsometrica , null);	
	}
	
	public int getPx() {
		return xIsometrica;
	}
	public int getPy() {
		return yIsometrica;
	}
}
