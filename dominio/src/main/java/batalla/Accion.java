package batalla;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import habilidades.Habilidad;
import personaje.Personaje;

public class Accion {
	//DON'T HAVE TIME.
	Personaje emisor;
	Personaje receptor;
	String lanzable;
	
   final Map<String, Runnable> methodMap = new HashMap<String, Runnable>();
	
	int velocidad;

	public Accion(Personaje e,	Personaje r,String a){
		emisor = e;
		receptor = r;
		lanzable = a;
//		velocidad = e.getVelocidad() + a.velocidad();
		
		methodMap.put("habilidad", new Runnable() {
            public void run() { emisor.lanzarHabilidad(lanzable, receptor); };
        });
		
		methodMap.put("objeto", new Runnable() {
            public void run() { emisor.lanzarItem(lanzable, receptor); };
        });		
		methodMap.put("defender", new Runnable() {
            public void run() { emisor.defenderse(); };
        });
		methodMap.put("huir", new Runnable() {
            public void run() { emisor.lanzarItem(lanzable, receptor); };
        });
		
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

	public void ejecutar() {
		
			
	}
}
