package tiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;
import juego.Camara;
import mapa.Punto;
import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Grafo;
import mapagrafico.dijkstra.Nodo;

public class TilePersonajeRemoto extends TilePersonaje {

	private int xIsometrica; 	// posicion real que se va dibujar
	private int yIsometrica;
	private int xActual;
	private int yActual;
	private List<Nodo> camino;
	private Nodo paso;
	AlgoritmoDelTacho moverGordo;
	private int nx;
	private int ny;



	public TilePersonajeRemoto(String nombre,String sprite, Punto point, Camara camara) {
		super(sprite,nombre,camara);
		
		xDestino = xInicio = point.getX();
		yDestino = yInicio = point.getY();
		
		int deltaX = camara.getxOffCamara()-camara.getxActualPJ() + xDestino - 2;
		int deltaY = camara.getyOffCamara()-camara.getyActualPJ() + yDestino - 1;
		
		xIsometrica = (deltaX - deltaY) * ( 64 / 2);
		yIsometrica = (deltaX + deltaY) * ( 32 / 2);
		
	}


	public void parar() {
		movimientoAnterior = movimiento;
		parado = true;
	}
	public int getxDestino() {
		return xDestino;
	}
	public int getyDestino() {
		return yDestino;
	}
	public void calcularDijkstra(Grafo grafoDeMapa, Nodo actual, Nodo destino) {
		moverGordo 	= 	new AlgoritmoDelTacho();
		moverGordo.calcularDijkstra(grafoDeMapa, actual, destino);
		camino 		=	moverGordo.obtenerCamino(destino);
	}

	private void moverUnPaso() { // Esto tengo que ver, pero lo que hace es mover paso a paso por el camino del DI kjsoihyoas TRAMMMMMMMMMMM
		if(camino == null || camino.isEmpty() ){		
			return;
		}
		paso = camino.get(0);
		xInicio = xDestino;
		yInicio = yDestino;
		xDestino = paso.getPunto().getX();
		yDestino = paso.getPunto().getY();
		camino.remove(0);
		enMovimiento = false;
	}
	
	public void mover(Graphics2D g2d) {
		
		xInicio=xDestino;
		yInicio=yDestino;	
		
		int deltaX = camara.getxOffCamara() - camara.getxActualPJ() + xDestino -2;
		int deltaY = camara.getyOffCamara() - camara.getyActualPJ() + yDestino -1;

		nx = (deltaX - deltaY ) * ( 64 / 2);
		ny = (deltaX + deltaY) * ( 32 / 2);

		if(xIsometrica < nx)
			xIsometrica+=2;

		if(xIsometrica > nx)
			xIsometrica-=2;

		if(yIsometrica < ny)
			yIsometrica++;

		if(yIsometrica > ny)
			yIsometrica--;

		
		g2d.drawImage( obtenerFrameActual(), xIsometrica, yIsometrica-32 , null);	
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g2d.setColor(Color.RED);
		g2d.setFont(fuente);
		g2d.drawString(nombre, xIsometrica, yIsometrica - 5);
		
	}
	
	public void dibujar(Graphics2D g2d) {
		
		xInicio=xDestino;
		yInicio=yDestino;	
		
		int deltaX = camara.getxOffCamara() - camara.getxActualPJ() + xDestino -2;
		int deltaY = camara.getyOffCamara() - camara.getyActualPJ() + yDestino -1;

		nx = (deltaX - deltaY ) * ( 64 / 2);
		ny = (deltaX + deltaY) * ( 32 / 2);
		
		g2d.drawImage( obtenerFrameActual(), nx, ny-32 , null);	
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g2d.setColor(Color.RED);
		g2d.setFont(fuente);
		g2d.drawString(nombre, nx, ny - 5);
		
	}
	
	public void actualizar() {

		if( ! estaEnMovimiento() && hayCamino() ){
			moverUnPaso();	
			paraDondeVoy(xDestino, yDestino);
		}
		if(nx == xIsometrica && ny == yIsometrica)
			enMovimiento = false;
		else
			enMovimiento = true;
		
	}
	
	
	private boolean hayCamino() {
		return 	camino != null && ! camino.isEmpty();
	}
	private boolean estaEnMovimiento() {
		return enMovimiento;
	}



}
