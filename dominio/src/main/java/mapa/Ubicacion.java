package mapa;

public class Ubicacion {
	double x;
	double y;
	double z;
	
	public Ubicacion(double coorX, double coorY) {
		this.x = coorX;
		this.y = coorY;
		this.z=0;
	}
	/**
	 * preguntar Lucas, si usar un par de if
	 * o un SWITCH !!!!!!!
	 * o nose :3 
	 * por ahora 4 direcciones pero son eight
	 * @param dir
	 */
	public void desplazar(String dir){
		if(dir == "N"){
			y++;
		}else if(dir == "S"){
			y--;
		}else if(dir == "O"){
			x--;
		}else if(dir == "E"){
			x++;
		}
	}
	public boolean delanteDe(Ubicacion obj){
		return false;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
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
}

