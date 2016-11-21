package cliente;

import java.io.IOException;

import javax.swing.JOptionPane;

import mensaje.MensajeInteraccion;

public class ThreadClienteEscuchar extends Thread{
	
private Cliente cliente;
private boolean conectado;
	
	public ThreadClienteEscuchar(Cliente cliente){
		this.cliente = cliente;
	}
	
	public void parar(){
		conectado = false;
	}
	
	@Override
	public void run(){
		conectado = true;
		MensajeInteraccion men;
		while(conectado){
			
			try {
				cliente.pedirInteraccion();
				
			} catch (IOException e) {
				conectado = false;
				JOptionPane.showMessageDialog(null, "El servidor se ha desconectado");
				System.exit(0);
			}
			
		}
	}

}
