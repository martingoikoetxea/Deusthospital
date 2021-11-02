package deusthospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class VentanaIniciosesion extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaActual,ventanaAnterior;
	private JLabel labeliniciosesion;
	private JPanel panelcentro,panelnorte,panelCentral;
	private JButton btnvolverinicio;
	private JLabel lblNewLabel;
	private JTextField textuUsuario;
	private JLabel lblNewLabel_1;
	private JTextField textContraseña;
	private JPanel panelSur;
	private JButton btnIniciosesion,btnRegistro;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaIniciosesion(JFrame va) {
		
		setTitle("Ventana incio sesion");
		ventanaActual = this;
		ventanaAnterior = va;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelnorte = new JPanel();
		contentPane.add(panelnorte, BorderLayout.NORTH);
		panelnorte.setLayout(new BorderLayout(0, 0));
		
		panelcentro = new JPanel();
		panelnorte.add(panelcentro, BorderLayout.NORTH);
		panelcentro.setLayout(new BorderLayout(0, 0));
		
		btnvolverinicio = new JButton("volver inicio");
		btnvolverinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelnorte.add(btnvolverinicio, BorderLayout.EAST);
		
		labeliniciosesion = new JLabel("INICIAR SESION");
		panelnorte.add(labeliniciosesion, BorderLayout.CENTER);
		
		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(2, 2, 0, 0));
		
		lblNewLabel = new JLabel("USUARIO");
		panelCentral.add(lblNewLabel);
		
		textuUsuario = new JTextField();
		panelCentral.add(textuUsuario);
		textuUsuario.setColumns(10);
		
		lblNewLabel_1 = new JLabel("CONTRSE\u00D1A");
		panelCentral.add(lblNewLabel_1);
		
		textContraseña = new JTextField();
		panelCentral.add(textContraseña);
		textContraseña.setColumns(10);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnIniciosesion = new JButton("INICIAR SESION");
		panelSur.add(btnIniciosesion);
		
		btnRegistro = new JButton("REGISTRO");
		panelSur.add(btnRegistro);
		btnvolverinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new VentanaRegistro(ventanaActual);
				ventanaActual.setVisible(false);
				
				
			}
			});
		setVisible(true);
		
	}
		
}
