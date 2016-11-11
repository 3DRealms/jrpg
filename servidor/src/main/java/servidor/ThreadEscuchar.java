package servidor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import database.SQLiteJDBC;
import mapa.Punto;
import mensaje.*;
import personaje.FactoriaPersonaje;
import personaje.Personaje;
import raza.Humano;



public class ThreadEscuchar extends Thread{
	
	private Canal jugadores;
	private SocketCliente cliente;
	SQLiteJDBC sqcon;
	
	public ThreadEscuchar(Canal jugadores, SocketCliente cliente){
		this.jugadores = jugadores;
		this.cliente = cliente;
		try {
			sqcon = SQLiteJDBC.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		
		
		intro();
		
	}
	
	private void intro(){
		try {

			MensajeAutenticacion men = cliente.pedirAutenticacion();
			
			if(men.isRegistro()){
				if(sqcon.crearUsuario(men.getUsername(), men.getPassword())){
					//si los datos son para un nuevo registro sigo con el mismo
					Personaje newper = FactoriaPersonaje.getPersonaje(men.getUsername(), "humano", "mago");
					newper.setUbicacion(6, 6);
					if(sqcon.guardarPersonaje(newper))
						cliente.enviarMensajeConfirmacion(true, "");
					else
						cliente.enviarMensajeConfirmacion(false, "Error al crear el personaje, intentelo nuevamente");
				}
				else{
					//sino le digo el nombre de usuario ya existe
					cliente.enviarMensajeConfirmacion(false, "El usuario ya existe");
				}
			}
			else{
				if(sqcon.autenticarUsuario(men.getUsername(), men.getPassword())){
					
					//si el mensaje era para loguearse y cumple la autenticacion lo uno al juego
					cliente.enviarMensajeConfirmacion(true, "");
					cliente.setUsuario(men.getUsername());
					Personaje per = sqcon.getPersonaje(men.getUsername());
					if(per != null){						
						jugadores.agregarCliente(cliente, per);					
						escuchar(jugadores);
						new ThreadEnviarPosicionesIniciales(jugadores, cliente).start();
					}
					else{
						cliente.enviarMensajeConfirmacion(false, "Hay un error con su cuenta.");
					}
					
				}
				else{
					//le muestro un error que los datos son incorrectos
					cliente.enviarMensajeConfirmacion(false, "Nombre de usuario y contraseña no coinciden");
				}
				
				
			}

			




		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	


	private void escuchar(Canal can){
		boolean conetado = true;
		while(conetado){
			
			try {
				MensajeInteraccion mens = cliente.pedirMensajeInteraccion();
				if(mens.isMovimiento())
					new ThreadEnviarMovimiento(can, mens).start();
			} catch (IOException e) {				
				e.printStackTrace();
				can.quitarCliente(cliente);
				try {
					cliente.cerrar();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				
				conetado = false;
				
				System.out.println("Servidor:Cliente Desconectado!");
			}
			
		}
	}
	
	

}
