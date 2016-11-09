package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import mapagrafico.MapaGrafico;
import mapagrafico.TilePersonaje;


@SuppressWarnings("serial")
public class JuegoPanel2 extends Component implements Runnable{

	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	public static final int fps = 60;
	
	public static final int xOffCamara = 16; // mouse.actualizar(); en el (0,0) del personaje segun el mouse es 
	public static final int yOffCamara = 6;  // el 16,6. Hay que ver bien como hacer para sacar la formula, 
										  // usando las dimeciones de la ventana, para calcular el centro y asi sacar los offSet de la camra.
	
	public static double timePerTick = 1000000000/fps;
	private MapaGrafico mapa;
	private Thread thread;
	private Mouse mouse;
	private double delta = 0;
	private boolean ejecutando = true;

	private TilePersonaje pj;

	JFrame padre;
	
	private boolean jugar = true;

	public JuegoPanel2(JFrame padre) {
		this.padre = padre;
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse = new Mouse();
		addMouseListener(mouse);
		pj = new TilePersonaje(1,1,4,"DANI",mouse);  //Pone las que quiera papu.
		mapa = new MapaGrafico("map4",pj);
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
		pj.actualizar();
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
		pj.dibujarCentro(g2d);
	}



}
