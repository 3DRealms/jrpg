package mapa;

public class Ubicacion {

	private int x;
	private int y;
	protected int z;

	public Ubicacion(int coorX, int coorY) {
		this.x = coorX;
		this.y = coorY;
		this.z=0;
	}
	/**
	 * preguntar Lucas, si usar un par de if
	 * o if else
	 * o un SWITCH !!!!!!!
	 * o nose :3 
	 * por ahora 4 direcciones, pero son eight.
	 * @param dir
	 */
	public void desplazar(String dir){
		/**
		 * El hermoso switch para desplazarce a voluntad.
		 * valido para coordenadas isometricas.
		 */
		switch (dir) {
		case "N":
			x--;
			y--;
			break;
		case "NE":
			y--;
			break;
		case "E":
			x++;
			y--;
			break;
		case "SE":
			x++;
			break;
		case "S":
			x++;
			y++;
			break;
		case "SO":
			y++;
			break;
		case "O":
			x--;
			y++;
			break;
		case "NO":
			x--;
			break;
		}


	}

	public boolean delanteDe(Ubicacion obj){
		return false;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int coorX) {
		x = coorX;
	}
	public void setY(int coorY) {
		y = coorY;
	}
	/**
	 * Si es negativo esta a la izquierda.
	 * Si es positivo esta a la derecha.
	 * si es 0 estan en la misma posicion.
	 */
	public double calcularDistancia(Ubicacion otraUbic) {
		double cateto1 = x - otraUbic.getX();
		double cateto2 = y - otraUbic.getY();
		double hipotenusa = Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
		return hipotenusa;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	public boolean comparar(Ubicacion ubic) {
		return this.x == ubic.x && this.y == ubic.y;
	}
}