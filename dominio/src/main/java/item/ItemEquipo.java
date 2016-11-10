package item;

public class ItemEquipo extends Item {
	// es todo 0 
	protected int fuerza;  
	protected int intelecto;
	protected int destreza;
	protected int vitalidad;
	protected int ataqueFisico;  
	protected int ataqueMagico;  
	protected int defensaFisica;
	protected int defensaMagica;

	public int getFuerza() {
		return fuerza;
	}
	public int getIntelecto() {
		return intelecto;
	}
	public ItemEquipo(String key, int nivel, String nombre, String descripcion, int fuerza, int intelecto, int destreza,
			int vitalidad, int ataqueFisico, int ataqueMagico, int defensaFisica, int defensaMagica) {
		super(key, nivel, nombre, descripcion);
		this.fuerza = fuerza;
		this.intelecto = intelecto;
		this.destreza = destreza;
		this.vitalidad = vitalidad;
		this.ataqueFisico = ataqueFisico;
		this.ataqueMagico = ataqueMagico;
		this.defensaFisica = defensaFisica;
		this.defensaMagica = defensaMagica;
	}
	public ItemEquipo() {
		super("noItem", 0, "Vacio", "Vacio");
		this.fuerza = 0;
		this.intelecto = 0;
		this.destreza = 0;
		this.vitalidad = 0;
		this.ataqueFisico = 0;
		this.ataqueMagico = 0;
		this.defensaFisica = 0;
		this.defensaMagica = 0;
	}
	
	public int getDestreza() {
		return destreza;
	}
	public int getVitalidad() {
		return vitalidad;
	}
	public int getAtaqueFisico() {
		return ataqueFisico;
	}
	public int getAtaqueMagico() {
		return ataqueMagico;
	}
	public int getDefensaFisica() {
		return defensaFisica;
	}
	public int getDefensaMagica() {
		return defensaMagica;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	
	/**
	 * Para diferencia en que parte va el equipo uso el toString.
	 */
	@Override
	public String toString() {
		return "sinEquipo";
	}


	

	
}
