package ventana;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CombatButton extends JButton{
	
	public CombatButton(String texto){
		super(texto);
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.setBackground(new Color(0, 120, 255));
		this.setBorderPainted(false);
	}

}
