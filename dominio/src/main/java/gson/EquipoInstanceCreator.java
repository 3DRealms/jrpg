package gson;

import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

import batalla.EquipoJugadores;

import interfaces.Equipo;

public class EquipoInstanceCreator implements InstanceCreator {
	public Equipo createInstance(Type type) {
	    return new EquipoJugadores();
	}
} 