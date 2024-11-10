package practica_final;

public class Cliente {
	private String numCliente;
	private String nombre;
	private String direccion;
	
	public Cliente(String numCliente, String nombre, String direccion) {
		super();
		this.numCliente = numCliente;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
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
	
}
