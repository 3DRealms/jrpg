package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import alianza.Alianza;
import alianza.Batallon;
import alianza.BatallonHumano;
import campoDeBatalla.CampoDeBatalla;

public class BatallaTest {
	
	@Test
	public void batallaJugadorContraBot(){
		CampoDeBatalla batalla = new CampoDeBatalla();
		Batallon bh = new BatallonHumano(5);
		Alianza a1 = new Alianza("Ls k-pos d zna Suûr");
		Assert.assertEquals(a1.toString() , batalla.batallaAuto(a1, bh));
	}
}
