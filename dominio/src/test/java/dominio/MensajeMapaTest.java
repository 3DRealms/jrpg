package dominio;

import org.junit.Assert;
import org.junit.Test;

import mapa.Mapa;
import mapa.Punto;
import mensaje.MensajeMovimiento;
import personaje.Personaje;
import raza.PersonajePrueba;

public class MensajeMapaTest {
/*	
	@Test
	public void casoAgregoYMuevoporMensaje(){
		Mapa mapa1 = new Mapa("map1",1,800,800);
		Personaje dani = new PersonajePrueba("El dani");
		dani.setUbicacion(1,1);
		dani.setPuedoMoverme(true);
		mapa1.agregarPersonaje(dani);
		MensajeMovimiento men = new MensajeMovimiento(new Punto(2,2), "El dani");
		Assert.assertTrue(mapa1.recibirMensajeMovmiento(men));
		Punto ubAct = dani.getUbicacion();
		Assert.assertTrue(ubAct.getX() == 2 && ubAct.getY() == 2);				
	}
	
	@Test
	public void AgregoMuchosYMuevoVariasVecesporMensaje(){
		Mapa mapa1 = new Mapa("map1",1,800,800);
		Personaje dani = new PersonajePrueba("El dani");
		Personaje alex = new PersonajePrueba("El alex");
		dani.setUbicacion(1,1);
		alex.setUbicacion(10,10);
		dani.setPuedoMoverme(true);
		alex.setPuedoMoverme(true);
		mapa1.agregarPersonaje(dani);
		mapa1.agregarPersonaje(alex);
		MensajeMovimiento men = new MensajeMovimiento(new Punto(2,2), "El dani");
		Assert.assertTrue(mapa1.recibirMensajeMovmiento(men));
		men = new MensajeMovimiento(new Punto(3,3), "El dani");
		Assert.assertTrue(mapa1.recibirMensajeMovmiento(men));
		men = new MensajeMovimiento(new Punto(3,2), "El dani");
		Assert.assertTrue(mapa1.recibirMensajeMovmiento(men));		
		Punto ubAct = dani.getUbicacion();
		Assert.assertTrue(ubAct.getX() == 3 && ubAct.getY() == 2);
		men = new MensajeMovimiento(new Punto(10,9), "El alex");
		Assert.assertTrue(mapa1.recibirMensajeMovmiento(men));
		ubAct = alex.getUbicacion();
		Assert.assertTrue(ubAct.getX() == 10 && ubAct.getY() == 9);				
	}
*/
}
