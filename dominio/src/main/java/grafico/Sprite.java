package grafico;

import java.awt.*;
import javax.swing.ImageIcon;
/**
 *
 * @author DrCoffee84
 */
public class Sprite{
	private int x,y;		 	//coordenadas
	private boolean visible; 	// si esta visible o no
	private String sprite; 		// el nombre de la imagen

	public Sprite() //Constructor
	{
		visible=true;
		x=y=0;
	}

	public boolean isVisble(){
		return visible;
	}

	public void setVisible(boolean estado){
		visible=estado;
	}

	/**
	 *  Obtenemos la coordenada horizontal actual del Sprite
	 * @return
	 */
	public int getX(){
		return x;
	}

	/**
	 * 
	 * Asignamos la coordenada horizontal actual del Sprite	
	 */
	public void setX(int valor){
		x=valor;
	}

	/**
	 * Obtenemos la coordenada vertical actual del Sprite
	 * @return
	 */
	public int getY(){
		return y;
	}

	/**
	 *  Asignamos la coordenada vertical actual del Sprite
	 * @param valor
	 */
	public void setY(int valor){
		y=valor;
	}

	/**
	 * Ancho del Sprite
	 * @return
	 */
	public int getWidth(){
		return new ImageIcon(getClass().getResource(sprite)).getImage().getWidth(null);
	}
	
	/**
	 *  Alto del Sprite
	 * @return
	 */
	public int getHeight(){
		return new ImageIcon(getClass().getResource(sprite)).getImage().getHeight(null);
	}
	/**
	 * Asignamos el fichero imagen al Sprite
	 * @param nombre
	 */
	public void setSprite(String nombre) {
		sprite=nombre;
	}

	/**
	 *  Nos devuelve el fichero imagen del Sprite
	 * @return
	 */
	public String getSprite(){
		return sprite;
	}

	/**
	 * Pegamos el Sprite en la pantalla
	 * @param grafico
	 * @param coordenadaHorizontal
	 * @param coordenadaVertical
	 */
	public void putSprite(Graphics grafico,int coordenadaHorizontal,int coordenadaVertical){
		x=coordenadaHorizontal;
		y=coordenadaVertical;
		if (visible) grafico.drawImage(new ImageIcon(getClass().getResource(sprite)).getImage(), x, y, null);
	}

}