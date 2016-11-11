package personaje;

import raza.Humano;
import raza.Mognatal;
import raza.Orco;

public class FactoriaPersonaje {
	
	public static Personaje getPersonaje(String nombre, String raza, String casta){
		Personaje aux;
		if (raza.equals("humano")) {
			aux = new Humano(nombre);
			return ponerCasta(aux,casta);
		}
		if(raza.equals("mognatal")){
			aux = new Mognatal(nombre);
			return ponerCasta(aux,casta);
		}
		if(raza.equals("orco")){
			aux = new Orco(nombre);
			return ponerCasta(aux,casta);
		}

		return null;
	}
	
	private static Personaje ponerCasta(Personaje per, String casta){
		if (casta.equals("guerrero")) {
			per.setCastaGuerrero();
			return per;
		}
		if(casta.equals("loromaster")){
			per.setCastaLoroMaster();
			return per;
		}
		if(casta.equals("mago")){
			per.setCastaMago();
			return per;
		}
		return null;
	}
	
	public static Personaje reconstruirPersonaje(Personaje per){
		Personaje aux;
		if (per.getTipoRaza().equals("humano")) {
			aux = new Humano(per);
			return ponerCasta(aux,per.getTipoCasta());
		}
		if(per.getTipoRaza().equals("mognatal")){
			aux = new Mognatal(per);
			return ponerCasta(aux,per.getTipoCasta());
		}
		if(per.getTipoRaza().equals("orco")){
			aux = new Orco(per);
			return ponerCasta(aux,per.getTipoCasta());
		}

		return null;
	}

}
