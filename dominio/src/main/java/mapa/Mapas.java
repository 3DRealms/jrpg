package mapa;

import java.util.ArrayList;

import mapa.Mapa;

public class Mapas {
	private Mapa currentMap = null;
	public ArrayList<Mapa> mapas = new ArrayList<Mapa>();

	public Mapas() {
	}
	public void loadMapById(int id) {
		for (Mapa m : mapas) {
			if (m.getId() == id) {
				currentMap = m;
				//	m.setActive();
				//	clear();
				break;
			}
		}
	}
}
