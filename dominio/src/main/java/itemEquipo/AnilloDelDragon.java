package itemEquipo;

import item.ItemEquipo;

public class AnilloDelDragon extends ItemEquipo {
	/**
	 * Equipo Anillo Del Dragon
	 * Unos de los mejores anillos que has visto.
	 * Tipo: anillo.
	 * Efecto:
	 * 		fuerza = 5;  
	 *		intelecto = 5;
	 *		destreza = 5;
	 *		vitalidad = 5;
	 *		ataqueFisico = 15;
	 *		ataqueMagico = 15;  
	 *		defensaFisica = 15;
	 *		defensaMagica = 15;
	 */
	public AnilloDelDragon() {
		this.fuerza = 5;  
		this.intelecto = 5;
		this.destreza = 5;
		this.vitalidad = 5;
		this.ataqueFisico = 15;
		this.ataqueMagico = 15;  
		this.defensaFisica = 15;
		this.defensaMagica = 15;
		this.descripcion = "Anillo del Dragón\nUn anillo con un dragón grabado. Concede a su portador la protección de los dragones. Sube todos los estados.";
	}
	@Override
	public String toString() {
		return "anillo";
	}
}
