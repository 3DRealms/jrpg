package items;

import personaje.Personaje;

public class BalaMagicaDePatsy extends Item {
	
	public BalaMagicaDePatsy(int cantidad){
		this.cantidadDeEfecto = 100;
		this.nivel = 0;
		this.cantidad = cantidad;
		this.limite = 5;
		this.Efecto = "daño";
		this.nombre = "Bala mágica de Patsy";
		this.descripcion = "La bala mágica de Patsy es lo último en armas buscadoras. No se trata de una cuestión de habilidad con esta excepcionalmente inteligente bala mágica que se mueve y actúa con rapidez. La bala mágica es tremendamente potente y muy eficiente a la hora de buscar puntos débiles del oponente. La bala mágica de Patsy puede llegar a causar 100 puntos de daño básico más el daño fisico";
		}
	
	@Override
	public void afectar(Personaje personaje) {
		personaje.serAtacadoDanioPuro(cantidadDeEfecto);
	}



}
