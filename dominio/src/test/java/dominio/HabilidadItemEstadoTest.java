package dominio;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import database.SQLiteJDBC;
import habilidad.Habilidad;
import itemEquipo.PaloDeEscobaMagico;
import itemEquipo.VaritaMagica;
import personaje.Personaje;
import raza.Mognatal;
import raza.PersonajePrueba;

public class HabilidadItemEstadoTest {

	@Test
	public void equipoSubeIntelectoYAtaco() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Personaje braian = new Mognatal("gandalf");
	
		braian.setCastaMago();
		braian.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
		
		Personaje alex = new PersonajePrueba("pichon"); //creo un pichon.

		int alexSalud = alex.getSaludActual();
			
		braian.equipar( new PaloDeEscobaMagico()); //Aca le equipo un item.
		braian.lanzarHabilidad("piroexplosion", alex);

		//La piroExplicion +  palo de escoba magico (que sube 5 de intelecto) quita 52 puntos de daño.
		Assert.assertEquals( alexSalud - 52, alex.getSaludActual());

	}

	@Test
	public void equipoDosItemQueSubeIntelectoYAtaco() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();

		Personaje braian = new Mognatal("gandalf");
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		braian.setCastaMago();
		braian.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));

		Personaje alex = new PersonajePrueba("pichon"); 
		int alexSalud = alex.getSaludActual();
		
		braian.equipar(new PaloDeEscobaMagico());	//Aca le equipo un item.		| 5 +
		braian.equipar(new VaritaMagica() );			//Aca le equipo otro item.	| 10 =
		braian.lanzarHabilidad("piroexplosion", alex);	//							| 15 de intelecto.
		Assert.assertEquals( alexSalud - 57, alex.getSaludActual());
		// La piroExplicion +  palo de escoba magico + varita Magica
		// quita 57 puntos de daño.
	}

}
