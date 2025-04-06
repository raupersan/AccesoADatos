package sin_SQL;

public class Cliente {
	private String numero;
	private String nombre;
	private String direccion;
	private boolean activo = true;

	public Cliente(String numero, String nombre, String direccion, boolean activo) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.activo = activo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
