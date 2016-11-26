package dominio;

import habilidad.Habilidad;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import raza.Mognatal;
import database.SQLiteJDBC;

public class CastaTest {
	@Test
	public void quePuedoSerMago(){
		Mognatal dani = new Mognatal("dani");
		dani.setCastaMago();
		Assert.assertTrue(dani.getCasta().toString().equals("Mago"));
	}
	
	@Test
	public void quePuedoSeGuerrero(){
		Mognatal dani = new Mognatal("dani");
		dani.setCastaGuerrero();
		Assert.assertTrue(dani.getCasta().toString().equals("Guerrero"));
	}
	
	@Test
	public void quePuedoSerLoroMaster(){
		Mognatal dani = new Mognatal("dani");
		dani.setCastaLoroMaster();
		Assert.assertTrue(dani.getCasta().toString().equals("Loro Master"));
	}

}
