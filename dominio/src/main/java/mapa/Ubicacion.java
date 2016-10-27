package mapa;

public class Ubicacion {
	int x;
	int y;
	int z;
	public Ubicacion(int coorX, int coorY) {
		this.x = coorX;
		this.y = coorY;
		this.z=0;
	}
	/**
	 * preguntar Lucas, si usar un par de if
	 * o un SWITCH !!!!!!!
	 * o nose :3 
	 * @param dirr
	 */
	public void desplazar(String dirr){
		if(dirr == "N"){
			y++;
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
	
	/**
	 * Si es negativo esta a la izquierda.
	 * Si es positivo esta a la derecha.
	 * si es 0 estan en la misma posicion.
	 */
	public int calcularDistancia(Ubicacion otraUbic) {
		int cateto1 = x - otraUbic.getX();
		int cateto2 = y - otraUbic.getY();
		
		int hipotenusa = (int) Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
		
		return hipotenusa;
	}
}

