package grafico;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mapagrafico.MapaGrafico;
import personaje.Personaje;
import raza.PersonajePrueba;

@SuppressWarnings("serial") // Pregunta chistoso
public class Pantalla extends JPanel {

	private JFrame frame;
	private static MapaGrafico map;

	public Pantalla() {
		//map = new Mapa(800, 600, "generic",1);
		initialize();
		frame.add(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Sprite logo = new Sprite("src\\main\\resources\\logo.png");
		logo.putSprite(g2d, 300, 0);
	}

	private void initialize() {	
		frame = new JFrame("The Loro of Desteny");
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Pantalla game = new Pantalla();	
		Personaje dani = new PersonajePrueba("el dani");
		map.agregarPersonaje(dani);
		Personaje pj = map.getPersonaje("el dani");
		//pj.setSprite( "src\\main\\resources\\dani.png" );
	//	pj.putSprite(g2d);
		
		while (true) {	
			game.repaint();
			Thread.sleep(100);
			dani.desplazar("E");

		}
	}
}