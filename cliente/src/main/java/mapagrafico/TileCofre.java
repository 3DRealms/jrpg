package mapagrafico;

public class TileCofre{


	public String getItemE() {
		return itemE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private boolean cerrado = true;
	private String itemE;
	int x;
	int y;
	public TileCofre(int x, int y, String itemE) {
		this.x = x;
		this.y = y;
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
