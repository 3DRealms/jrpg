package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mapa.Punto;
import tiles.TilePiso;

public class Mouse implements MouseListener{

	private int x;
	private int y;
	private int[] pos;
	private Punto posInt;
	private int xInt;
	private int yInt;
	private boolean recorrido;
	private boolean interaccion;

	public Mouse() {
		pos = new int[2];
		x=0;
		y=0;
		xInt = 0;
		yInt = 0;
	}
	@Override
	public void mouseClicked(MouseEvent evento) {
		if(evento.getButton() == MouseEvent.BUTTON3){
			x = evento.getX();
			y = evento.getY();
			recorrido = true;
		}
		else if(evento.getButton() == MouseEvent.BUTTON1){
			//aca mando el comando de interaccion
			xInt = evento.getX();
			yInt = evento.getY();
			interaccion = true;
		}
		
	//	JuegoTest_SinServidor.cursor("click");
	}
	
	
	public boolean getRecorrido(){
		return recorrido;
	}
	public void setRecorrido(boolean b) {
		recorrido = b;
	}
	
	public boolean isInteraccion() {
		return interaccion;
	}
	public void setInteraccion(boolean interaccion) {
		this.interaccion = interaccion;
	}
	public void actualizar() {
		
		int x0 = x - ( TilePiso.ANCHO / 2 ); //ancho/2
		int y0 = y;

		int auxX = y0 + (x0 / 2);
		int auxY = y0 - (x0 / 2);

		if(auxX < 0)
			auxX -= 31;
		if(auxY < 0)
			auxY -= 31;


		auxX /= 32;
		auxY /= 32;
		
		posInt = calcularPunto(xInt, yInt);

		pos[0] = auxX;
		pos[1] = auxY;

	}
	
	
	private Punto calcularPunto(int x, int y) {
		int x0 = x - ( TilePiso.ANCHO / 2 ); //ancho/2
		int y0 = y;

		int auxX = y0 + (x0 / 2);
		int auxY = y0 - (x0 / 2);

		if(auxX < 0)
			auxX -= 31;
		if(auxY < 0)
			auxY -= 31;


		auxX /= 32;
		auxY /= 32;
		
		return new Punto(auxX, auxY);
		
	}
	public int[] getPos() {
		return pos;
	}
	
	public Punto getPosInt() {
		return posInt;
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
