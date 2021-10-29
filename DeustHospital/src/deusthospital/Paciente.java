package deusthospital;

public class Paciente {
	private String dni;
	private int telefono;
	private String contrase�a;
	
	public Paciente(String dni, int telefono, String contrase�a) {
		super();
		this.dni = dni;
		this.telefono = telefono;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", telefono=" + telefono + ", contrase�a=" + contrase�a + "]";
	}
	

}
