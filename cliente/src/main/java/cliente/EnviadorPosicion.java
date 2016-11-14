package cliente;

import mapa.Punto;
import mensaje.MensajeInteraccion;
import mensaje.MensajeMovimiento;

public class EnviadorPosicion {
	
	Cliente client;
	String emisor;
	String mapa;
	String sprite;
	
	public EnviadorPosicion(Cliente client, String emisor, String mapa, String sprite){
		this.client = client;
		this.emisor = emisor;
		this.sprite = sprite;
		this.mapa = mapa;
	}
	
	public void enviarPosicion(Punto point){
		new ThreadClienteEnviarInteraccion(client, new MensajeMovimiento(point, emisor, mapa, sprite)).start();
		
	}
	
	public void enviarDetencion(){
		new ThreadClienteEnviarInteraccion(client, new MensajeInteraccion(emisor, "parado")).start();
	}


	
	

}
