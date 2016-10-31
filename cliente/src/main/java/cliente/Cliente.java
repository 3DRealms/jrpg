package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import com.google.gson.Gson;

import mensaje.*;

public class Cliente {

	Socket cliente;
	String serverIP;
	Integer puerto;
	String usuario;
	

	public Cliente(String usuario) throws UnknownHostException, IOException{
		this.usuario = usuario;

		loadProperty("cliente.properties");
		cliente = new Socket(serverIP, puerto);


	}

	public void escuchar(){
		new ThreadClienteEscuchar(cliente).start();
	}

	public void enviar(String mensaje) throws IOException{
		DataOutputStream salida = new DataOutputStream(
				cliente.getOutputStream());
		Mensaje men = new Mensaje(mensaje);
		final Gson gson = new Gson();
		salida.writeUTF(gson.toJson(men));

	}
	
	private void enviarObjeto(Object mensaje) throws IOException{
		DataOutputStream salida = new DataOutputStream(
				cliente.getOutputStream());
		final Gson gson = new Gson();
		salida.writeUTF(gson.toJson(mensaje));
	}
	
	public MensajeConfirmacion enviarAutenticacion(String usuario, String clave) throws IOException{

		enviarObjeto(new MensajeAutenticacion(usuario,clave,false));
		return this.pedirConfirmacion();

	}
	
	


	public void cerrar(){
		try {
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadProperty(String dir) throws IOException{
		Properties propiedades = new Properties();
		InputStream entrada = null;	
		entrada = new FileInputStream(dir);
		propiedades.load(entrada);
		serverIP = propiedades.getProperty("serverIP");
		String puertoString = propiedades.getProperty("port");
		puerto =  Integer.parseInt(puertoString);
	}
	
	public MensajeConfirmacion pedirConfirmacion() throws IOException{
		DataInputStream lectura = new DataInputStream(
				cliente.getInputStream());
		final Gson gson = new Gson();
		return gson.fromJson(lectura.readUTF(), MensajeConfirmacion.class);

	}

	public MensajeConfirmacion enviarRegistro(String user, String pass) throws IOException {

		enviarObjeto(new MensajeAutenticacion(usuario,pass,true));
		return this.pedirConfirmacion();


	}


}
