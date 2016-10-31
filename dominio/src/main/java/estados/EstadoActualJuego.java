package estados;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;

public class EstadoActualJuego {

	private Estado[] estado;
	private int actual;
//	private int anterior;

	public static final int NUM_ESTADOS = 5;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int MAPAEXPLORACION = 2;
	public static final int BATALLA = 3;
	public static final int CARGA = 4;


	public void actualizar() {
		if( estado[actual] != null )
			estado[actual].actualizar();
	}

	public void dibujar(Graphics2D g) {
		if(estado[actual] != null) {
			estado[actual].dibujar(g);
		}
	}

	public void setMapa(File map) {
		try {
			estado[MAPAEXPLORACION] = new EstadoMapaExploracion(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
