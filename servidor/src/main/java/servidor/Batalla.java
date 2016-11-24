package servidor;


import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import acciones.Accion;
import acciones.AccionGenerica;
import acciones.FactoriaAcciones;
import batalla.EquipoSimple;
import personaje.Personaje;
import interfaces.Equipo;
import mensaje.Mensaje;
import mensaje.MensajeActualizacionCobate;
import mensaje.MensajeBatalla;
import mensaje.MensajeInicioCombate;
import mensaje.MensajeInteraccion;



public class Batalla extends Thread  {

	private List  <Personaje> equipo1Original;
	private List  <Personaje> equipo2Original;

	private List<SocketCliente> socketEquipo1;
	private List<SocketCliente> socketEquipo2;
	private EquipoSimple equipo1;
	private EquipoSimple equipo2;
	/** Para test (segun Lucas)
	 * @param e1
	 * @param e2
	 * @return
	 */
	public static String batallaAutotomatica(Equipo e1, Equipo e2) {
		boolean fin = false;
		String ganador = "empate";
		while( !fin ){ 	
			e1.atacar(e2);
			if( e2.isEmpty() ){
				fin = true;
				ganador = e1.toString();
			}

			e2.atacar(e1);
			if( e1.isEmpty() ){
				fin = true;
				ganador = e2.toString();
			}
		}
		return ganador;
	}


	public Batalla(CanalCombate canalCombate)  {
		this.socketEquipo1 = canalCombate.getEq1();
		this.socketEquipo2 = canalCombate.getEq2();

	}


	/**
	 * Batallar, es el combate por turnos, pero se ordena segun la velocidad de la accion elegida.
	 * Al finalizar la batalla se reparte el botin, oro y experiencia.
	 *
	 * Con un par de if, podemos hacer que la batalla sea distinta :D (por velocidad, o por otro parametro).
	 * @throws InterruptedException 
	 */	
	public void batallar() throws InterruptedException{
		// Peleo mientras no haya ganador
		List<Accion> accionesEquipo1;
		List<Accion> accionesEquipo2;
		
		int turno = 1;
		while( obtenerGanador() == null ){

			accionesEquipo1 = pedirAcciones(socketEquipo1);
			accionesEquipo2 = pedirAcciones(socketEquipo2);

			turnoPorVelocidad( accionesEquipo1 , accionesEquipo2 ); // Las ejecuto.
			// Despues se cargarian las Accion en una lista?
			turno ++;
		}
		

		//	finalizarBatalla(obtenerGanador());
	}


	private List<Accion> pedirAcciones(List<SocketCliente> eq ) {
		Accion acc;
		MensajeBatalla men;


		List<Accion> acciones = new ArrayList<>();
		for(SocketCliente cliente : eq){
			if(cliente.getPer().estaMuerto())
				continue; //saltea el pj
			try {

				men = cliente.pedirMensajeBatalla();
				acc = FactoriaAcciones.getAccion(buscarPJ(men.getEmisor()),buscarPJ(men.getObjetivo()),men.getAccion(),men.getTipo());

				acciones.add( acc );
			} catch (IOException e) {
				//e.printStackTrace(); Cambiemos.
			}
		}
		return acciones;
	}

	private void turnoPorVelocidad(List <Accion> accEquipo1, List <Accion> accEquipo2) throws InterruptedException{
		//ejecuto las Accion y voy mandando lo que pasa al cliente

		//Uno las listas:
		List<Accion> acciones = new ArrayList<Accion>(accEquipo1);
		acciones.addAll(accEquipo2);

		//Ordeno por velocidad:
		Collections.sort(acciones, Accion.AccVelComparator);//Ordeno por velocidad.
		MensajeActualizacionCobate emisor;
		MensajeActualizacionCobate objetivo;
		Personaje pjAux;
		
		for (Accion accion : acciones) {
			accion.ejecutar();
			
			pjAux = accion.getEmisor();
			emisor = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), "TOMA WACHO" );
			
			pjAux = accion.getObjetivo();
			objetivo = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), "TOMA WACHO" );
			
			enviarMensajes(emisor,objetivo);	
			sleep(4000);
		}
		
		perdirAccionesClientes();
		
	}

	private void perdirAccionesClientes() {
		MensajeActualizacionCobate men = new MensajeActualizacionCobate("", MensajeInteraccion.PEDIRACCION, 0, 0, "");
		
		for(SocketCliente cliente : socketEquipo1){
			try {
				cliente.enviarMensaje(men);
			} catch (IOException e) {
			//	e.printStackTrace(); // Cambiemos
			}
		}		
		for(SocketCliente cliente : socketEquipo2){
			try {
				cliente.enviarMensaje(men);
			} catch (IOException e) {
				//	e.printStackTrace(); // Cambiemos
			}
		}
		
	}


	private Personaje buscarPJ(String string) {
		for(SocketCliente cliente : socketEquipo1){
			if( string.equals(cliente.getPer().getNombre()))
				return cliente.getPer();
		}		
		for(SocketCliente cliente : socketEquipo2){
			if( string.equals(cliente.getPer().getNombre()))
				return cliente.getPer();
		}		
		return null;
	}


	private void enviarMensajes(MensajeActualizacionCobate emisor, MensajeActualizacionCobate objetivo) {
		for(SocketCliente cliente : socketEquipo1){
			try {
				cliente.enviarMensaje(emisor);
				cliente.enviarMensaje(objetivo);
			} catch (IOException e) {
			//	e.printStackTrace(); // Cambiemos
			}
		}		
		for(SocketCliente cliente : socketEquipo2){
			try {
				cliente.enviarMensaje(emisor);
				cliente.enviarMensaje(objetivo);
			} catch (IOException e) {
				//	e.printStackTrace(); // Cambiemos
			}
		}		
	}


	/**
	 * Devuelve si hay ganador.(osea el equipo contrario muere);
	 * @return
	 */
	private EquipoSimple obtenerGanador(){
		if( socketEquipo2.isEmpty() ){
			return equipo1;
		}
		if( socketEquipo1.isEmpty() ){
			return equipo2;
		}
		return null;
	}




	private void darBotin(Equipo ganador, Equipo perdedor){

		//	List<Equipo> equipo;
		int oro; 
		int experiencia;
		//le quito el botin al equipo perdedor y se lo doy al ganador
		//equipo = perdedor.perderItemsEquipo(); 
		oro = perdedor.quitarOro();	
		experiencia = calcularExperencia();

		ganador.repartirBotin(oro);
		ganador.darExperiencia(experiencia);
	}

	private int calcularExperencia() {
		return 0; //esto puede ser por la duracion, o por la cantidad de turnos, o que se yoxDD.
	}

	private void finalizarBatalla(Equipo ganador){
		//	if( ganador == socketEquipo1)
		//darBotin(socketEquipo1,socketEquipo2);
		//else
		//	darBotin(socketEquipo2,socketEquipo1);

	}

}
