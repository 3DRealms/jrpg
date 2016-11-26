package servidor;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import acciones.Accion;
import acciones.FactoriaAcciones;
import mensaje.MensajeBatalla;
import mensaje.MensajeInteraccion;

public class ThreadEscucharBatalla extends Thread{
	
private SocketCliente cliente;
private List<Accion> acciones;
private Batalla batalla;
	
	public ThreadEscucharBatalla(SocketCliente cliente, List<Accion> acciones, Batalla batalla){
		this.cliente = cliente;
		this.acciones = acciones;
		this.batalla = batalla;
	}

	@Override
	public void run(){
		Accion acc;
		MensajeBatalla men;
		try {
			men = cliente.pedirMensajeBatalla();
			acc = FactoriaAcciones.getAccion(batalla.buscarPJ(men.getEmisor()),batalla.buscarPJ(men.getObjetivo()),men.getAccion(),men.getTipo());
			acciones.add( acc );
		} catch (IOException e) {
			batalla.quitarCliente(cliente);
		}
		
	}

}
