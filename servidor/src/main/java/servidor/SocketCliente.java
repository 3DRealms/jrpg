package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import com.google.gson.Gson;
import mapa.Punto;
import mensaje.*;
import personaje.Personaje;

public class SocketCliente {
	
	String usuario;
	Socket cliente;
	private Personaje per;
	
	public Personaje getPer() {
		return per;
	}

	public void setPer(Personaje per) {
		this.per = per;
	}

	public SocketCliente(Socket cliente){
		this.cliente = cliente;
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	
	public void enviarMensaje(Object men) throws IOException{
		DataOutputStream salida = new DataOutputStream(
				cliente.getOutputStream());
		final Gson gson = new Gson();		
		salida.writeUTF(gson.toJson(men));
		
	}
	
	public void enviarMensajeServidor(String mensaje) throws IOException{
		this.enviarMensaje(new Mensaje("Servidor", mensaje));
	}
	
	public void cerrar() throws IOException{
		cliente.close();
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public Mensaje pedirMensaje() throws IOException{
		DataInputStream lectura = new DataInputStream(
				cliente.getInputStream());
		String leido = lectura.readUTF();
		Gson gson = new Gson();
		Mensaje men = gson.fromJson(leido, Mensaje.class);
		return men;
	}
	
	
	public MensajeAutenticacion pedirAutenticacion() throws IOException{
		DataInputStream lectura = new DataInputStream(
				cliente.getInputStream());
		String leido = lectura.readUTF();
		Gson gson = new Gson();
		MensajeAutenticacion men = gson.fromJson(leido, MensajeAutenticacion.class);
		return men;
	}
	
	public void enviarMensajeConfirmacion(boolean estado,String mensaje) throws IOException{
		this.enviarMensaje(new MensajeConfirmacion(estado, mensaje));
	}
	
	public void enviarMensajePosicion(Punto punto,String personaje, String mapa, String sprite) throws IOException{
		this.enviarMensaje(new MensajeMovimiento(punto, personaje, mapa,sprite));
	}

	public MensajeInteraccion pedirMensajeInteraccion() throws IOException {
		
		DataInputStream lectura = new DataInputStream(
				cliente.getInputStream());
		String leido = lectura.readUTF();
		Gson gson = new Gson();
		
		MensajeInteraccion men = gson.fromJson(leido, MensajeInteraccion.class);
		if(men.isMovimiento())
			return gson.fromJson(leido, MensajeMovimiento.class);
		if(men.isAccion())
			return men;
		if(men.isCombate())
			return men;
		if(men.isParado())
			return men;
		
		return null;
	}
	
	

}
