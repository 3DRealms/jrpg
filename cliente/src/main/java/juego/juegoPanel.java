package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mapagrafico.MapaGrafico;
import mapagrafico.Tile;


 // No vamos a tener ID es un solo juego :v.
@SuppressWarnings("serial")
public class JuegoPanel extends Component implements Runnable, KeyListener{
	
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	
	private Thread thread;
	private boolean ejecutando = true;
	private MapaGrafico mapa;
	
	private Tile pj;
	int x = 0;

	public JuegoPanel() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		//addKeyListener(this);
		pj = new Tile(5,5,1);
		mapa = new MapaGrafico("map2");
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
		//	hacerDibujos();				//Actualizo el dibujo
			repaint();					//Dibujo en la patanlla.
			try {
				//Thread.sleep(200); //Hacer calculos para sacar el tiempo para que de 60FPS(o 30)
				Thread.sleep(60); //Hacer calculos para sacar el tiempo para que de 60FPS(o 30)
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * si logro sincronizar esto, ya queda pipi cucu 
	 */
	
	public void actualizar() {
	mapa.actualizar();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		mapa.dibujar(g2d,10,10);
		pj.dibujarCentro(g2d, 5, -7);

	}
//	public void hacerDibujos() {
	//}
	
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
/*
	@SuppressWarnings("unused")
	private void paint(Graphics2D g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		Sprite logo = new Sprite("src\\main\\resources\\logo.png");
		logo.putSprite(g2d, 300, 0);	
	}
*/
	

}
