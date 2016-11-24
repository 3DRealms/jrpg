package acciones;

import java.util.Comparator;
import personaje.Personaje;

public abstract class Accion {
	//DON'T HAVE TIME.
	Personaje emisor;
	Personaje objetivo;
	int velocidad;
	String accion;
	String tipo;




	public int getVelocidad() {
		return velocidad;
	}
	public String getAccion() {
		return accion;
	}
	public String getTipo() {
		return tipo;
	}
	public Accion(Personaje emisor,	Personaje objetivo,String accion,String tipo){
		this.emisor = emisor;
		this.objetivo = objetivo;
		this.accion = accion;
		this.tipo = tipo;

	}
	@Override
	public String toString() {
		return emisor.toString()+" "+objetivo.toString()+" "+accion+" "+tipo;
	}


	public Personaje getEmisor() {
		return emisor;
	}
	public Personaje getObjetivo() {
		return objetivo;
	}

	public static Comparator<Accion> getAccVelComparator() {
		return AccVelComparator;
	}


	/**
	 * Comparador entre dos Acciones.
	 * Compara las velocidades. Si la accion 1 es mas veloz que la accion 2 es positivo
	 * si son iguales es 0, y si la accion 1 es mas lenta que la accion 2 es negativo.
	 */
	public static Comparator<Accion> AccVelComparator = new Comparator<Accion>() {
		public int compare(Accion a1 , Accion a2) {
			return a1.velocidad - a2.velocidad;
		}
	};

	public abstract void ejecutar();
}
