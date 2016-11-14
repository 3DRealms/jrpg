package juego;

public class Camara {
	private final int xOffCamara;
	private final int yOffCamara; 
	private final int alto;
	private final int ancho;

	public Camara(int ancho, int alto) {
	//	int xCamara= ancho/2 - (ancho/2)%32;
	//	int yCamara = alto/2 - (alto/2)%32;
		int x0 = 320; //ancho/2
		int y0 = 320;
		this.alto = alto;
		this.ancho = ancho;
		int auxX = y0 + (x0 / 2);
		int auxY = y0 - (x0 / 2);
		if(auxX < 0)
			auxX -= 31; // 32X64
		if(auxY < 0)
			auxY -= 31;
		auxX /= 32;
		auxY /= 32;
		xOffCamara = auxX+1; 
		yOffCamara = auxY+1;
	}
	
	public int getxOffCamara() {
		return xOffCamara;
	}

	public int getyOffCamara() {
		return yOffCamara;
	}

	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
		return alto;
	}


}
