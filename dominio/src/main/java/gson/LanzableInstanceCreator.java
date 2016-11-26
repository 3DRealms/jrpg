package gson;

import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

import batalla.EquipoJugadores;

import interfaces.Equipo;
import item.ItemCurativa;
import item.ItemLanzable;

public class LanzableInstanceCreator implements InstanceCreator {
	public ItemLanzable createInstance(Type type) {
	    return new ItemCurativa();
	}
} 