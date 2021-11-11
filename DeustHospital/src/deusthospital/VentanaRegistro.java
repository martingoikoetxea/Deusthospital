package deusthospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanaRegistro extends JFrame {

	private JFrame ventanaActual,ventanaAnterior;
	private JPanel contentPane,panelsur;
	private JButton btnregistro;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textUsuario;
	private JLabel labelContraseña;
	private JTextField textContraseña;
	private JLabel labelconfirmarcon;
	private JTextField textConfirmarcon;
	private JLabel lblNewLabel_3;
	private JTextField texttlf;
	private static Connection con; 

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(JFrame va) {
		
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
		ventanaActual = this;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelsur = new JPanel();
		contentPane.add(panelsur, BorderLayout.NORTH);
		
		btnregistro = new JButton("Registro");
		
		contentPane.add(btnregistro, BorderLayout.SOUTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		
		lblNewLabel = new JLabel("DNI");
		panel.add(lblNewLabel);
		
		textUsuario = new JTextField();
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		labelContraseña = new JLabel("CONTRASE\u00D1A");
		panel.add(labelContraseña);
		
		textContraseña = new JTextField();
		panel.add(textContraseña);
		textContraseña.setColumns(10);
		
		labelconfirmarcon = new JLabel("CONFIRMAR CONTRASE\u00D1A");
		panel.add(labelconfirmarcon);
		
		textConfirmarcon = new JTextField();
		panel.add(textConfirmarcon);
		textConfirmarcon.setColumns(10);
		
		lblNewLabel_3 = new JLabel("TELEFONO");
		panel.add(lblNewLabel_3);
		
		texttlf = new JTextField();
		panel.add(texttlf);
		texttlf.setColumns(10);
		
		btnregistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dni = textUsuario.getText();
				String c =textContraseña.getText();
				String cc = textConfirmarcon.getText();
				String tlf = texttlf.getText();
				String tlfformato="[0-9]{9}";
				String dniformato = "[0-9]{8}[A-Z]";
				boolean Correctodni = Pattern.matches(dniformato, dni);
				boolean Correctotlf = Pattern.matches(tlfformato, tlf);
				if(!dni.equals("") && !c.equals("")&& !cc.equals("")) {
					
					int resul = VentanaPrincipal.ObtenerPaciente(con, dni,c);
					if(resul == 0) {
						if(Correctodni && Correctotlf) {
								if(c.equals(cc) ) {
									String t = texttlf.getText();
									VentanaPrincipal.insertarPaciente(con, dni, tlf,c);
									VentanaPrincipal.closeBD(con);
									JOptionPane.showMessageDialog(null, "Te has registrado correctamente");
									ventanaActual.dispose();
									ventanaAnterior.setVisible(true);
									System.out.println(VentanaPrincipal.tmpacientes);
								}else {
									JOptionPane.showMessageDialog( null, "La contraseña no coincide");
									vaciarContraseña();
								}
						}
						else {
							JOptionPane.showMessageDialog( null, "Telefono o Dni incorrecto");
							vaciarCampos();		
						
							
						}
					}else {
						JOptionPane.showMessageDialog(null, "ERROR! Ese nombre de usuario ya existe");
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
		textUsuario.setText("");
		textContraseña.setText("");
		textConfirmarcon.setText("");
		texttlf.setText("");
		
	}
	private void vaciarContraseña() {
		// TODO Auto-generated method stub
		
		textContraseña.setText("");
		textConfirmarcon.setText("");
		
	}
	private void vaciarTlf() {
		// TODO Auto-generated method stub
		texttlf.setText("");
		
		
	}
	private void vaciarDni() {
		// TODO Auto-generated method stub
		textUsuario.setText("");
		
		
	}

}
