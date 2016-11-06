package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Combate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate frame = new Combate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Combate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 745);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel fondoBatalla = new ImagePanel("src\\main\\resources\\combate\\forestbackground.jpg");		
		fondoBatalla.setBounds(0, 0, 1024, 520);
		contentPane.add(fondoBatalla);
		
		JPanel fondoMenu = new ImagePanel("src\\main\\resources\\combate\\menu.jpg");		
		fondoMenu.setBounds(0, 520, 1024, 200);
		contentPane.add(fondoMenu);
	}
}
