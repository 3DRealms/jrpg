package sprites;

import java.awt.image.BufferedImage;

public class HojaSprite {
	private BufferedImage hoja;
	
	public HojaSprite(BufferedImage sheet) {
		this.hoja = sheet;
	}
	
	public BufferedImage cortar(int x, int y, 
			int ancho, int alto){
		return hoja.getSubimage(x, y, ancho, alto);
	}

}
