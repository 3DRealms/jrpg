package personaje;


import casta.Casta;
import casta.Mago;
import habilidades.Habilidad;
import interfaces.Atacable;

public abstract class Personaje implements Atacable {


	//Atributos Basicos: Para todas las razas iguales (por ahora) pero la forma de caluclar cambia segun la casta, de la casta.
	protected Casta casta;
	protected int ataque;  
	protected int defensaFisica;
	protected int defensaMagica;

	//Estados, inicialmente todo personaje nuevo tiene 0  y se van escalando a "gusto".
	protected int fuerza = 0;  
	protected int intelecto = 0;
	protected int destreza = 0;
	protected int vitalidad = 0;

	//Progreso del personaje.
	protected int nivel = 0;
	protected int experiencia = 0;
	protected int puntosDeEstados = 0;
	// vector pos = nivel, valor = experencia necesaria. Bueno son 100 niveles loco xD
	private final int[ ] NIVELES = {0, 100, 250, 450, 700, 1000, 1350, 1750, 2200, 2700, 3250, 
								3850, 4500, 5200, 5950, 6750, 7600, 8500, 9450, 10450, 11500, 12600, 
							   13750, 14950, 16200, 17500, 18850, 20250, 21700, 23200, 24750, 26350, 28000,
							   29700, 31450, 33250, 35100, 37000, 38950, 40950, 43000, 45100, 47250, 49450,
							   51700, 54000, 56350, 58750, 61200, 63700, 66250, 68850, 71500, 74200, 76950,
							   79750, 82600, 85500, 88450, 91450, 94500, 97600, 100750, 103950, 107200, 110500, 
							   113850, 117250, 120700, 124200, 127750, 131350, 135000, 138700, 142450, 146250, 150100, 
							   154000, 157950, 161950, 166000, 170100, 174250, 178450, 182700, 187000, 191350, 195750, 
							   200200, 204700, 209250, 213850, 218500, 223200, 227950, 232750, 237600, 242500, 247450, 252450,
							   300000};
	//Salud: Estos dependeran de la raza, tendra su salud base diferente.
	protected String nombre;
	protected int saludBase; 
	protected int energiaBase;
	// Estos son calculadp
	protected int saludActual;
	protected int energiaActual; 

	//Constructor.
	public Personaje(String nombre) {
		this.nombre = nombre;
	}
	//Experencia
	public void subirExperencia(int exp) {
		this.experiencia += exp;
		subirNivel();
	}
	public int getExperiencia() {
		return this.experiencia;
	}
	public int getNivel() {
		return this.nivel;
	}
	
	private void subirNivel() {
		int nivelAntiguo = this.nivel;
		int nivelNuevo = 0;
		for ( int i=0;  i < NIVELES.length ; i++) {
			if( this.experiencia >= NIVELES[i])
				nivelNuevo = i;
		}
		if(nivelAntiguo < nivelNuevo)
			puntosDeEstados += 5; // 5 puntos por nivel.
		this.nivel = nivelNuevo;
	}


	//Abstract, esto depende de la raza.
	protected void despuesDeAtacar(){};
	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensaFisica();
	public abstract int obtenerPuntosDeDefensaMagica();

	// Casta
	public Casta getCasta() {
		return casta;
	}

	//Metodo general de personaje(sujeto a cambios)

