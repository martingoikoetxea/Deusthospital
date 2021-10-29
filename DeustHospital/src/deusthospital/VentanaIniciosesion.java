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
import java.awt.event.ActionEvent;

public class VentanaIniciosesion extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaActual,ventanaAnterior;
	private JTextField textFieldusuario;
	private JTextField textFieldcontraseña;
	private JTextArea  txtUsuarioContrasea;
	private JLabel labeliniciosesion;
	private JPanel panelcentro,panelnorte,paneltextfields;
	private JButton btnvolverinicio;
	private JButton btniniciosesion;
	private JButton btnregistro;

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
		
		txtUsuarioContrasea = new JTextArea();
		txtUsuarioContrasea.setText("\r\n\r\n\r\nUSUARIO\r\n\r\n\r\n\r\n\r\nCONTRASE\u00D1A");
		contentPane.add(txtUsuarioContrasea, BorderLayout.WEST);
		
		paneltextfields = new JPanel();
		contentPane.add(paneltextfields, BorderLayout.CENTER);
		paneltextfields.setLayout(new BorderLayout(0, 0));
		
		textFieldusuario = new JTextField();
		paneltextfields.add(textFieldusuario, BorderLayout.SOUTH);
		textFieldusuario.setColumns(10);
		textFieldusuario.setSize(100, 200);
		
		textFieldcontraseña = new JTextField();
		paneltextfields.add(textFieldcontraseña, BorderLayout.NORTH);
		textFieldcontraseña.setColumns(10);
		
		btniniciosesion = new JButton("Inicio sesion");
		paneltextfields.add(btniniciosesion, BorderLayout.WEST);
		
		btnregistro = new JButton("Registro");
		
		paneltextfields.add(btnregistro, BorderLayout.EAST);
		
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistro(ventanaActual);
				ventanaActual.setVisible(false);
			}
		});
		btnvolverinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		setVisible(true);
		
	}
		
}
