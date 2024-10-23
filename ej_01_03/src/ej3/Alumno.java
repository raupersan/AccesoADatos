package ej3;

public class Alumno {
	private String nombre, apellido;
	private int nota;
	public Alumno(String nombre, String apellido, int nota) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
