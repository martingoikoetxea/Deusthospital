package deusthospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btninformacion;
	private JButton btncontacto;
	private JButton btniniciosesion;
	private JLabel labeltexto;
	private JLabel labelimagen;
	private JFrame ventanaActual;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		ventanaActual = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelnorte = new JPanel();
		contentPane.add(panelnorte, BorderLayout.NORTH);
		
		labeltexto = new JLabel(" DEUSTOHEALTH");
		panelnorte.add(labeltexto);
		btninformacion = new JButton("informacion");
		btninformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				new VentanaInformacion(ventanaActual);
				
			}
		});
		panelnorte.add(btninformacion);
		
		btncontacto = new JButton("contacto");
		panelnorte.add(btncontacto);
		
		btniniciosesion = new JButton("inicio sesion");
		panelnorte.add(btniniciosesion);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		labelimagen = new JLabel("imagen");
		panel.add(labelimagen);
	}

}
