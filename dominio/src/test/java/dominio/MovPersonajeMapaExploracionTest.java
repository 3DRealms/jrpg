package dominio;

import org.junit.Assert;
import org.junit.Test;

import mapa.Punto;
import personaje.Personaje;
import raza.PersonajePrueba;

public class MovPersonajeMapaExploracionTest {
	/**
	 * para norte sur este oeste, la forma de evaluar es la misma.
	 */
	@Test
	public void moverseLibreEnElMapaNorte(){
		Personaje dani = new PersonajePrueba("El dani cho super dragon souls wacho");
		Punto inicio = new Punto(0,0);
		Punto dondeQuieroIr = new Punto(0,1);

		Assert.assertEquals( 0, dani.getUbicacion().calcularDistancia(inicio) , 0.001);
		//Esto a 0 de distancia del inicio.

		dani.desplazar("N");

		Assert.assertEquals(0 , dani.getUbicacion().calcularDistancia(dondeQuieroIr), 0.001);
		//Ahora estoy a 0 de distancia del lugar donde queria ir , osea que llegue :3.
	}

}
