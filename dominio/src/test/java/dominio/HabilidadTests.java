package dominio;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import database.SQLiteJDBC;
import habilidad.*;
import personaje.Personaje;
import raza.Humano;
import raza.Mognatal;
import raza.PersonajePrueba;

public class HabilidadTests {
	/**
	 *  Especificacion de habilidades
	 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *  piroExplosion: Revienta a un elemigo con una explosion arcana que consume su miseria en dolor.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void quePuedoAgregarHabilidad() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Mognatal dani = new Mognatal("dani");
		dani.setCastaMago();
		Assert.assertEquals(0, dani.getCasta().getCantidadDeHabilidades());
		dani.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
		Assert.assertEquals(1, dani.getCasta().getCantidadDeHabilidades());
	}

	@Test
	public void queUnPersonajePuedeLanzarHabilidadPorNombre() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Mognatal dani = new Mognatal("dani");
		dani.setCastaMago();
		dani.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));

		//Creo un personaje para atacarlo.
		Personaje alex = new PersonajePrueba("alex");
		int alexSalud = alex.getSaludActual();
		dani.lanzarHabilidad("piroexplosion", alex); 
		//System.out.println(alexSalud + " - " + alex.getSaludActual());
		// Piro Explosion quita 20 puntos de vida. 
		Assert.assertEquals( alexSalud - 50, alex.getSaludActual());
		
	}


	@Test
	public void queUnaHabilidadEscaleConIntelecto() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Mognatal dani = new Mognatal("dani");
		dani.setCastaMago();
		dani.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
		Personaje alex = new PersonajePrueba("alex");
		int alexSalud = alex.getSaludActual();
		
		dani.subirExperencia(1000); //Subo 5 niveles para tener puntos.
		//Aumento El intelecto
		dani.subirIntelecto();
		dani.subirIntelecto();
		dani.subirIntelecto();
		dani.subirIntelecto();
		dani.subirIntelecto();
		
		dani.lanzarHabilidad("piroexplosion"  , alex); 

		// Piro Explosion quita 40 puntos de vida, al tener mas intelecto, pega 20 pntos mas (aguante la PiroExplosion).
		//Perdon dani _:, nerfie piroexplosion, I'm sorry man, I'm sorry, ahora solo sube un punto mas
		Assert.assertEquals(alexSalud-51, alex.getSaludActual());
	}
	@Test
	public void lanzoUnaHabilidadQueNoTengo() {
		Personaje braian = new Mognatal("gandalf");
		braian.setCastaMago();
		Personaje alex = new PersonajePrueba("pichon"); //creo un pichon.
		Assert.assertFalse(braian.lanzarHabilidad("escudoDivino", alex));
	}
	
	@Test
	public void sinEnergia() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Personaje dani = new Humano("Dr.Coffee"); // El humano tiene  100 de energia base
		dani.setCastaMago();
		dani.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
		
		//Lanzo 2 habilidades para quedar con poca energia,cada piroExplosion gasta 35 (osea 70pnts total gasto).
		Personaje pichon = new Mognatal("bot1");
		dani.lanzarHabilidad("piroExplosion", pichon); 
		dani.lanzarHabilidad("piroExplosion", pichon);

		//aca no tiene mas energia porque ya quede en 30 y PiroExplocion consume 35.
		Assert.assertFalse( dani.lanzarHabilidad("piroExplosion", pichon) ); 

	}
	@Test
	public void verHabilidad() throws ClassNotFoundException, SQLException{
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Personaje dani = new Mognatal("Dr.Coffee");
		dani.setCastaMago();
		dani.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
		dani.agregarHabilidad("cadenarelampago", habilidades.get("cadenarelampago"));
		Assert.assertEquals("Habilidades:\ncadenarelampago\npiroexplosion\n", dani.verHabilidades());
		
		
	}

}
