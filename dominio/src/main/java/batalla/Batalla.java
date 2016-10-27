package batalla;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import personaje.Personaje;
import interfaces.Equipo;



@SuppressWarnings("unused") // banca un cacho loco
public class Batalla  {

	private List  <Personaje> equipo1Original;
	private List  <Personaje> equipo2Original;

	private List  <Personaje> equipo1;
	private List  <Personaje> equipo2;
	
	/**
	 * Para test (segun Lucas)
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



	public Batalla(Equipo equipo1, Equipo equipo2){
		this.equipo1 = equipo1.getEquipo();
		this.equipo2 = equipo2.getEquipo();

		this.equipo1Original = equipo1.clonar();
		this.equipo2Original = equipo2.clonar();
	}

	public void batallar(){
		//peleo mientras no haya ganador
		while(obtenerGanador() != null){

//			turno( pedirAccion(equipo1) , pedirAccion(equipo2) );
			//Despues se cargarian las Accion en una lista?
			
		}

		finalizarBatalla(obtenerGanador());

	}

	private void turno(List <Accion> accEquipo1, List <Accion> accEquipo2){
		//ejecuto las Accion y voy mandando lo que pasa al cliente
	}

	private List<Personaje> obtenerGanador(){
		//recorro la lista de cada equipo a ver si estan vivos o muerto

		return null;
	}

	private List<Accion> pedirAccion(ArrayList<Personaje> equipo){
		// aca le pido las Accion a cada equipo de lo que desean hacer
		Accion accion;
		List<Accion> acciones = new ArrayList<Accion>();
		for (int i = 0; i < equipo.size(); i++) {
			accion = equipo.get(i).pedirAccion();
			acciones.add(accion);
		}
		return acciones;
	}

	private void darBotin(List <Personaje> ganador, List <Personaje> perdedor){
		//le quito el botin al equipo perdedor y se lo doy al ganador

	}

	private void darExperiencia(List <Personaje> ganador, List <Personaje> perdedor){
		// y le doy la experiencia al cada personaje del equipo ganador
	}

	private void finalizarBatalla(List <Personaje> ganador){
		if(ganador == equipo1){ //aca se podria preguntar si hay empate
			darBotin(equipo1,equipo2); // y en el "else", un ternario preguntando ganador entre equipo 1 y 2
		}
		else{
			darBotin(equipo2,equipo1);
		}
	}
	
}
