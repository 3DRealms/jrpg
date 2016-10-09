package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import habilidades.PiroExplosion;
import personaje.Personaje;
import raza.Mognatal;

public class HechizosTests {

	@Test
	public void quePuedoAgregarHechizos() {
		Mognatal gandalf = new Mognatal();
		gandalf.setCastaMago();
		Assert.assertEquals(0, gandalf.getCasta().getCantidadDeHabilidades());
		gandalf.getCasta().agregarHabilidad("piroExplosion", new PiroExplosion());
		Assert.assertEquals(1, gandalf.getCasta().getCantidadDeHabilidades());
	}

	@Test
	public void queUnPersonajePuedeHechizarPorNombre() {
		Mognatal gandalf = new Mognatal();
		gandalf.setCastaMago();
		gandalf.getCasta().agregarHabilidad("piroExplosion", new PiroExplosion());
		Personaje gimli = new Mognatal();
		Assert.assertEquals(120, gimli.getSaludActual());
		// Piro Explosion quita 20 puntos de vida. 
		gandalf.getCasta().lanzarHabilidad("piroExplosion", gimli); 
	}
	@Test
	public void queUnaHabilidadEscaleConIntelecto() {
		Mognatal gandalf = new Mognatal();
		gandalf.setCastaMago();
		gandalf.getCasta().agregarHabilidad("piroExplosion", new PiroExplosion());
		Personaje gimli = new Mognatal();
		Assert.assertEquals(120, gimli.getSaludActual());
		
		gandalf.getCasta().lanzarHabilidad("piroExplosion", gimli); 	
		Assert.assertEquals(100, gimli.getSaludActual());
	
		//Aumento El intelecto
		gandalf.subirIntelecto(5);
		gandalf.getCasta().lanzarHabilidad("piroExplosion", gimli); 
		
		// Piro Explosion quita 40 puntos de vida, al tener mas intelecto, pega 20 pntos mas.
		Assert.assertEquals(60, gimli.getSaludActual());
	}
	@Test
	public void quePorFaltaDeEnergiaNoPuedaLanzarUnaHabilidad() {
		Mognatal gandalf = new Mognatal();
		gandalf.setCastaMago();
		gandalf.getCasta().agregarHabilidad("piroExplosion", new PiroExplosion());
		Personaje gimli = new Mognatal();
		Assert.assertEquals(120, gimli.getSaludActual());
		gandalf.getCasta().lanzarHabilidad("piroExplosion", gimli); 
		
		Assert.assertEquals(100, gimli.getSaludActual());
		gandalf.subirIntelecto(5);
		gandalf.getCasta().lanzarHabilidad("piroExplosion", gimli); 
		Assert.assertEquals(60, gimli.getSaludActual());
		
		//aca no tiene mas energia porque ya quede en 30 y PiroExplocion consume 35.
		Assert.assertFalse(gandalf.getCasta().lanzarHabilidad("piroExplosion", gimli)); 
	}

}
