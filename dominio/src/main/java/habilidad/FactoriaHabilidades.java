package habilidad;


public class FactoriaHabilidades {

	public static Habilidad getAccion(String nombre, String efecto, String descripcion, int costo, int nivel, int cantEfecto,
			int velocidad){
		if (efecto.equals("curativa")) {
			return new HabilidadCurativa(nombre,efecto,descripcion,costo,nivel,cantEfecto,velocidad);
		}
		if(efecto.equals("fisica")){
			return new HabilidadFisica(nombre,efecto,descripcion,costo,nivel,cantEfecto,velocidad);
		}
		if(efecto.equals("magica")){
			return new HabilidadMagica(nombre,efecto,descripcion,costo,nivel,cantEfecto,velocidad);
		}
		if(efecto.equals("truedamage")){
			return new HabilidadTrueDamage(nombre,efecto,descripcion,costo,nivel,cantEfecto,velocidad);
		}
		return null;
	}

}
