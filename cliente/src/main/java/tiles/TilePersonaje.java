package tiles;

import java.awt.image.BufferedImage;
import juego.Camara;
import sprites.Animacion;
import sprites.Sprite;

public abstract class TilePersonaje {
	protected String nombre;
	
	// Posiciones
	protected int xInicio;
	protected int yInicio;
	protected int xDestino;
	protected int yDestino;
	protected Camara camara;
	protected boolean enMovimiento;
	protected int movimiento;
	protected boolean parado;
	protected int movimientoAnterior;
	protected Animacion[] animacionCaminado;

	public TilePersonaje(String sprite, String nombre, Camara camara) {
	this.nombre = nombre;
	this.camara = camara;
	inicializarAnimaciones("src\\main\\resources\\personajes\\"+sprite+".png");

	}
	public void inicializarAnimaciones(String pathPJ) {
		Sprite spriteCaminando =  new Sprite(pathPJ);
		animacionCaminado = new Animacion[8];
		for (int i = 0; i < animacionCaminado.length; i++) {
			animacionCaminado[i] = new Animacion(100, spriteCaminando.getVectorSprite(i));
		}
	}
	public void actualizarAnimaciones() {
		for (int i = 0; i < 8; i++) {
			animacionCaminado[i].actualizar();
		}

	}

	public BufferedImage obtenerFrameActual() {
		if (!parado)
			return animacionCaminado[movimiento].getFrameActual();
		return animacionCaminado[movimientoAnterior].getFrame(8);
	}


	// Esto lo podria resolver con un 1 byte en c++ ¬¬
	public void paraDondeVoy(int xDestino2, int yDestino2) {
		movimiento = 0;
		parado = false;

		if (xInicio == xDestino2 && yInicio == yDestino2) { // parado
			parado = true;
			return; 
		}
		if (xInicio > xDestino2 && yInicio > yDestino2) {// sur
			movimiento = 6;
			return;
		}
		if (xInicio > xDestino2 && yInicio == yDestino2) { // sureste 
			movimiento = 5;
			return;
		}
		if (xInicio > xDestino2 && yInicio < yDestino2) {// este
			movimiento = 4;
			return;
		}
		if (xInicio == xDestino2 && yInicio < yDestino2) {// noreste
			movimiento = 3;
			return;
		}
		if (xInicio < xDestino2 && yInicio == yDestino2) {// noroeste
			movimiento = 1;
			return;
		}
		if (xInicio < xDestino2 && yInicio > yDestino2) {// oeste
			movimiento = 0;
			return;
		}
		if (xInicio == xDestino2 && yInicio > yDestino2) {// suroeste
			movimiento = 7;
			return;
		}
		if (xInicio < xDestino2 && yInicio < yDestino2) {// norte
			movimiento = 2;
			return;
		}
	}
	
	@Override
	public String toString() {
		return this.nombre +" "+xDestino+" : "+yDestino;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getXDestino() {
		return xDestino;
	}

	public int getYDestino() {
		return yDestino;
	}
	
	public int getyAnterior() {
		return yInicio;
	}
	public int getxAnterior() {
		return xInicio;
	}
}
