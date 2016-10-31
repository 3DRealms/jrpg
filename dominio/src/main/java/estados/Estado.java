package estados;

import java.awt.Graphics2D;


public abstract class Estado {
	
	public Estado() {
		
	}
	
	public abstract void actualizar();
	public abstract void dibujar(Graphics2D g);
	public abstract void entradaDelTeclado();
}	
