package batalla;

import java.util.Comparator;

import personaje.Personaje;

public class Accion {
	//DON'T HAVE TIME.
	Personaje emisor;
	Personaje receptor;
	
	String AYUDAPORFAVOR;
	
	int velocidad;

	public Accion(Personaje e,	Personaje r,String a){
		emisor = e;
		receptor = r;
		AYUDAPORFAVOR = a;
//		velocidad = e.getVelocidad() + a.velocidad();
	}

	public static Comparator<Accion> AccVelComparator = new Comparator<Accion>() {
		public int compare(Accion a1 , Accion a2) {
			return a1.velocidad - a2.velocidad;
		}
	};

	public void ejecutar() {
			// QUE SE YO, pero aca se tiene que ejecutar la accion.
	}
}
