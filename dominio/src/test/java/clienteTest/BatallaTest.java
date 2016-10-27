package clienteTest;

import org.junit.Test;

import batalla.EquipoJugadores;
import batallonNPC.EquipoNPC;
import batallonNPC.BatallonHumano;

public class BatallaTest {
	
	@Test
	public void batallaJugadorContraBot(){
		EquipoNPC bh = new BatallonHumano(5);
		EquipoJugadores a1 = new EquipoJugadores("Ls k-pos d zna Suûr");
	//	Batalla batalla = new Batalla();
	//	Assert.assertEquals(a1.toString() , batalla.batallaAuto(a1, bh));
	}
}
