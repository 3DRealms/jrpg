package dominio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import acciones.Accion;
import batalla.EquipoJugadores;
import database.SQLiteJDBC;
import habilidad.Habilidad;

import mensaje.MensajeBatalla;
import personaje.Personaje;
import raza.PersonajePrueba;

public class PedirAccionTest {

	@Test
	public void peronsajePideAccion() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		
		Personaje pj = new PersonajePrueba("alex");
		pj.setCastaMago();
		pj.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));
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

	@Test
	public void equipoPedirAccion() throws ClassNotFoundException, SQLException {
		SQLiteJDBC.getInstance();
		Map<String, Habilidad> habilidades = SQLiteJDBC.obtenerHabilidades();
		// Creo 6 personajes, y 2 equipos:
		Personaje dani = new PersonajePrueba("dani");
		Personaje alex = new PersonajePrueba("alex");
		Personaje braian = new PersonajePrueba("braian");

		Personaje pablo = new PersonajePrueba("pablo");
		Personaje martin = new PersonajePrueba("martin");
		Personaje nahuel = new PersonajePrueba("nahuel");

		EquipoJugadores malos = new EquipoJugadores("Promotion system");
		EquipoJugadores buenos = new EquipoJugadores("3DRealms");


		//Esto lo voy a  suar para validar:
		int saludPablo = pablo.getSaludActual();
		int saluDNahuel = nahuel.getSaludActual();


		//Aca le doy habilidades a cada pj. por ahora es asi.
		dani.setCastaMago();
		dani.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));

		alex.setCastaLoroMaster();
		alex.agregarHabilidad("piroexplosion", habilidades.get("piroexplosion"));

		braian.setCastaGuerrero();
		braian.agregarHabilidad("piroexplosion", habilidades.get("curar"));

		martin.setCastaGuerrero();
		martin.agregarHabilidad("piroexplosion", habilidades.get("cadenarelampago"));


		// Esto es una lista de mensajes, que deberia ser por gson, pero para probar las hago a mano.
		List<MensajeBatalla> mensajeBuenos = new ArrayList<MensajeBatalla>();


		//Esto se llenaria por la red.
		MensajeBatalla mensajeDani		= new MensajeBatalla("yo", "pablo", "piroExplosion", "habilidad");
		MensajeBatalla mensajeAlex		= new MensajeBatalla("yo", "nahuel", "loroPunch", "habilidad");
		MensajeBatalla mensajeBraian	= new MensajeBatalla("yo", "dani", "curar", "habilidad");
		MensajeBatalla mensajeMartin 	= new MensajeBatalla("yo","dani","rompeHuesos","habilidad"); 

		//aca agrego al equipo.
		buenos.agregar(dani); 
		mensajeBuenos.add(mensajeDani);

		buenos.agregar(alex);
		mensajeBuenos.add(mensajeAlex);

		buenos.agregar(braian);
		mensajeBuenos.add(mensajeBraian);

		//Esto lo hago para que ataque al dani y despues se cura.
		malos.agregar(pablo);
		malos.agregar(martin);
		malos.agregar(nahuel);

		int saludDani = dani.getSaludActual();

		List<Accion> acc = buenos.pedirAccionTest(malos, mensajeBuenos );

		//esta accion solo es para bajarle vida a dani asi braian me cura.
		Accion ac = martin.pedirAccionTest(buenos, mensajeMartin );
		ac.ejecutar();
		//-50 del la habilidad rompe huesos que le hizo martin a dani.
		
		Assert.assertEquals(saludDani - 50 , dani.getSaludActual());

		saludDani = dani.getSaludActual();

		for (int i = 0; i < acc.size(); i++) {
			acc.get(i).ejecutar();			
		}

		//Compruebo que los resultados si son correctos
		Assert.assertEquals(saludPablo - 20, pablo.getSaludActual());
		Assert.assertEquals(saluDNahuel - 80, nahuel.getSaludActual());
		Assert.assertEquals(saludDani + 20, dani.getSaludActual());
	}
}
