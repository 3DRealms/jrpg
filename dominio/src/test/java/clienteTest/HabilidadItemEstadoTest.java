package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import Equipo.PaloDeEscobaMagico;
import Equipo.VaritaMagica;
import habilidades.PiroExplosion;
import personaje.Personaje;
import raza.Mognatal;
import raza.PersonajePrueba;

public class HabilidadItemEstadoTest {
	///Tegno que arreglar este JUNIT, si lo arreglamos ya esta casi todo pipicucu.

	/**
	 *  Especificacion de Items:
	 *  ~~~~~~~~~~~~~~~~~~~~~~~
	 *  PaloDeEscobaMagico: Este baston sube 5 el intelecto. 
	 */

	@Test
	public void equipoSubeIntelectoYAtaco() {
		Personaje braian = new Mognatal("gandalf");
		braian.setCastaMago();
		braian.agregarHabilidad("piroExplosion", new PiroExplosion());
		Personaje alex = new PersonajePrueba("pichon"); //creo un pichon.

		int alexSalud = alex.getSaludActual();
		braian = new PaloDeEscobaMagico(braian); //Aca le equipo un item.
		braian.lanzarHabilidad("piroExplosion", alex); // BOOOM.

		//La piroExplicion +  palo de escoba magico (que sube 5 de intelecto) quita 40 puntos de daño.
		Assert.assertEquals( alexSalud - 40, alex.getSaludActual());
	}
		
	@Test
	public void equipoDosItemQueSubeIntelectoYAtaco() {
		Personaje braian = new Mognatal("gandalf");
		braian.setCastaMago();
		braian.agregarHabilidad("piroExplosion", new PiroExplosion());

		Personaje alex = new PersonajePrueba("pichon"); //creo un pichon.
		int alexSalud = alex.getSaludActual();

		braian = new PaloDeEscobaMagico(braian); //Aca le equipo un item.
		braian = new VaritaMagica(braian); //Aca le equipo otro item.
		braian.lanzarHabilidad("piroExplosion", alex); // BOOOM.

		//La piroExplicion +  palo de escoba magico + varita Magica (que sube 15 de intelecto en total) quita 80 puntos de daño.
		Assert.assertEquals( alexSalud - 80, alex.getSaludActual());
	}
	
	 
}
