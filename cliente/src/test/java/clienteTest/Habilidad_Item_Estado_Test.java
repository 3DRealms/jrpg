package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import equipo.PaloDeEscobaMagico;
import habilidades.PiroExplosion;
import personaje.Personaje;
import raza.Mognatal;

public class Habilidad_Item_Estado_Test {
///Tegno que arreglar este JUNIT, si lo arreglamos ya esta casi todo pipicucu.
	@Test
	public void quePorFaltaDeEnergiaNoPuedaLanzarUnaHabilidad() {
		
		Personaje gandalf = new Mognatal("gandalf");
		
		gandalf.setCastaMago();
		gandalf.getCasta().agregarHabilidad("piroExplosion", new PiroExplosion());
		
		Personaje gimli = new Mognatal("gimli");
		
		Assert.assertEquals(120, gimli.getSaludActual());
		gandalf.lanzarHabilidad("piroExplosion", gimli); 
		
		Assert.assertEquals(100, gimli.getSaludActual());
		
		gandalf = new PaloDeEscobaMagico(gandalf);
		
		gandalf.getCasta().lanzarHabilidad("piroExplosion", gimli);
		Assert.assertEquals(60, gimli.getSaludActual());
		
		//aca no tiene mas energia porque ya quede en 30 y PiroExplocion consume 35.
		Assert.assertFalse(gandalf.lanzarHabilidad("piroExplosion", gimli)); 
		
		//Auto ataque de 15 puntos.
		gandalf.atacar(gimli);
		Assert.assertEquals(45, gimli.getSaludActual());
		
	}
}
