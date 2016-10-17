package personaje;

import casta.Casta;
import casta.Mago;
import habilidades.Habilidad;
import interfaces.Atacable;

public abstract class Personaje implements Atacable {


	//Atributos Basicos: Para todas las razas iguales (por ahora) pero la forma de caluclar cambia segun la casta, de la casta.
	protected Casta casta;
	protected int ataque = 15;  
	protected int energia = 100; 
	protected int defensa = 0;
	protected final int ENERGIA_ATAQUE_NORMAL = 1; //enegia que gasta por autoAtaque.

	//Estados, inicialmente todo personaje nuevo tiene 0  y se van escalando a "gusto".
	protected int fuerza = 0;  
	protected int intelecto = 0;
	protected int destreza = 0;
	protected int vitalidad = 0;

	//Progreso del personaje.
	protected int nivel = 1;
	protected int experiencia = 0;

	//Salud: Estos dependeran de la raza, tendra su salud base diferente.
	protected String nombre;
	protected int saludBase = 120; // 120 es para hacer pruebas.
	protected int saludActual; // Este es calculado (calculo que dependera de la casta).


	///////////// RANCIO //////////////////


	public Personaje(String nombre) {
		this.nombre = nombre;
	}
	//Abstract, esto depende de la raza.
	protected void despuesDeAtacar(){};
	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();

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
			atacado.serAtacado(obtenerPuntosDeAtaque());
			energia -= ENERGIA_ATAQUE_NORMAL; //1
			despuesDeAtacar();
		}
	}
	/**
	 * 
	 * 	Lanzar habilidad del conjuro, si no lo encuentra no lo lanza.
	 * @param conjuro
	 * @param personaje
	 * @return
	 */
	public  boolean lanzarHabilidad(String conjuro, Personaje personaje){
		Habilidad h;
		h = getCasta().getHabilidad(conjuro);

		if( h != null && getEnergia() >= h.getCosto()){
			consumirEnergia(h.getCosto());
			h.afectar(personaje, getEstado() );
			return true;
		}
		
		return false;
	}
	
	/**
	 * Devuelve los puntos del estado de la casta para usar en (por ahora)
	 * en lanzarHabilidad->afectar, entonces le mando el estado y con eso 
	 * las habilidades haran los calculos conrespondientes para aumentar su efecto.
	 * EJ: si hago el getEstado del mago me deberia devolver el intelecto.
	 * sino no tiene casta devuelve 0.
	 * 
	 * Ya se que no es optimo pero por ahora funciona.
	 * @return
	 */
	public int getEstado(){
		int estado = 0;
		if( getCasta().getEstado().equals("intelecto") )
			estado = getIntelecto();
		else
			estado = 0;
		return estado;
	}
	/**
	 * 1% por cada punto de defensa es bloqueado.
	 * @param danio
	 */
	public void serAtacado(int danio) {
		this.saludActual -=  (int) danio - (danio*defensa)/100;
	}
	public void serCurado() {
		this.saludActual = 100;
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
			saludActual = calcularSaludActual();
	}

	@SuppressWarnings("unused") 	//Baja cambio dejame en paz.
	private void serEnergizado() {
		this.energia = 100;
	}

	/**
	 * subir energia en tantos puntos :O.  
	 */
	public void serEnergizado(int energia) {
		int aux = energia + energia;
		if(aux <= energia )
			this.energia = aux;
		else
			saludActual = calcularSaludActual();
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
		this.saludActual = calcularSaludActual();
	}
	public void subirIntelecto(int intelecto) {
		this.intelecto += intelecto;
	}
	public int calcularSaludActual(){
		return saludBase+(vitalidad*4); // cada 5 puntos da 20 de vida.
	}
	public int getEnergia() {
		return this.energia;
	}
	public void consumirEnergia(int energia) {
		int aux = this.energia - energia;
		if(aux < 0){
			this.energia = 0;
		}
		this.energia = aux;
	}

	//Casta:
	//Por ahora seria asi:
	public void setCastaMago() {
		this.casta = new Mago();
	}
	/**
	 * Buscar forma general de hacerlo mmmm
	 * deberia estudiar Sistemas Operativos.
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
}

