package interfaces;

public interface Atacable {
	public void serAtacadoFisico(int danio);
	public void serAtacadoMagico(int danio);
	public void morir();
	public boolean estaMuerto();
}
