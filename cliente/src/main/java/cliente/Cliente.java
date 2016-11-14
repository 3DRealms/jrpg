package cliente;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import casta.Casta;
import gson.CastaInstanceCreator;
import gson.EquipoInstanceCreator;
import gson.PersonajeInstanceCreator;
import interfaces.Equipo;
import juego.JuegoPanel;
import mensaje.*;
import personaje.Personaje;

public class Cliente {

	Socket cliente;
	String serverIP;
	Integer puerto;
	String usuario;
	JuegoPanel juego;
	JFrame ventana;
	

	public Cliente(String usuario) throws UnknownHostException, IOException{
		this.usuario = usuario;

		loadProperty("cliente.properties");
		cliente = new Socket(serverIP, puerto);


	}

	public void escuchar(){
		new ThreadClienteEscuchar(this).start();
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
	
	public void enviarInteraccion(MensajeInteraccion men) throws IOException{

		enviarObjeto(men);
		

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
	
	public MensajeInteraccion pedirInteraccion() throws IOException{
		DataInputStream lectura = new DataInputStream(
				cliente.getInputStream());
		final Gson gson = new Gson();
		String men = lectura.readUTF();
		final MensajeInteraccion menInt = gson.fromJson(men, MensajeInteraccion.class);
		return menInt;
	}
	
	public void abrirJuego(Personaje per){
		
		ventana=new JFrame("El señor de los aniloros"); //Ventana comun
		juego = new JuegoPanel(ventana,per.getUbicacion(),per, "map_test", this);
		ventana.add(juego); //Dentro de la ventana pongo el juego.
		ventana.pack(); //hace que el tamaño se ajuste al tamaño preferido y diseños de sus subcomponentes.
		ventana.setLocationRelativeTo(null); //centro
		ventana.setResizable(true); // evito que se cambie el tamaño para que no se chanfle todo.
		ventana.setVisible(true); // uno se mata haciendo los graficos para que ponga false ¬¬
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // :c adios amor.
		ventana.setCursor(cursor());
		escuchar();
		
	}
	private static Cursor cursor() {
		Image im = Toolkit.getDefaultToolkit().createImage("src\\main\\resources\\cursor.png");
		Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL");
		return cur;
	}

}
