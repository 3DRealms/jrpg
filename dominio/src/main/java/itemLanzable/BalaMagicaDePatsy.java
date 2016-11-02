package itemLanzable;

import item.ItemLanzable;
import personaje.Personaje;

public class BalaMagicaDePatsy extends ItemLanzable {
	
	public BalaMagicaDePatsy(int cantidad){
		this.cantidadDeEfecto = 100;
		this.nivel = 0;
		this.cantidad = cantidad;

		this.efecto = "da�o";
		this.nombre = "Bala m�gica de Patsy";
		this.descripcion = "La bala m�gica de Patsy es lo �ltimo en armas buscadoras. No se trata de una cuesti�n de habilidad con esta excepcionalmente inteligente bala m�gica que se mueve y act�a con rapidez. La bala m�gica es tremendamente potente y muy eficiente a la hora de buscar puntos d�biles del oponente. La bala m�gica de Patsy puede llegar a causar 100 puntos de da�o b�sico m�s el da�o fisico";
		}
	
	@Override
	public void afectar(Personaje personaje) {
		personaje.serAtacadoDanioPuro(cantidadDeEfecto);
	}

	@Override
	public String key() {
		return "danio";
	}



}
