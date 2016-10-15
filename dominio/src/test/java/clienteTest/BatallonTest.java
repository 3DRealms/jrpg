package clienteTest;
import org.junit.Assert;
import org.junit.Test;

import batallon.Batallon;
import batallon.BatallonHumano;
import batallon.BatallonOrco;


public class BatallonTest {
	/**
	 * 	
	 * Partida entre npc para probar el algoritmo propuesto en clase.
	 * 
	 * @param b1
	 * @param b2
	 * @return
	 */
	private String partidaEntreNPCs(Batallon b1, Batallon b2) {
		boolean fin = false;
		String ganador = "empate";
		int i = 1;

		//System.out.println("¡Empieza la batalla!");
		while( !fin || i <= 100 ){ 	//Hasta que alguno gane o se lleguen a los 100 turnos. 
									//(considerando que cualquier ataque gaste energia, puede pasar que todo el equipo de bot se qude sin energia).
			
			//	System.out.println("Round "+i+".");
			b1.atacar(b2);
			if( b2.isEmpty() ){
				fin = true;
				ganador = b1.quienSoy();
			}
			
			b2.atacar(b1);
			if( b1.isEmpty() ){
				fin = true;
				ganador = b2.quienSoy();
			}
			i++;
		}
		
		return ganador;
	}
	
    /***********************************************************************************************************************************
	 *  Cuando es n vs n deberia ganar los orcos porque van eliminandos humanos uno a uno entonces el humano tiene menos ataque promedio.*
	 *  Suponiendo que los dos tenga ataques iguales, y que el ataque sea menor que la vida.										   * 	
	 ***********************************************************************************************************************************/
	
	@Test
	public void batallaGanaHumano1vs1(){
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(1);
		//Comienza primero el humano y gana
		Assert.assertEquals("humanos", partidaEntreNPCs(b_Humano, b_Orco));
	}
	@Test
	public void batallaGanaOrco1vs1(){
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(1);
		//Comienza primero el orco y gana
		Assert.assertEquals("orcos", partidaEntreNPCs(b_Orco,b_Humano));
	}

	@Test
	public void batallaGanaOrcos10vs10(){
		Batallon b_Humano = new BatallonHumano(10);
		Batallon b_Orco = new BatallonOrco(10);
		Assert.assertEquals("orcos", partidaEntreNPCs(b_Humano, b_Orco));
	}
	
	
	@Test
	public void batallaGanaOrcos1000vs1000(){
		Batallon b_Humano = new BatallonHumano(1000);
		Batallon b_Orco = new BatallonOrco(1000);
		Assert.assertEquals("orcos", partidaEntreNPCs(b_Humano, b_Orco));
	}
	@Test
	public void batallaGanaHumanos15vs1(){
		Batallon b_Humano = new BatallonHumano(15);
		Batallon b_Orco = new BatallonOrco(1);
		Assert.assertEquals("humanos", partidaEntreNPCs(b_Humano, b_Orco));
	}
	@Test
	public void batallaGanaOrcos1vs15(){
		Batallon b_Humano = new BatallonHumano(1);
		Batallon b_Orco = new BatallonOrco(15);
		Assert.assertEquals("orcos", partidaEntreNPCs(b_Humano, b_Orco));
	}

	
}
