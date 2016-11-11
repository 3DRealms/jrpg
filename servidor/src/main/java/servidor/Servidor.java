package servidor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import database.SQLiteJDBC;

public class Servidor extends Thread{
	
	private Canal jugadores = new Canal("General", 200,200);
	private int puerto;
	
	Servidor() throws IOException, ClassNotFoundException, SQLException{
		loadProperty("server.properties");
		SQLiteJDBC sqcon = SQLiteJDBC.getInstance();

	}
	
	@Override
	public void run(){
		
		try{
			
			ServerSocket server = new ServerSocket(puerto);
			SocketCliente cliente;
			System.out.println("Arranco el servidor!");
			while(true){
				cliente = new SocketCliente(server.accept());
				//cliente.enviarMensajeServidor("Conectado!");
				System.out.println("Servidor:Cliente Conectado!");
				//clientes.add(cliente);
				new ThreadEscuchar(jugadores,cliente).start();
				cliente = null;
			}
			
	
			}
			catch(IOException e){
				e.printStackTrace();
			}

		
	}
	
	private void loadProperty(String dir) throws IOException{
		Properties propiedades = new Properties();
		InputStream entrada = null;	
		entrada = new FileInputStream(dir);
		propiedades.load(entrada);
		
		String puertoString = propiedades.getProperty("port");
		puerto =  Integer.parseInt(puertoString);
	}
	
	public static void main(String[] args) {
		Servidor escuchar;
		try {
			escuchar = new Servidor();
			escuchar.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String sTexto;
			boolean conectado = true;

			sTexto = br.readLine();	
			while(! sTexto.equals("FIN") && conectado) {		  
				//aca hago comandos locos
				sTexto = br.readLine();
			}
			System.exit(0);

		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
