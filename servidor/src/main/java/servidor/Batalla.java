package servidor;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import acciones.Accion;
import acciones.FactoriaAcciones;
import personaje.Personaje;
import interfaces.Equipo;
import mensaje.MensajeActualizacionCobate;
import mensaje.MensajeBatalla;
import mensaje.MensajeInicioCombate;
import mensaje.MensajeInteraccion;



public class Batalla extends Thread  {


	private List<SocketCliente> socketEquipo1;
	private List<SocketCliente> socketEquipo2;
	private List<Personaje> equipo1;
	private List<Personaje> equipo2;



	public Batalla(CanalCombate canalCombate)  {
		this.socketEquipo1 = canalCombate.getEq1();
		this.socketEquipo2 = canalCombate.getEq2();
		equipo1 = new ArrayList<>();
		equipo2 = new ArrayList<>();

		for (SocketCliente c : socketEquipo1) {
			equipo1.add(c.getPer());
		}

		for (SocketCliente c : socketEquipo2) {
			equipo2.add(c.getPer());
		}
	}



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





	/**
	 * Batallar, es el combate por turnos, pero se ordena segun la velocidad de la accion elegida.
	 * Al finalizar la batalla se reparte el botin, oro y experiencia.
	 *
	 * Con un par de if, podemos hacer que la batalla sea distinta :D (por velocidad, o por otro parametro).
	 * @throws InterruptedException 
	 * @throws IOException 
	 */	
	public void batallar() throws InterruptedException, IOException{
		// Peleo mientras no haya ganador
		List<Accion> accionesEquipo1;
		List<Accion> accionesEquipo2;

		while( obtenerGanador() == null ){

			accionesEquipo1 = pedirAcciones(socketEquipo1);
			accionesEquipo2 = pedirAcciones(socketEquipo2);

			turnoPorVelocidad( accionesEquipo1 , accionesEquipo2 ); // Las ejecuto.
		}

		finalizarBatalla(obtenerGanador());
	}


	private void mandarPersonajes() throws IOException {
		for(SocketCliente cliente : socketEquipo1){
			try {
				cliente.enviarMensaje(cliente.getPer()); //RANCIO <_
			} catch (IOException e) {
				socketEquipo1.remove(cliente); 
				cliente.cerrar();
			}
		}		
		for(SocketCliente cliente : socketEquipo2){
			try {
				cliente.enviarMensaje(cliente.getPer());//RANCIO  re loco >
			} catch (IOException e) {
				socketEquipo1.remove(cliente); 
				cliente.cerrar();
			}
		}		
	}


