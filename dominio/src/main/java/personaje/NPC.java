package personaje;

import interfaces.Atacable;

public class NPC implements Atacable {
	protected int energia = 100;
	protected int salud = 100;
	
	@Override
	public void serAtacadoFisico(int danio){
		this.salud -= danio;
	}

	@Override
	public void morir() {	
		//aca se puede disparar el re-spaw en tantos segudos.
	}

	@Override
	public boolean estaMuerto() {
		return false;
	}

	@Override
	public void serAtacadoMagico(int danio) {
		this.salud -= danio;		
	}
	

}
