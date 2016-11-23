package batalla;

public class PersonajeSimple {
	
	String nombre; 
	int vida;
	int energia;
	int vidaAct;
	int energiaAct;
	String sprite;

	public PersonajeSimple(String nombre, int vida, int energia, int vidaAct, int energiaAct, String sprite) {
		this.nombre = nombre;
		this.vida = vida;
		this.energia = energia;
		this.vidaAct = vidaAct;
		this.energiaAct = energiaAct;
		this.sprite = sprite;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}

	public int getEnergia() {
		return energia;
	}

	public int getVidaAct() {
		return vidaAct;
	}

	public int getEnergiaAct() {
		return energiaAct;
	}

	public String getSprite() {
		return sprite;
	}
	
}
