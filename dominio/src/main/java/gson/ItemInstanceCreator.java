package gson;

import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

import item.ItemEquipo;
import personaje.Personaje;
import raza.Humano;


public class ItemInstanceCreator implements InstanceCreator {
	public ItemEquipo createInstance(Type type) {
	    return new ItemEquipo();
	}
} 