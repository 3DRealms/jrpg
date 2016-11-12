package servidor;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mapa.Mapa;
import mapa.Punto;
import mensaje.*;
import personaje.Personaje;
import raza.Humano;


public class Canal {
	
	List<SocketCliente> canal;
	String nombre;
	Mapa map;
	
	public Canal(String nombre, int alto, int ancho) {
		this.map = new Mapa(nombre, alto, ancho);
		this.canal = new ArrayList<SocketCliente>();
		this.nombre = nombre;
		
	}
	
	public boolean esMiNombre(String nombre){
		return nombre.equals(this.nombre);
	}
	
	public void agregarCliente(SocketCliente cliente, Personaje per) throws IOException{
		canal.add(cliente);
		map.agregarPersonaje(per, cliente.getUsuario());
		cliente.enviarMensajePosicion(per.getUbicacion(), cliente.getUsuario(), "mapa4");

	}
	
	public String toString(){
		return nombre;
	}
	
	public void quitarCliente(SocketCliente cliente){
		canal.remove(cliente);
	}
	
	public void enviarMensaje(Object men){
		
		for(SocketCliente cliente : canal)
		{
			
			try {
				cliente.enviarMensaje(men);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				this.quitarCliente(cliente);
				
				try {
					cliente.cerrar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
			
		
		
	}
	}
	
	public void enviarPosicionesACliente(SocketCliente cliente){
		 Map<String,Punto> personajes = map.obtenerPosiciones();
		for(String key : personajes.keySet())
		{
			
			try {
				cliente.enviarMensaje(new MensajeMovimiento(personajes.get(key), key, nombre));
			} catch (IOException e) {

				e.printStackTrace();
				
				this.quitarCliente(cliente);
				
				try {
					cliente.cerrar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
			
		
		
	}
	}
		
	public void enviarPosicion(MensajeMovimiento men){
			
			for(SocketCliente cliente : canal)
			{
				
				try {
					cliente.enviarMensaje(men);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					this.quitarCliente(cliente);
					
					try {
						cliente.cerrar();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
				}
				
			
			
		}
	}
	
	
	
	

}
