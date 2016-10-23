package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import habilidades.PiroExplosion;
import habilidades.RayoDeInteligencia;
import personaje.Personaje;
import raza.Humano;
import raza.Mognatal;
import raza.PersonajePrueba;

public class HabilidadTests {
	/**
	 *  Especificacion de habilidades
	 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *  piroExplosion: Revienta a un elemigo con una explosion arcana que consume su miseria en dolor.
	 */
	@Test
	public void quePuedoAgregarHabilidad() {
		Mognatal dani = new Mognatal("dani");
		dani.setCastaMago();
		Assert.assertEquals(0, dani.getCasta().getCantidadDeHabilidades());
		dani.agregarHabilidad("piroExplosion", new PiroExplosion());
		Assert.assertEquals(1, dani.getCasta().getCantidadDeHabilidades());
	}

	@Test
	public void queUnPersonajePuedeLanzarHabilidadPorNombre() {
		Mognatal dani = new Mognatal("dani");
		dani.setCastaMago();
		dani.agregarHabilidad("piroExplosion", new PiroExplosion());

		//Creo un personaje para atacarlo.
		Personaje alex = new PersonajePrueba("alex");
		int alexSalud = alex.getSaludActual();
		dani.lanzarHabilidad("piroExplosion", alex); 
		System.out.println(alex.getSaludActual());
		// Piro Explosion quita 20 puntos de vida. 
		Assert.assertEquals( alexSalud - 20, alex.getSaludActual());
	}


	@Test
	public void queUnaHabilidadEscaleConIntelecto() {
		Mognatal dani = new Mognatal("dani");
		dani.setCastaMago();
		dani.agregarHabilidad("piroExplosion", new PiroExplosion());
		Personaje alex = new PersonajePrueba("alex");
		int alexSalud = alex.getSaludActual();

		//Aumento El intelecto
		dani.subirIntelecto(5);
		dani.lanzarHabilidad("piroExplosion", alex); 

		// Piro Explosion quita 40 puntos de vida, al tener mas intelecto, pega 20 pntos mas (aguante la PiroExplosion).
		Assert.assertEquals(alexSalud-40, alex.getSaludActual());
	}

	@Test
	public void sinEnergia() {

		Personaje dani = new Humano("Dr.Coffee"); // El humano tiene  100 de energia base
		dani.setCastaMago();
		dani.agregarHabilidad("piroExplosion", new PiroExplosion());

		//Lanzo 2 habilidades para quedar con poca energia,cada piroExplosion gasta 35 (osea 70pnts total gasto).
		Personaje pichon = new Mognatal("bot1");
		dani.lanzarHabilidad("piroExplosion", pichon); 
		dani.lanzarHabilidad("piroExplosion", pichon);

		//aca no tiene mas energia porque ya quede en 30 y PiroExplocion consume 35.
		Assert.assertFalse( dani.lanzarHabilidad("piroExplosion", pichon) ); 

	}
	@Test
	public void verHabilidad(){
		Personaje dani = new Mognatal("Dr.Coffee");
		dani.setCastaMago();
		dani.agregarHabilidad("piroExplosion", new PiroExplosion());
		dani.agregarHabilidad("rayoDeInteligencia", new RayoDeInteligencia());
		//		System.out.println(dani.verHabilidades()); // LUCAS OSEA TENGO QUE VERLO YO OSEA CALMATE UN POCO.
		Assert.assertEquals("Habilidades:\npiroExplosion\nrayoDeInteligencia\n", dani.verHabilidades());
	}

}
