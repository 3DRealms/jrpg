package equipos;

import java.util.LinkedList;
import java.util.List;

import interfaces.Atacable;
import interfaces.Equipo;
import personaje.Personaje;

public class Alianza implements Equipo{

	private List<Personaje> alianza;
	private String nombreEquipo;
	private int lider = -1; // (? preguntar pero bueno jajajaj
	
	/**
	 * Bueno alianza de personajes. 
	 * Se le debe pasar el nombre del equipo.
	 * @param nombreEquipo
	 * @author DrCoffee84
	 */
	public Alianza(String nombreEquipo) {
		alianza = new LinkedList<Personaje>();
		this.nombreEquipo = nombreEquipo;
	}
	/**
	 * Agregar personaje, por ahora pense que puede tener un lider
	 * que es el que decide las batallas.
	 * igual posiblemente esto no exista en el futuro :).
	 * @param pj
	 * @author DrCoffee84
	 */
	public void agregar(Personaje pj){
		alianza.add(pj);
		if( lider ==  -1 )
			lider = alianza.size();
	}


	/**
	 * El Equipo conformado por jugadores va tener que 
	 * atacar uno por vez en un turno de la partida
	 * cada jugador puede selecionar a quien va a atacar
	 * 
	 * ##
	 * y [a futuro] se deberia poder saltear un turno o 
	 * elegir el orden de ataque.
	 * Ej: j1 j2 j3 j4 j5
	 * pero estrategicamente quiero que ataque en el otro orden
	 * j4 j5 j1 j3 j2.
	 *  @author DrCoffee84
	 */
	//RANCIO.
	@Override
	public void atacar(Equipo victimas) {}
//	{
//		Scanner teclado = new Scanner(System.in);
//		Personaje victima;
//		Personaje pj;
//		String habilidad;
//		for (int i = 0; i < alianza.size(); i++) {
//			pj = alianza.get(i);
//			do {
//				i = teclado.nextInt();
//			} while (i < victimas.length() );
//			victima = victimas.get(i);
//			do {
//				habilidad = teclado.nextLine();
//			}while(pj.lanzarHabilidad( habilidad, victima));
//			victimas.serAtacado(victima);
//		}
//	}

	
	/// Todo el codigo de aqui puede volar:
	@Override
	public String toString() {
		return nombreEquipo;
	}

	@Override
	public boolean isEmpty() {
		return alianza.isEmpty();
	}
		
	@Override
	public void serAtacado(Atacable personaje) {
		if(  personaje.estaMuerto() ){
			this.alianza.remove(personaje);
		}
	}
	@Override
	public Personaje get(int i) {
		return alianza.get(i);
	}
	@Override
	public Atacable obtenerProximaVictima() {
		return null;
	}
	@Override
	public int length() {
		return 0;
	}


}
