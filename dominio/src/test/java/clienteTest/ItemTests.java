package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import items.ConAnilloDraupnir;
import items.ConEscudoSvalinn;
import items.ConEspadaSkofnung;
import personaje.Personaje;
import raza.Humano;
import raza.Mognatal;
import raza.Orco;




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
		sigmund = new ConEspadaSkofnung(sigmund);
		Assert.assertEquals(ataque + 5, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarAmbosItems() {

		Personaje sigmund = new Humano("Sigmund");
		int ataque =  sigmund.obtenerPuntosDeAtaque();
		int defensa = sigmund.obtenerPuntosDeDefensa();

		// agrego item de ataque
		sigmund = new ConEspadaSkofnung(sigmund);
		// agrego defensa
		sigmund = new ConEscudoSvalinn(sigmund);

		Assert.assertEquals(10 + defensa, sigmund.obtenerPuntosDeDefensa());

		// y no pierdo ataque
		Assert.assertEquals(5 + ataque, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarDosTiposDeItem() {
		Personaje sigmund = new Humano("Sigmund");

		// agrego item de ataque
		sigmund = new ConEspadaSkofnung(sigmund);
		int ataqueConEspada =  sigmund.obtenerPuntosDeAtaque();

		// agrego anillo multiplicador (x2)
		sigmund = new ConAnilloDraupnir(sigmund);
		Assert.assertEquals(ataqueConEspada * 2, sigmund.obtenerPuntosDeAtaque());

	}
	
	
	@Test
	public void quePuedoAgregarYAtacar() {
		Personaje sigmund = new Humano("Sigmund");
		sigmund = new ConEspadaSkofnung(sigmund);
		int ataqueConEspada = sigmund.obtenerPuntosDeAtaque();
		//Creo Personaje
		Personaje generic = new Humano("bot");
		int salud =  generic.getSaludActual();

		//Ataque normal.
		sigmund.atacar(generic);
		Assert.assertEquals( salud - ataqueConEspada, generic.getSaludActual() );

	}

	@Test
	public void quePuedoAgregarDosTiposDeItemYAtacar() {
		Personaje sigmund = new Humano("Sigmund");
		sigmund = new ConEspadaSkofnung(sigmund);
		sigmund = new ConAnilloDraupnir(sigmund);
		int ataqueConEspadaY_Anillo =  sigmund.obtenerPuntosDeAtaque();
		
		//Creo Personaje
		Personaje generic = new Humano("bot");
		int salud =  generic.getSaludActual();

		//Lo ataco
		sigmund.atacar(generic);
		Assert.assertEquals( salud - ataqueConEspadaY_Anillo , generic.getSaludActual() );
	}
	@Test
	public void lanzoUnaHabilidadQueNoTengo() {
		Personaje braian = new Mognatal("gandalf");
		braian.setCastaMago();
		
		Personaje alex = new Orco("pichon"); //creo un pichon.

		
		Assert.assertFalse(braian.lanzarHabilidad("escudoDivino", alex));
	}

}
