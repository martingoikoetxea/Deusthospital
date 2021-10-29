package deusthospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaContacto extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaActual,ventanaAnterior;
	private JTextArea txtrEmailTelefonoFax,txtrDeustohealthdeustoprojectes;
	private JButton btnvolverinicio;
	private JPanel panelnorte,panelcentro;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaContacto( JFrame va) {
		setTitle("Ventana contacto");
		ventanaActual = this;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelnorte = new JPanel();
		contentPane.add(panelnorte, BorderLayout.NORTH);
		panelnorte.setLayout(new BorderLayout(0, 0));
		
		btnvolverinicio = new JButton("volver inicio");
		panelnorte.add(btnvolverinicio, BorderLayout.EAST);
		
		panelcentro = new JPanel();
		contentPane.add(panelcentro, BorderLayout.CENTER);
		panelcentro.setLayout(new BorderLayout(0, 0));
		
		txtrEmailTelefonoFax = new JTextArea();
		txtrEmailTelefonoFax.setBackground(Color.LIGHT_GRAY);
		txtrEmailTelefonoFax.setText("EMAIL\r\n\r\n\r\nTELEFONO\r\n\r\n\r\nFAX\r\n\r\n\r\nDIRECCION");
		panelcentro.add(txtrEmailTelefonoFax, BorderLayout.WEST);
		
		txtrDeustohealthdeustoprojectes = new JTextArea();
		txtrDeustohealthdeustoprojectes.setBackground(Color.WHITE);
		txtrDeustohealthdeustoprojectes.setText("deustohealth@deustoproject.es\r\n\r\n\r\n94 675 39 08\r\n\r\n\r\n098445\r\n\r\n\r\nSpain, Vizcaya, 48100, C\\Altamira 21");
		panelcentro.add(txtrDeustohealthdeustoprojectes, BorderLayout.CENTER);
	
		
		btnvolverinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
		}
		});
		setVisible(true);
}
}
