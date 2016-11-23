package gson;

import java.lang.reflect.Type;

import com.google.gson.InstanceCreator;

import habilidad.Habilidad;
import habilidad.HabilidadInstance;

public class HabilidadInstanceCreator implements InstanceCreator {
	public Habilidad createInstance(Type type) {
	    return new HabilidadInstance();
	}
}
