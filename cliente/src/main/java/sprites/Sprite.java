package sprites;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Sprite {
	public static BufferedImage[] piso;

	public static BufferedImage pelado, cubo;
	private static final int ancho = 64, alto = 32;
	private static final int altoObjeto = 64;
	private static final int anchopj = 64, altopj = 64;

	/**
	 * Esto va a ser para las animaciones del pj, todavia no esta listo
	 */
	public static BufferedImage[] pjArriba= new BufferedImage[5] ;
	public static BufferedImage[] pjAbajo= new BufferedImage[5];
	public static BufferedImage[] pjDerecha= new BufferedImage[5];
	public static BufferedImage[] pjIzquierda= new BufferedImage[5];
	public static BufferedImage[] pjArribaDerecha= new BufferedImage[5];
	public static BufferedImage[] pjArribaIzquierda= new BufferedImage[5];
	public static BufferedImage[] pjAbajoDerecha= new BufferedImage[5];
	public static BufferedImage[] pjAbajoIzquierda = new BufferedImage[5];
	
	

	public static BufferedImage[] estandar;

	public static void inicializar(String pathPiso,String pathPJ){
		HojaSprite hoja = new HojaSprite(CargaImagen.cargarImagen(pathPiso));
		//HojaSprite hojapj = new HojaSprite(CargaImagen.cargarImagen(pathPJ));
		HojaSprite hojaPelado = new HojaSprite(CargaImagen.cargarImagen(pathPJ));
		System.out.println(pathPJ);
		recortarSprite(hojaPelado,1,5,0,pjAbajo);
		recortarSprite(hojaPelado,3,5,2,pjDerecha);
		recortarSprite(hojaPelado,7,5,6,pjIzquierda);
		recortarSprite(hojaPelado,5,5,4,pjArriba);
		recortarSprite(hojaPelado,4,5,3,pjArribaDerecha);
		recortarSprite(hojaPelado,6,5,5,pjArribaIzquierda);
		recortarSprite(hojaPelado,2,5,1,pjAbajoDerecha);
		recortarSprite(hojaPelado,8,5,7,pjAbajoIzquierda);
		
		piso = new BufferedImage[6];

		int k = 0;

		for (int i = 0; i <  2 ;i++) {
			for (int j = 0; j < 3; j++) {
				if(j<2)
					piso[k] =  hoja.cortar(ancho*i, alto*j, ancho, alto);
				else
					piso[k] =  hoja.cortar(ancho*i, alto*j, ancho, altoObjeto);
				k++;
			}
		}


			//cubo =hojapj.cortar(0, 0, 64, 64);
		//	pelado = hojapj.cortar(anchopj, 0, anchopj, altopj);
	}
	/**
	 * Funcion para cortar sprites y cargarlos en un vector de bufferedImage
	 * previamente inicializado.
	 * 
	 * @param hoja la hoja de sprites
	 * @param cantFila la cantidad de elementos en vertical
	 * @param numElementosColumna cantidad de elementos en horizontal
	 * @param cortaDesdeAca desde donde cortar
	 * @param vector el vector de bufferedImage
	 */
	public static void recortarSprite(HojaSprite hoja, int cantFila,
			int numElementosColumna,int cortaDesdeAca, BufferedImage[] vector){
		int x = 0;

		for (int i = cortaDesdeAca; i < cantFila; i++) {
			for (int j = 0; j < numElementosColumna; j++) {
				vector[x] = hoja.cortar(anchopj*j, altopj*i, anchopj, altopj);
				x++;
			}
		}
	}

	public static Image getImagePiso(int sprite) {
		return piso[sprite];
	}
	public static Image loadImage(String path) {
		return new ImageIcon(path).getImage();
	}


}