package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.PersonajePrueba;

/**
 * 	Se entiende por estado a todo atributo que afecta de manera positiva a mi personaje.
 * 	PersonajePrueba:
 *	ataque = 15;
 *	energiaBase = 100;
 *	saludBase = 120;
 * 	fuerza = 0;  
 *	intelecto = 0;
 *	destreza = 0;
 *	vitalidad = 0;
 * */
public class SubirEstadosDelPersonajeTest {
	
	@Test
	public void subirVitalidad() {
		Personaje pj = new PersonajePrueba("ZuCuLeNTo");
		pj.subirExperencia(1000);
		int saludpj = pj.getSaludActual();
		//Subo 5 puntos de vitalidad
		pj.subirVitalidad();
		pj.subirVitalidad();
		pj.subirVitalidad();
		pj.subirVitalidad();
		pj.subirVitalidad();
		
		Assert.assertEquals(5, pj.getVitalidad());
		// Cada 5 puntos aumenta 20 de vida.
		Assert.assertEquals(saludpj + 20, pj.getSaludActual());
	}
	@Test
	public void subirDestreza() {
		Personaje pj = new PersonajePrueba("ZuCuLeNTo");
		int energiapj = pj.getEnergia();
		pj.subirExperencia(1000);

		//Subo 5 puntos de destreza.
		
		pj.subirDestreza();
		pj.subirDestreza();
		pj.subirDestreza();
		pj.subirDestreza();
		pj.subirDestreza();
		
		Assert.assertEquals( 5, pj.getDestreza());
		// Cada 5 puntos aumenta 10 de energia.
		Assert.assertEquals(energiapj + 10, pj.getEnergia());
	}
	@Test
	public void subirIntelecto() {
		Personaje pj = new PersonajePrueba("ZuCuLeNTo");
		pj.subirExperencia(1000);
		//Subo 5 puntos de intelecto.
		pj.subirIntelecto();
		pj.subirIntelecto();
		pj.subirIntelecto();
		pj.subirIntelecto();
		pj.subirIntelecto();

		Assert.assertEquals( 5 , pj.getIntelecto());
	}
	@Test
	public void subirFuerza() {
		Personaje pj = new PersonajePrueba("ZuCuLeNTo");
		pj.subirExperencia(1000); //Tengo 10 puntos
		int ataquepj = pj.obtenerPuntosDeAtaqueFisico();
		//Subo 5 puntos de fuerza.
		pj.subirFuerza();
		pj.subirFuerza();
		pj.subirFuerza();
		pj.subirFuerza();
		pj.subirFuerza();

		Assert.assertEquals( 5 , pj.getFuerza());
		Assert.assertEquals( ataquepj + 10 , pj.obtenerPuntosDeAtaqueFisico());
	}
	
}