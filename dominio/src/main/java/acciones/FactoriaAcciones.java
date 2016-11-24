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

	public static Accion getAccion(Accion acc) {
		if (acc.getTipo().equals(MensajeBatalla.DEFENDER)) {
			return new AccionDefender(  acc.getEmisor(),	 acc.getObjetivo(), acc.getAccion(), acc.getTipo());
		}
		if(acc.getTipo().equals(MensajeBatalla.HABILIDAD)){
			return new AccionHabilidad( acc.getEmisor(),  acc.getObjetivo(), acc.getAccion(), acc.getTipo());
		}
		if(acc.getTipo().equals(MensajeBatalla.OBJETO)){
			return new AccionObjeto( acc.getEmisor(),  acc.getObjetivo(), acc.getAccion(), acc.getTipo());
		}
		if(acc.getTipo().equals(MensajeBatalla.HUIR)){
			return new AccionHuir( acc.getEmisor(),  acc.getObjetivo(), acc.getAccion(), acc.getTipo());
		}
		return null;
	}

}
