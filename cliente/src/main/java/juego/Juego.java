package juego;


import java.awt.EventQueue;
import ventana.Autenticar;

public class Juego {
	public final static String NOMBRE_DEL_JUEGO = "[3DRealms] Loro";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Autenticar frame = new Autenticar();
				frame.setVisible(true);
			}
		});
	}
}

