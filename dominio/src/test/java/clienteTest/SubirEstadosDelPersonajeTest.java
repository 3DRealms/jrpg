package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.Mognatal;

/**
 * 	Se entiende por estado a todo atributo que afecta de manera positiva a mi personaje.
 * 	EJ: vitalidad, fuerza, intelecto. 
 * */
public class SubirEstadosDelPersonajeTest {
	
	@Test
	public void subirVitalidad() {
		Personaje maguito = new Mognatal("Boger");
		int saludMaguito = maguito.getSaludActual();
		maguito.subirVitalidad(5);
		Assert.assertEquals(saludMaguito + 20, maguito.getSaludActual());
	}
	
}