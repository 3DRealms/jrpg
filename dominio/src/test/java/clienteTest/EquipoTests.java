package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import item.ItemEquipo;
import itemEquipo.AnilloDelDragon;
import itemEquipo.EscudoDeMadera;
import itemEquipo.PaloDeEscobaMagico;
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
	public void quePuedoAgregarAnillo() {

		Personaje dani = new PersonajePrueba("Dr.Coffee");
		dani.obtenerPuntosDeDefensaFisica();
		Assert.assertEquals( 0, dani.obtenerPuntosDeDefensaFisica());

		dani.equipar( new AnilloDelDragon() );
		//El anillo aumenta 15 def
		Assert.assertEquals( 15, dani.obtenerPuntosDeDefensaFisica());

	}
	
	@Test
	public void quePuedoAgregarDosItem() {
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		//Equipo los dos anillos:
		dani.equipar( new AnilloDelDragon() );	//	| 15+
		dani.equipar( new EscudoDeMadera() );	// 	|  5

		Assert.assertEquals( 20 , dani.obtenerPuntosDeDefensaFisica());
	}

	@Test
	public void quePuedoAgregarDosItemYQuitarUno() {
			Personaje dani = new PersonajePrueba("Dr.Coffee");
			dani.obtenerPuntosDeDefensaFisica();
			Assert.assertEquals( 0, dani.obtenerPuntosDeDefensaFisica());
			dani.equipar( new AnilloDelDragon() );  //		15 de defensa.
			dani.equipar( new EscudoDeMadera()  );	//		5 de defensa.

			Assert.assertEquals( 20 , dani.obtenerPuntosDeDefensaFisica());
			// Saco el anillo 
			dani.desequipar("anillo");
			Assert.assertEquals( 5 , dani.obtenerPuntosDeDefensaFisica());
	}
	@Test
	public void quePuedoAgregarDosItemYQuitarDos() {
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		dani.obtenerPuntosDeDefensaFisica();
		//Equipo los dos anillos:
		dani.equipar( new AnilloDelDragon() );
		dani.equipar( new PaloDeEscobaMagico());

		// Saco los dos items
		dani.desequipar("anillo");
		dani.desequipar("armaDer");
		
		Assert.assertEquals("sinEquipo" , dani.verEquipo("anillo").toString() );
		Assert.assertEquals("sinEquipo" , dani.verEquipo("armaDer").toString() );
		
	}


	@Test
	public void quePuedoAgregarYAtacar() {
		Personaje dani = new PersonajePrueba("Dr.Coffee");

		dani.equipar( new AnilloDelDragon() );
		Personaje alex = new PersonajePrueba("Loco del tacho");
		int salud = alex.getSaludActual();
		dani.atacar(alex);
		Assert.assertEquals(salud - 30 , alex.getSaludActual());
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

