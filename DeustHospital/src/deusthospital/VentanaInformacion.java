package deusthospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInformacion extends JFrame {
	
	private JFrame ventanaActual,ventanaAnterior;
	private JPanel contentPane;
	private JButton btnvolverinicio;
	private JLabel texto;
	private JPanel panelcentro,panelnorte;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaInformacion(JFrame va) {
		setTitle("Ventana informacion");
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
		
		texto = new JLabel("INFORMACION DEUSTHOSPITAL");
		panelnorte.add(texto);
		
		btnvolverinicio = new JButton("volver inicio");
		btnvolverinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelnorte.add(btnvolverinicio);
		
		panelcentro = new JPanel();
		contentPane.add(panelcentro, BorderLayout.CENTER);
		
		JTextArea txtarea = new JTextArea();
		txtarea.setText("Aqui va el texto");
		panelcentro.add(txtarea);
		
		// EVENTOS
		
		btnvolverinicio.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ventanaActual.dispose();
			ventanaAnterior.setVisible(true);
		}
		});
		setVisible(true);
}
}
