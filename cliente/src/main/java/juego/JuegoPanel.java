package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JFrame;

import cliente.Cliente;
import cliente.EnviadorPosicion;
import mapa.Punto;
import mapagrafico.MapaGrafico;
import personaje.Personaje;
import tiles.TilePersonajeLocal;
import tiles.TilePersonajeRemoto;


@SuppressWarnings("serial")
public class JuegoPanel extends Component implements Runnable{

	public static final int ANCHO = 1024;
	public static final int ALTO = 768;
	public static final int fps = 60;
	public static double timePerTick = 1000000000/fps;
	
	protected JFrame padre;
	protected Cliente cliente;
	protected EnviadorPosicion env;
	
	private MapaGrafico mapa;
	private Thread thread;
	private Mouse mouse;
	private double delta = 0;
	private boolean ejecutando = true;
	private TilePersonajeLocal pjDibujo;
	private Camara camara;
	private HashMap<String, TilePersonajeRemoto> personajes;

	private boolean jugar = true;

	public JuegoPanel(JFrame padre,Punto spaw, Personaje pj,String nombreMapa, Cliente cliente) {
		this.padre = padre;
		this.cliente = cliente;
		this.personajes = new HashMap<String, TilePersonajeRemoto>();
		env = new EnviadorPosicion(cliente, pj.getNombre(),nombreMapa, pj.getSprite());
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse 	 = new Mouse();
		camara = new Camara(ANCHO, ALTO);
		addMouseListener(mouse);
		pjDibujo = new TilePersonajeLocal(spaw,pj,mouse,camara);  
		mapa 	 = new MapaGrafico(nombreMapa,pjDibujo,camara, env,personajes);
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
		
		if(mouse.isInteraccion()){
			String destino = hayAlguien(mouse.getPosInt());
			if(destino != null){
				//enviar mensaje interaccion con servidor
				
			}
			mouse.setInteraccion(false);
		}
		
	}

	private String hayAlguien(Punto posInt) {
		for (String persona : personajes.keySet()) {
			personajes.get(persona).getXDestino();
			personajes.get(persona).getYDestino();
			
		}
		return null;
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
		TilePersonajeRemoto player = personajes.get(pj);
		if (player == null){
			
			player= new TilePersonajeRemoto(pj,sprite,point, camara);
			personajes.put(pj, player );
		}
		else{
			mapa.moverPlayer(player,point);
		}
	}

	public void nuevaDetencionPersonaje(String pj){ //estp creo que vuela.
		// aca te envio que el personaje llego a su destino, 
		// si por las dudas no llego todavia moverlo magicamente.
	}

}
