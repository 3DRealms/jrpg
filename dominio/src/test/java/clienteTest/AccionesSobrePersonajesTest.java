package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.PersonajePrueba;

public class AccionesSobrePersonajesTest {
	@Test
	public void serCuradoExactoLoQueMeFalta() {
		Personaje dani = new PersonajePrueba("MetralletaRancia");
		int saludDani = dani.getSaludActual();
		//Lo ataco y verifico que le quito esa energia.
		dani.serAtacadoFisico(50);
		dani.serCurado(50);	
		Assert.assertEquals( saludDani , dani.getSaludActual() );
	}
	@Test
	public void serCurado() {
		Personaje dani = new PersonajePrueba("MetralletaRancia");
		int saludDani = dani.getSaludActual();
		//Lo ataco y verifico que le quito esa energia.
		dani.serAtacadoFisico(150);
		dani.serCurado(50);	 //Verifico que exactamente sea 50 lo que curo.
		Assert.assertEquals( saludDani - 100, dani.getSaludActual() );
	}
	@Test
	public void serCuradoPeroNoDeMas() {
		Personaje dani = new PersonajePrueba("MetralletaRancia");
		int saludDani = dani.getSaludActual();
		//Lo ataco y verifico que le quito esa energia.
		dani.serCurado(50);	
							//Quedo Con la misma vida y no con saludDani +50.
		Assert.assertEquals( saludDani , dani.getSaludActual() );
	}
	
	@Test
	public void consumirEnergia() {
		Personaje dani = new PersonajePrueba("MetralletaRancia");
		int energiaDani = dani.getEnergia();
		//Lo ataco y verifico que le quito esa energia.
		dani.consumirEnergia(50);
		Assert.assertEquals( energiaDani-50 , dani.getEnergia() );
	}
	@Test
	public void serEnergizadoExactoLoQueConsumo() {
		Personaje dani = new PersonajePrueba("MetralletaRancia");
		int energiaDani = dani.getEnergia();
		//Lo ataco y verifico que le quito esa energia.
		dani.consumirEnergia(50);
		dani.serEnergizado(50);	
		Assert.assertEquals( energiaDani , dani.getEnergia() );
	}
	@Test
	public void serEnergizado() {
		Personaje dani = new PersonajePrueba("MetralletaRancia");
		int energiaDani = dani.getEnergia();
		//Lo ataco y verifico que le quito esa energia.
		dani.consumirEnergia(100);
		dani.serEnergizado(50);	
		Assert.assertEquals( energiaDani - 50, dani.getEnergia() );
	}
	@Test
	public void serEnergizadoPeroNoDeMas() {
		Personaje dani = new PersonajePrueba("MetralletaRancia");
		int energiaDani = dani.getEnergia();
		//Lo ataco y verifico que le quito esa energia.
		dani.serEnergizado(50);	
						//Quedo Con la misma energia y no con energiaDani +50.
		Assert.assertEquals( energiaDani , dani.getEnergia() );
	}

}
