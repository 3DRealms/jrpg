package dominio;

import java.sql.SQLException;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import database.SQLiteJDBC;
import item.ItemEquipo;
import personaje.Personaje;
import raza.PersonajePrueba;





public class EquipoTests {

	/*
	 * Especificacion de Equipos
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * EspadaSkofnung: Esta espada aumenta en 5 pts el ataque
	 * EscudoSvalinn: Este escudo otorga 10 pts de defensa
	 * AnilloDraupnir: Este anillo multiplica el ataque x2
	 * PaloDeEscobaMagico: Este baston magico que aumenta en 5 el intelecto
	 * VaritaMagica: 
	 */
	@Test
	public void quePuedoAgregarAnillo() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, ItemEquipo> equipables = SQLiteJDBC.obtenerEquipables();
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		dani.obtenerPuntosDeDefensaFisica();
		Assert.assertEquals( 0, dani.obtenerPuntosDeDefensaFisica());


		dani.equipar( equipables.get("AnilloDragon") );
		//El anillo aumenta 15 def
	
		Assert.assertEquals( 15, dani.obtenerPuntosDeDefensaFisica());
		//AGREGO TESTEO DE .defender()  .sacarDefensa()
		dani.defenderse();
		Assert.assertEquals(60, dani.obtenerPuntosDeDefensaFisica());

	}


	@Test
	public void quePuedoAgregarDosItem() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, ItemEquipo> equipables = SQLiteJDBC.obtenerEquipables();
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		//Equipo los dos anillos:
		dani.equipar( equipables.get("AnilloDragon")  );	//	| 15+
		dani.equipar( equipables.get("EscudoMadera")   );	// 	|  5
		
		System.out.println(dani.getItemEquipables());

		Assert.assertEquals( 20 , dani.obtenerPuntosDeDefensaFisica());
	}

	@Test
	public void quePuedoAgregarDosItemYQuitarUno() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, ItemEquipo> equipables = SQLiteJDBC.obtenerEquipables();
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		dani.obtenerPuntosDeDefensaFisica();
		Assert.assertEquals( 0, dani.obtenerPuntosDeDefensaFisica());
		dani.equipar( equipables.get("AnilloDragon")  );  //		15 de defensa.
		dani.equipar(equipables.get("EscudoMadera")  );	//		5 de defensa.

		Assert.assertEquals( 20 , dani.obtenerPuntosDeDefensaFisica());
		// Saco el anillo 
		dani.desequipar("anillo");
		Assert.assertEquals( 5 , dani.obtenerPuntosDeDefensaFisica());
	}
	@Test
	public void quePuedoAgregarDosItemYQuitarDos() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, ItemEquipo> equipables = SQLiteJDBC.obtenerEquipables();
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		dani.obtenerPuntosDeDefensaFisica();
		//Equipo los dos anillos:
		dani.equipar( equipables.get("AnilloDragon")  );
		dani.equipar( equipables.get("PaloDeEscoba") );

		// Saco los dos items
		dani.desequipar("anillo");
		dani.desequipar("armaDer");

		Assert.assertEquals("sinEquipo" , dani.verEquipo("anillo").toString() );
		Assert.assertEquals("sinEquipo" , dani.verEquipo("armaDer").toString() );

	}


	@Test
	public void quePuedoAgregarYAtacar() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, ItemEquipo> equipables = SQLiteJDBC.obtenerEquipables();
		Personaje dani = new PersonajePrueba("Dr.Coffee");

		dani.equipar( equipables.get("AnilloDragon")  );
		Personaje alex = new PersonajePrueba("Loco del tacho");
		int salud = alex.getSaludActual();
	//	dani.atacar(alex);
		//El anillo aumenta el ataque en 15, y la fuerza( que tambien aumenta el ataque) en 5, osea 10 puntos mas de fuerza
		// en total tengo 15 + 10 + 15 = 40.
		Assert.assertEquals(salud - 40 , alex.getSaludActual());
	}

	@Test
	public void quePuedoAgregarDosTiposDeEquipoYAtacar() {

	}
	@Test
	public void verEquipo(){
		//	Personaje dani = new PersonajePrueba("Dr.Coffee");

	}

	@Test
	public void equipoDosEquipoIguales(){

	}

	//Voy por aca:
	@Test
	public void sacarEscudo(){

	}

}

