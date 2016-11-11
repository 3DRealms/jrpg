package servidor;

import java.io.IOException;
import java.util.List;
import mensaje.*;


public class ThreadEnviarMovimiento extends Thread{
	
	private Canal clientes;
	MensajeInteraccion men;
	String remitente;

	
	public ThreadEnviarMovimiento(Canal clientes, MensajeInteraccion mens){
		this.clientes = clientes;		
		this.men = mens;
	}
	
	@Override
	public void run(){
			clientes.enviarMensaje(men);						
	}

}
