package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import items.AnilloDraupnir;
import items.EscudoSvalinn;
import items.EspadaSkofnung;
import items.PaloDeEscobaMagico;
import items.VaritaMagica;
import personaje.Personaje;
import raza.Humano;
import raza.Mognatal;
import raza.PersonajePrueba;




public class ItemTests {

	/*
	 * Especificacion de Items
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * ConEspadaSkofnung: Esta espada aumenta en 5 pts el ataque
	 * ConEscudoSvalinn: Este escudo otorga 10 pts de defensa
	 * ConAnilloDraupnir: Este anillo multiplica el ataque x2
	 */

	@Test
	public void quePuedoAgregarItemDeAtaque() {

		Personaje sigmund = new Humano("Sigmund");
		int ataque =  sigmund.obtenerPuntosDeAtaque();

		// agrego item de ataque
		sigmund = new EspadaSkofnung(sigmund);
		Assert.assertEquals(ataque + 5, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarAmbosItems() {

		Personaje sigmund = new Humano("Sigmund");
		int ataque =  sigmund.obtenerPuntosDeAtaque();
		int defensa = sigmund.obtenerPuntosDeDefensaFisica();

		// agrego item de ataque
		sigmund = new EspadaSkofnung(sigmund);
		// agrego defensa
		sigmund = new EscudoSvalinn(sigmund);

		Assert.assertEquals(10 + defensa, sigmund.obtenerPuntosDeDefensaFisica());

		// y no pierdo ataque
		Assert.assertEquals(5 + ataque, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarDosTiposDeItem() {
		Personaje sigmund = new Humano("Sigmund");

		// agrego item de ataque
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
	public void quePuedoAgregarDosTiposDeItemYAtacar() {
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
	public void verItem(){
		Personaje dani = new Mognatal("Dr.Coffee");
		dani = new AnilloDraupnir(dani);
		dani = new EscudoSvalinn(dani);
		dani = new EspadaSkofnung(dani);
		dani = new PaloDeEscobaMagico(dani);
		dani = new VaritaMagica(dani);

		//System.out.println(dani.verItems()); // LUCAS OSEA TENGO QUE VERLO YO OSEA CALMATE UN POCO.
		Assert.assertEquals("Items:\nAnillo Draupnir\nEscudo Svalinn\nEspada Skofnung\nPalo De Escoba Magico\nVarita Magica", dani.verItems());
	}

}
