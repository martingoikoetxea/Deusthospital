package deusthospital;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	private JTextField textUsuario;
	private JLabel lblNewLabel_1;
	private JPasswordField textContraseña;
	private JPanel panelSur;
	private JButton btnIniciosesion,btnRegistro;
	private static Connection con; 

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaIniciosesion(JFrame va) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con  =  DriverManager.getConnection("jdbc:sqlite:deusthospital.db");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		
		lblNewLabel = new JLabel("DNI");
		panelCentral.add(lblNewLabel);
		
		textUsuario = new JTextField();
		panelCentral.add(textUsuario);
		textUsuario.setColumns(10);
		
		lblNewLabel_1 = new JLabel("CONTRSE\u00D1A");
		panelCentral.add(lblNewLabel_1);
		
		textContraseña = new JPasswordField();
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
				
		btnIniciosesion.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String dni = textUsuario.getText();
						String c = new String(textContraseña.getPassword());
						if(!dni.equals("") && !c.equals("")) {
							
							int resul = VentanaPrincipal.ObtenerPaciente(con, dni, c);
							if(resul == 0) {
								JOptionPane.showMessageDialog(null, "No estás registrado");
							}else if(resul==1) {
								JOptionPane.showMessageDialog(null, "La contraseña no es correcta");
							}else {
								JOptionPane.showMessageDialog(null, "Ongi etorri!");
								
							}
						}
						textUsuario.setText("");
						textContraseña.setText("");
					}
		});
		
		setVisible(true);
		
	}
	private void vaciarCampos() {
		// TODO Auto-generated method stub
		textContraseña.setText("");
		textUsuario.setText("");
		
	}
		
		});
	}
}

