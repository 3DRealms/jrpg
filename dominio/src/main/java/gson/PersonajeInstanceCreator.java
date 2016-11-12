package gson;

import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

import personaje.Personaje;
import raza.Humano;


public class PersonajeInstanceCreator implements InstanceCreator {
	public Personaje createInstance(Type type) {
	    return new Humano();
	}
} 