package sprites;

import java.awt.image.BufferedImage;

public class Sprite {
	public static BufferedImage pasto, pastoFloreado, piso, blanco,negro,agua;
	public static BufferedImage pelado, cubo;
	private static final int ancho = 64, alto = 32;
	private static final int anchopj =64, altopj = 64;
	
	
	/**
	 * Esto va a ser para las animaciones del pj, todavia no esta listo
	 */
	public static BufferedImage[] pjArriba;
	public static BufferedImage[] pjAbajo;
	public static BufferedImage[] pjDerecha;
	public static BufferedImage[] pjIzquierda;
	
	
	
	public static void inicializar(){
		HojaSprite hoja = new HojaSprite(cargaImagen.cargarImagen("src/main/resources/mapas/sprites/spriteMapa.png"));
		HojaSprite hojapj = new HojaSprite(cargaImagen.cargarImagen("src/main/resources/mapas/sprites/spritepj.png"));
		pasto  = hoja.cortar(0, 0, ancho, alto);
		pastoFloreado = hoja.cortar(ancho, 0, ancho, alto);
		piso = hoja.cortar(ancho*2, 0, ancho, alto);
		agua = hoja.cortar(ancho*3, 0, ancho, alto);
		
		cubo =hojapj.cortar(0, 0, anchopj, altopj);
		pelado = hojapj.cortar(anchopj, 0, anchopj, altopj);
		
	}
	
	
	
}
