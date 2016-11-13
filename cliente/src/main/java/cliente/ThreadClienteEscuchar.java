package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import mensaje.*;
import com.google.gson.Gson;


public class ThreadClienteEscuchar extends Thread{
	
private Cliente cliente;
	
	public ThreadClienteEscuchar(Cliente cliente){
		this.cliente = cliente;
	}
	
	@Override
	public void run(){
		boolean conectado = true;
		
		while(conectado){
			
			try {
				cliente.pedirInteraccion();
			} catch (IOException e) {
				conectado = false;
			}
			
		}
	}

}
