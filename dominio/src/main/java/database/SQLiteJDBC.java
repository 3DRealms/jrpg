package database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import casta.Casta;
import gson.CastaInstanceCreator;
import gson.EquipoInstanceCreator;
import gson.HabilidadDeserialiser;
import gson.HabilidadInstanceCreator;
import gson.PersonajeInstanceCreator;
import habilidad.*;
import interfaces.Equipo;
import item.FactoriaItemLanzable;
import item.ItemEquipo;
import item.ItemLanzable;
import personaje.FactoriaPersonaje;
import personaje.Personaje;

public class SQLiteJDBC
{
	private static SQLiteJDBC instance = null;
	private static Connection c = null;

	protected SQLiteJDBC() throws ClassNotFoundException, SQLException {
		// Exists only to defeat instantiation.
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:juego.db");
		c.setAutoCommit(false);
	}

	public  boolean autenticarUsuario(String username, String password) throws SQLException{

		Statement stmt = null;
		username = username.toLowerCase();
		boolean resultado = false;


		stmt = c.createStatement();

		String consulta = "SELECT id_player FROM jugadores WHERE username = '"+username+"' AND password = '"+password+"' LIMIT 1;";

		ResultSet rs = stmt.executeQuery(consulta);
		resultado = rs.next();
		//boolean resultado = true;
		/*while ( rs.next() ) {
	         int id = rs.getInt("id_player");
	      }*/

		rs.close();
		stmt.close();

		return resultado;
	}


	public static Map<String,Habilidad> obtenerHabilidades() throws SQLException{

		Statement stmt = null;
		Map<String,Habilidad> habilidades = new HashMap<String,Habilidad>();

		stmt = c.createStatement();

		String consulta = "SELECT * FROM habilidad;";

		ResultSet rs = stmt.executeQuery(consulta);

		while ( rs.next() ) {
			Habilidad aux = FactoriaHabilidades.getHabilidad(
					rs.getString("nombre"), rs.getString("efecto"), rs.getString("descripcion"),
					rs.getInt("costo"), rs.getInt("nivel"), rs.getInt("cantEfecto"), rs.getInt("velocidad"));

			habilidades.put(rs.getString("key"), aux);
		}

		rs.close();
		stmt.close();



		return habilidades;
	}

	public static Map<String,ItemLanzable> obtenerLanzables() throws SQLException{

		Statement stmt = null;
		Map<String,ItemLanzable> lanzables = new HashMap<String,ItemLanzable>();
		stmt = c.createStatement();

		String consulta = "SELECT * FROM itemLanzable;";

		ResultSet rs = stmt.executeQuery(consulta);

		while ( rs.next() ) {
			ItemLanzable aux = FactoriaItemLanzable.getItemLanzable(
					rs.getString("key"), rs.getInt("nivel"),rs.getString("nombre"), rs.getString("descripcion"),
					rs.getInt("cantEfecto"), rs.getString("efecto"),1, rs.getInt("velocidad"));

			lanzables.put(rs.getString("key"), aux);
		}

		rs.close();
		stmt.close();


		return lanzables;
	}

	public static Map<String,ItemEquipo> obtenerEquipables() throws SQLException{

		Statement stmt = null;
		Map<String,ItemEquipo> equipables = new HashMap<String,ItemEquipo>();

		stmt = c.createStatement();

		String consulta = "SELECT * FROM itemEquipable;";

		ResultSet rs = stmt.executeQuery(consulta);

		while ( rs.next() ) {
			ItemEquipo aux = new ItemEquipo(
					rs.getString("key"), rs.getInt("nivel"), rs.getString("nombre"),
					rs.getString("descripcion"),rs.getInt("fuerza"), rs.getInt("intelecto"), 
					rs.getInt("destreza"),rs.getInt("vitalidad"), rs.getInt("ataqueFisico"), 
					rs.getInt("ataqueMagico"),rs.getInt("defensaFisica"), rs.getInt("defensaMagica"),rs.getString("tipo"));	

			equipables.put(rs.getString("key"), aux);
		}

		rs.close();
		stmt.close();



		return equipables;
	}

	public  boolean crearUsuario(String username, String password) {

		Statement stmt = null;
		username = username.toLowerCase();
		try {
			stmt = c.createStatement();

			String sql = "INSERT INTO jugadores (username,password) " +
					"VALUES ('"+username+"', '"+password+"');"; 
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean guardarPersonaje(Personaje per) {
		Statement stmt = null;

		final Gson gson = new Gson();		

		try {
			stmt = c.createStatement();
	
		String sql = "UPDATE jugadores SET json = '" +
				gson.toJson(per) +
				"' WHERE username = '"+per.getNombre().toLowerCase()+"';"; 

		stmt.executeUpdate(sql);

		stmt.close();
		c.commit();	
		} catch (SQLException e) {
			return false;
		}

		return true;

	}

	public void cerrar() throws SQLException{
		c.close();
	}

	public static SQLiteJDBC getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new SQLiteJDBC();
		}
		return instance;
	}

	public Personaje getPersonaje(String username) throws SQLException {
		Statement stmt = null;
		username = username.toLowerCase();
		Personaje resultado = null;

		stmt = c.createStatement();

		String consulta = "SELECT json FROM jugadores WHERE username = '"+username+"' LIMIT 1;";

		ResultSet rs = stmt.executeQuery(consulta);
		if(rs.next()){
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Casta.class, new CastaInstanceCreator()); 
			gsonBuilder.registerTypeAdapter(Personaje.class, new PersonajeInstanceCreator()); 
			gsonBuilder.registerTypeAdapter(Equipo.class, new EquipoInstanceCreator()); 
			gsonBuilder.registerTypeAdapter(Habilidad.class, new HabilidadDeserialiser()).create();
			Gson gson = gsonBuilder.create();
			String stringRes = rs.getString("json");

			resultado = gson.fromJson(stringRes, Personaje.class);
			////resultado = FactoriaPersonaje.reconstruirPersonaje(resultado);


		}
		rs.close();
		stmt.close();
		return resultado;

	}
}