	private List<Accion> pedirAcciones(List<SocketCliente> eq ) throws IOException{
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
				socketEquipo1.remove(cliente); 
				cliente.cerrar(); // Si no puede enviar mensaje, y bue que se ponga a estudiar base de datos.
			}
		}
		return acciones;
	}

	private void turnoPorVelocidad(List <Accion> accEquipo1, List <Accion> accEquipo2) throws InterruptedException, IOException{
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
			if(accion.getEmisor().estaMuerto())
				continue; // salta una iteracion del fo

			int vida = accion.getObjetivo().getSaludActual();
			int mana = accion.getObjetivo().getEnergia();
			
			accion.ejecutar();

			pjAux = accion.getEmisor();
			String aux = armarMensajeLanzar(accion.getEmisor().getNombre(),accion.getObjetivo().getNombre(),accion.getTipo(),accion.getAccion());
			emisor = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), aux);
			String aux2 = armarMensajeEfecto(vida,mana,accion.getObjetivo().getVitalidad(),accion.getObjetivo().getEnergia(),accion.getObjetivo().getNombre());
			pjAux = accion.getObjetivo();
			objetivo = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), aux2 );

			enviarMensajes(emisor,objetivo);	
			sleep(4000);
		}
		if( obtenerGanador() == null)
			perdirAccionesClientes();

	}

	private String armarMensajeEfecto(int vidaI, int manaI, int vidaF, int manaF, String nombre) {
		String aux = nombre;
		int deltaVida = (vidaI-vidaF);
		int deltaMana = (manaI-manaF);
		if(deltaVida>0){
			aux+=" perdio "+deltaVida+" puntos de Vida";
		}else if(deltaVida<0){
			aux+=" gano "+Math.abs(deltaVida)+" puntos de Vida";
		}
		if(deltaMana>0){
			if(deltaVida!=0)
				aux+=" y";
			aux+=" perdio "+deltaMana+" puntos de Energia";
		}else if(deltaMana<0){
			if(deltaVida!=0)
				aux+=" y";
			aux+=" gano "+Math.abs(deltaMana)+" puntos de Energia";
		}
		
		
		
		
		return aux;
	}



	private String armarMensajeLanzar(String emisor, String objetivo, String tipo, String accion) {
		String aux = emisor;
		if(accion.equals("atacar")){
			aux += " ataco a "+objetivo;
		}
		else if(tipo.equals(MensajeBatalla.HABILIDAD)){
			aux += " lanzo "+accion+" sobre "+objetivo;
		}
		else if(tipo.equals(MensajeBatalla.DEFENDER)){
			aux += " se defendio";
		}
		else if(tipo.equals(MensajeBatalla.OBJETO)){
			aux += " utilizo "+accion+" sobre "+objetivo;
		}
		return aux;
	}



	private void perdirAccionesClientes() throws IOException {
		MensajeActualizacionCobate men = new MensajeActualizacionCobate("", MensajeInteraccion.PEDIRACCION, 0, 0, "");

		for(SocketCliente cliente : socketEquipo1){
			try {
				cliente.enviarMensaje(men);
			} catch (IOException e) {
				socketEquipo1.remove(cliente);
				cliente.cerrar();
			}
		}		
		for(SocketCliente cliente : socketEquipo2){
			try {
				cliente.enviarMensaje(men);
			} catch (IOException e) {
				socketEquipo1.remove(cliente); 
				cliente.cerrar();
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


	private void enviarMensajes(MensajeActualizacionCobate emisor, MensajeActualizacionCobate objetivo) throws IOException {
		for(SocketCliente cliente : socketEquipo1){
			try {
				cliente.enviarMensaje(emisor);
				cliente.enviarMensaje(objetivo);
			} catch (IOException e) {
				socketEquipo1.remove(cliente); cliente.cerrar();
			}
		}		
		for(SocketCliente cliente : socketEquipo2){
			try {
				cliente.enviarMensaje(emisor);
				cliente.enviarMensaje(objetivo);
			} catch (IOException e) {
				socketEquipo1.remove(cliente);
				cliente.cerrar(); // Que se vaya  a la ******* de su tia :).-
			}
		}		
	}


	/**
	 * Devuelve si hay ganador.(osea el equipo contrario muere);
	 * @return
	 */
	private List<Personaje> obtenerGanador(){
		if( estanMuertos(equipo1) ){
			return equipo2;
		}
		if( estanMuertos(equipo2) ){
			return equipo1;
		}
		return null;
	}

	private boolean estanMuertos(List<Personaje> equipo){
		for (Personaje personaje : equipo) {
			if(!personaje.estaMuerto())
				return false;
		}
		return true;
	}

	private void darBotin(List<Personaje> ganador, List<Personaje> perdedor){

		//	List<Equipo> equipo;
		int oro; 
		int experiencia;
		//le quito el botin al equipo perdedor y se lo doy al ganador
		//equipo = perdedor.perderItemsEquipo(); 
		oro = quitarOro(perdedor);	
		experiencia = calcularExperencia(perdedor);
		repartirBotin(oro,ganador,experiencia);

	}

	
	private int quitarOro(List<Personaje> perdedor) {
		int cantOro = 0;
		for (Personaje personaje : perdedor) {
			cantOro += personaje.quitarOroPerder();
		}
		return cantOro;
	}
	private void repartirBotin(int oro, List<Personaje> ganador, int experiencia) {
		oro /= ganador.size();
		experiencia /= ganador.size();
		for (Personaje personaje : ganador) {
			personaje.darOro(oro);
			personaje.subirExperencia(experiencia);
		}
		
	}

	private int calcularExperencia(List<Personaje> perdedor) {
		int cantExp = 0;
		for (Personaje pj : perdedor) {
			cantExp += pj.getNivel()*59; // pongo 59 porqiu eestoy re locooo
		}
		return cantExp;
	}

	private void finalizarBatalla(List<Personaje> ganador){
		if( ganador == equipo1)
			darBotin(equipo1,equipo2);
		else 
			darBotin(equipo2,equipo1);

	}


	private int getNivelPromedio(List<Personaje> ganador) {
		int nivelPromedio = 0;
		for (Personaje pj : ganador) {
			nivelPromedio += pj.getNivel();
		}
		return nivelPromedio/ganador.size();
	}


}
