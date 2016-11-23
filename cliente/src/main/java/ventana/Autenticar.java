package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import juego.JuegoPanel;
import mapa.Punto;
import mensaje.MensajeConfirmacion;
import personaje.Personaje;
import raza.PersonajePrueba;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Autenticar extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField claveField;



	/**
	 * Create the frame.
	 */
	public Autenticar() {
		setTitle("Super Awesome Game (No Minecraft)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel botones = new JPanel();
		contentPane.add(botones, BorderLayout.SOUTH);
		botones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarSesion();
			}
		});
		botones.add(btnIniciarSesion);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro ventana = new Registro();
				ventana.setVisible(true);
			}
		});
		botones.add(btnRegistrarse);

		JPanel campos = new JPanel();
		contentPane.add(campos, BorderLayout.CENTER);
		campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		campos.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblUsuario = new JLabel("Usuario: ");
		panel.add(lblUsuario);

		userField = new JTextField();
		panel.add(userField);
		userField.setColumns(25);

		JPanel panel_1 = new JPanel();
		campos.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		panel_1.add(lblContrasea);

		claveField = new JPasswordField();
		claveField.setColumns(25);
		panel_1.add(claveField);
	}

	public void iniciarSesion(){
		String user = userField.getText();
		String pass = String.valueOf(claveField.getPassword());
		Cliente client;
		try {
			client = new Cliente(user);
			MensajeConfirmacion men = client.enviarAutenticacion(user, pass);
			if(men.isConfirmado()){
				//JOptionPane.showMessageDialog(null, "Logueado");
				//ACA ABRO EL PUTO JUEGO
					Personaje personaje = client.pedirPersonaje();
				//Personaje personaje = new PersonajePrueba("the Dani");
				abrirJuego(personaje,client);

				//no te olvides de abrirlo

			}
			else{
				JOptionPane.showMessageDialog(null, men.getMensaje());
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error de conexion, no se puede conectar. Anda a estudiar.");
			System.exit(0);
		}




	}

	private void abrirJuego(Personaje per, Cliente client){
		client.abrirJuego(per);
		this.setVisible(false);
	}

}
