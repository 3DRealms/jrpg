package personaje;


import java.util.HashMap;
import java.util.Map;
import casta.Casta;
import casta.Mago;
import habilidades.Habilidad;
import interfaces.Atacable;
import items.Item;

public abstract class Personaje implements Atacable {

	//Salud y Energia: Estos dependeran de la raza, tendra su salud base diferente.
	protected String nombre;
	protected int saludBase; 
	protected int energiaBase;
	// Estos son calculado
	protected int saludActual;
	protected int energiaActual; 

	//Aca esta todo el manejo de habilidades, depende la casta tendra un libro distinto.
	protected Casta casta;
	protected Map<String, Item> mochilaItem;
	// Ver
	protected Map<String, PersonajeEquipado> mochilaEquipo;
	protected final int ESPACIO_MOCHILA = 5;

	// Atributos: depende de items, (cada raza empieza con basicos pero a la larga se amortigua.
	protected int ataqueFisico;  
	protected int ataqueMagico;  
	protected int defensaFisica;
	protected int defensaMagica;

	//Estados, inicialmente todo personaje nuevo tiene 0  y se van escalando a "gusto".
	protected int fuerza = 0;  
	protected int intelecto = 0;
	protected int destreza = 0;
	protected int vitalidad = 0;

	//Equipo
	protected boolean equipoCasco = false;
	protected boolean equipoArmadura = false;
	protected boolean equipoAnillo1 = false;
	protected boolean equipoAnillo2 = false;
	protected boolean equipoArmaIzq = false;  //Hay armas de dos manos.
	protected boolean equipoArmaDer = false;


	//Progreso del personaje.
	protected int nivel = 0;
	protected int experiencia = 0;
	protected int puntosDeEstados = 0;

	// vector de niveles, la posicion  es = a nivel, el valor es = a experencia necesaria. Bueno son 100 niveles loco xD
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

	//Constructor:
	public Personaje(String nombre) {
		mochilaItem = new HashMap<String, Item>();
		this.nombre = nombre;
	}

	// #############################################

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

	public int getPuntosDeEstados(){
		return this.puntosDeEstados;
	}

	private void subirNivel() {
		int nivelAntiguo = this.nivel;
		int nivelNuevo = 0;
		for ( int i=0;  i < NIVELES.length ; i++) {
			if( this.experiencia >= NIVELES[i])
				nivelNuevo = i;
		}
		this.nivel = nivelNuevo;
		int nivelesQueSubi = nivelNuevo-nivelAntiguo;
		if(nivelesQueSubi>0)
			puntosDeEstados += 2*nivelesQueSubi; // 2 puntos por nivel.
	}

	//	#######################################################

	//Abstract, esto depende del equipo.

	protected abstract int calcularPuntosDeAtaque();
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensaFisica();
	public abstract int obtenerPuntosDeDefensaMagica();
	//protected void despuesDeAtacar(){};
	//protected abstract boolean puedeAtacar();

	/**
	 * Cada raza lo va a sobreEscribir
	 * @return
	 */
	public  int calcularSaludTotal(){
		return saludBase; 
	}
	/**
	 * Cada raza lo va a sobreEscribir
	 * @return
	 */
	public int calcularEnergiaTotal(){
		return energiaBase; // cada 5 puntos da 10 de energia.
	}
	public int getEnergia() {
		return this.energiaActual;
	}
	public void consumirEnergia(int energia) {
		this.energiaActual -= energia;
	}

	//	#######################################################
	// Casta:
	public Casta getCasta() {
		return casta;
	}

	//Por ahora seria asi:
	public void setCastaMago() {
		this.casta = new Mago();
	}

	public void agregarHabilidad(String conjuro, Habilidad habilidad) {
		casta.agregarHabilidad(conjuro, habilidad);
	}
	public String verHabilidades() {
		String habilidades= "Habilidades:\n";
		for ( String key : casta.getHabilidades().keySet() ) {
			habilidades += key + "\n";
		}
		return habilidades;
	}

	//Metodo general de personaje(sujeto a cambios)

	/** 
	 * El atacar es generico para todos. 
	 * The Lore of Destiny v0.52
	 * @param atacado
	 */
	public void atacar(Atacable atacado) {
		//Por el momento es un ataque simple que no consume energia.
		atacado.serAtacadoFisico(obtenerPuntosDeAtaque());
	}

