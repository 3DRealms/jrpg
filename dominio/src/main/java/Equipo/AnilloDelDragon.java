package Equipo;


public class AnilloDelDragon extends Equipo {

	public AnilloDelDragon() {
		this.fuerza = 5;  
		this.intelecto = 5;
		this.destreza = 5;
		this.vitalidad = 5;
		this.ataqueFisico = 15;
		this.ataqueMagico = 15;  
		this.defensaFisica = 15;
		this.defensaMagica = 15;
		this.descripcion = "Un anillo con un dragón grabado. Concede a su portador la protección de los dragones.";
	}
	@Override
	public String toString() {
		return "Anillo del Dragón";
	}
	


}
