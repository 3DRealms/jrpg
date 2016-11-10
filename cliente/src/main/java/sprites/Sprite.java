package sprites;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Sprite {
	public static BufferedImage[] piso;

	public static BufferedImage pelado, cubo;
	private static final int ancho = 64, alto = 32;
	private static final int altoObjeto = 64;


	/**
	 * Esto va a ser para las animaciones del pj, todavia no esta listo
	 */
	public static BufferedImage[] pjArriba;
	public static BufferedImage[] pjAbajo;
	public static BufferedImage[] pjDerecha;
	public static BufferedImage[] pjIzquierda;

	public static BufferedImage[] estandar;

	public static void inicializar(String pathPiso,String pathPJ){
		HojaSprite hoja = new HojaSprite(CargaImagen.cargarImagen(pathPiso));
		//	HojaSprite hojapj = new HojaSprite(CargaImagen.cargarImagen(pathPJ));
		piso = new BufferedImage[6];

		int k = 0;

		for (int i = 0; i <  2 ;i++) {
			for (int j = 0; j < 3; j++) {
				if(j<2)
					piso[k] =  hoja.cortar(ancho*i, alto*j, ancho, alto);
				else
					piso[k] =  hoja.cortar(ancho*i, alto*j, ancho, altoObjeto);
				k++;
				System.out.println(i+" "+j);
			}
		}


		//	cubo =hojapj.cortar(0, 0, anchopj, altopj);
		//	pelado = hojapj.cortar(anchopj, 0, anchopj, altopj);

	}

	public static void recortarSprite(HojaSprite hoja, int numElementosFila,
			int numElementosColumna){
		estandar = new BufferedImage[numElementosFila*numElementosColumna];
		int x = 0;

		for (int i = 0; i < numElementosFila; i++) {
			for (int j = 0; j < numElementosColumna; j++) {
				estandar[x] = hoja.cortar(ancho*j, alto*i, ancho, alto);
				x++;
			}
		}
	}

	public static Image getImagePiso(int sprite) {
		return piso[sprite];
	}



}
