package tiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import juego.Camara;
import juego.Mouse;
import mapa.Punto;
import personaje.Personaje;

public class TilePersonajeLocal extends TilePersonaje {

	private final int xCentro;
	private final int yCentro;
	private Mouse mouse;
	private boolean nuevoRecorrido;
	private Personaje pj;

	public TilePersonajeLocal(Punto point,Personaje pj,Mouse mouse,Camara camara) {
		super(pj.getSprite(),pj.getNombre(),camara);
		
		this.xCentro = 320;
		this.yCentro = 320;
		this.movimiento = 0;
		this.pj = pj;
		this.xInicio = this.xDestino = -point.getX();  //alta logica wachin.
		this.yInicio = this.yDestino =  -point.getY();
		this.camara.setxActualPJ(-xInicio);
		this.camara.setyActualPJ(-yInicio); // BIEN BRAIAN BIEN aca pusiste setxActualPJ(yInicio) NO SERVIS PARA NADA LOCO.
		this.mouse = mouse;
		this.nuevoRecorrido = false; // NO BORRAR.
		// baicamente como le sumo (16,6) para que coicida con el 0,0 del mapa.

	}


	/**
	 * Ver si le mando las coordenadas donde  esto al personaje.
	 * @param g2d
	 * @param deltaX
	 * @param deltaY
	 */
	public void dibujarCentro(Graphics g) {  
		g.drawImage( obtenerFrameActual() ,xCentro-25, yCentro-50, null);
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.GREEN);
		g.setFont(fuente);
		g.drawString(nombre, xCentro, yCentro - 25);

	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();

		actualizarAnimaciones();

		if (mouse.getRecorrido()) {
			setNuevoRecorrido(true);
			xDestino = xInicio - posMouse[0] + camara.getxOffCamara();
			yDestino = yInicio - posMouse[1] + camara.getyOffCamara();
			mouse.setRecorrido(false); 
		}

	}

	public void mover(int xDestino2, int yDestino2) {
		xInicio = xDestino2;  
		yInicio = yDestino2;

	}

	public void setNuevoRecorrido(boolean bs){
		this.nuevoRecorrido = bs;
	}

	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;	
	}


	public boolean estaEnMovimiento() {
		return enMovimiento;
	}

	public void setEnMovimiento(boolean b) {
		this.enMovimiento = b;
	}

	public void parar() {
		movimientoAnterior = movimiento;
		parado = true;
	}

	public int getXCentro() {
		return xCentro;
	}
	public int getYCentro() {
		return yCentro;
	}
	
}
