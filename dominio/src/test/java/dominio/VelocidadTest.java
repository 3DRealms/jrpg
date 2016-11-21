package dominio;

import habilidad.Habilidad;
import item.ItemLanzable;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import database.SQLiteJDBC;
import personaje.Personaje;
import raza.PersonajePrueba;

public class VelocidadTest {
	
	
	@Test
	public void subirObtenerVelocidadBasica() {
		Personaje alex = new PersonajePrueba("elwacho");
		int velocidad = alex.getVelocidad();
		Assert.assertEquals(0, velocidad);
		alex.subirExperencia(1000);
		alex.subirVelocidad();
		alex.subirVelocidad();
		alex.subirVelocidad();
		alex.subirVelocidad();
		alex.subirVelocidad();
		Assert.assertEquals(5, alex.getVelocidad());
		
	}
	@Test
	public void subirYObtenerVelocidadItem()throws ClassNotFoundException, SQLException  {
		SQLiteJDBC.getInstance();
		Map<String, ItemLanzable> lanzables = SQLiteJDBC.obtenerLanzables();
		Personaje tacho = new PersonajePrueba("elwacho");
		tacho.guardarItem("bomba", lanzables.get("bomba"));
		int velocidadBomba = tacho.getVelLanzarItem("bomba");
		tacho.subirExperencia(1000);
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		Assert.assertEquals(velocidadBomba+5,tacho.getVelLanzarItem("bomba"));
		Assert.assertNotNull(tacho.verItemsLanzablesEnMochila());

		
	}
	
	@Test
	public void subirYObtenerVelocidadHabilidad()throws ClassNotFoundException, SQLException  {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		Personaje tacho = new PersonajePrueba("elwacho");
		tacho.setCastaMago();
		tacho.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
		
		int velocidadInicial =tacho.getVelLanzarHabilidad("piroexplosion");
		
		tacho.subirExperencia(1000);
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		tacho.subirVelocidad();
		
		
		Assert.assertEquals(velocidadInicial+5,tacho.getVelLanzarHabilidad("piroexplosion"));
		
	}
	

	
}
