package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 1000, 745);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel listModel;

		listModel = new DefaultListModel();
		
		JPanel fondoBatalla = new ImagePanel("src\\main\\resources\\combate\\carcel.jpg");		
		fondoBatalla.setBounds(0, 0, 1024, 520);
		contentPane.add(fondoBatalla);
		fondoBatalla.setLayout(null);
		
		JPanel team1player1 = new SpriteCombate("src\\main\\resources\\combate\\actor\\actor1.png");
		team1player1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				((SpriteCombate) team1player1).mostrarFlecha(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				((SpriteCombate) team1player1).mostrarFlecha(false);
			}
		});
		team1player1.setLocation(25, 100);
		fondoBatalla.add(team1player1);

		JPanel team1player2 = new SpriteCombate("src\\main\\resources\\combate\\actor\\actor1.png");
		team1player2.setLocation(25, 240);
		fondoBatalla.add(team1player2);
		
		JPanel team1player3 = new SpriteCombate("src\\main\\resources\\combate\\actor\\actor1.png");
		team1player3.setLocation(25, 380);
		fondoBatalla.add(team1player3);

		JPanel team1player4 = new SpriteCombate("src\\main\\resources\\combate\\actor\\actor1.png");
		team1player4.setLocation(150, 180);
		fondoBatalla.add(team1player4);
		
		JPanel team1player5 = new SpriteCombate("src\\main\\resources\\combate\\actor\\actor1.png");
		team1player5.setLocation(150, 340);
		fondoBatalla.add(team1player5);
		
		
		
		JPanel fondoMenu = new ImagePanel("src\\main\\resources\\combate\\menu.jpg");		
		fondoMenu.setBounds(0, 520, 1024, 200);
		contentPane.add(fondoMenu);
		fondoMenu.setLayout(null);
		
		JPanel acciones = new JPanel();
		acciones.setBounds(0, 0, 256, 200);
		fondoMenu.add(acciones);
		acciones.setLayout(null);
		acciones.setOpaque(false);
		
		JButton btnHuir = new CombatButton("HUIR");
		btnHuir.setBounds(28, 158, 200, 28);
		acciones.add(btnHuir);
		
		JButton btnMochila = new CombatButton("MOCHILA");
		btnMochila.setBounds(28, 86, 200, 28);
		acciones.add(btnMochila);
		
		JButton btnDefender = new CombatButton("DEFENDER");
		btnDefender.setBounds(28, 122, 200, 28);
		acciones.add(btnDefender);
		
		JButton btnHabilidades = new CombatButton("HABILIDADES");
		btnHabilidades.setBounds(28, 50, 200, 28);
		acciones.add(btnHabilidades);
		
		JButton btnAtacar = new CombatButton("ATACAR");
		btnAtacar.setBounds(28, 14, 200, 28);
		acciones.add(btnAtacar);
		
		JPanel listaPanel = new JPanel();
		listaPanel.setBounds(256, 0, 768, 200);
		listaPanel.setOpaque(false);
		listaPanel.setLayout(null);		
		//listaPanel.setVisible(false);
		fondoMenu.add(listaPanel);
		
		JScrollPane listaScroll = new JScrollPane();
		listaScroll.setBounds(20, 20, 728, 160);
		listaPanel.add(listaScroll);
		
		JList lista = new JList(listModel);
		lista.setBounds(0, 0, 728, 160);
		lista.setForeground(Color.WHITE);
		lista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lista.setBackground(new Color(0, 120, 255));
		listaScroll.setViewportView(lista);
		
		
		JScrollPane mensajesScroll = new JScrollPane();
		mensajesScroll.setBounds(276, 20, 728, 160);
		mensajesScroll.setVisible(false);
		fondoMenu.add(mensajesScroll);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 4, 22);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setBackground(new Color(0, 120, 255));
		textArea.setEditable(false);
		mensajesScroll.setViewportView(textArea);
		


	}
}
