package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{

	private int x;
	private int y;
	private int[] pos;
	private boolean recorrido;
	public Mouse() {
		pos = new int[2];
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
	public void setNuevoRecorrido(boolean b) {
		recorrido = b;
	}
	public void actualizar() {
		pos[0] = x;
		pos[1] = y;
	}
	public int[] getPos() {
		return pos;
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
