package juego;

public class Camara {
	public final int xOffCamara;
	public final int yOffCamara; 
	public final int alto;
	public final int ancho;
	public int getxOffCamara() {
		return xOffCamara;
	}

	public int getyOffCamara() {
		return yOffCamara;
	}

	public Camara(int ancho, int alto, int xCamara, int yCamara) {

		int x0 = xCamara; //ancho/2
		int y0 = yCamara;
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

	public int getAlto() {
		return alto;
	}

}
