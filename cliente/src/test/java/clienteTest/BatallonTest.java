package clienteTest;
import org.junit.Assert;
import org.junit.Test;

import batallon.Batallon;
import batallon.BatallonHumano;
import batallon.BatallonOrco;


public class BatallonTest {
	@Test
	public void batallaGanaHumano(){
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(1);
		Assert.assertEquals("alianza", partida(b_Humano, b_Orco));
	}

	private String partida(Batallon b_Humano, Batallon b_Orco) {
		boolean fin = false;
		String ganador = "";
		int i = 1;

		System.out.println("¡Empieza la batalla!");
		while( !fin ){
			System.out.println("Round "+i+".");

			b_Humano.atacar(b_Orco);
			if( b_Orco.isEmpty() ){
				fin = true;
				ganador = "alianza";
			}
			b_Orco.atacar(b_Humano);

			if( b_Humano.isEmpty() ){
				fin = true;
				ganador = "orda";
			}
			i++;
		}
		System.out.println("El ganador es: "+ganador);
		return ganador;
	}
}
