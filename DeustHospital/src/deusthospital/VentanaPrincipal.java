package deusthospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private ImageIcon imagenVitales;
	private JPanel contentPane;
	private JButton btninformacion;
	private JButton btncontacto;
	private JButton btniniciosesion;
	private JLabel labeltexto;
	private JLabel labelimagen;
	private JFrame ventanaActual;
	private static Connection con; 
	public static TreeMap<String, Paciente> tmpacientes;
	

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
		
		crearTablaPaciente(con);
		closeBD(con);
		
		
		imagenVitales = new ImageIcon(VentanaRegistro.class.getResource(""));
		ventanaActual = this;
		setTitle ("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		tmpacientes = new TreeMap<>();
		
		JPanel panelnorte = new JPanel();
		contentPane.add(panelnorte, BorderLayout.NORTH);
		
		labeltexto = new JLabel(" DEUSTOHEALTH");
		panelnorte.add(labeltexto);
		btninformacion = new JButton("informacion");
		
		
		panelnorte.add(btninformacion);
		
		btncontacto = new JButton("contacto");
		panelnorte.add(btncontacto);
		
		btniniciosesion = new JButton("inicio sesion");
		panelnorte.add(btniniciosesion);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		labelimagen = new JLabel("");
		labelimagen.setMaximumSize(panel.getMaximumSize());
		
		labelimagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/deusthospital/vitales.jpg")));
		panel.add(labelimagen);
	
		btninformacion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			new VentanaInformacion(ventanaActual);
			ventanaActual.setVisible(false);
			
			
		}
		});
		
		btncontacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new VentanaContacto(ventanaActual);
				ventanaActual.setVisible(false);
				
				
			}
			});
		btniniciosesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new VentanaIniciosesion(ventanaActual);
				ventanaActual.setVisible(false);
				
				
			}
			});
		setVisible(true);

}
	public static void closeBD(Connection con) {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void insertarPaciente (Connection con , String dni ,String telefono, String contraseña) {
			String sentSQL = "INSERT INTO paciente VALUES ('"+dni+"','"+telefono+"' ,"+contraseña+")";
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	public static void  crearTablaPaciente(Connection con) {
		
		String sentencia = "CREATE TABLE Paciente(dni String,contraseña String, telefono interger)";
		Statement st = null;
		
		try {
			st = con.createStatement();
			st.executeUpdate(sentencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(st !=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static int ObtenerPaciente(Connection con,String dni, String contraseña) {
		String sentencia = "SELECT con FROM paciente WHERE '"+dni+"'";
		Statement st = null;
		int result = 0;
		try {
			st.executeUpdate(sentencia);
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) {
				if(rs.getString("contraseña").equals(contraseña)) {
					result=2;
					
				}else {
					result = 1;
				}
				
			}else {
				result = 0;
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
		
	}

		
	}
	


