package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import mapagrafico.MapaGrafico;
import mapagrafico.Tile;
import mapagrafico.TilePersonaje;


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

	private TilePersonaje pj;
	private int x;
	private int y;

	private boolean jugar = true;

	public JuegoPanel() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse = new Mouse();
		addMouseListener(mouse);
		mapa = new MapaGrafico("map4");
		pj = new TilePersonaje(7,1,5,"DANI");
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
		if(jugar){
			//posicion inicial del mapa
			mapa.dibujar(g2d, 0, 0);
			jugar = false;
		}
		pj.getEntrada(mouse);
		mapa.mover(g2d,pj.getxFinal(),pj.getyFinal());
		pj.dibujarCentro(g2d,0,0);
	}



}
