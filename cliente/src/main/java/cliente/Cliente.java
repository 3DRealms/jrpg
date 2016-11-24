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
import gson.HabilidadInstanceCreator;
import gson.PersonajeInstanceCreator;
import habilidad.Habilidad;
import interfaces.Equipo;
import juego.JuegoPanel;
import mensaje.*;
import personaje.Personaje;
import ventana.Combate;

public class Cliente {

	private Socket cliente;
	private String serverIP;
	private Integer puerto;
	private String usuario;
	private JuegoPanel juego;
	private JFrame ventana;
	private Combate combat;
	private ThreadClienteEscuchar listenerInt;
	private Personaje pj;

	public Cliente(String usuario) throws UnknownHostException, IOException{
		this.usuario = usuario;
		loadProperty("cliente.properties");
		cliente = new Socket(serverIP, puerto);
	}

	public void escuchar(){
		listenerInt = new ThreadClienteEscuchar(this);
		listenerInt.start();
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



	public void cerrar() throws IOException{
		cliente.close();
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
		gsonBuilder.registerTypeAdapter(Habilidad.class,new HabilidadInstanceCreator());
		Gson gson = gsonBuilder.create();
		String lect = lectura.readUTF();
		return gson.fromJson(lect, Personaje.class);
	}



	public MensajeConfirmacion enviarRegistro(String user, String pass, String casta, String raza) throws IOException {
		enviarObjeto(new MensajeAutenticacion(usuario,pass,true,casta,raza));
		return this.pedirConfirmacion();
	}

	public void pedirInteraccion() throws IOException{
		DataInputStream lectura = new DataInputStream(
				cliente.getInputStream());
		String leido = lectura.readUTF();
		Gson gson = new Gson();

		MensajeInteraccion men = gson.fromJson(leido, MensajeInteraccion.class);
		if(men.isMovimiento()){
			men = gson.fromJson(leido, MensajeMovimiento.class);
			if(!men.getEmisor().equals(usuario))
				juego.nuevoMovimientoPersonajes(men.getEmisor(), ((MensajeMovimiento)men).getSprite(), ((MensajeMovimiento)men).getPos());
		}			
		if(men.isAccion()){

		}

		if(men.isCombate()){
			//aca ARRRRRRRANCO EL COMBATE
			//listenerInt.parar();
			men = gson.fromJson(leido, MensajeInicioCombate.class);

			combat = new Combate(((MensajeInicioCombate) men).getEquipo1() , ((MensajeInicioCombate)men).getEquipo2(),this);
			combat.setLocationRelativeTo(null); //centro
			combat.setResizable(false); // evito que se cambie el tamaño para que no se chanfle todo.
			combat.setVisible(true); // uno se mata haciendo los graficos para que ponga false ¬¬
			combat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // :c adios amor.
			ventana.setVisible(false);
		}

		if(men.isParado()){
			if(!men.getEmisor().equals(usuario))
				juego.nuevaDetencionPersonaje(men.getEmisor());
		}

	}

	public void abrirJuego(Personaje per){

		this.pj = per;
		ventana=new JFrame("El señor de los aniloros"); //Ventana comun
		juego = new JuegoPanel(ventana,per.getUbicacion(),per, "map_exterior", this);
		ventana.add(juego); //Dentro de la ventana pongo el juego.
		ventana.pack(); //hace que el tamaño se ajuste al tamaño preferido y diseños de sus subcomponentes.
		ventana.setLocationRelativeTo(null); //centro
		ventana.setResizable(false); // evito que se cambie el tamaño para que no se chanfle todo.
		ventana.setVisible(true); // uno se mata haciendo los graficos para que ponga false ¬¬
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // :c adios amor.
		ventana.setCursor(cursor());
		escuchar();

	}

	public void enviarMensajeCombate(String per){

		new ThreadClienteEnviarInteraccion(this,new MensajeInteraccion(per, MensajeInteraccion.COMBATE)).start();
	}

	private static Cursor cursor() {
		Image im = Toolkit.getDefaultToolkit().createImage("src\\main\\resources\\cursor.png");
		Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL");
		return cur;
	}

	public Personaje getPj() {
		return pj;
	}

	public void enviarMensajeDuranteBatalla(MensajeBatalla men) {
		try {
			enviarObjeto(men);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
