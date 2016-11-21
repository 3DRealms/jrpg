package batalla;

import java.util.ArrayList;
import java.util.List;

public class EquipoSimple {
	
	List<PersonajeSimple> personajes;
	
	public EquipoSimple(){
		personajes = new ArrayList<PersonajeSimple>();
	}
	
	public void agregarPersonaje(String nombre, int vida, int energia, int vidaAct, int energiaAct, String sprite){
		personajes.add(new PersonajeSimple(nombre,vida,energia,vidaAct,energiaAct,sprite));
	}

	public List<PersonajeSimple> getPersonajes() {
		return personajes;
	}

}
