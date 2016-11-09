package juego;

public class Camara {
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	
	public int xOffCamara; 
	public int yOffCamara; 
	
	public Camara(int ancho, int alto, int xCamara, int yCamara) {

		int x0 = xCamara; //ancho/2
		int y0 = yCamara;

		int auxX = y0 + (x0 / 2);
		int auxY = y0 - (x0 / 2);

		if(auxX < 0)
			auxX -= 31; // 32X64
		if(auxY < 0)
			auxY -= 31;


		auxX /= 32;
		auxY /= 32;
		
		xOffCamara = auxX; 
		yOffCamara = auxY;
	}

}
