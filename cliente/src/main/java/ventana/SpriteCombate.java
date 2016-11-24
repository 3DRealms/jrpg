package ventana;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SpriteCombate extends JPanel{
	
	JPanel sprite;
	JPanel cuadro;
	JPanel flecha;
	JLabel lblPlayername;
	JLabel lblPlayerlife;
	JLabel playerMana;
	
	String nombre;
	int vidaBase;
	

	int manaBase;
	int vida;
	int mana;
	
	
	SpriteCombate(String spritePath,String nombre,int vidaBase,int manaBase,int vida,int mana, boolean invertido){
		this.setOpaque(false);
		this.setLayout(null);
		
		this.nombre = nombre;
		this.vidaBase = vidaBase;
		this.manaBase = manaBase;
		this.vida = vida;
		this.mana = mana;
		
		sprite = new ImagePanel(spritePath, invertido);
		sprite.setBounds(16, 56, 64, 64);
		sprite.setOpaque(false);
		
		this.add(sprite);		
		this.setSize(96, 120);
		
		cuadro = new ImagePanel("src\\main\\resources\\combate\\cartel.png");	
		cuadro.setBounds(0, 0, 96, 54);
		cuadro.setOpaque(false);
		this.add(cuadro);
		cuadro.setLayout(null);
		
		flecha = new ImagePanel("src\\main\\resources\\combate\\flecha.png");	
		flecha.setBounds(0, 0, 96, 54);
		flecha.setOpaque(false);
		flecha.setVisible(false);
		this.add(flecha);
		cuadro.setLayout(null);
		
		
		lblPlayername = new JLabel(nombre);
		lblPlayername.setForeground(Color.WHITE);
		lblPlayername.setBounds(0, 3, 96, 20);
		cuadro.add(lblPlayername);
		lblPlayername.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayername.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblPlayerlife = new JLabel();
		escribirVida(vida);
		lblPlayerlife.setForeground(Color.WHITE);
		lblPlayerlife.setBounds(0, 24, 96, 11);
		cuadro.add(lblPlayerlife);
		lblPlayerlife.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblPlayerlife.setHorizontalAlignment(SwingConstants.CENTER);
		
		playerMana = new JLabel();
		escribirMana(mana);
		playerMana.setForeground(Color.WHITE);
		playerMana.setBounds(0, 37, 96, 11);
		cuadro.add(playerMana);
		playerMana.setFont(new Font("Tahoma", Font.BOLD, 9));
		playerMana.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void mostrarFlecha(boolean arg){
		
		flecha.setVisible(arg);
		cuadro.setVisible(!arg);
		
	}
	
	public void escribirVida(int vidaAct){
		lblPlayerlife.setText("HP:"+vidaAct+"/"+vidaBase);
	}
	
	public void escribirMana(int manaAct){
		playerMana.setText("MP:"+manaAct+"/"+manaBase);
	}
	public String getNombre() {
		return nombre;
	}

	public void actualizarEstado(int vida2, int energia) {
		this.escribirVida(vida2);
		this.escribirMana(energia);
		
	}

}
