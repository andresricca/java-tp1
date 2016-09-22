package uiDesktop;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entidades.Personaje;
import negocio.CtrlPersonaje;
import utils.ApplicationException;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PanelABMPersonaje extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtPuntos;
	private JButton btnGuardar;
	private JSpinner spVida;
	private JSpinner spEnergia;
	private JSpinner spDefensa;
	private JSpinner spEvasion;
	
	private int puntosTotales;
	private int puntosRestantes;

	/**
	 * Create the panel.
	 */
	public PanelABMPersonaje() {
		setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Dialog", Font.BOLD, 18));
		lblID.setBounds(100, 105, 46, 20);
		add(lblID);
		
		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(156, 102, 70, 26);
		add(txtId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNombre.setBounds(267, 105, 70, 20);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(347, 102, 230, 26);
		add(txtNombre);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVida.setFont(new Font("Dialog", Font.BOLD, 16));
		lblVida.setBounds(347, 156, 46, 20);
		add(lblVida);
		
		JLabel lblEnergia = new JLabel("Energ\u00EDa");
		lblEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergia.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnergia.setBounds(302, 198, 91, 20);
		add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefensa.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDefensa.setBounds(312, 238, 81, 20);
		add(lblDefensa);
		
		JLabel lblEvasion = new JLabel("Evasi\u00F3n");
		lblEvasion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEvasion.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEvasion.setBounds(308, 278, 85, 20);
		add(lblEvasion);
		
		ChangeListener cl = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				actualizarValores();
			}	
		};
		
		spVida = new JSpinner();
		spVida.addChangeListener(cl);
		spVida.setFont(new Font("Dialog", Font.PLAIN, 16));
		spVida.setBounds(433, 156, 112, 20);
		add(spVida);
		
		spEnergia = new JSpinner();
		spEnergia.addChangeListener(cl);
		spEnergia.setFont(new Font("Dialog", Font.PLAIN, 16));
		spEnergia.setBounds(433, 196, 112, 20);
		add(spEnergia);
		
		spDefensa = new JSpinner();
		spDefensa.addChangeListener(cl);
		spDefensa.setFont(new Font("Dialog", Font.PLAIN, 16));
		spDefensa.setBounds(433, 236, 112, 20);
		add(spDefensa);
		
		spEvasion = new JSpinner();
		spEvasion.addChangeListener(cl);
		spEvasion.setFont(new Font("Dialog", Font.PLAIN, 16));
		spEvasion.setBounds(433, 276, 112, 20);
		add(spEvasion);
		
		JLabel lblPuntos = new JLabel("Puntos disponibles");
		lblPuntos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPuntos.setBounds(213, 337, 180, 20);
		add(lblPuntos);
		
		txtPuntos = new JTextField("");
		txtPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntos.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPuntos.setEditable(false);
		txtPuntos.setColumns(10);
		txtPuntos.setBounds(431, 337, 114, 20);
		add(txtPuntos);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnGuardar.setBounds(520, 432, 141, 26);
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelar();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelar.setBounds(100, 432, 141, 26);
		add(btnCancelar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(100, 73, 561, 1);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(100, 404, 561, 1);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(99, 73, 1, 331);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(661, 73, 1, 331);
		add(separator_3);
	}
	
	
	
	public void prepararCrear() {
		limpiar();		
		puntosTotales = CtrlPersonaje.getCtrl().getPuntosInicio();
		txtId.setText("0");
		actualizarValores();
	}
	
	public void prepararModificar(Personaje p) {
		limpiar();
		mapearAFormulario(p);
		actualizarValores();
	}
	
	private void limpiar() {
		txtId.setText("");
		txtNombre.setText("");
		spVida.setValue(0);
		spEnergia.setValue(0);
		spDefensa.setValue(0);
		spEvasion.setValue(0);
	}
	
	private void mapearAFormulario(Personaje p) {
		txtId.setText(Integer.toString(p.getId()));
		txtNombre.setText(p.getNombre());
		puntosTotales = p.getPuntosTotales();
		spVida.setValue(p.getVida());
		spEnergia.setValue(p.getEnergia());
		spDefensa.setValue(p.getDefensa());
		spEvasion.setValue(p.getEvasion());
	}
	
	private void guardar() {
		try {
			Personaje p = mapearDeFormulario();
			if(p.getId()==0) {
				CtrlPersonaje.getCtrl().add(p);
			} else {
				CtrlPersonaje.getCtrl().update(p);
			}
			TP1.getPanelPrincipal().cargarPersonajes();
			TP1.showPanel(TP1.PANEL_PRINCIPAL);
		} catch(ApplicationException ae) {
			JOptionPane.showMessageDialog(this, ae.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error inesperado al guardar");
		}		
	}
	
	private Personaje mapearDeFormulario() {
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtId.getText()));
		p.setNombre(txtNombre.getText().trim());
		p.setVida((Integer)spVida.getValue());
		p.setEnergia((Integer)spEnergia.getValue());
		p.setDefensa((Integer)spDefensa.getValue());
		p.setEvasion((Integer)spEvasion.getValue());
		p.setPuntosTotales(puntosTotales);
		return p;
	}
	
	private void cancelar() {
		TP1.showPanel(TP1.PANEL_PRINCIPAL);
	}
	
	
	
	private void actualizarValores() {
		puntosRestantes=puntosTotales-(Integer)spVida.getValue()-(Integer)spEnergia.getValue()-
				(Integer)spDefensa.getValue()-(Integer)spEvasion.getValue();
		txtPuntos.setText(Integer.toString(puntosRestantes));
		
		limitarSpinner(spVida, Integer.MAX_VALUE);
		limitarSpinner(spEnergia, Integer.MAX_VALUE);
		limitarSpinner(spDefensa, CtrlPersonaje.getCtrl().getMaxDefensa());
		limitarSpinner(spEvasion, CtrlPersonaje.getCtrl().getMaxEvasion());
	}
	
	private void limitarSpinner(JSpinner s, int tope) {
		int valor = (Integer) s.getValue();
		int max = valor + puntosRestantes;
		if(max > tope) {
			max = tope;
		}
		s.setModel(new SpinnerNumberModel(valor, 0, max, 1));
	}
	

	
}