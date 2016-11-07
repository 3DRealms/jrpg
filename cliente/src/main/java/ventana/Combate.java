package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.newdawn.easyogg.OggClip;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



public class Combate extends JFrame {

	private JPanel contentPane;
	
	private List<Point> posEquipo1;
	private List<Point> posEquipo2;
	private List <SpriteCombate> equipo1;
	private List <SpriteCombate> equipo2;
	
	OggClip musica = null;
	OggClip sonido = null;
	

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
		
		posEquipo1 = new ArrayList<Point>();
		equipo1 = new ArrayList<SpriteCombate>();
		posEquipo2 = new ArrayList<Point>();
		equipo2 = new ArrayList<SpriteCombate>();
		
		posEquipo1.add(new Point(25,100));
		posEquipo1.add(new Point(25,240));
		posEquipo1.add(new Point(25,380));
		posEquipo1.add(new Point(150,180));
		posEquipo1.add(new Point(150,340));
		
		posEquipo2.add(new Point(879,100));
		posEquipo2.add(new Point(879,240));
		posEquipo2.add(new Point(879,380));
		posEquipo2.add(new Point(754,180));
		posEquipo2.add(new Point(754,340));
		
		boolean audiosAbiertos = abrirAudios();
		if(audiosAbiertos){
			musica.setGain(0.8f);
			musica.loop();
			
		}
		
		
		String pathSprite = "src\\main\\resources\\combate\\actor\\actor1.png";
		
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
		
		for(Point pos: posEquipo1){
			SpriteCombate player1 = new SpriteCombate(pathSprite, "Lightray", 500, 250, 500, 250, true);
			player1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					((SpriteCombate) player1).mostrarFlecha(true);
					if(audiosAbiertos){
						sonido.play();	
					}
				}
				@Override
				public void mouseExited(MouseEvent e) {
					((SpriteCombate) player1).mostrarFlecha(false);
				}
			});
			player1.setLocation(pos);
			fondoBatalla.add(player1);
			equipo1.add(player1);
		}
		
		for(Point pos: posEquipo2){
			SpriteCombate player1 = new SpriteCombate(pathSprite, "Lightray", 500, 250, 500, 250, false);
			player1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					((SpriteCombate) player1).mostrarFlecha(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					((SpriteCombate) player1).mostrarFlecha(false);
				}
			});
			player1.setLocation(pos);
			fondoBatalla.add(player1);
			equipo2.add(player1);
		}
		
		
/*
		JPanel team1player2 = new SpriteCombate(pathSprite, "Lightray", 500, 250, 500, 250);
		team1player2.setLocation(25, 240);
		fondoBatalla.add(team1player2);
		
		JPanel team1player3 = new SpriteCombate(pathSprite, "Lightray", 500, 250, 500, 250);
		team1player3.setLocation(25, 380);
		fondoBatalla.add(team1player3);

		JPanel team1player4 = new SpriteCombate(pathSprite, "Lightray", 500, 250, 500, 250);
		team1player4.setLocation(150, 180);
		fondoBatalla.add(team1player4);
		
		JPanel team1player5 = new SpriteCombate(pathSprite, "Lightray", 500, 250, 500, 250);
		team1player5.setLocation(150, 340);
		fondoBatalla.add(team1player5);
		
*/		
		
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
	
	private boolean abrirAudios(){
		try {
			InputStream inputStream1 =
				      new FileInputStream("src\\main\\resources\\sound\\battle1.ogg");
			musica = new OggClip(inputStream1);
			InputStream inputStream2 =
				      new FileInputStream("src\\main\\resources\\sound\\sound.ogg");
			sonido = new OggClip(inputStream2);
			
		} catch (IOException e1) {
			return false;
		}
		return true;
	}
	

}
