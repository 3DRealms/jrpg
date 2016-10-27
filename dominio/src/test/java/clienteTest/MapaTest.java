package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import mapa.Mapa;
import mapa.Ubicacion;
import personaje.Personaje;
import raza.PersonajePrueba;


public class MapaTest {
	// Válida seria 

	@Test
	public void estoyDentroDelMapa01() {
		Mapa mapa1 = new Mapa(200,200,"Lanus");
		Personaje dani = new PersonajePrueba("El dani");
		
		dani.setUbicacion(0,0); 

		Assert.assertTrue( mapa1.posicionValida(dani.getUbicacion() )  ); // veo si ese algo esta dentro del mapa.
	}
	@Test
	public void estoyDentroDelMapa02() {
		Mapa mapa1 = new Mapa(200,200,"Lanus");
		Personaje dani = new PersonajePrueba("El dani wacho");
		
		dani.setUbicacion(150,39); 
		
		Assert.assertTrue( mapa1.posicionValida(dani.getUbicacion() ) ); // veo si ese algo esta dentro del mapa.
	}
	@Test
	public void estoyDentroDelMapa03() {
		Mapa mapa1 = new Mapa(200,200,"Lanus");
		Personaje dani = new PersonajePrueba("El dani re wacho");
		dani.setUbicacion(200,200); 
		Assert.assertTrue( mapa1.posicionValida(dani.getUbicacion() )); // veo si ese algo esta dentro del mapa.
	}
	@Test
	public void estoyFueraDelMapa01() {
		Mapa mapa1 = new Mapa(200,200,"Lanus");
		Personaje dani = new PersonajePrueba("El dani recontra wacho");
		dani.setUbicacion(201,201); 
		Assert.assertFalse( mapa1.posicionValida(dani.getUbicacion()) ); // veo si ese algo esta fuera del mapa.
	}
	@Test
	public void estoyFueraDelMapa02() {
		Mapa mapa1 = new Mapa(200,200,"Lanus");
		Personaje dani = new PersonajePrueba("El dani UTRA wacho");
		dani.setUbicacion(-5,-5); //me fui al limbo
		Assert.assertFalse( mapa1.posicionValida(dani.getUbicacion())); // veo si ese algo esta fuera del mapa.
	}
	@Test
	public void moverseLibreEnElMapa(){
		Personaje dani = new PersonajePrueba("El dani cho super dragon souls wacho");
		Ubicacion inicio = new Ubicacion(0,0);
		Ubicacion dondeQuieroIr = new Ubicacion(0,1);
		
		Assert.assertEquals(0, dani.getUbicacion().calcularDistancia(inicio));
		
		dani.desplazar("N");
		
		Assert.assertEquals(0 , dani.getUbicacion().calcularDistancia(dondeQuieroIr));
	}
}
