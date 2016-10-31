package database;

import java.sql.*;

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

	public  boolean autenticarUsuario(String username, String password){
		
		Statement stmt = null;
		username = username.toLowerCase();
		boolean resultado = false;
		try {

			stmt = c.createStatement();

			String consulta = "SELECT id_player FROM jugadores WHERE username = '"+username+"' AND password = '"+password+"' LIMIT 1;";

			ResultSet rs = stmt.executeQuery(consulta);
			resultado = rs.next();
			//boolean resultado = true;
			/*while ( rs.next() ) {
	         int id = rs.getInt("id_player");
	         System.out.println(id);
	      }*/

			rs.close();
			stmt.close();
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}

		return resultado;
	}
	
	public  boolean crearUsuario(String username, String password){

		Statement stmt = null;
		username = username.toLowerCase();
		try {			
			stmt = c.createStatement();
			String sql = "INSERT INTO jugadores (username,password) " +
					"VALUES ('"+username+"', '"+password+"');"; 
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
			return true;



	}
	
	public void cerrar(){
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static SQLiteJDBC getInstance() throws ClassNotFoundException, SQLException {
	      if(instance == null) {
	         instance = new SQLiteJDBC();
	      }
	      return instance;
	   }
}