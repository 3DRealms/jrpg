package sprites;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Sprite {
	public static BufferedImage[] piso;

	public static BufferedImage pelado, cubo;
	private static final int ancho = 64, alto = 32;
	private static final int altoObjeto = 64;
	private static final int anchopj = 128, altopj = 128;
	private static final int framesPJ = 9;
	private static final int dirreciones = 8;
	private static final int cantidadSprite = 6;
	public static final BufferedImage click = CargaImagen.cargarImagen("src\\main\\resources\\click.png");
	/**
	 * Esto va a ser para las animaciones del pj, todavia no esta listo
	 */
	private BufferedImage[][] sprite;
	

	public static BufferedImage[] estandar;


	public Sprite(String pathPJ) {
		HojaSprite hojaPJ = new HojaSprite(CargaImagen.cargarImagen(pathPJ));
		sprite = new BufferedImage[dirreciones][framesPJ];

		for (int i = 0; i < 8; i++) {
			recortarSprite(hojaPJ,i+1,framesPJ,i,sprite[i]);
		}	
	}

	public static void inicializar(String pathPiso){
		HojaSprite hoja = new HojaSprite(CargaImagen.cargarImagen(pathPiso));


		piso = new BufferedImage[cantidadSprite];

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

	public BufferedImage[] getVectorSprite(int i ) {
		return sprite[i];
	}
	public static Image getImagePiso(int sprite) {
		return piso[sprite];
	}
	public static Image loadImage(String path) {
		return new ImageIcon(path).getImage();
	}



}