package dominio;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import mapa.Mapa;
import personaje.Personaje;
import raza.PersonajePrueba;


public class MapaTest {

	// Válida seria 
	@Test
	public void estoyDentroDelMapa01() throws FileNotFoundException {
		Mapa mapa1 = new Mapa("map1");
		Personaje dani = new PersonajePrueba("El dani");

		dani.setUbicacion(0,0); 

		Assert.assertTrue( mapa1.posicionValida( dani.getUbicacion() )  ); // veo si ese algo esta dentro del mapa.
	}

	@Test
	public void hayObstaculo() throws FileNotFoundException {
		Mapa mapa1 = new Mapa("map1");
		Personaje dani = new PersonajePrueba("El dani");

		dani.setUbicacion(1,1);  //Aca estoy en una posicion invalidad.

		Assert.assertFalse( mapa1.posicionValida( dani.getUbicacion() )  ); // veo si ese algo esta dentro del mapa.
	}

	@Test
	public void estoyDentroDelMapa02() throws FileNotFoundException {
		Mapa mapa1 = new Mapa("map1");
		Personaje dani = new PersonajePrueba("El dani wacho");

		dani.setUbicacion(150,39); 

		Assert.assertTrue( mapa1.posicionValida(dani.getUbicacion() ) ); // veo si ese algo esta dentro del mapa.
	}
	@Test
	public void estoyDentroDelMapa03() throws FileNotFoundException {
		Mapa mapa1 = new Mapa("map1");
		Personaje dani = new PersonajePrueba("El dani re wacho");
		dani.setUbicacion(199,199);  //limite.
		Assert.assertTrue( mapa1.posicionValida(dani.getUbicacion() )); // veo si ese algo esta dentro del mapa.
	}
	@Test
	public void estoyFueraDelMapa01() throws FileNotFoundException {
		Mapa mapa1 = new Mapa("map1");
		Personaje dani = new PersonajePrueba("El dani recontra wacho");
		dani.setUbicacion(200,200);  //Ya me pase
		Assert.assertFalse( mapa1.posicionValida(dani.getUbicacion()) ); // veo si ese algo esta fuera del mapa.
	}
	@Test
	public void estoyFueraDelMapa02() throws FileNotFoundException {
		Mapa mapa1 = new Mapa("map1");
		Personaje dani = new PersonajePrueba("El dani UTRA wacho");
		dani.setUbicacion(-5,-5); //me fui al limbo
		Assert.assertFalse( mapa1.posicionValida(dani.getUbicacion())); // veo si ese algo esta fuera del mapa.
	}
	

}
