package ventana;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensaje.MensajeConfirmacion;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField userField;
	private JPasswordField passwordField;
	private JPasswordField password2Field;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		try {
			Registro dialog = new Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Registro() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblUsuario = new JLabel("Usuario: ");
				panel.add(lblUsuario);
			}
			{
				userField = new JTextField();
				panel.add(userField);
				userField.setColumns(25);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
				panel.add(lblContrasea);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setColumns(25);
				panel.add(passwordField);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblRepitaContrasea = new JLabel("Repita Contrase\u00F1a: ");
				panel.add(lblRepitaContrasea);
			}
			{
				password2Field = new JPasswordField();
				password2Field.setColumns(25);
				panel.add(password2Field);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						registrarse();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void registrarse(){
		String user = userField.getText();
		String pass = String.valueOf(passwordField.getPassword());
		String pass2 = String.valueOf(password2Field.getPassword());
		if(pass.equals(pass2)){
			Cliente client;
			try {
				client = new Cliente(user);
				MensajeConfirmacion men = client.enviarRegistro(user, pass);
				if(men.isConfirmado()){
					JOptionPane.showMessageDialog(null, "Registrado");
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, men.getMensaje());
				}
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error de conexion");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Las claves no coinciden");
		}





	}


}
