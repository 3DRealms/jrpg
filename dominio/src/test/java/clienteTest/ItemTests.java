package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import equipo.ConAnilloDraupnir;
import equipo.ConEscudoSvalinn;
import equipo.ConEspadaSkofnung;
import personaje.Personaje;
import raza.Humano;




public class ItemTests {

	/*
	 * EspecificaciÃ³n de Items
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * ConEspadaSkofnung: Esta espada aumenta en 5 pts el ataque
	 * ConEscudoSvalinn: Este escudo otorga 10 pts de defensa
	 * ConAnilloDraupnir: Este anillo multiplica el ataque x2
	 */

	@Test
	public void quePuedoAgregarItemDeAtaque() {

		Personaje sigmund = new Humano("Sigmund");
		Assert.assertEquals(15, sigmund.obtenerPuntosDeAtaque());

		// agrego item de ataque
		sigmund = new ConEspadaSkofnung(sigmund);
		Assert.assertEquals(5 + 15, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarAmbosItems() {

		Personaje sigmund = new Humano("Sigmund");
		Assert.assertEquals(15, sigmund.obtenerPuntosDeAtaque());

		// agrego item de ataque
		sigmund = new ConEspadaSkofnung(sigmund);
		Assert.assertEquals(5 + 15, sigmund.obtenerPuntosDeAtaque());

		Assert.assertEquals(0, sigmund.obtenerPuntosDeDefensa());
		sigmund = new ConEscudoSvalinn(sigmund);
		// agrego defensa
		Assert.assertEquals(10 + 0, sigmund.obtenerPuntosDeDefensa());
		// y no pierdo ataque
		System.out.println(sigmund.obtenerPuntosDeAtaque());
		Assert.assertEquals(5 + 15, sigmund.obtenerPuntosDeAtaque());
	}

	@Test
	public void quePuedoAgregarDosTiposDeItem() {
		Personaje sigmund = new Humano("Sigmund");
		Assert.assertEquals(15, sigmund.obtenerPuntosDeAtaque());

		// agrego item de ataque
		sigmund = new ConEspadaSkofnung(sigmund);
		Assert.assertEquals(5 + 15, sigmund.obtenerPuntosDeAtaque());

		// agrego anillo multiplicador (x2)
		sigmund = new ConAnilloDraupnir(sigmund);
		Assert.assertEquals((5 + 15) * 2, sigmund.obtenerPuntosDeAtaque());

	}


	@Test
	public void quePuedoAgregarYAtacar() {
		//Creo el personaje.
		Personaje sigmund = new Humano("Sigmund");
		Assert.assertEquals(15, sigmund.obtenerPuntosDeAtaque());
		
		// Agrego item de ataque (+15)
		sigmund = new ConEspadaSkofnung(sigmund);
		Assert.assertEquals(5 + 15, sigmund.obtenerPuntosDeAtaque());
		
		//Creo Personaje
		Personaje generic = new Humano("bot");
		Assert.assertEquals( 120, generic.getSaludActual() );
		
		//Ataco
		sigmund.atacar(generic);
		Assert.assertEquals(100, generic.getSaludActual());
		
	}

	@Test
    public void quePuedoAgregarDosTiposDeItemYAtacar() {
    	Personaje sigmund = new Humano("Sigmund");
    	Assert.assertEquals(15, sigmund.obtenerPuntosDeAtaque());
    	// Agrego item de ataque (+15)
    	sigmund = new ConEspadaSkofnung(sigmund);
    	Assert.assertEquals(5 + 15, sigmund.obtenerPuntosDeAtaque());
    	
    	// Agrego anillo multiplicador (x2)
    	sigmund = new ConAnilloDraupnir(sigmund);
    	Assert.assertEquals((5 + 15) * 2, sigmund.obtenerPuntosDeAtaque());
    	
    	//Creo Personaje
    	Personaje generic = new Humano("bot");
    	Assert.assertEquals( 120, generic.getSaludActual() );
    	
    	//Lo ataco
    	sigmund.atacar(generic);
    	Assert.assertEquals(80, generic.getSaludActual());
    	
    	// Agrego anillo multiplicador (x2)
    	sigmund = new ConAnilloDraupnir(sigmund);
    	Assert.assertEquals(((5 + 15) * 2)*2, sigmund.obtenerPuntosDeAtaque());
    	
    	// Lo vuelvo a atacar.
    	sigmund.atacar(generic);
    	//Si tenia 80 de vida, y ahora tengo 80 de daño, pues lo mato :V.
    	Assert.assertTrue(sigmund.estaMuerto());
}

}
