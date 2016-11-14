	package juego;

import javax.swing.JFrame;

import personaje.Personaje;
import raza.PersonajePrueba;

public class JuegoTest_SinServidor {
	
	public static void main(String[] args) {
		JFrame ventana=new JFrame("El señor de los aniloros"); //Ventana comun
		Personaje pj_test = new PersonajePrueba("Krilin");
		String nombreMapa = "map_test";
		ventana.add(new JuegoPanel(ventana, pj_test.getUbicacion(),pj_test,nombreMapa)); //Dentro de la ventana pongo el juego.

		ventana.pack(); //hace que el tamaño se ajuste al tamaño preferido y diseños de sus subcomponentes.

		ventana.setLocationRelativeTo(null); //centro

		ventana.setResizable(true); // evito que se cambie el tamaño para que no se chanfle todo.

		ventana.setVisible(true); // uno se mata haciendo los graficos para que ponga false ¬¬

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // :c adios amor.
	}
}
