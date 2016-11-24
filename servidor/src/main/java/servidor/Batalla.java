package servidor;


import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import acciones.Accion;
import batalla.EquipoSimple;
import personaje.Personaje;
import interfaces.Equipo;
import mensaje.Mensaje;



public class Batalla  {

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


	public Batalla(CanalCombate canalCombate) {
		this.socketEquipo1 = canalCombate.getEq1();
		this.socketEquipo2 = canalCombate.getEq2();
		
	}


	/**
	 * Batallar, es el combate por turnos, pero se ordena segun la velocidad de la accion elegida.
	 * Al finalizar la batalla se reparte el botin, oro y experiencia.
	 *
	 * Con un par de if, podemos hacer que la batalla sea distinta :D (por velocidad, o por otro parametro).
	 */	
	public void batallar(){
		// Peleo mientras no haya ganador
		List<Accion> accionesEquipo1;
		List<Accion> accionesEquipo2;

		while( obtenerGanador() == null ){

			accionesEquipo1 = pedirAcciones(socketEquipo1);
			accionesEquipo2 = pedirAcciones(socketEquipo2);
					
			turnoPorVelocidad( accionesEquipo1 , accionesEquipo2 ); // Las ejecuto.
			// Despues se cargarian las Accion en una lista?
		}

	//	finalizarBatalla(obtenerGanador());
	}


	private List<Accion> pedirAcciones(List<SocketCliente> eq ) {
		Accion acc;
		String json;
		List<Accion> acciones = new ArrayList<>();
		for(SocketCliente cliente : eq){
			try {
				
				Gson gson = new Gson();
				json = cliente.pedirMensajeBatalla().toString();
				acc = gson.fromJson(json , Accion.class);

				acciones.add( acc );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return acciones;
	}

	private void turnoPorVelocidad(List <Accion> accEquipo1, List <Accion> accEquipo2){
		//ejecuto las Accion y voy mandando lo que pasa al cliente

		//Uno las listas:
		List<Accion> acciones = new ArrayList<Accion>(accEquipo1);
		acciones.addAll(accEquipo2);

		//Ordeno por velocidad:
		Collections.sort(acciones, Accion.AccVelComparator);//Ordeno por velocidad.
		
		for (Accion accion : acciones) {
			accion.ejecutar();
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