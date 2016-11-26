package servidor;


import java.sql.SQLException;
import java.util.Map;

import database.SQLiteJDBC;
import habilidad.Habilidad;

public class Habilidades {

	private static Habilidades instance = null;
	private Map<String,Habilidad> habilidades;

	private Habilidades() throws SQLException {
		habilidades = SQLiteJDBC.obtenerHabilidades();
	}

	public static Habilidades getInstance() throws SQLException {
		if(instance == null) {
			instance = new Habilidades();
		}
		return instance;
	}
	
	public Habilidad getHabilidad(String key) {
		return habilidades.get(key);
	}

}