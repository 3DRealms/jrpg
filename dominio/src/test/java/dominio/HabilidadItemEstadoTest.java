package dominio;

import org.junit.Assert;
import org.junit.Test;

import habilidades.PiroExplosion;
import itemEquipo.PaloDeEscobaMagico;
import itemEquipo.VaritaMagica;
import personaje.Personaje;
import raza.Mognatal;
import raza.PersonajePrueba;

public class HabilidadItemEstadoTest {

	@Test
	public void equipoSubeIntelectoYAtaco() {
		Personaje braian = new Mognatal("gandalf");
		braian.setCastaMago();
		braian.agregarHabilidad("piroExplosion", new PiroExplosion());
		Personaje alex = new PersonajePrueba("pichon"); //creo un pichon.

		int alexSalud = alex.getSaludActual();
		braian.equipar( new PaloDeEscobaMagico()); //Aca le equipo un item.
		braian.lanzarHabilidad("piroExplosion", alex);

		//La piroExplicion +  palo de escoba magico (que sube 5 de intelecto) quita 40 puntos de daño.
		Assert.assertEquals( alexSalud - 40, alex.getSaludActual());
	}

	@Test
	public void equipoDosItemQueSubeIntelectoYAtaco() {
		Personaje braian = new PersonajePrueba("gandalf");
		braian.setCastaMago();
		braian.agregarHabilidad("piroExplosion", new PiroExplosion());

		Personaje alex = new PersonajePrueba("pichon"); 
		int alexSalud = alex.getSaludActual();
		
		braian.equipar(new PaloDeEscobaMagico());	//Aca le equipo un item.	| 5 +
		braian.equipar(new VaritaMagica() );			//Aca le equipo otro item.	| 10 =
		braian.lanzarHabilidad("piroExplosion", alex);	//							| 15 de intelecto.
		
		Assert.assertEquals( alexSalud - 80, alex.getSaludActual());
		// La piroExplicion +  palo de escoba magico + varita Magica
		// quita 80 puntos de daño.
	}


}
