package habilidad;


import personaje.Personaje;

public class HabilidadFisica extends Habilidad{


	public HabilidadFisica(String nombre, String efecto, String descripcion, int costo, int nivel, int cantEfecto,
			int velocidad) {
		super(nombre, efecto, descripcion, costo, nivel, cantEfecto, velocidad);

	}

	@Override
	public void afectar(Personaje victima, int estado,int ataqueFisico) {
		victima.serAtacadoFisico(calcularFinal(ataqueFisico));
	}

	private int calcularFinal(int ataqueFisico) {
		return cantEfecto+ataqueFisico;
	}

}
