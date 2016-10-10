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
	protected final int ENERGIAAUTOATAQUE = 1; //enegia que gasta por autoAtaque.

	//Estados, inicialmente todo personaje nuevo tiene 0  y se van escalando a "gusto".
	protected int fuerza = 0;  
	protected int intelecto = 0;
	protected int destreza = 0;
	protected int vitalidad = 0;

	//progreso
	protected int nivel = 1;
	protected int experiencia = 0;

	//Salud: Estos dependeran de la raza, tendra su salud base diferente.
	protected String nombre;
	protected int saludBase = 120; //esto es para hacer pruebas.
 	protected int saludActual;
 	///////////////////////////////
	public Personaje(String nombre) {
		this.nombre = nombre;
	}
	protected void despuesDeAtacar() { }
	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();
	public Casta getCasta() {
		return casta;
	}
	public void serAtacado(int danio) {
		this.saludActual -= danio;
	}
	public void serCurado() {
		this.saludActual = 100;
	}
	public void serEnergizado() {
		this.energia = 100;
	}
	@Override
	public void morir() {
	}
	public void lanzarHabilidad(Habilidad obj){

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
	
	public int getIntelecto() {
		return intelecto;
	}
	public void setCastaMago() {
		casta = new Mago();
	}

 	/** 
 	 * 
 	 * @param atacado
 	 * por el momento el atacar es generico para todos. 
 	 * cada metodo es igual en cada Raza, (esto para hacer pruebas). 
 	 * en el futuro hay que ir cambiando cada metodo de cada raza para darle sabor.
 	 * The lore of destiny v0.18
 	 */
	public void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			int puntosDeAtaque = calcularPuntosDeAtaque();
			atacado.serAtacado(puntosDeAtaque);
			energia -= ENERGIAAUTOATAQUE; //1
			despuesDeAtacar();
		}
	}
	public  boolean lanzarHabilidad(String conjuro, Personaje personaje){
		Habilidad h = casta.getHabilidades().get(conjuro);
		if( getEnergia() >= h.getCosto()){
			consumirEnergia(h.getCosto());
			casta.lanzarHabilidad(conjuro, personaje,intelecto);
			//Ya se que esto esta mal, pero son las 2:11 am y no doy mas :v 
			return true;
		}
		return false;
	}
	
	public void agregarHabilidad(String conjuro, Habilidad habilidad) {
		casta.agregarHabilidad(conjuro, habilidad);
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}

