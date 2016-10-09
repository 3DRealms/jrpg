package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.Mognatal;

/**
 * 
 * 	Se entiende por estado a todo atributo que afecta de manera positiva a mi personaje.
 * 	EJ: vitalidad, fuerza, intelecto. 
 * */
public class SubirEstadosDelPersonajeTest {
	
	@Test
	public void subirVitalidad() {
		Personaje magito = new Mognatal();
		Assert.assertEquals(120, magito.getSaludActual());
		magito.subirVitalidad(5);
		Assert.assertEquals(140, magito.getSaludActual());
	}
}
