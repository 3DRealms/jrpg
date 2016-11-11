package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import mapagrafico.MapaGrafico;
import mapagrafico.TilePersonaje;
import personaje.Personaje;
import raza.PersonajePrueba;


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
	private Personaje pj;
	private TilePersonaje pjDibujo;

	JFrame padre;
	
	private boolean jugar = true;

	public JuegoPanel(JFrame padre) {
		pj = new PersonajePrueba("El Dani");
		this.padre = padre;
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse = new Mouse();
		addMouseListener(mouse);
		pjDibujo = new TilePersonaje(1,1,4,pj,mouse);  //Pone las que quiera papu.
		mapa = new MapaGrafico("map_test",pjDibujo);
		thread = new Thread(this);
		thread.start();
	}


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

	public void actualizar() {
		mouse.actualizar(); 
		pjDibujo.actualizar();
		mapa.actualizar();
	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if(jugar){
			mapa.dibujar(g2d);
			jugar = false;
		}
		mapa.mover(g2d);
		
	}
}
