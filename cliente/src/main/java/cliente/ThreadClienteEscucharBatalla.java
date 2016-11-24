package cliente;

import java.io.IOException;

import javax.swing.JOptionPane;

import mensaje.MensajeActualizacionCobate;
import mensaje.MensajeInteraccion;
import ventana.Combate;

public class ThreadClienteEscucharBatalla extends Thread{

	private Cliente cliente;
	private Combate combat;
	

	public ThreadClienteEscucharBatalla(Cliente cliente, Combate combat){
		this.cliente = cliente;
		this.combat = combat;
	}

	@Override
	public void run(){
		MensajeActualizacionCobate men;
		
		try {
			men = cliente.pedirActualizacionBatlla();
			while(men.isActuliazacionBatalla()){
				combat.actualizarEstado(men);
				men = cliente.pedirActualizacionBatlla();
			}
			if(men.isPedirAccion())
				combat.pedirAccion();
			if(men.isFinBatalla())
				cliente.terminarCombate();	
			
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El servidor se ha desconectado");
			System.exit(0);
		}
	}

}

