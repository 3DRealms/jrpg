package cliente;

import java.io.IOException;

import javax.swing.JOptionPane;

import mensaje.MensajeInteraccion;

public class ThreadClienteEnviarInteraccion extends Thread{
	
private Cliente cliente;
private MensajeInteraccion men;
	
	public ThreadClienteEnviarInteraccion(Cliente cliente, MensajeInteraccion men){
		this.cliente = cliente;
		this.men = men;
	}
	
	@Override
	public void run(){
			try {
				cliente.enviarInteraccion(men);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "El servidor se ha desconectado");
				System.exit(0);
		}
	}

}
