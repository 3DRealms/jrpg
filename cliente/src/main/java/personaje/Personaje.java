package personaje;

import casta.Casta;
import casta.Mago;
import habilidades.Habilidad;
import interfaces.Atacable;
import interfaces.Ubicable;

public abstract class Personaje implements Atacable {


	protected int idPersonaje;
	protected int ataque;
	protected Casta casta;
	protected int destreza;
	protected int energia;
	protected int defensa;
	protected int experiencia;
	protected int fuerza;  
	protected int intelecto;
	protected int nivel;

	protected String nombre;
	protected int saludBase;
	protected int saludActual;
	protected int vitalidad;



	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			int puntosDeAtaque = calcularPuntosDeAtaque();
			atacado.serAtacado(puntosDeAtaque);
			energia -= puntosDeAtaque;
			despuesDeAtacar();
		}
	}

	protected void despuesDeAtacar() { }

	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();

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
		return saludBase <= 0;
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
		return saludBase+(vitalidad*4); 
		//algoritmo trucho para ir escalando la salud.
		// cada 5 puntos da 20 de vida.
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
		casta = new Mago(this);
	}
	public Casta getCasta(){
		return casta;
	}
}

