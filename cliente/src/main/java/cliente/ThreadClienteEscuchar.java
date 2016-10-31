package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import mensaje.*;
import com.google.gson.Gson;


public class ThreadClienteEscuchar extends Thread{
	
private Socket cliente;
	
	public ThreadClienteEscuchar(Socket cliente){
		this.cliente = cliente;
	}
	
	@Override
	public void run(){
		boolean conectado = true;
		
		while(conectado){
			
			try {
				DataInputStream lectura = new DataInputStream(
						cliente.getInputStream());
				final Gson gson = new Gson();
				final Mensaje men = gson.fromJson(lectura.readUTF(), Mensaje.class);
				System.out.println(men);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				conectado = false;
			}
			
		}
	}

}
