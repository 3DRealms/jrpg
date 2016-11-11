package dominio;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import database.SQLiteJDBC;
import habilidad.Habilidad;
import item.ItemEquipo;
import personaje.Personaje;
import raza.Mognatal;
import raza.PersonajePrueba;

public class HabilidadItemEstadoTest {

	@Test
	public void equipoSubeIntelectoYAtaco() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Map<String, ItemEquipo> equipables = SQLiteJDBC.obtenerEquipables();
		Personaje braian = new Mognatal("gandalf");
	
		braian.setCastaMago();
		braian.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
		
		Personaje alex = new PersonajePrueba("pichon"); //creo un pichon.

		int alexSalud = alex.getSaludActual();
			
		braian.equipar( equipables.get("PaloDeEscoba")); //Aca le equipo un item.
		braian.lanzarHabilidad("piroexplosion", alex);

		//La piroExplicion +  palo de escoba magico (que sube  12 de intelecto) quita 56 puntos de daño.
		Assert.assertEquals( alexSalud - 56, alex.getSaludActual());

	}

	@Test
	public void equipoDosItemQueSubeIntelectoYAtaco() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Personaje braian = new Mognatal("gandalf");
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Map<String, ItemEquipo> equipables = SQLiteJDBC.obtenerEquipables();

		braian.setCastaMago();
		braian.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));

		Personaje alex = new PersonajePrueba("pichon"); 
		int alexSalud = alex.getSaludActual();
		
		braian.equipar( equipables.get("PaloDeEscoba") );			//Aca le equipo un item.	| 12 +
		braian.equipar( equipables.get("VaritaMagica") );			//Aca le equipo otro item.	| 20 =
		braian.lanzarHabilidad("piroexplosion", alex);				//							| 32 de intelecto.
		Assert.assertEquals( alexSalud - 60, alex.getSaludActual());
		// La piroExplicion +  palo de escoba magico + varita Magica
		// quita 57 puntos de daño.
	}

}