	/** 
	 * 
	 * @param atacado
	 * por el momento el atacar es generico para todos. 
	 * cada metodo es igual en cada Raza, (esto para hacer pruebas). 
	 * en el futuro hay que ir cambiando cada metodo de cada raza para darle sabor.
	 * The lore of destiny v0.19
	 */
	public void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacadoFisico(obtenerPuntosDeAtaque());
			despuesDeAtacar();
		}
	}

	/**
	 * 	Lanzar habilidad[algun conjuro del libro, ya sea una "superPatada" o "sacasonapas" o "pitulin"].
	 *  Si no lo encuentra no lo lanza.
	 * @param conjuro
	 * @param personaje
	 * @return
	 */
	public  boolean lanzarHabilidad(String conjuro, Personaje personaje){
		Habilidad h;
		h = getCasta().getHabilidad(conjuro);

		if( h != null && getEnergia() >= h.getCosto()){
			consumirEnergia(h.getCosto());
			h.afectar(personaje, getCasta().getEstado(this) );
			return true;
		}
		return false;
	}

	/**
	 * 1% del daño es reducido por cada punto de defensa Fisica.
	 * @param danio
	 */
	public void serAtacadoFisico(int danio) {
		this.saludActual -=  (int) danio - (danio*defensaFisica)/100;
	}
	/**
	 *  1% del daño es reducido por cada punto de defensa Magica.
	 * @param danio
	 */
	public void serAtacadoMagico(int danio){
		this.saludActual -=  (int) danio - (danio*defensaMagica)/100;
	}

	/**Cura 
	 * 
	 */
	public void serCurado() {
		this.saludActual = calcularSaludTotal();
	}

	/**
	 * Ahora puedo curar a un aliado.
	 * @param vida
	 */
	public void serCurado(int vida) {
		int aux = saludActual + vida;
		if(aux <= saludActual )
			this.saludActual = aux;
		else
			saludActual = calcularSaludTotal();
	}

	public void serEnergizado() {
		this.energiaActual = 100;
	}

	/**
	 * subir energia en tantos puntos :O.  
	 */
	public void serEnergizado(int e) {
		int aux = this.energiaActual + e;
		if(aux <= energiaActual )
			this.energiaActual = aux;
		else
			saludActual = calcularSaludTotal();
	}

	@Override
	public void morir() {
	}

	public boolean estaMuerto() {
		return saludActual <= 0;
	}
	public int getSaludActual(){
		return this.saludActual;
	}
	public void subirVitalidad(int vitalidad) {
		this.vitalidad += vitalidad;
		this.saludActual = calcularSaludTotal();
	}
	public void subirDestreza(int destreza) {
		this.destreza += destreza;
		this.energiaActual = calcularEnergiaTotal();
	}
	public void subirIntelecto(int intelecto) {
		this.intelecto += intelecto;
	}
	public int calcularSaludTotal(){
		return saludBase+(vitalidad*4); // cada 5 puntos da 20 de vida.
	}
	public int calcularEnergiaTotal(){
		return energiaBase+(destreza*2); // cada 5 puntos da 10 de energia.
	}
	public int getEnergia() {
		return this.energiaActual;
	}
	public void consumirEnergia(int energia) {
		this.energiaActual -= energia;
	}

	//Casta:
	//Por ahora seria asi:
	public void setCastaMago() {
		this.casta = new Mago();
	}

	/**
	 * Buscar forma general de hacerlo mmmm
	 * deberia estudiar Sistemas Operativos. // Ya aprobe :) 
	 * @param casta
	 */
	public void setCasta(String casta) {
		if(casta.equals("mago"))
			this.casta = new Mago();
	}

	public void agregarHabilidad(String conjuro, Habilidad habilidad) {
		casta.agregarHabilidad(conjuro, habilidad);
	}

	@Override
	public String toString() {
		return nombre;
	}
	public int getIntelecto() {
		return intelecto;
	}
	public String verHabilidades() {
		String habilidades= "Habilidades:\n";
		for ( String key : casta.getHabilidades().keySet() ) {
		    habilidades += key + "\n";
		}
		return habilidades;
	}
	public String verItems() {
		return "Items:";
	}

	//	public void miTurno(Equipo victimas) {
	//		int i;
	//		Personaje victima;
	//		Scanner teclado = new Scanner(System.in);
	//		do {
	//			i = teclado.nextInt();
	//			victima = victimas.get(i);
	//		} while (victima == null);
	//		// aca algun metodo para seleccionar 	
	//	}

}

