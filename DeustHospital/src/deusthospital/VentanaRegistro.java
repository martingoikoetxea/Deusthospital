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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private JFrame ventanaActual,ventanaAnterior;
	private JPanel contentPane,panelnorte;
	private JTextField textDni;
	private JTextField textContrasena;
	private JTextField textTelefono;
	private JButton btnregistro;
	private JTextField textConfirmarcon;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(JFrame va) {
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
		
		textDni = new JTextField();
		contentPane.add(textDni, BorderLayout.SOUTH);
		textDni.setColumns(10);
		
		textContrasena = new JTextField();
		contentPane.add(textContrasena, BorderLayout.WEST);
		textContrasena.setColumns(10);
		
		textTelefono = new JTextField();
		contentPane.add(textTelefono, BorderLayout.EAST);
		textTelefono.setColumns(10);
		
		btnregistro = new JButton("Registro");
		
		contentPane.add(btnregistro, BorderLayout.NORTH);
		
		textConfirmarcon = new JTextField();
		contentPane.add(textConfirmarcon, BorderLayout.CENTER);
		textConfirmarcon.setColumns(10);
		
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dniformato = "[0-9]{8}[A-Z]";
				String d = textDni.getText();
				boolean Correctodni = Pattern.matches(dniformato, d);
				if(Correctodni) {
					String c = textContrasena.getText();
					String cc = textConfirmarcon.getText();
					if(c.equals(cc) ) {
						int t = Integer.parseInt(textTelefono.getText());
						Paciente p = new Paciente(d,t,c);
						VentanaPrincipal.tmpacientes.put(p.getDni(),p);
						vaciarCampos();
						
					}else {
						JOptionPane.showMessageDialog( null, "La contraseña no coincide");
					}
					
				}
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
			}

			private void vaciarCampos() {
				// TODO Auto-generated method stub
				textDni.setText("");
				textContrasena.setText("");
				textConfirmarcon.setText("");
				textTelefono.setText("");
				
			}
		});
		setVisible(true);
	}
	

}
