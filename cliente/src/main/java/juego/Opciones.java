package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cliente.Cliente;
import item.ItemEquipo;
import mensaje.MensajeInteraccion;
import personaje.Personaje;

@SuppressWarnings("serial")
public class Opciones extends JFrame {
	private JPanel listaPanel;
	private DefaultListModel<String> listModel;
	private List<String> llavesListModel;
	private Cliente cliente;
	private Personaje pj;
	private JScrollPane listaScroll;
	private JList<String> lista;

	public Opciones(Personaje pj, Cliente cliente) {
		this.cliente = cliente;
		this.pj = pj;
		listModel = new DefaultListModel<String>();
		llavesListModel = new ArrayList<String>();
		listaPanel = new JPanel();
		listaScroll = new JScrollPane();
		listaScroll.setBounds(20, 20, 728, 160);
		listaPanel.add(listaScroll);
		lista = new JList<String>(listModel);
		lista.setBounds(0, 0, 728, 160);
		lista.setBackground(Color.LIGHT_GRAY);
		listaScroll.setViewportView(lista);
		cargarItems();
		
		setVisible(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setType(Type.UTILITY);
		setTitle(pj.getNombre());
		setAutoRequestFocus(false);
		setBounds(100, 100, 450, 234);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblIntelecto = new JLabel(""+pj.getIntelecto());
		lblIntelecto.setBounds(120, 33, 46, 14);
		getContentPane().add(lblIntelecto);

		JLabel lblVitalidad = new JLabel(""+pj.getVitalidad());
		lblVitalidad.setBounds(120, 67, 46, 14);
		getContentPane().add(lblVitalidad);

		JLabel lblDestreza = new JLabel(""+pj.getDestreza());
		lblDestreza.setBounds(120, 101, 46, 14);
		getContentPane().add(lblDestreza);

		JLabel lblFuerza = new JLabel(""+pj.getFuerza());
		lblFuerza.setBounds(120, 135, 46, 14);
		getContentPane().add(lblFuerza);

		JLabel lblVelocidad = new JLabel(""+pj.getVelocidad());
		lblVelocidad.setBounds(120, 166, 46, 14);
		getContentPane().add(lblVelocidad);

		JLabel lblPuntos = new JLabel("Puntos: "+pj.getPuntosDeEstados());
		lblPuntos.setBounds(10, 11, 150, 14);
		getContentPane().add(lblPuntos);

		JButton btnIntelecto = new JButton("Intelecto");
		btnIntelecto.setBounds(10, 29, 100, 23);	
		btnIntelecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( pj.subirIntelecto() ){
					lblIntelecto.setText(""+pj.getIntelecto());
					lblPuntos.setText("Puntos: "+pj.getPuntosDeEstados());
					enviarMensajeSubirEstado("intelecto");
				}
			}

		});
		getContentPane().add(btnIntelecto);

		JButton btnVitalidad = new JButton("Vitalidad");
		btnVitalidad.setBounds(10, 63, 100, 23);
		btnVitalidad.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				if( pj.subirVitalidad() ){
					lblVitalidad.setText(""+pj.getVitalidad());
					lblPuntos.setText("Puntos: "+pj.getPuntosDeEstados());
					enviarMensajeSubirEstado("vitalidad");
				}
			}


		});
		getContentPane().add(btnVitalidad);

		JButton btnDestreza = new JButton("Destreza");
		btnDestreza.setBounds(10, 97, 100, 23);
		btnDestreza.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				if( pj.subirDestreza() ){
					lblDestreza.setText(""+pj.getDestreza());
					lblPuntos.setText("Puntos: "+pj.getPuntosDeEstados());
					enviarMensajeSubirEstado("destreza");
				}
			}
		});
		getContentPane().add(btnDestreza);

		JButton btnFuerza = new JButton("Fuerza");
		btnFuerza.setBounds(10, 131, 100, 23);
		btnFuerza.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				if( pj.subirFuerza() ){
					lblFuerza.setText(""+pj.getFuerza());
					lblPuntos.setText("Puntos: "+pj.getPuntosDeEstados());
					enviarMensajeSubirEstado("fuerza");
				}
			}
		});
		getContentPane().add(btnFuerza);

		JButton btnVelocidad = new JButton("Velocidad");
		btnVelocidad.setBounds(10, 162, 100, 23);
		btnVelocidad.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				if( pj.subirVelocidad() ){
					lblVelocidad.setText(""+pj.getVelocidad());
					lblPuntos.setText("Puntos: "+pj.getPuntosDeEstados());
					enviarMensajeSubirEstado("velocidad");
				}
			}
		});
		getContentPane().add(btnVelocidad);
		JPanel panel = new JPanel();
		panel.setBounds(157, 29, 109, 156);
		getContentPane().add(panel);

		JLabel lblEquipo = new JLabel("Mochila");
		lblEquipo.setBounds(157, 11, 46, 14);
		getContentPane().add(lblEquipo);

		JPanel mochilaPanel = new JPanel();
		mochilaPanel.setBounds(331, 29, 93, 156);
		getContentPane().add(mochilaPanel);
		mochilaPanel.add(listaPanel);

		JLabel lblEquipo_1 = new JLabel("Equipo");
		lblEquipo_1.setBounds(331, 11, 46, 14);
		getContentPane().add(lblEquipo_1);

		JButton btnEquipar = new JButton("->");
		btnEquipar.setBounds(276, 63, 45, 57);
		getContentPane().add(btnEquipar);
	}


	private void enviarMensajeSubirEstado(String estado) {
		try {
			cliente.enviarInteraccion(new MensajeInteraccion(estado, MensajeInteraccion.ESTADO));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error en actualizar datos.\nDetalles: "+e.toString());
		}
	}

	private void cargarItems(){
		llavesListModel.clear();
		Map<String,ItemEquipo> equipables = pj.getItemEquipables();
		for (String equipo : equipables.keySet()) {
			listModel.addElement(equipables.get(equipo).getNombre());
			llavesListModel.add(equipo);
		}
	}
}



