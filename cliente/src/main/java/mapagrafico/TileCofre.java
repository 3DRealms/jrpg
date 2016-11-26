package mapagrafico;

import tiles.TileObstaculo64x64;

public class TileCofre extends TileObstaculo64x64{


	private boolean cerrado = true;
	private String itemE;

	public TileCofre(int x, int y, int sprite, String itemE) {
		super(x,y,sprite);
		this.itemE = itemE;
	} 

	public String abrir() {
		if( cerrado ){
			cerrado = false;
			return itemE;
		}
		return null;
	}


}
