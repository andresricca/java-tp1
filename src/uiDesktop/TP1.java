package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Container;



public class TP1 {
	
	final static String PANEL_PRINCIPAL="Panel Principal";
	final static String PANEL_ABMPERSONAJE="Panel ABMPersonaje";
	
	CardLayout card;
	PanelPrincipal panelPrincipal;
	PanelABMPersonaje panelABMPersonaje;
	
//Consultar
	private static TP1 window;
	
	public static void showPanel(String nombrePanel) {
		Container cp=window.frame.getContentPane();
		window.card.show(cp, nombrePanel);
	}
	
	public static PanelPrincipal getPanelPrincipal() {
		return window.panelPrincipal;
	}
	
	public static PanelABMPersonaje getPanelABMPersonaje() {
		return window.panelABMPersonaje;
	}
	
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new TP1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TP1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		card=new CardLayout(0, 0);
		frame.getContentPane().setLayout(card);
		
		panelPrincipal=new PanelPrincipal();
		panelABMPersonaje=new PanelABMPersonaje();
		frame.getContentPane().add(panelPrincipal, PANEL_PRINCIPAL);
		frame.getContentPane().add(panelABMPersonaje, PANEL_ABMPERSONAJE);
	}

}
