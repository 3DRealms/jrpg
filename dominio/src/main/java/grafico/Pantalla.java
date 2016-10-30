package grafico;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


import personaje.Personaje;
import raza.PersonajePrueba;

@SuppressWarnings("serial") // Pregunta chistoso
public class Pantalla extends JPanel {

	private JFrame frame;
	//private static Mapa map;
	public static Personaje pj = new PersonajePrueba("el dani");
	protected Pantalla() {
		//	map = new Mapa(800, 600, "gerli");
		initialize();
		frame.add(this);
		pj.setSprite( "C:\\Users\\laboratorios.UNLMLAB.000\\Desktop\\jrpg-master\\dominio\\src\\main\\resources\\dani.png" );
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Sprite logo = new Sprite("src\\main\\resources\\logo.png");
		logo.putSprite(g2d, 300, 0);
		pj.putSprite(g2d);
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
		//	Personaje dani = new PersonajePrueba("el dani");
		//map.agregarPersonaje(dani);
		//	Personaje pj = map.getPersonaje(0);


		//while (true) {	
			game.repaint();
			Thread.sleep(10);
			pj.desplazar("N");
			Thread.sleep(10);
			pj.desplazar("E");
			Thread.sleep(10);
			pj.desplazar("N");
			Thread.sleep(10);
			pj.desplazar("N");
			Thread.sleep(10);
			pj.desplazar("N");

		//}
	}
}