package dominio;

import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.PersonajePrueba;

public class NivelPuntosTest {
	@Test
	public void subirExperienciaYSubirNivel() {
		Personaje dani = new PersonajePrueba("n00b");
		dani.subirExperencia(100);
		// ya subio un nivel, entonces obtengo 2 puntos de estados para gastar. (esto puede variar, no se si por nivel )
		Assert.assertEquals( 2 , dani.getPuntosDeEstados());		
	}
	
	@Test
	public void gastar2Puntos(){
		Personaje dani = new PersonajePrueba("n00b");
		dani.subirExperencia(100);
		dani.subirIntelecto();
		dani.subirIntelecto();
		Assert.assertEquals( 0 , dani.getPuntosDeEstados());		

	}
	@Test
	public void gastar1Puntos(){
		Personaje dani = new PersonajePrueba("n00b");
		dani.subirExperencia(100); //Obtengo 2 puntos por nivel(por ahroa xD)
		dani.subirIntelecto();
		Assert.assertEquals( 1 , dani.getPuntosDeEstados());		
		
	}
	@Test
	public void suboVariosNivelesEnFormaInregular(){
		Personaje dani = new PersonajePrueba("n00b");
		//1000 exp que necesito para subir al nivel 5
		dani.subirExperencia(90); 
		dani.subirExperencia(50); 
		dani.subirExperencia(100);
		dani.subirExperencia(75); 
		dani.subirExperencia(50); 
		dani.subirExperencia(5); 
		dani.subirExperencia(195); 
		dani.subirExperencia(100); 
		dani.subirExperencia(25); 
		dani.subirExperencia(110);
		dani.subirExperencia(200);
		//Suma total 1000 exp osea 5 niveles por ende si no gasto punto debo tener 10 puntos.
		Assert.assertEquals( 10 , dani.getPuntosDeEstados());		
	}
	@Test
	public void suboVariosNivelesEnFormaInregularIncremental(){
		Personaje dani = new PersonajePrueba("n00b");
		//1000 exp que necesito para subir al nivel 5
		dani.subirExperencia(5); 
		dani.subirExperencia(5); 
		dani.subirExperencia(5);
		dani.subirExperencia(5); 
		dani.subirExperencia(5); 
		dani.subirExperencia(5); 
		dani.subirExperencia(5); 
		dani.subirExperencia(5); 
		dani.subirExperencia(5); 
		dani.subirExperencia(5);
		Assert.assertEquals( 0 , dani.getPuntosDeEstados());		
		
		dani.subirExperencia(950);
		Assert.assertEquals( 10 , dani.getPuntosDeEstados());		
	}
	@Test
	public void suboMasDeUnNivelALaVez(){
		Personaje dani = new PersonajePrueba("n00b");
							//1000 exp que necesito para subir al nivel 5
		dani.subirExperencia(1000); //Obtengo 2 puntos por nivel * 5 (por ahroa xD)
		Assert.assertEquals( 10 , dani.getPuntosDeEstados());		
		
	}
}
