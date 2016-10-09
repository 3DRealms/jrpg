package clienteTest;
import org.junit.Test;

import batallon.Batallon;
import batallon.BatallonHumano;
import batallon.BatallonOrco;
import junit.framework.Assert;


public class BatallonTest {
	@Test
	public void batallaGanaHumano(){
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(1);
		int i = 1; 
		String ganador = "";
		boolean fin = false;
		System.out.println("¡Empieza la batalla!");
		
		while( !fin ){
			System.out.println("Round "+i+".");
			
			b_Humano.atacar(b_Orco);
			if( b_Orco.isEmpty() ){
				fin = true;
				ganador = "ALIANZA";
			}
			b_Orco.atacar(b_Humano);
			
			if( b_Humano.isEmpty() ){
				fin = true;
				ganador = "ORDA";
			}
			i++;
		}
		System.out.println("El ganador es: "+ganador);
	}
}
