package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import estados.EstadoActualJuego;
import mapa.Grafico;
import mapa.Mapa;


 // No vamos a tener ID es un solo juego :v.
@SuppressWarnings("serial")
public class juegoPanel extends Component implements Runnable, KeyListener{
	
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private Thread thread;
	private boolean ejecutando;
	private Graphics2D g;
	private EstadoActualJuego estadoActualJuego;
	private BufferedImage image;
	
	
	public juegoPanel(File map) {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		estadoActualJuego.setMapa(map);
		addKeyListener(this);
		thread = new Thread(this);
		thread.start();
	}
	

	/**
	 * Aca es donde se actualiza el contenido del juego y se dibuja.	
	 */
	@Override
	public void run(){
		
		
		while(ejecutando) {

			actualizar();				//Actualizo el juego
			dibujar();					//Dibujo en la patanlla.

			try {
				Thread.sleep(200); //Hacer calculos para sacar el tiempo para que de 60FPS(o 30)
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	private void actualizar() {
		estadoActualJuego.actualizar();
	}
	private void dibujar() {
		estadoActualJuego.dibujar(g);
	}
	
	/**
	 * Ver bien esto para hacerlo mejor:
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	

}
