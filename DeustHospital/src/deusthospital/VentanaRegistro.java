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
	private JLabel labelContrase�a;
	private JTextField textContrase�a;
	private JLabel labelconfirmarcon;
	private JTextField textConfirmarcon;
	private JLabel lblNewLabel_3;
	private JTextField texttlf;

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
		
		labelContrase�a = new JLabel("CONTRASE\u00D1A");
		panel.add(labelContrase�a);
		
		textContrase�a = new JTextField();
		panel.add(textContrase�a);
		textContrase�a.setColumns(10);
		
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
			public void actionPerformed(ActionEvent e) {
				String dniformato = "[0-9]{8}[A-Z]";
				String d = textUsuario.getText();
				String tlfformato="[0-9]{9}";
				String tlf = texttlf.getText();
				boolean Correctodni = Pattern.matches(dniformato, d);
				boolean Correctotlf = Pattern.matches(tlfformato, tlf);
				if(Correctodni) {
					String c = textContrase�a.getText();
					String cc = textConfirmarcon.getText();
					if(Correctotlf) {
						if(c.equals(cc) ) {
							int t = Integer.parseInt(texttlf.getText());
							Paciente p = new Paciente(d,t,c);
							VentanaPrincipal.tmpacientes.put(p.getDni(),p);
							vaciarCampos();
							System.out.println("se ha metido bien");
							ventanaActual.dispose();
							ventanaAnterior.setVisible(true);
							System.out.println(VentanaPrincipal.tmpacientes);
						}else {
							JOptionPane.showMessageDialog( null, "La contrase�a no coincide");
							vaciarContrase�a();
						}
					
				}else {
					JOptionPane.showMessageDialog( null, "Telefono incorrecto");
					vaciarTlf();
					
				}
				}
				
				}

			
				});
				
				setVisible(true);
	}
	private void vaciarCampos() {
		// TODO Auto-generated method stub
		textUsuario.setText("");
		textContrase�a.setText("");
		textConfirmarcon.setText("");
		texttlf.setText("");
		
	}
	private void vaciarContrase�a() {
		// TODO Auto-generated method stub
		
		textContrase�a.setText("");
		textConfirmarcon.setText("");
		
	}
	private void vaciarTlf() {
		// TODO Auto-generated method stub
		texttlf.setText("");
		
		
	}

}
