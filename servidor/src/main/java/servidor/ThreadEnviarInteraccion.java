package servidor;

import java.io.IOException;
import java.util.List;
import mensaje.*;


public class ThreadEnviarInteraccion extends Thread{
	
	private Canal clientes;
	MensajeInteraccion men;

	
	public ThreadEnviarInteraccion(Canal clientes, MensajeInteraccion mens){
		this.clientes = clientes;		
		this.men = mens;
	}
	
	@Override
	public void run(){
			clientes.enviarMensaje(men);						
	}

}
