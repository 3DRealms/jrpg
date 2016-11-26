package tiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import juego.Camara;
import mapa.Punto;
import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Grafo;
import mapagrafico.dijkstra.Nodo;
import sprites.Animacion;

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
	protected double distancia;
	protected Punto desti;


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
		camino.add(destino); //Solucion provisoria xD
		camino.add(destino);

		desti = destino.getPunto();
	}

	private void moverUnPaso() { // Esto tengo que ver, pero lo que hace es mover paso a paso por el camino del DI kjsoihyoas TRAMMMMMMMMMMM
		if(camino == null || camino.isEmpty() ){		
			parado = true;
			return;
		}
		paso = camino.get(0);
		xInicio = xDestino;
		yInicio = yDestino;
		xDestino = paso.getPunto().getX();
		yDestino = paso.getPunto().getY();
		camino.remove(0);
		distancia = desti.calcularDistancia(paso.getPunto());
		
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
		for (Animacion animacion : animacionCaminado) {
			animacion.actualizar();
		}
	}
	
	
	private boolean hayCamino() {
		return 	camino != null && ! camino.isEmpty();
	}
	private boolean estaEnMovimiento() {
		return enMovimiento;
	}
	/**
	 * Son distintas  a la del personaje local:
	 */
	public void paraDondeVoy(int xDestino2, int yDestino2) {
		movimiento = 0;
		parado = false;

		if (xInicio == xDestino2 && yInicio == yDestino2) { // parado
			parado = true;
			return; 
		}
		
		if (xInicio > xDestino2 && yInicio > yDestino2) {// sur
			movimiento = 2;
			return;
		}
		if (xInicio > xDestino2 && yInicio == yDestino2) { // sureste 
			movimiento = 1;
			return;
		}
		if (xInicio > xDestino2 && yInicio < yDestino2) {// este
			movimiento = 0;
			return;
		}
		if (xInicio == xDestino2 && yInicio < yDestino2) {// noreste
			movimiento = 7;
			return;
		}
		if (xInicio < xDestino2 && yInicio == yDestino2) {// noroeste
			movimiento = 5;
			return;
		}
		if (xInicio < xDestino2 && yInicio > yDestino2) {// oeste
			movimiento = 4;
			return;
		}
		if (xInicio == xDestino2 && yInicio > yDestino2) {// suroeste
			movimiento = 3;
			return;
		}
		if (xInicio < xDestino2 && yInicio < yDestino2) {// norte
			movimiento = 6;
			return;
		}
	}
	
	@Override
	public BufferedImage obtenerFrameActual() {
		if(distancia != 0)
			movimientoAnterior = movimiento;
		
		if (hayCamino())
			return animacionCaminado[movimiento].getFrameActual();
		
		return animacionCaminado[movimientoAnterior].getFrame(8);
	}

}
