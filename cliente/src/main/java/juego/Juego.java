	package juego;


import javax.swing.JFrame;

import mapa.Punto;
import raza.PersonajePrueba;

public class Juego {
	public final static String NOMBRE_DEL_JUEGO = "[3DRealms] Loro";
	/**
	 * EL MAIN ES TODO
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame ventana=new JFrame(NOMBRE_DEL_JUEGO); //Ventana comun
				
		ventana.add(new JuegoPanel(ventana,new Punto(1,1),new PersonajePrueba("El dani wacho"))); //Dentro de la ventana pongo el juego, y el spaw ahora.
		
		ventana.pack(); //hace que el tamaño se ajuste al tamaño preferido y diseños de sus subcomponentes.

		ventana.setLocationRelativeTo(null); //centro
		
		ventana.setResizable(true); // evito que se cambie el tamaño para que no se chanfle todo.
		
		ventana.setVisible(true); // uno se mata haciendo los graficos para que ponga false ¬¬
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // :c adios amor.

	}
}

