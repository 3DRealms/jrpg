package estados;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;

import mapa.Mapa;


public class EstadoMapaExploracion extends Estado{

	
	protected Mapa mapa;
	
	public EstadoMapaExploracion(File map) throws FileNotFoundException {
		this.mapa = new Mapa(map);
	}

	@Override
	public void actualizar() {
		
	}

	@Override
	public void dibujar(Graphics2D g) {
		
	}

	@Override
	public void entradaDelTeclado() {
		
	}

}
