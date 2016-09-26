package uiDesktop;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entidades.Personaje;
import negocio.CtrlCombate;
import utils.ApplicationException;

import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCombate extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private CtrlCombate ctrlCombate;
	
	private JSpinner spPuntosAtaque;
	private JButton btnAtacar;
	private JLabel lblTurnoJugador;
	private JLabel lblJugador1;
	private JLabel lblJugador2;
	private JProgressBar barVida1;
	private JLabel lblVida1;
	private JProgressBar barEnergia1;
	private JLabel lblEnergia1;
	private JProgressBar barVida2;
	private JLabel lblVida2;
	private JProgressBar barEnergia2;
	private JLabel lblEnergia2;

	
	
	public PanelCombate() {
		ctrlCombate=new CtrlCombate();
		
		setLayout(null);
		
		lblJugador1 = new JLabel("NombrePersonaje1");
		lblJugador1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblJugador1.setBounds(20, 11, 234, 20);
		add(lblJugador1);
		
		lblJugador2 = new JLabel("NombrePersonaje2");
		lblJugador2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJugador2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblJugador2.setBounds(535, 11, 234, 20);
		add(lblJugador2);
		
		barVida1 = new JProgressBar();
		barVida1.setForeground(new Color(0, 255, 0));
		barVida1.setBounds(20, 57, 234, 14);
		add(barVida1);
		
		JLabel lblVidaBar1 = new JLabel("VIDA");
		lblVidaBar1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVidaBar1.setBounds(20, 42, 75, 14);
		add(lblVidaBar1);
		lblVida1 = new JLabel("0");
		lblVida1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVida1.setBounds(264, 57, 55, 14);
		add(lblVida1);
		
		JLabel lblEnergiaBar1 = new JLabel("ENERGIA");
		lblEnergiaBar1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnergiaBar1.setBounds(20, 82, 75, 14);
		add(lblEnergiaBar1);
		
		barEnergia1 = new JProgressBar();
		barEnergia1.setForeground(Color.BLUE);
		barEnergia1.setBounds(20, 97, 234, 14);
		add(barEnergia1);
		
		lblEnergia1 = new JLabel("0");
		lblEnergia1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnergia1.setBounds(264, 97, 55, 14);
		add(lblEnergia1);
		
		JLabel lblVidaBar2;
		lblVidaBar2 = new JLabel("VIDA");
		lblVidaBar2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVidaBar2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVidaBar2.setBounds(694, 42, 75, 14);
		add(lblVidaBar2);
		
		barVida2 = new InverseProgressBar();
		barVida2.setForeground(Color.GREEN);
		barVida2.setBounds(535, 57, 234, 14);
		add(barVida2);
		
		JLabel lblEnergiaBar2 = new JLabel("ENERGIA");
		lblEnergiaBar2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergiaBar2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnergiaBar2.setBounds(694, 82, 75, 14);
		add(lblEnergiaBar2);
		
		barEnergia2 = new InverseProgressBar();
		barEnergia2.setForeground(Color.BLUE);
		barEnergia2.setBounds(535, 97, 234, 14);
		add(barEnergia2);
		
		lblEnergia2 = new JLabel("0");
		lblEnergia2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergia2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnergia2.setBounds(470, 97, 55, 14);
		add(lblEnergia2);
		
		lblVida2 = new JLabel("0");
		lblVida2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVida2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVida2.setBounds(470, 57, 55, 14);
		add(lblVida2);
		
		JLabel lblTurno = new JLabel("TURNO");
		lblTurno.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno.setBounds(264, 168, 261, 26);
		add(lblTurno);
		
		lblTurnoJugador = new JLabel("NombrePersonaje");
		lblTurnoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnoJugador.setFont(new Font("Dialog", Font.BOLD, 26));
		lblTurnoJugador.setBounds(264, 217, 261, 34);
		add(lblTurnoJugador);
		
		spPuntosAtaque = new JSpinner();
		spPuntosAtaque.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				habilitarAtaque();
			}
		});
		spPuntosAtaque.setFont(new Font("Dialog", Font.BOLD, 18));
		spPuntosAtaque.setBounds(248, 306, 85, 34);
		add(spPuntosAtaque);
		
		btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atacar();
			}
		});
		btnAtacar.setEnabled(false);
		btnAtacar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnAtacar.setBounds(335, 306, 118, 34);
		add(btnAtacar);
		
		JButton btnDefender = new JButton("Defender");
		btnDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		btnDefender.setFont(new Font("Dialog", Font.BOLD, 18));
		btnDefender.setBounds(335, 365, 118, 34);
		add(btnDefender);
		
	}
	
	
	
	public void nuevoCombate(Personaje jugador1, Personaje jugador2) {
		ctrlCombate.nuevoCombate(jugador1, jugador2);
		
		barVida1.setMaximum(jugador1.getVida());
		barEnergia1.setMaximum(jugador1.getEnergia());
		barVida2.setMaximum(jugador2.getVida());
		barEnergia2.setMaximum(jugador2.getEnergia());
		
		actualizarCombate();
	}
	
	private void actualizarCombate() {
		Personaje j1=ctrlCombate.getJugador1();
		lblJugador1.setText(j1.getNombre());
		lblVida1.setText(Integer.toString(j1.getVidaRestante()));
		lblEnergia1.setText(Integer.toString(j1.getEnergiaRestante()));
		barVida1.setValue(j1.getVidaRestante());
		barEnergia1.setValue(j1.getEnergiaRestante());
		
		Personaje j2=ctrlCombate.getJugador2();
		lblJugador2.setText(j2.getNombre());
		lblVida2.setText(Integer.toString(j2.getVidaRestante()));
		lblEnergia2.setText(Integer.toString(j2.getEnergiaRestante()));
		barVida2.setValue(j2.getVidaRestante());
		barEnergia2.setValue(j2.getEnergiaRestante());
		
		lblTurnoJugador.setText(ctrlCombate.getTurno().getNombre());
		
		int max=ctrlCombate.getTurno().getEnergiaRestante();
		spPuntosAtaque.setModel(new SpinnerNumberModel(0, 0, max, 1));
		btnAtacar.setEnabled(false);
	}
	
	
	
	private void habilitarAtaque() {
		boolean habilitar=false;
		int puntos=(Integer)spPuntosAtaque.getValue();
		if(puntos>0) {
			habilitar=true;
		}
		btnAtacar.setEnabled(habilitar);
	}
	
	
	
	private void atacar() {
		int puntos=(Integer)spPuntosAtaque.getValue();
		try {
			ctrlCombate.atacar(puntos);
			actualizarCombate();
			if(ctrlCombate.getFinCombate()) {
				JOptionPane.showMessageDialog(this, ctrlCombate.getTurno().getNombre()+" gana el combate!");
				TP1.getPanelPrincipal().limpiar();
				TP1.getPanelPrincipal().cargarPersonajes();
				TP1.showPanel(TP1.PANEL_PRINCIPAL);
			}
		} catch (ApplicationException ae) {
			JOptionPane.showMessageDialog(this, ae.getMessage());
		}
	}
	
	private void defender() {
		try {
			ctrlCombate.defender();
		} catch (ApplicationException ae) {
			JOptionPane.showMessageDialog(this, ae.getMessage());
		}
		actualizarCombate();
	}
	
}
