package servidor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import database.SQLiteJDBC;
import mensaje.*;



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
			// TODO Auto-generated catch block
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
					cliente.enviarMensajeConfirmacion(true, "");									
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
					//jugadores.agregarCliente(cliente);					
					//escuchar(jugadores);
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
				Mensaje mens = new Mensaje(cliente.getUsuario(),cliente.pedirMensaje().getMensaje());
				new ThreadEnviar(can, mens).start();
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
