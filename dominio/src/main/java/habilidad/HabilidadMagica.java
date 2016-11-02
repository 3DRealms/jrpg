package habilidad;


import personaje.Personaje;

public class HabilidadMagica extends Habilidad {
	

	public HabilidadMagica(String nombre, String efecto, String descripcion, int costo, int nivel, int cantEfecto,
			int velocidad) {
		super(nombre, efecto, descripcion, costo, nivel, cantEfecto, velocidad);
	}

	@Override
	public void afectar(Personaje victima, int estado,int ataque) {
		victima.serAtacadoMagico(calcularFinal(estado, ataque));
		
	}

	private int calcularFinal(int estado, int ataque) {
		return cantEfecto+(estado*ataque)/100;
	}


}