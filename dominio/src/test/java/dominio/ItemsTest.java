package dominio;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import database.SQLiteJDBC;
import item.ItemEquipo;
import item.ItemLanzable;
import personaje.Personaje;
import raza.Humano;
import raza.Gordo;

public class ItemsTest {
	@Test
	public void quePuedoTenerUnItem() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, ItemLanzable> lanzables = SQLiteJDBC.obtenerLanzables();

		Personaje coffee = new Humano("El Dani turritu");
		Assert.assertEquals(0, coffee.cantidadItems());
		coffee.guardarItem("bomba",  lanzables.get("bomba"));//balaMagicaDePasty
		Assert.assertEquals(1, coffee.cantidadItems());
	}
	@Test
	public void quePuedoLanzarUnItem() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, ItemLanzable> lanzables = SQLiteJDBC.obtenerLanzables();
		Personaje coffee = new Humano("El Dani turritu");
		coffee.guardarItem("bomba", lanzables.get("bomba") );
		Personaje locoDelTecho = new Gordo("El alex tontis");
		int saludLocoDelTecho = locoDelTecho.getSaludActual();
		coffee.lanzarItem("bomba", locoDelTecho);
		//SI DICE LOCO DEL TECHO! 
		Assert.assertEquals(saludLocoDelTecho - 170, locoDelTecho.getSaludActual());
							//TE HACE PERCHA.
		Assert.assertTrue( locoDelTecho.estaMuerto() ); // funca :) 
	}


}
