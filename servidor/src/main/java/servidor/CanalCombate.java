package servidor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CanalCombate {

	private List<SocketCliente> equipo1;
	private List<SocketCliente> equipo2;
	private boolean termino = false; // por eso de las moscas	


	public boolean isTermino() {
		return termino;
	}
	public void setTermino(boolean b){
		termino = b;
	}

	public CanalCombate(){
		equipo1 = new ArrayList<SocketCliente>();
		equipo2 = new ArrayList<SocketCliente>();
	}

	public void agregarEquipo1(SocketCliente client){
		equipo1.add(client);
	}

	public void agregarEquipo2(SocketCliente client){
		equipo2.add(client);
	}

	public List<SocketCliente> getEq1() {
		return equipo1;
	}

	public List<SocketCliente> getEq2() {
		return equipo2;
	}

	public boolean estoyAca(SocketCliente clienteYo) {
		if( equipo1.contains(clienteYo))
			return true;
		if( equipo2.contains(clienteYo))
			return true;		
		
		return false;
	}
}
