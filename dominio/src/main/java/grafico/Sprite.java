package grafico;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public final class Sprite {

	private Image sprite;
	private boolean visible = true; 	// si esta visible o no

	
	public Sprite(String sprite) {
		
		this.sprite = new ImageIcon(sprite).getImage();
	}


	public void putSprite(Graphics grafico,int coorX,int coorY){

		if (visible)
			grafico.drawImage(sprite, coorX, coorY, null);
	}
	
}



