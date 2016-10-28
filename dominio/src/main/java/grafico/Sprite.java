package grafico;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public final class Sprite {
	private final int lado; //tamaño del sprite ej: 32x32
	private int x;
	private int y; //coordenadas para sacar del la hoja de sprite.
	private int[] pixeles;
	private final SpriteSheet spriteSheet;
	private boolean visible; 	// si esta visible o no


	public Sprite(final int lado,final int columna, final int fila,final SpriteSheet spriteSheet){
		this.lado = lado;
		this.pixeles = new int[lado*lado];
		
		this.x = columna*lado;
		this.y = fila*lado;
		
		this.spriteSheet = spriteSheet;
		
		for (int i = 0; i < pixeles.length; i++) {
			for (int j = 0; j < pixeles.length; j++) {
				pixeles[j + i * lado] = spriteSheet.getPixeles(sacarSprite(spriteSheet, i, j) );
			}
		}
	}

	private int sacarSprite(final SpriteSheet spriteSheet, int y, int x) {
		return (x + this.x) + (y+this.y) * spriteSheet.getAncho();
	}

	/**
	 * Pegamos el Sprite en la pantalla
	 * @param grafico
	 * @param coordenadaHorizontal
	 * @param coordenadaVertical
	 */
	public void putSprite(Graphics grafico,int coordenadaHorizontal,int coordenadaVertical){
		x=coordenadaHorizontal;
		y=coordenadaVertical;
		if (visible)
			grafico.drawImage(pixeles, x, y, null);
	}
}
