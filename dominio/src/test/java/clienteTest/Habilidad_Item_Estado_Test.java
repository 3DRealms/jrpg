package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import equipo.PaloDeEscobaMagico;
import habilidades.PiroExplosion;
import personaje.Personaje;
import raza.Mognatal;

public class Habilidad_Item_Estado_Test {
	///Tegno que arreglar este JUNIT, si lo arreglamos ya esta casi todo pipicucu.
	
	/**
	 *  Especificacion de Items:
	 *  ~~~~~~~~~~~~~~~~~~~~~~~
	 *  PaloDeEscobaMagico: Este baston sube 5 el intelecto.
	 *  
	 */
	
	@Test
	public void equipoSubeIntelectoYataco() {
		//Creo un mago, creo otro pj para que reciva danio, y bue.
		Personaje braian = new Mognatal("gandalf");
		braian.setCastaMago();
		braian.agregarHabilidad("piroExplosion", new PiroExplosion());
		Personaje alex = new Mognatal("pichon"); //creo un pichon.
		int alexSalud = alex.getSaludActual();

		braian = new PaloDeEscobaMagico(braian); //Aca le equipo un item.
		braian.lanzarHabilidad("piroExplosion", alex); // BOOOM.		
		
		//La piroExplicion +  palo de escoba magico (que sube 5 de intelecto) quita 40 puntos de daño.
		//Todavia no esta funcionando.
		Assert.assertEquals( alexSalud - 40, alex.getSaludActual());
	}
}
