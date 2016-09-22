package uiDesktop;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidades.Personaje;
import negocio.CtrlPersonaje;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;



public class PanelPrincipal extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Personaje[] jugador;
	
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	
	DefaultListModel<Personaje> dlm;
	
	private JList<Personaje> listPersonajes;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnSeleccionar1;
	private JButton btnSeleccionar2;
	private JButton btnLimpiar;
	private JButton btnCombate;

	public PanelPrincipal() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 86, 292, 353);
		add(scrollPane);
		
		listPersonajes = new JList<Personaje>();
		listPersonajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonajes.setFont(new Font("Dialog", Font.PLAIN, 16));
		listPersonajes.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				habilitarBotones();
			}	
		});
		scrollPane.setViewportView(listPersonajes);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPersonaje();
			}
		});
		btnModificar.setBounds(193, 474, 127, 26);
		add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(28, 474, 127, 26);
		add(btnEliminar);
		
		JLabel lblListaPersonajes = new JLabel("Lista de personajes");
		lblListaPersonajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPersonajes.setFont(new Font("Dialog", Font.BOLD, 18));
		lblListaPersonajes.setBounds(28, 48, 292, 26);
		add(lblListaPersonajes);
		
		txtJugador1 = new JTextField();
		txtJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugador1.setEditable(false);
		txtJugador1.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtJugador1.setBounds(471, 144, 292, 32);
		add(txtJugador1);
		txtJugador1.setColumns(10);
		
		btnSeleccionar1 = new JButton("=> Seleccionar");
		btnSeleccionar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionar1();
			}
		});
		btnSeleccionar1.setEnabled(false);
		btnSeleccionar1.setBounds(332, 144, 127, 32);
		add(btnSeleccionar1);
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblJugador1.setBounds(471, 119, 292, 21);
		add(lblJugador1);
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblJugador2.setBounds(471, 206, 292, 21);
		add(lblJugador2);
		
		txtJugador2 = new JTextField();
		txtJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugador2.setEditable(false);
		txtJugador2.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtJugador2.setColumns(10);
		txtJugador2.setBounds(471, 231, 292, 32);
		add(txtJugador2);
		
		btnSeleccionar2 = new JButton("=> Seleccionar");
		btnSeleccionar2.setEnabled(false);
		btnSeleccionar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionar2();
			}
		});
		btnSeleccionar2.setBounds(332, 231, 127, 32);
		add(btnSeleccionar2);
		
		btnCombate = new JButton("Ir al combate!");
		btnCombate.setEnabled(false);
		btnCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCombate.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCombate.setBounds(548, 328, 135, 42);
		add(btnCombate);
		
		JButton btnCrear = new JButton("Crear nuevo personaje");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearPersonaje();
			}
		});
		btnCrear.setBounds(28, 440, 292, 26);
		add(btnCrear);
		
		btnLimpiar = new JButton("<= Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setEnabled(false);
		btnLimpiar.setBounds(332, 191, 98, 26);
		add(btnLimpiar);
		
		jugador=new Personaje[2];
		cargarPersonajes();
	}
	
	
	
	public void cargarPersonajes() {
		dlm=new DefaultListModel<Personaje>();
		Personaje[] personajes = CtrlPersonaje.getCtrl().getPersonajes();
		for(int i=0;i<personajes.length;i++) {
			dlm.addElement(personajes[i]);
		}
		listPersonajes.setModel(dlm);
		if(jugador[0]!=null) {
			dlm.removeElement(jugador[0]);
		}
		if(jugador[1]!=null) {
			dlm.removeElement(jugador[1]);
		}
	}
	
	private void crearPersonaje() {
		TP1.getPanelABMPersonaje().prepararCrear();
		TP1.showPanel(TP1.PANEL_ABMPERSONAJE);
	}
	
	private void modificarPersonaje() {
		TP1.getPanelABMPersonaje().prepararModificar(listPersonajes.getSelectedValue());
		TP1.showPanel(TP1.PANEL_ABMPERSONAJE);
		
	}
	
	private void eliminar() {
		Personaje p=listPersonajes.getSelectedValue();
		CtrlPersonaje.getCtrl().delete(p);
		dlm.removeElement(p);
	}
	
	
	
	private void seleccionar1() {
		seleccionar(txtJugador1, 0);
	}
	
	private void seleccionar2() {
		seleccionar(txtJugador2, 1);
	}
	
	private void seleccionar(JTextField txt, int i) {
		if(jugador[i]!=null) {
			dlm.addElement(jugador[i]);
		}
		jugador[i]=listPersonajes.getSelectedValue();
		txt.setText(jugador[i].toString());
		dlm.removeElement(jugador[i]);
		
		btnLimpiar.setEnabled(true);
		if(jugador[0]!=null && jugador[1]!=null) {
			btnCombate.setEnabled(true);
		}
	}
	
	private void limpiar() {
		if(jugador[0]!=null) {
			dlm.addElement(jugador[0]);
			txtJugador1.setText("");
			jugador[0]=null;
		}
		if(jugador[1]!=null) {
			dlm.addElement(jugador[1]);
			txtJugador2.setText("");
			jugador[1]=null;
		}
		btnLimpiar.setEnabled(false);
		btnCombate.setEnabled(false);
	}
	
	
	
	private void habilitarBotones() {
		if(listPersonajes.getSelectedIndex()==-1) {
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
			btnSeleccionar1.setEnabled(false);
			btnSeleccionar2.setEnabled(false);
		} else {
			btnEliminar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnSeleccionar1.setEnabled(true);
			btnSeleccionar2.setEnabled(true);
		}
	}
}
