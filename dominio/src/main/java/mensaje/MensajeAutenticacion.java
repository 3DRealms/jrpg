package mensaje;

public class MensajeAutenticacion {
	
	private String username;
	private String password;
	private boolean registro;
	private String casta;
	private String raza;
	
	public MensajeAutenticacion(String username, String password, boolean registro, String casta, String raza) {

		this.username = username;
		this.password = password;
		this.registro = registro;
		this.casta = casta;
		this.raza = raza;
	}
	
	
	
	public MensajeAutenticacion(String username, String password, boolean registrado) {

		this.username = username;
		this.password = password;
		this.registro = registrado;
		this.casta = "";
		this.raza = "";
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
