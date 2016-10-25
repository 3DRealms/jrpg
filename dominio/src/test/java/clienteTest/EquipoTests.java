package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import Equipo.AnilloDelDragon;
import Equipo.AnilloDraupnir;
import Equipo.Equipo;
import Equipo.EscudoDeMadera;
import Equipo.EscudoSvalinn;
import Equipo.EspadaSkofnung;
import Equipo.PaloDeEscobaMagico;
import Equipo.VaritaMagica;
import personaje.Personaje;
import raza.Humano;
import raza.Mognatal;
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
	public void quePuedoAgregarEquipoDeAtaque() {

		Personaje sigmund = new Humano("Sigmund");
		int ataque =  sigmund.obtenerPuntosDeAtaque();

		// agrego Equipo de ataque
		sigmund = new EspadaSkofnung(sigmund);
		Assert.assertEquals(ataque + 5, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarAmbosEquipos() {

		Personaje sigmund = new Humano("Sigmund");
		int ataque =  sigmund.obtenerPuntosDeAtaque();
		int defensa = sigmund.obtenerPuntosDeDefensaFisica();

		// agrego Equipo de ataque
		sigmund = new EspadaSkofnung(sigmund);
		// agrego defensa
		sigmund = new EscudoSvalinn(sigmund);

		Assert.assertEquals(10 + defensa, sigmund.obtenerPuntosDeDefensaFisica());

		// y no pierdo ataque
		Assert.assertEquals(5 + ataque, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarDosTiposDeEquipo() {
		Personaje sigmund = new Humano("Sigmund");

		// agrego Equipo de ataque
		sigmund = new EspadaSkofnung(sigmund);
		int ataqueConEspada =  sigmund.obtenerPuntosDeAtaque();

		// agrego anillo multiplicador (x2)
		sigmund = new AnilloDraupnir(sigmund);
		Assert.assertEquals(ataqueConEspada * 2, sigmund.obtenerPuntosDeAtaque());

	}


	@Test
	public void quePuedoAgregarYAtacar() {
		Personaje sigmund = new Humano("Sigmund");
		sigmund = new EspadaSkofnung(sigmund);
		int ataqueConEspada = sigmund.obtenerPuntosDeAtaque();
		//Creo Personaje
		Personaje generic = new PersonajePrueba("bot");
		int salud =  generic.getSaludActual();

		//Ataque normal.
		sigmund.atacar(generic);
		Assert.assertEquals( salud - ataqueConEspada, generic.getSaludActual() );

	}

	@Test
	public void quePuedoAgregarDosTiposDeEquipoYAtacar() {
		Personaje sigmund = new Humano("Sigmund");
		sigmund = new EspadaSkofnung(sigmund);
		sigmund = new AnilloDraupnir(sigmund);
		int ataqueConEspadaY_Anillo =  sigmund.obtenerPuntosDeAtaque();

		//Creo Personaje
		Personaje generic = new PersonajePrueba("bot");
		int salud =  generic.getSaludActual();

		//Lo ataco
		sigmund.atacar(generic);
		Assert.assertEquals( salud - ataqueConEspadaY_Anillo , generic.getSaludActual() );
	}
	@Test
	public void lanzoUnaHabilidadQueNoTengo() {
		Personaje braian = new Mognatal("gandalf");
		braian.setCastaMago();

		Personaje alex = new PersonajePrueba("pichon"); //creo un pichon.


		Assert.assertFalse(braian.lanzarHabilidad("escudoDivino", alex));
	}

	@Test
	public void verEquipo(){
		Personaje dani = new Mognatal("Dr.Coffee");
		dani = new AnilloDraupnir(dani);
		dani = new EscudoSvalinn(dani);
		dani = new EspadaSkofnung(dani);
		dani = new PaloDeEscobaMagico(dani);
		dani = new VaritaMagica(dani);
		Assert.assertEquals("Equipo:\nAnillo Draupnir\nEscudo Svalinn\nEspada Skofnung\nPalo De Escoba Magico\nVarita Magica", dani.verEquipo());
	}

	@Test
	public void equipoDosEquipoIguales(){
		Personaje dani = new Mognatal("Dr.Coffee");
		dani = new EscudoSvalinn(dani);

	//	Assert.assertEquals(false, dani.puedoEquiparArmaIzq());
	}

	//Voy por aca:
	@Test
	public void sacarEscudo(){
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		dani = new AnilloDraupnir(dani); 
		dani = new EspadaSkofnung(dani);
		dani = new EscudoDeMadera(dani);
		
		dani = dani.getPj().getPj();
		
		
	//	Assert.assertEquals(true, dani.puedoEquiparArmaIzq()); // ahora tengo el espacio.
	}
	
	
	@Test
	public void otroDiseñoDeEquipo(){
		Personaje dani = new PersonajePrueba("Dr.Coffee");
		dani.obtenerPuntosDeDefensaFisicaConEquipo();
		Assert.assertEquals( 0, dani.obtenerPuntosDeDefensaFisicaConEquipo());
		dani.setAnillo1( new AnilloDelDragon() );
		//El anillo aumenta 15 def
		Assert.assertEquals( 15, dani.obtenerPuntosDeDefensaFisicaConEquipo());
		
		dani.setAnillo2( new AnilloDelDragon() );
		//Equipo otro anillo
		Assert.assertEquals( 30, dani.obtenerPuntosDeDefensaFisicaConEquipo());

		// Saco el primer anillo 
		dani.setAnillo1( new Equipo() );
		Assert.assertEquals( 15, dani.obtenerPuntosDeDefensaFisicaConEquipo());
		
	}
	



}
