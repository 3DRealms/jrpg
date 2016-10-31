package dominio;

import org.junit.Assert;
import org.junit.Test;

import acciones.Accion;
import batalla.EquipoJugadores;
import habilidades.PiroExplosion;
import mensaje.MensajeBatalla;
import personaje.Personaje;
import raza.PersonajePrueba;

public class PedirAccionTest {

	@Test
	public void caso01() {
		Personaje pj = new PersonajePrueba("alex");
		pj.setCastaMago();
		pj.agregarHabilidad("piroExplosion", new PiroExplosion());
		EquipoJugadores malos = new EquipoJugadores("Promotion system");
		Personaje pablito = new PersonajePrueba("pablo");
		
		malos.agregar(pablito);
		int saludPablito = pablito.getSaludActual();
		
		//Esto se llenaria por la red
		MensajeBatalla mensaje = new MensajeBatalla("yo", "pablo", "piroExplosion", "habilidad");
		
		Accion acc = pj.pedirAccionTest(malos, mensaje );
		acc.ejecutar();
		Assert.assertEquals(saludPablito - 20, pablito.getSaludActual());
		
	}
}
