package uiDesktop;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidades.Personaje;
import negocio.CtrlPersonaje;
import utils.ApplicationException;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;



public class PanelPrincipal extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Personaje jugador1;
	private Personaje jugador2;
	
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
				combate();
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
		
		cargarPersonajes();
	}
	
	
	
	public void cargarPersonajes() {
		try {
			Personaje[] personajes=CtrlPersonaje.getCtrl().getPersonajes();
			dlm=new DefaultListModel<Personaje>();
			for(int i=0;i<personajes.length;i++) {
				dlm.addElement(personajes[i]);
			}
			listPersonajes.setModel(dlm);
			
			if(jugador1!=null) {
				dlm.removeElement(jugador1);
			}
			if(jugador2!=null) {
				dlm.removeElement(jugador2);
			}
		} catch (ApplicationException ae) {
			JOptionPane.showMessageDialog(this, ae.getMessage());;
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
		try {
			Personaje p=listPersonajes.getSelectedValue();
			CtrlPersonaje.getCtrl().delete(p);
			dlm.removeElement(p);
		} catch (ApplicationException ae) {
			JOptionPane.showMessageDialog(this, ae.getMessage());
		}
	}
	
	
	
	private void seleccionar1() {
		jugador1=seleccionar(jugador1);
		txtJugador1.setText(jugador1.toString());
		habilitarCombate();
	}
	
	private void seleccionar2() {
		jugador2=seleccionar(jugador2);
		txtJugador2.setText(jugador2.toString());
		habilitarCombate();
	}
	
	private Personaje seleccionar(Personaje p) {
		if(p!=null) {
			dlm.addElement(p);
		}
		p=listPersonajes.getSelectedValue();
		dlm.removeElement(p);	
		btnLimpiar.setEnabled(true);
		return p;
	}
	
	private void habilitarCombate() {
		if(jugador1!=null && jugador2!=null) {
			btnCombate.setEnabled(true);
		}
	}
	
	public void limpiar() {
		if(jugador1!=null) {
			dlm.addElement(jugador1);
			txtJugador1.setText("");
			jugador1=null;
		}
		if(jugador2!=null) {
			dlm.addElement(jugador2);
			txtJugador2.setText("");
			jugador2=null;
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
	
	
	
	private void combate() {
		try {
			TP1.getPanelCombate().nuevoCombate(jugador1, jugador2);
			TP1.showPanel(TP1.PANEL_COMBATE);
		} catch(ApplicationException ae) {
			JOptionPane.showMessageDialog(this, ae.getMessage());
		}
	}
}
