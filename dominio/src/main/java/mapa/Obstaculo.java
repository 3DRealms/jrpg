package mapa;

import grafico.Sprite;

@SuppressWarnings("unused") // Banca un cacho
public class Obstaculo {
	private Ubicacion ubicacion;
//	private Sprite sprite;
	
	
	public Obstaculo(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

}
