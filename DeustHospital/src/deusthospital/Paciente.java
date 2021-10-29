package deusthospital;

public class Paciente {
	private String dni;
	private int telefono;
	private String contraseña;
	
	public Paciente(String dni, int telefono, String contraseña) {
		super();
		this.dni = dni;
		this.telefono = telefono;
		this.contraseña = contraseña;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", telefono=" + telefono + ", contraseña=" + contraseña + "]";
	}
	

}