	/**
	 * 	Lanzar habilidad[algun conjuro del libro, ya sea una "superPatada" o "piroExplosion" o "pitulin"].
	 *  Si no lo encuentra no lo lanza.
	 * @param conjuro
	 * @param personaje
	 * @return
	 */
	public  boolean lanzarHabilidad(String conjuro, Personaje personaje){
		Habilidad h = getCasta().getHabilidad(conjuro);
		if( h != null && getEnergia() >= h.getCosto()){
			//Dependiendo el tipo de habilidad, entonces le envio el ataque correspondiente.

			if(h.getTipo().equals("normal"))
				h.afectar(personaje, getCasta().getEstado(this), 0);

			else if(h.getTipo().equals("magico"))
				h.afectar(personaje, getCasta().getEstado(this), ataqueMagico );

			else if(h.getTipo().equals("fisico"))
				h.afectar(personaje, getCasta().getEstado(this), ataqueFisico );

			consumirEnergia(h.getCosto());
			return true;
		}
		return false;
	}
	public  boolean lanzarItem(String item, Personaje personaje){
		Item  i = mochilaItem.get(item);
		if(i != null ){
			i.afectar(personaje);
			i.usar();
			if(i.getCantidad() == 0)
				this.mochilaItem.remove(item);
			return true;
		}

		return false;
	}

	/**
	 * 1% del daño es reducido por cada punto de defensa Fisica.
	 * @param danio
	 */
	public void serAtacadoFisico(int danio) {
		this.saludActual -=  (int) danio - (danio*obtenerPuntosDeDefensaFisica())/100;
	}

	/**
	 *  1% del daño es reducido por cada punto de defensa Magica.
	 * @param danio
	 */
	public void serAtacadoMagico(int danio){
		this.saludActual -=  (int) danio - (danio*obtenerPuntosDeDefensaMagica())/100;
	}

	/**
	 *  Todo el daño es aplicado.
	 * @param danio
	 */
	public void serAtacadoDanioPuro(int danio){
		this.saludActual -=  (int) danio;
	}

	/** 
	 * Cura toda la vida.
	 */
	public void serCurado() {
		this.saludActual = calcularSaludTotal();
	}

	/**
	 * Cura una cierta cantidad de vida.
	 * @param vida
	 */
	public void serCurado(int vida) {
		int aux = saludActual + vida;
		if(aux <= calcularSaludTotal() )
			this.saludActual = aux;
		else
			saludActual = calcularSaludTotal();
	}
	/**
	 * Energiza al maximo
	 */
	public void serEnergizado() {
		this.energiaActual = calcularEnergiaTotal();
	}

	/**
	 * Energiza en tantos puntos.  
	 */
	public void serEnergizado(int e) {
		int aux = this.energiaActual + e;
		if(aux <= calcularEnergiaTotal() )
			this.energiaActual = aux;
		else
			energiaActual = calcularEnergiaTotal();
	}

	@Override // No implementado todavia, posiblemente no este mas.
	public void morir() { 
	}

	/**
	 * Dice si el personaje esta muerto.
	 */
	public boolean estaMuerto() {
		return saludActual <= 0;
	}

	public int getSaludActual(){
		return this.saludActual;
	}

	//Subir habilidad:
	//Sube 1 punto, (supongo esto va estar en un botoncito y hago click) 
	public boolean subirVitalidad() {
		if( this.puntosDeEstados==0 )
			return false;
		this.puntosDeEstados--;
		this.vitalidad ++;
		this.saludActual = calcularSaludTotal();
		return true;
	}

	public boolean subirDestreza() {
		if( this.puntosDeEstados==0 )
			return false;
		this.puntosDeEstados--;
		this.destreza ++;
		this.energiaActual = calcularEnergiaTotal();
		return true;
	}
	public boolean subirIntelecto() {
		if( this.puntosDeEstados==0 )
			return false;
		this.puntosDeEstados--;
		this.intelecto++;
		return true;
	}
	public boolean subirFuerza() {
		if( this.puntosDeEstados==0 )
			return false;
		this.puntosDeEstados--;
		this.fuerza ++;
		return true;
	}


	public int getIntelecto() {
		return intelecto;
	}
	public int getVitalidad() {
		return this.vitalidad;
	}
	public int getDestreza() {
		return this.destreza;
	}
	public int getFuerza() {
		return this.fuerza;
	}

	@Override
	public String toString() {
		return nombre;
	}
	public String verEquipo() {
		return "Equipo:";
	}
// #################################
	//Items:
	public boolean guardarItem(String i, Item item){
		// Si no puedo equipar no equipo.
		Item loTengo = mochilaItem.get(i);
		if( loTengo == null){
			if(ESPACIO_MOCHILA <= cantidadItems())
				return false;
			mochilaItem.put(i,item);
		}
		else{
			if(loTengo.getCantidad() >= item.getLimite())
				loTengo.aumentarCantidad( item.getCantidad() );
		}
		return true;
	}
	public int cantidadItems(){
		return mochilaItem.size();
	}
	public String verItems(){
		String Items= "Items:\n";
		for ( String key : mochilaItem.keySet() ) {
			Items += key + "\n";
		}
		return Items;
	}
	
	
	
	
	
	///Equipo:
	public boolean puedoEquiparArmaIzq() {
		return this.equipoArmaIzq;
	}
	public void setEquipoArmaIzq(boolean equipoArmaIzq) {
		this.equipoArmaIzq = equipoArmaIzq;
	}


	public void quitarArmIqz(Personaje yo){};


}

