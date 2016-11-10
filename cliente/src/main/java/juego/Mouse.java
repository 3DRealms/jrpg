package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mapagrafico.Tile;

public class Mouse implements MouseListener{

	private int x;
	private int y;
	private int[] pos;
	private boolean recorrido;
	public Mouse() {
		pos = new int[2];
		x=0;
		y=0;
	}
	@Override
	public void mouseClicked(MouseEvent evento) {
		x = evento.getX();
		y = evento.getY();
		recorrido = true;
	}
	public boolean getRecorrido(){
		return recorrido;
	}
	public void setRecorrido(boolean b) {
		recorrido = b;
	}
	public void actualizar() {
		
		int x0 = x - ( Tile.ANCHO / 2 ); //ancho/2
		int y0 = y;

		int auxX = y0 + (x0 / 2);
		int auxY = y0 - (x0 / 2);

		if(auxX < 0)
			auxX -= 31;
		if(auxY < 0)
			auxY -= 31;


		auxX /= 32;
		auxY /= 32;

		pos[0] = auxX;
		pos[1] = auxY;

	}
	
	
	public int[] getPos() {
		return pos;
	}
	@Override
	public String toString() {
		return pos[0]+" : "+pos[1];
	}
	
	@Override
	public void mouseEntered(MouseEvent evento) {}

	@Override
	public void mouseExited(MouseEvent evento) {}

	@Override
	public void mousePressed(MouseEvent evento) {}

	@Override
	public void mouseReleased(MouseEvent evento) {}

}
