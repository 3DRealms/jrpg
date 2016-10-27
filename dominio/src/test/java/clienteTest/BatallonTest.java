package clienteTest;
import org.junit.Assert;
import org.junit.Test;

import batalla.Batalla;
import batallonNPC.EquipoNPC;
import batallonNPC.BatallonHumano;
import batallonNPC.BatallonOrco;


public class BatallonTest {
	
    /***********************************************************************************************************************************
	 *  Cuando es n vs n deberia ganar los orcos porque van eliminandos humanos uno a uno entonces el humano tiene menos ataque promedio.*
	 *  Suponiendo que los dos tenga ataques iguales, y que el ataque sea menor que la vida.										   * 	
	 ***********************************************************************************************************************************/
	
	@Test
	public void batallaGanaOrco1vs1EmpiezaHumano(){
		EquipoNPC b_Humano = new BatallonHumano(1);
		EquipoNPC b_Orco = new BatallonOrco(1);
		//Comienza primero el humano y pierde porque el orco tiene mas recistencia fisica y ataque.
		Assert.assertEquals("orcos", Batalla.batallaAutotomatica(b_Humano, b_Orco));
		
	}
	@Test
	public void batallaGanaOrco1vs1EmpiezaOrco(){
		EquipoNPC b_Humano = new BatallonHumano(1);
		EquipoNPC b_Orco = new BatallonOrco(1);
		//Comienza primero el orco y gana
		Assert.assertEquals("orcos", Batalla.batallaAutotomatica(b_Orco,b_Humano));
	}

	@Test
	public void batallaGanaOrcos10vs10(){
		EquipoNPC b_Humano = new BatallonHumano(10);
		EquipoNPC b_Orco = new BatallonOrco(10);
		Assert.assertEquals("orcos", Batalla.batallaAutotomatica(b_Humano, b_Orco));
	}
	
	
	@Test
	public void batallaGanaOrcos1000vs1000(){
		EquipoNPC b_Humano = new BatallonHumano(1000);
		EquipoNPC b_Orco = new BatallonOrco(1000);
		Assert.assertEquals("orcos", Batalla.batallaAutotomatica(b_Humano, b_Orco));
	}
	@Test
	public void batallaGanaHumanos15vs1(){
		EquipoNPC b_Humano = new BatallonHumano(15);
		EquipoNPC b_Orco = new BatallonOrco(1);
		Assert.assertEquals("humanos", Batalla.batallaAutotomatica(b_Humano, b_Orco));
	}
	@Test
	public void batallaGanaOrcos1vs15(){
		EquipoNPC b_Humano = new BatallonHumano(1);
		EquipoNPC b_Orco = new BatallonOrco(15);
		Assert.assertEquals("orcos", Batalla.batallaAutotomatica(b_Humano, b_Orco));
	}

	
}
