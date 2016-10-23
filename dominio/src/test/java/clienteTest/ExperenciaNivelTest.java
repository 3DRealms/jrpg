package clienteTest;



import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.Mognatal;
import raza.PersonajePrueba;

public class ExperenciaNivelTest {
	
	@Test
	public void subirEXP() {
		Personaje dani = new Mognatal("n00b");
		
		Assert.assertEquals( 0, dani.getExperiencia());
		dani.subirExperencia(10);
		Assert.assertEquals( 10, dani.getExperiencia());
	}
	
	@Test
	public void subirExperienciaYSubirNivel() {
		Personaje dani = new Mognatal("n00b");
		
		Assert.assertEquals( 0, dani.getNivel());
		dani.subirExperencia(100);
		Assert.assertEquals( 1 , dani.getNivel());
	}
	@Test
	public void subir2Niveles() {
		Personaje dani = new Mognatal("n00b");
		dani.subirExperencia(100);
		dani.subirExperencia(150); // Proximo nivel 200 exp
		Assert.assertEquals( 2 , dani.getNivel());
	}
	@Test
	public void subir3Niveles() {
		Personaje dani = new Mognatal("n00b");
		dani.subirExperencia(100);
		dani.subirExperencia(150); // Proximo nivel 200 exp
		dani.subirExperencia(200); // Proximo nivel 250 exp
		Assert.assertEquals( 3 , dani.getNivel());
	}
	@Test
	public void subir4Niveles() {
		Personaje dani = new Mognatal("n00b");
		dani.subirExperencia(100);
		dani.subirExperencia(150); // Proximo nivel 200 exp
		dani.subirExperencia(200); // Proximo nivel 250 exp
		dani.subirExperencia(250); // Proximo nivel 300 exp
		Assert.assertEquals( 4 , dani.getNivel());
	}
	@Test
	public void subirMaximoNivele() {
		Personaje dani = new PersonajePrueba("pr0M4sterR4c3PCG4M3R");
		dani.subirExperencia(300000); // Proximo nivel - exp
		Assert.assertEquals( 100 , dani.getNivel());
	}
	
	

}
