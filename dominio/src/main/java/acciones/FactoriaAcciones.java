package acciones;

import mensaje.MensajeBatalla;
import personaje.Personaje;

public class FactoriaAcciones {

	public static Accion getAccion(Personaje emisor,Personaje objetivo,String accion,String tipo){
		if (tipo.equals(MensajeBatalla.DEFENDER)) {
			return new AccionDefender( emisor,	 objetivo, accion, tipo);
		}
		if(tipo.equals(MensajeBatalla.HABILIDAD)){
			return new AccionHabilidad( emisor, objetivo, accion, tipo);
		}
		if(tipo.equals(MensajeBatalla.OBJETO)){
			return new AccionObjeto( emisor, objetivo, accion, tipo);
		}
		if(tipo.equals(MensajeBatalla.HUIR)){
			return new AccionHuir( emisor, objetivo, accion, tipo);
		}
		return null;
	}

}
