package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import casta.Casta;
import gson.CastaInstanceCreator;
import gson.EquipoInstanceCreator;
import gson.PersonajeInstanceCreator;
import interfaces.Equipo;
import mensaje.*;
import personaje.Personaje;

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

	public Personaje pedirPersonaje() throws IOException{
		DataInputStream lectura = new DataInputStream(
				cliente.getInputStream());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Casta.class, new CastaInstanceCreator()); 
		gsonBuilder.registerTypeAdapter(Personaje.class, new PersonajeInstanceCreator()); 
		gsonBuilder.registerTypeAdapter(Equipo.class, new EquipoInstanceCreator()); 
		Gson gson = gsonBuilder.create();
		String lect = lectura.readUTF();
		System.out.println(lect);
		return gson.fromJson(lect, Personaje.class);

	}
	

	public MensajeConfirmacion enviarRegistro(String user, String pass, String casta, String raza) throws IOException {

		enviarObjeto(new MensajeAutenticacion(usuario,pass,true,casta,raza));
		return this.pedirConfirmacion();


	}


}
