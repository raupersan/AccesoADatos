package modeloExamen_01;

import java.io.Serializable;
public class Persona implements Serializable{
	private String nombre, contraseña, rol;
	public Persona(String nombre, String contraseña, String rol) {
		this.nombre=nombre;
		this.contraseña=contraseña;
		this.rol=rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "\nnombre=" + nombre + ", contraseña=" + contraseña + ", rol=" + rol ;
	}
	
}
