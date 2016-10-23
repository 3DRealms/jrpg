package items;

import personaje.Personaje;

public class PotaDeEnergia  extends Item{
	public PotaDeEnergia(int cantidad){
		this.cantidadDeEfecto = 100;
		this.nivel = 0;
		this.cantidad = cantidad;
		this.limite = 5;
		this.Efecto = "energia";
		this.nombre = "Pota de mana";
		this.descripcion = "Clasica pota de mana que aumenta "+cantidadDeEfecto+"pnts de energia.";
		}
	@Override
	public void afectar(Personaje personaje) {
		personaje.serEnergizado(cantidadDeEfecto);		
	}

}
