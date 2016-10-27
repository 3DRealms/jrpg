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
		dani.subirExperencia(150); //250EXP = NIVEL 2.
		// Proximo nivel 200 exp
		Assert.assertEquals( 2 , dani.getNivel());
	}
	@Test
	public void subir3Niveles() {
		Personaje dani = new Mognatal("n00b");
		dani.subirExperencia(100);
		dani.subirExperencia(150);  //250EXP = NIVEL 2
		// Proximo nivel 200 exp
		dani.subirExperencia(200); 	//450EXP = NIVEL 3
		// Proximo nivel 250 exp
		Assert.assertEquals( 3 , dani.getNivel());
	}
	@Test
	public void subir4Niveles() {
		Personaje dani = new Mognatal("n00b");
		dani.subirExperencia(100);
		dani.subirExperencia(150); 
		dani.subirExperencia(200);
		dani.subirExperencia(250); //600EXP = NIVEL 4
		Assert.assertEquals( 4 , dani.getNivel());
	}
	@Test
	public void subirMaximoNivele() {
		Personaje dani = new PersonajePrueba("pr0M4sterR4c3PCG4M3R");
		dani.subirExperencia(300000); // Proximo nivel - exp
		Assert.assertEquals( 100 , dani.getNivel());
	}

	@Test
	public void subir1NivelYObtenerPuntos() {
		Personaje dani = new PersonajePrueba("Lucas_Videla");
		dani.subirExperencia(100); // 2 puntos en un nivel.
		Assert.assertEquals( 2 , dani.getPuntosDeEstados());
	}
	@Test
	public void subir2NivelYObtenerPuntos() {
		Personaje dani = new PersonajePrueba("sharingan");
		dani.subirExperencia(250); // 2 puntos en un nivel.
		Assert.assertEquals( 4 , dani.getPuntosDeEstados());
	}
	@Test
	public void subir10NivelYObtenerPuntos() {
		Personaje dani = new PersonajePrueba("pr0M4sterR4c3PCG4M3R");
		dani.subirExperencia(2800); // 2 puntos en un nivel.
		Assert.assertEquals( 20 , dani.getPuntosDeEstados());
	}
	@Test
	public void subirFormaDisparejaNivel() {
		Personaje dani = new PersonajePrueba("LocoDel22");
		dani.subirExperencia(10);
		Assert.assertEquals ( 0 , dani.getNivel());
		dani.subirExperencia(200); 
		dani.subirExperencia(450); 
		dani.subirExperencia(489); 
		dani.subirExperencia(99); 
		dani.subirExperencia(254); 
		dani.subirExperencia(900); 
		dani.subirExperencia(150); 
		dani.subirExperencia(50); 
		dani.subirExperencia(20); 
		dani.subirExperencia(100); 
		dani.subirExperencia(500); 
		Assert.assertEquals( 10 , dani.getNivel());
	}
	@Test
	public void sinExperienciaNivel0(){
		Personaje dani = new PersonajePrueba("LocoDel22");
		dani.subirExperencia(0);
		Assert.assertEquals ( 0 , dani.getNivel());
	}
	@Test
	public void pocaExperienciaNoSuboDeNivel(){
		Personaje dani = new PersonajePrueba("nacho");
		dani.subirExperencia(99);
		Assert.assertEquals ( 0 , dani.getNivel());
	}



}
