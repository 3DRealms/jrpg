package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import items.BalaMagicaDePatsy;
import personaje.Personaje;
import raza.Humano;
import raza.Orco;

public class ItemsTest {
	@Test
	public void quePuedoTenerUnItem() {
		Personaje coffee = new Humano("El Dani turritu");
		Assert.assertEquals(0, coffee.cantidadItems());
		coffee.guardarItem("balaMagicaDePasty", new BalaMagicaDePatsy(1));
		Assert.assertEquals(1, coffee.cantidadItems());
	}
	@Test
	public void quePuedoLanzarUnItem() {
		Personaje coffee = new Humano("El Dani turritu");
		coffee.guardarItem("balaMagicaDePasty", new BalaMagicaDePatsy(1));
		Personaje locoDelTecho = new Orco("El alex tontis");
		int saludLocoDelTecho = locoDelTecho.getSaludActual();
		coffee.lanzarItem("balaMagicaDePasty", locoDelTecho);
		//SI DICE LOCO DEL TECHO!
		Assert.assertEquals(saludLocoDelTecho - 100, locoDelTecho.getSaludActual());
	}

}
