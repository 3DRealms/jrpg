package mensaje;

public class MensajeAutenticacion {
	
	private String username;
	private String password;
	private boolean registro;
	
	public MensajeAutenticacion(String username, String password, boolean registrado) {

		this.username = username;
		this.password = password;
		this.registro = registrado;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isRegistro() {
		return registro;
	}

}
