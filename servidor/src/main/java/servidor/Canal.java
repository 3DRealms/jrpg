package servidor;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mensaje.*;


public class Canal {
	
	List<SocketCliente> canal;
	String nombre;
	public Canal(String nombre) {

		this.canal = new ArrayList<SocketCliente>();
		this.nombre = nombre;
	}
	
	public boolean esMiNombre(String nombre){
		return nombre.equals(this.nombre);
	}
	
	public void agregarCliente(SocketCliente cliente){
		canal.add(cliente);
	}
	
	public String toString(){
		return nombre;
	}
	
	public void quitarCliente(SocketCliente cliente){
		canal.remove(cliente);
	}
	
	public void enviarMensaje(Mensaje men){
		
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
