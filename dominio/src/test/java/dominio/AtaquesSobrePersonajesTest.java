package dominio;

import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.Gordo;
import raza.PersonajePrueba;

public class AtaquesSobrePersonajesTest {
	
	@Test
	public void serAtacadoFisico() {
		Personaje dani = new PersonajePrueba("PistolaLoca");
		int saludDani = dani.getSaludActual();
		//Lo ataco y verifico que le quito esa energia.
				   dani.serAtacadoFisico(50);
		Assert.assertEquals( saludDani - 50, dani.getSaludActual() );
	}
	@Test
	public void serAtacadoMagico() {
		Personaje dani = new PersonajePrueba("PistolaLoca");
		int saludDani = dani.getSaludActual();
		//Lo ataco y verifico que le quito esa energia.
		dani.serAtacadoMagico(50);
		Assert.assertEquals( saludDani - 50, dani.getSaludActual() );
	}
	@Test
	public void serAtacadoFisicoConDefenza() {
		Personaje dani = new Gordo("PistolaLoca");
		//El Orco tiene 15 puntos de defensa.
		int saludDani = dani.getSaludActual();
		//Lo ataco y verifico que le quito esa energia.
		dani.serAtacadoFisico(50);        //def Fisica
		Assert.assertEquals( saludDani-50   +7 , dani.getSaludActual() );
	}
	@Test
	public void serAtacadoMagicoConDefenza() {
		Personaje dani = new Gordo("PistolaLoca");
		//El Orco tiene 5 puntos de defensa.
		int saludDani = dani.getSaludActual();
		//Lo ataco y verifico que le quito esa energia.
		dani.serAtacadoMagico(50);        //def Magica
		Assert.assertEquals( saludDani-50   +2 , dani.getSaludActual() );
	}
}
