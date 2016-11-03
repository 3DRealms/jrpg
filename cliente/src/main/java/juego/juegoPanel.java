package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import mapagrafico.MapaGrafico;
import mapagrafico.Tile;


@SuppressWarnings("serial")
public class JuegoPanel extends Component implements Runnable{

	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	public static final int fps = 60;
	public static double timePerTick = 1000000000/fps;
	private MapaGrafico mapa;
	private Thread thread;
	private Mouse mouse;
	private double delta = 0;
	private boolean ejecutando = true;

	private Tile pj;
	int x = 3;

	public JuegoPanel() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse = new Mouse();
		//addKeyListener(this);
		pj = new Tile(7,2,1);
		mapa = new MapaGrafico("map1");
		thread = new Thread(this);
		thread.start();
	}


	/**
	 * Aca es donde se actualiza el contenido del juego y se dibuja.	
	 */
	@Override
	public void run(){

		long now;
		long lastTime = System.nanoTime();

		while(ejecutando) {

			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;

			if(delta >=1){   
				actualizar();
				repaint();
				delta--;
			}
		}
	}
	/*
	 * si logro sincronizar esto, ya queda pipi cucu 
	 */

	public void actualizar() {
		mouse.actualizar();
		mapa.actualizar();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		mapa.dibujar(g2d,x--,x+1);
		pj.dibujarCentro(g2d,7,2);
	}

}
