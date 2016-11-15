package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

import cliente.Cliente;
import cliente.EnviadorPosicion;
import mapa.Punto;
import mapagrafico.MapaGrafico;
import mapagrafico.TilePersonaje;
import personaje.Personaje;


@SuppressWarnings("serial")
public class JuegoPanel extends Component implements Runnable{

	public static final int ANCHO = 1024;
	public static final int ALTO = 768;
	public static final int fps = 60;


	public static double timePerTick = 1000000000/fps;
	private MapaGrafico mapa;
	private Thread thread;
	private Mouse mouse;
	private double delta = 0;
	private boolean ejecutando = true;
	private TilePersonaje pjDibujo;
	private Camara camara;
	JFrame padre;
	Cliente cliente;
	
	EnviadorPosicion env;

	private boolean jugar = true;

	public JuegoPanel(JFrame padre,Punto spaw, Personaje pj,String nombreMapa, Cliente cliente) {
		this.padre = padre;
		this.cliente = cliente;
		env = new EnviadorPosicion(cliente, pj.getNombre(),nombreMapa, pj.getSprite());
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse 	 = new Mouse();
		camara = new Camara(ANCHO, ALTO);
		addMouseListener(mouse);
		pjDibujo = new TilePersonaje(spaw,pj,mouse,camara);  
		mapa 	 = new MapaGrafico(nombreMapa,pjDibujo,camara, env);
		thread 	 = new Thread(this);
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
		mouse.actualizar();  // Preguntar porque aveces no me lo agarra :c estupido mouse listener de java ?
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
	
	public void nuevoMovimientoPersonajes(String pj, String sprite, Punto point){
		// aca te envio el nombre de personaje, su sprite y su pungo,
		// tendrias que fijarte si el personaje no existe agregarlo y si existe 
		// hacerle dijstra para empezar a moverlo
	}
	
	public void nuevaDetencionPersonaje(String pj){
		// aca te envio que el personaje llego a su destino, 
		// si por las dudas no llego todavia moverlo magicamente.
	}
	
}
