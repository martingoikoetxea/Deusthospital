package deusthospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ventanaCitas extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaActual,ventanaAnterior;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ventanaCitas(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("HAS ENTRADO");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		setVisible(true);
	}
	
}
