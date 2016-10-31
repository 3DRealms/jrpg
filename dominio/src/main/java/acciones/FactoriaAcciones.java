package acciones;

import personaje.Personaje;

public class FactoriaAcciones {

	public static Accion getAccion(Personaje emisor,Personaje objetivo,String accion,String tipo){
		if (tipo.equals("defender")) {
			return new AccionDefender( emisor,	 objetivo, accion, tipo);
		}
		if(tipo.equals("habilidad")){
			return new AccionHabilidad( emisor, objetivo, accion, tipo);
		}
		if(tipo.equals("objeto")){
			return new AccionObjeto( emisor, objetivo, accion, tipo);
		}
		if(tipo.equals("huir")){
			return new AccionHuir( emisor, objetivo, accion, tipo);
		}
		return null;
	}

}
