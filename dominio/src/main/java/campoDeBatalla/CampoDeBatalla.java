package campoDeBatalla;

import interfaces.Grupo;

public class CampoDeBatalla {
	/**
	 * Para test (segun Lucas)
	 * @param e1
	 * @param e2
	 * @return
	 */
	public String batallaAuto(Grupo e1, Grupo e2) {
		boolean fin = false;
		String ganador = "empate";
		while( !fin ){ 	
			e1.atacar(e2);
			if( e2.isEmpty() ){
				fin = true;
				ganador = e1.toString();
			}
			
			e2.atacar(e1);
			if( e1.isEmpty() ){
				fin = true;
				ganador = e2.toString();
			}
		}
		return ganador;
	}
	public String batalla(Grupo e1, Grupo e2) {
		String ganador = "empate";
		//Hacer una lista de personajes con sus habilidades y su victima, que se ordene por velocidad y que se ejecute.		
		
		return ganador;
	}
}
