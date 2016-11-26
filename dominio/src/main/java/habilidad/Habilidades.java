package habilidad;


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

	public static Habilidades getInstance(){
		if(instance == null) {
			try {
				instance = new Habilidades();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public Habilidad getHabilidad(String key) {
		return habilidades.get(key);
	}

}