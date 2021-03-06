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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField userField;
	private JPasswordField passwordField;
	private JPasswordField password2Field;
	private JComboBox razaBox;
	private JComboBox castaBox;

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
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblRaza = new JLabel("Raza: ");
				panel.add(lblRaza);
			}
			{
				razaBox = new JComboBox();
				razaBox.setModel(new DefaultComboBoxModel(new String[] {"Humano", "Orco", "Mognatal"}));
				panel.add(razaBox);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblCasta = new JLabel("Casta: ");
				panel.add(lblCasta);
			}
			{
				castaBox = new JComboBox();
				castaBox.setModel(new DefaultComboBoxModel(new String[] {"Guerrero", "LoroMaster", "Mago"}));
				panel.add(castaBox);
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
		String casta = (String) castaBox.getSelectedItem();
		String raza = (String) razaBox.getSelectedItem();
		
		casta = casta.toLowerCase();
		raza = raza.toLowerCase();
		
		if(pass.equals(pass2)){
			Cliente client;

			
			try {
				client = new Cliente(user);
				MensajeConfirmacion men = client.enviarRegistro(user, pass, casta, raza);
				if(men.isConfirmado()){
					JOptionPane.showMessageDialog(null, "Registrado");
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, men.getMensaje());
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error de conexion, que pena <:)");
			}
		
		}
		else{
			JOptionPane.showMessageDialog(null, "Las claves no coinciden");
		}





	}


}
