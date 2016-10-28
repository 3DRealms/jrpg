package batalla;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import personaje.Personaje;
import interfaces.Equipo;



@SuppressWarnings("unused") // banca un cacho loco
public class Batalla  {

	private static final int MAX_JUGADORES = 5;

	private List  <Personaje> equipo1Original;
	private List  <Personaje> equipo2Original;

	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo equipoEmpate;

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


	/**
	 * Constructor de la clase batalla. 
	 * @param equipo1
	 * @param equipo2
	 */
	public Batalla(Equipo equipo1, Equipo equipo2){
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	/**
	 * Batallar, es el combate por turnos, pero se ordena segun la velocidad de la accion elegida.
	 * Al finalizar la batalla se reparte el botin, oro y experiencia.
	 */
	public void batallar(){
		// Peleo mientras no haya ganador
		List<Accion> accionesEquipo1;
		List<Accion> accionesEquipo2;

		while(obtenerGanador() != null){

			accionesEquipo1 = equipo1.pedirAccion(this); //Les pido las acciones al equipo1 de esta batalla.
			accionesEquipo2 = equipo2.pedirAccion(this); //Les pido las acciones al equipo2 de esta batalla.

			turnoPorVelocidad( accionesEquipo1 , accionesEquipo2 ); // Las ejecuto.

			// Despues se cargarian las Accion en una lista?

		}

		finalizarBatalla(obtenerGanador());



	}

	private void turnoPorVelocidad(List <Accion> accEquipo1, List <Accion> accEquipo2){
		//ejecuto las Accion y voy mandando lo que pasa al cliente

		//Uno las listas:
		List<Accion> acciones = new ArrayList<Accion>(accEquipo1);
		acciones.addAll(accEquipo2);

		//Ordeno por velocidad:
		acciones.sort(Accion.AccVelComparator); //Ordeno por velocidad.

		for (Accion accion : acciones) {
			accion.ejecutar();
		}
	}

	/**
	 * Devuelve si hay ganador.(osea el equipo contrario muere);
	 * @return
	 */
	private Equipo obtenerGanador(){
		if( equipo2.isEmpty() ){
			return equipo1;
		}
		if( equipo1.isEmpty() ){
			return equipo2;
		}
		return null;
	}




	private void darBotin(Equipo ganador, Equipo perdedor){

		List<Equipo> equipo;
		int oro; 
		int experiencia;
		//le quito el botin al equipo perdedor y se lo doy al ganador
		equipo = perdedor.perderItemsEquipo(); 
		oro = perdedor.quitarOro();	
		experiencia = calcularExperencia();

		ganador.repartirBotin(equipo,oro);
		ganador.darExperiencia(experiencia);
	}

	private int calcularExperencia() {
		return 0; //esto puede ser por la duracion, o por la cantidad de turnos, o que se yoxDD.
	}

	private void finalizarBatalla(Equipo ganador){
		if( ganador == equipo1)
			darBotin(equipo1,equipo2);
		else
			darBotin(equipo2,equipo1);

	}

}
