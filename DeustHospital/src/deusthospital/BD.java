package deusthospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BD {
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con =  DriverManager.getConnection("jdbc:sqlite: "+nombreBD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
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
	
	public static void insertarPaciente (Connection con , String dni ,int telefono, String contrase�a) {
		String sentSQL = "INSERT INTO paciente VALUES ('"+dni+"','"+telefono+"' ,"+contrase�a+")";
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
		
		String sentencia = "CREATE TABLE Paciente(dni String,contrase�a String, telefono interger)";
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
	
	public static int ObtenerPaciente(Connection con,String dni, String contrase�a) {
		String sentencia = "SELECT con FROM paciente WHERE '"+dni+"'";
		Statement st = null;
		int result = 0;
		try {
			st.executeUpdate(sentencia);
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) {
				if(rs.getString("contrase�a").equals(contrase�a)) {
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
