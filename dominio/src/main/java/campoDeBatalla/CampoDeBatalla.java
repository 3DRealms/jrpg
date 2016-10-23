package campoDeBatalla;

import interfaces.Equipo;

public class CampoDeBatalla {
	
	public String batalla(Equipo e1, Equipo e2) {
		boolean fin = false;
		String ganador = "empate";
		
		/**
		 * GORDOPOLIS.
		 */
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
}
