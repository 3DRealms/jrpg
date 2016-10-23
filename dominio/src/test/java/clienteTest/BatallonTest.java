package clienteTest;
import org.junit.Assert;
import org.junit.Test;

import alianza.Batallon;
import alianza.BatallonHumano;
import alianza.BatallonOrco;
import campoDeBatalla.CampoDeBatalla;


public class BatallonTest {CampoDeBatalla batalla1 = new CampoDeBatalla();
	
    /***********************************************************************************************************************************
	 *  Cuando es n vs n deberia ganar los orcos porque van eliminandos humanos uno a uno entonces el humano tiene menos ataque promedio.*
	 *  Suponiendo que los dos tenga ataques iguales, y que el ataque sea menor que la vida.										   * 	
	 ***********************************************************************************************************************************/
	
	@Test
	public void batallaGanaOrco1vs1EmpiezaHumano(){
		CampoDeBatalla batalla1 = new CampoDeBatalla();
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(1);
		//Comienza primero el humano y pierde porque el orco tiene mas recistencia fisica y ataque.
		Assert.assertEquals("orcos", batalla1.batalla(b_Humano, b_Orco));
		
	}
	@Test
	public void batallaGanaOrco1vs1EmpiezaOrco(){
		CampoDeBatalla batalla1 = new CampoDeBatalla();
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(1);
		//Comienza primero el orco y gana
		Assert.assertEquals("orcos", batalla1.batalla(b_Orco,b_Humano));
	}

	@Test
	public void batallaGanaOrcos10vs10(){
		CampoDeBatalla batalla1 = new CampoDeBatalla();
		Batallon b_Humano = new BatallonHumano(10);
		Batallon b_Orco = new BatallonOrco(10);
		Assert.assertEquals("orcos", batalla1.batalla(b_Humano, b_Orco));
	}
	
	
	@Test
	public void batallaGanaOrcos1000vs1000(){
		CampoDeBatalla batalla1 = new CampoDeBatalla();
		Batallon b_Humano = new BatallonHumano(1000);
		Batallon b_Orco = new BatallonOrco(1000);
		Assert.assertEquals("orcos", batalla1.batalla(b_Humano, b_Orco));
	}
	@Test
	public void batallaGanaHumanos15vs1(){
		CampoDeBatalla batalla1 = new CampoDeBatalla();
		Batallon b_Humano = new BatallonHumano(15);
		Batallon b_Orco = new BatallonOrco(1);
		Assert.assertEquals("humanos", batalla1.batalla(b_Humano, b_Orco));
	}
	@Test
	public void batallaGanaOrcos1vs15(){
		CampoDeBatalla batalla1 = new CampoDeBatalla();
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(15);
		Assert.assertEquals("orcos", batalla1.batalla(b_Humano, b_Orco));
	}

	
}
