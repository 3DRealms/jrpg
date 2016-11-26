package servidor;

import java.sql.SQLException;
import java.util.Map;

import database.SQLiteJDBC;
import item.ItemEquipo;

public class ItemsEquipo {

	private static ItemsEquipo instance = null;
	private Map<String,ItemEquipo> itemsEquipo;

	private ItemsEquipo() throws SQLException {
		itemsEquipo = SQLiteJDBC.obtenerEquipables();
	}

	public static ItemsEquipo getInstance() throws SQLException  {
		if(instance == null) {
			instance = new ItemsEquipo();
		}
		return instance;
	}

	public ItemEquipo getHabilidad(String key) {
		return itemsEquipo.get(key);
	}

}
