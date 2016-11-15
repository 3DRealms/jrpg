package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;
import mapa.Punto;
import mapagrafico.dijkstra.AlgoritmoDelTacho;
import mapagrafico.dijkstra.Grafo;
import mapagrafico.dijkstra.Nodo;
import sprites.Animacion;
import sprites.Sprite;

public class TilePlayer {

	private Animacion[] animacionCaminado;
	private int xActual;
	private int yActual;
	private int xDestino;
	private int yDestino;
	protected int xIsometrica; 	// posicion real que se va dibujar
	protected int yIsometrica;
	private List<Nodo> camino;
	private int xAnterior;
	private int yAnterior;
	private Nodo paso;
	private String nombre;
	AlgoritmoDelTacho moverGordo;

	public TilePlayer(String nombre,String sprite, Punto point) {
		xDestino = xActual = xAnterior = point.getX();
		yDestino = yActual = yAnterior = point.getY();
		this.nombre = nombre;
		inicializarAnimaciones("src\\main\\resources\\personajes\\"+sprite+".png");
	}
	public void inicializarAnimaciones(String pathPJ) {
		Sprite spriteCaminando =  new Sprite(pathPJ);
		animacionCaminado = new Animacion[8];
		for (int i = 0; i < animacionCaminado.length; i++) {
			animacionCaminado[i] = new Animacion(100, spriteCaminando.getVectorSprite(i));
		}
	}

	public void actualizarAnimaciones() {
		for (int i = 0; i < 8; i++) {
			animacionCaminado[i].actualizar();
		}
	}
	public int getxDestino() {
		return xDestino;
	}
	public int getyDestino() {
		return yDestino;
	}
	public void calcularDijkstra(Grafo grafoDeMapa, Nodo actual, Nodo destino) {
		moverGordo 	= 	new AlgoritmoDelTacho();
		camino 		=	moverGordo.obtenerCamino(destino);
	}

	private void moverUnPaso() { // Esto tengo que ver, pero lo que hace es mover paso a paso por el camino del DI kjsoihyoas TRAMMMMMMMMMMM
		if(camino == null || camino.isEmpty() )
			return;
		paso = camino.get(0);
		xAnterior = xDestino;
		yAnterior = yDestino;
		xDestino = paso.getPunto().getX();
		yDestino = paso.getPunto().getY();
		camino.remove(0);
	}

	public void mover(Graphics2D g2d) {
		
		xActual+=xDestino;
		yActual+=yDestino;	

		int nx = (xActual - yActual) * ( 128 / 2);
		int ny = (xActual + yActual) * ( 128 / 2);

		if(xIsometrica < nx)
			xIsometrica+=2;

		if(xIsometrica > nx)
			xIsometrica-=2;

		if(yIsometrica < ny)
			yIsometrica++;

		if(yIsometrica > ny)
			yIsometrica--;

		g2d.drawImage( animacionCaminado[0].getFrameActual(), xIsometrica, yIsometrica-32 , null);	
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g2d.setColor(Color.RED);
		g2d.setFont(fuente);
		g2d.drawString(nombre, xIsometrica, yIsometrica - 5);
	}
	public void actualizar() {
		if(xActual==xDestino &&	yActual==yDestino ){
			moverUnPaso();
		}		
	}

	public int getyAnterior() {
		return yAnterior;
	}
	public int getxAnterior() {
		return xAnterior;
	}

	@Override
	public String toString() {
		return this.nombre +" "+xDestino+" : "+yDestino;
	}

}
