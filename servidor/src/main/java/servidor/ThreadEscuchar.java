package servidor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import acciones.Accion;
import database.SQLiteJDBC;
import habilidad.Habilidad;
import mensaje.*;
import personaje.FactoriaPersonaje;
import personaje.Personaje;



public class ThreadEscuchar extends Thread{

	private Canal jugadores;
	private SocketCliente cliente;
	private SQLiteJDBC sqcon;
	private JTextArea textArea;

	public ThreadEscuchar(Canal jugadores, SocketCliente cliente,JTextArea textArea){
		this.jugadores = jugadores;
		this.cliente = cliente;
		this.textArea = textArea; // Para escribir los mensaje de error; solo es una referencia :v ultra cho optimo mama
		try {
			sqcon = SQLiteJDBC.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			textArea.append("Error con la base de datos.\nDetalle:  "+e.toString()+"\n");
		}
	}

	@Override
	public void run(){
		try {
			intro();
		} catch (SQLException e) {
			textArea.append("Error en la base de datos: " + e.toString()+"\n");
		}
	}

	private void intro() throws SQLException{
		try {
			MensajeAutenticacion men = cliente.pedirAutenticacion();
			if(men.isRegistro()){
				if(sqcon.crearUsuario(men.getUsername(), men.getPassword())){
					//si los datos son para un nuevo registro sigo con el mismo
					Personaje newper = FactoriaPersonaje.getPersonaje(men.getUsername(), men.getRaza(), men.getCasta());
					newper.setUbicacion(6, 6);
					if(sqcon.guardarPersonaje(newper))
						cliente.enviarMensajeConfirmacion(true, "");
					else
						cliente.enviarMensajeConfirmacion(false, "Error al crear el personaje, intentelo nuevamente");
				}
				else{
					cliente.enviarMensajeConfirmacion(false, "El usuario ya existe");
				}
			}
			else{
				if(sqcon.autenticarUsuario(men.getUsername(), men.getPassword())){

					//si el mensaje era para loguearse y cumple la autenticacion lo uno al juego
					cliente.enviarMensajeConfirmacion(true, "");
					cliente.setUsuario(men.getUsername());
					Personaje per = sqcon.getPersonaje(men.getUsername());
					Map<String, Habilidad> h = SQLiteJDBC.obtenerHabilidades();
					if(per != null){
						per.autoAgregarce();
						//per.agregarHabilidad("curar", h.get("curar"));
						
						cliente.enviarMensaje(per);
						cliente.setPer(per);
						jugadores.agregarCliente(cliente, per);		
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							textArea.append("Error al entrar el personaje al mundo");
						}
						new ThreadEnviarPosicionesIniciales(jugadores, cliente).start();
						textArea.append("Envio del personaje: "+per.getNombre()+"\n");
						escuchar(jugadores);						

					}
					else{
						cliente.enviarMensajeConfirmacion(false, "Hay un error con su cuenta.");
					}

				}
				else{
					//le muestro un error que los datos son incorrectos
					cliente.enviarMensajeConfirmacion(false, "Nombre de usuario y contraseña no coinciden.");
				}
			}

		} catch (IOException e) {
			try {
				cliente.cerrar();
			} catch (IOException e1) {
				textArea.append("No se pudo cerrar el cliente.\n");
			}
		}


	}



	private void escuchar(Canal can) throws SQLException{
		boolean conetado = true;

		while(conetado){

			try {

				MensajeInteraccion mens = cliente.pedirMensajeInteraccion();

				if(mens.isMovimiento()){
					can.moverPersonaje(cliente.getPer(), ((MensajeMovimiento) mens).getPos());
					new ThreadEnviarInteraccion(can, mens).start();
				}

				if(mens.isParado()){
					can.detenerPersonaje(cliente.getPer());
					new ThreadEnviarInteraccion(can, mens).start();
				}

				if( mens.isCombate() ){
					CanalCombate canalCombate  = can.empezarCombate(cliente.getPer().getNombre(), mens.getEmisor());
					escucharCombate(canalCombate);
				
				
				}
				if( mens.isArrancoCombate() ){
					can.terminarCombate(cliente.getPer().getNombre(), mens.getEmisor());

				}



			} catch (IOException e) {				
				can.quitarCliente(cliente);
				if(!sqcon.guardarPersonaje(cliente.getPer())){
					textArea.append("No se pudo guardar el personaje " + cliente.getUsuario());
				}
				try {
					cliente.cerrar();
				} catch (IOException e1) {
					textArea.append("No se pudo cerrar al cliente");
				}
				conetado = false;
				textArea.append("Cliente Desconectado.");
			}

		}
	}

	private void escucharCombate(CanalCombate canalCombate) {
		Batalla batalla = new Batalla(canalCombate);
	}



}
