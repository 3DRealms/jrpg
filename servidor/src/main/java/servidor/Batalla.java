package servidor;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
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
	
	private Canal canal;



	public Batalla(CanalCombate canalCombate, Canal canal)  {
		this.canal = canal;
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
		long timeout;

		while( obtenerGanador() == null ){
			
			//timeout = System.currentTimeMillis();
			
			accionesEquipo1 = pedirAcciones(socketEquipo1);
			accionesEquipo2 = pedirAcciones(socketEquipo2);
			
			sleep(2000);
			while((accionesEquipo1.size() + accionesEquipo2.size()) < (socketEquipo1.size() + socketEquipo2.size())){
				limpiarCanal(socketEquipo1);
				limpiarCanal(socketEquipo2);
				sleep(500);
			}
				
			turnoPorVelocidad( accionesEquipo1 , accionesEquipo2 ); // Las ejecuto.
		}

		finalizarBatalla(obtenerGanador());
	}

/* NO se estaria usando
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
*/

	private void limpiarCanal(List<SocketCliente> socketEquipo12) {

		for (SocketCliente cliente : socketEquipo12) {
			if(cliente.isCerrado()){

				socketEquipo12.remove(cliente);
				cliente.getPer().matar();
				canal.quitarCliente(cliente);
				
			}
				
		}

	}



	private List<Accion> pedirAcciones(List<SocketCliente> eq ) throws IOException{
		

		List<Accion> acciones = new ArrayList<>();
		try{
		for(SocketCliente cliente : eq){
			if(cliente.getPer().estaMuerto())
				continue; //saltea el pj
			new ThreadEscucharBatalla(cliente,acciones,this).start();
		}
		}
		catch (ConcurrentModificationException e) {
			// Superposicion de acciones? NO TENGO NI IDEA QUE AVISAR ACA!
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
			if(accion.getEmisor().estaMuerto() || accion.getEmisor()== null || accion.getObjetivo() == null)
				continue; // salta una iteracion del for si el emisor esta muerto, o si se descoecto el emisor o el objetivo

			int vida = accion.getObjetivo().getSaludActual();
			int mana = accion.getObjetivo().getEnergia();
			
			accion.ejecutar();
			
			 vida -=accion.getObjetivo().getSaludActual();
			 mana -= accion.getObjetivo().getEnergia();
			 /*if(vida<0){
				 vida=accion.getObjetivo().getVitalidad();
			 }*/
			
			pjAux = accion.getEmisor();
			String aux = armarMensajeLanzar(accion.getEmisor().getNombre(),accion.getObjetivo().getNombre(),accion.getTipo(),accion.getAccion());
			emisor = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), aux);
			String aux2 = armarMensajeEfecto(vida,mana,accion.getObjetivo().getNombre());
			pjAux = accion.getObjetivo();
			objetivo = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), aux2 );

			/*vida -= accion.getObjetivo().getSaludActual();
			pjAux = accion.getEmisor();
			String aux = armarMensajeLanzar(accion.getEmisor().getNombre(),accion.getObjetivo().getNombre(),accion.getTipo(),accion.getAccion());
			emisor = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), aux);
			String aux2 = armarMensajeEfecto(vida,mana,accion.getObjetivo().getVitalidad(),accion.getObjetivo().getEnergia(),accion.getObjetivo().getNombre());
			pjAux = accion.getObjetivo();
			objetivo = new MensajeActualizacionCobate( pjAux.getNombre()  , MensajeInicioCombate.ACTBATALLA, pjAux.getSaludActual(), pjAux.getEnergia(), aux2 );
*/
			enviarMensajes(emisor,objetivo);	
			sleep(4000);
		}
		if( obtenerGanador() == null)
			perdirAccionesClientes();

	}

	//private String armarMensajeEfecto(int vidaI, int manaI, int vidaF, int manaF, String nombre) {
	private String armarMensajeEfecto(int deltaVida, int deltaMana, String nombre) {
		String aux = nombre;
		//int deltaVida = (vidaI-vidaF);
		//int deltaMana = (manaI-manaF);
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
				cliente.getPer().matar();
				canal.quitarCliente(cliente);
			}
		}		
		for(SocketCliente cliente : socketEquipo2){
			try {
				cliente.enviarMensaje(men);
			} catch (IOException e) {
				socketEquipo2.remove(cliente);
				cliente.getPer().matar();
				canal.quitarCliente(cliente);
			}
		}
	}


	public Personaje buscarPJ(String string) {
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
				socketEquipo1.remove(cliente);
				cliente.getPer().matar();
				canal.quitarCliente(cliente);
			}
		}		
		for(SocketCliente cliente : socketEquipo2){
			try {
				cliente.enviarMensaje(emisor);
				cliente.enviarMensaje(objetivo);
			} catch (IOException e) {
				socketEquipo2.remove(cliente);
				cliente.getPer().matar();
				canal.quitarCliente(cliente);
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





	public void quitarCliente(SocketCliente cliente) {
		if(!socketEquipo1.remove(cliente))
			socketEquipo2.remove(cliente);
		cliente.getPer().matar();
		canal.quitarCliente(cliente);
		
	}


}
