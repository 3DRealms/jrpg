package item;


import java.sql.SQLException;
import java.util.Map;

import database.SQLiteJDBC;
import habilidad.Habilidad;

public class ItemsLanzables {

	private static ItemsLanzables instance = null;
	private Map<String, ItemLanzable> lanzables;

	private ItemsLanzables() throws SQLException {
		lanzables = SQLiteJDBC.obtenerLanzables();
	}

	public static ItemsLanzables getInstance(){
		if(instance == null) {
			try {
				instance = new ItemsLanzables();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public ItemLanzable getLanzable(String key) {
		return lanzables.get(key);
	}

}