package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import campoDeBatalla.CampoDeBatalla;
import equipos.Alianza;
import equipos.Batallon;
import equipos.BatallonHumano;

public class BatallaTest {
	
	@Test
	public void batallaJugadorContraBot(){
		CampoDeBatalla batalla = new CampoDeBatalla();
		Batallon bh = new BatallonHumano(5);
		Alianza a1 = new Alianza("Ls k-pos d zna Suûr");
		Assert.assertEquals(a1.toString() , batalla.batalla(a1, bh));
	}
}
