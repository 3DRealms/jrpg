package grafico;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings( { "unused", "serial" } ) // Preguntar Lucas.
public final class SpriteSheet extends JPanel
{
	private int x,y;		 	//coordenadas
	private String pathSprite; 		// el path de la imagen
	private final int[] pixeles;
	private final int ancho,alto;

	
	public SpriteSheet(int x, int y, String pathSprite,final int ancho,final int alto) {
		this.x = x;
		this.y = y;
		this.pathSprite = pathSprite;
		this.ancho = ancho;
		this.alto = alto;
		this.pixeles = new int[ancho*alto];
		
		BufferedImage imagen;
		try {
			imagen =  ImageIO.read(SpriteSheet.class.getResource(pathSprite));
			
			imagen.getRGB(0,0, ancho, alto, pixeles, 0, ancho);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public int getPixeles(int coor) {
		return pixeles[coor];
	}



	public int getAncho() {
		return this.ancho;
	}
	



}