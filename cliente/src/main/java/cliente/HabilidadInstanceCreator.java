package cliente;

import java.lang.reflect.Type;

import habilidad.Habilidad;

public class HabilidadInstanceCreator {
	public Habilidad createInstance(Type type) {
	    return new HabilidadInstance();
	}
}
