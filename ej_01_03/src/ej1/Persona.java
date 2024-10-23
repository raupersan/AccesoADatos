package ej1;

import java.io.Serializable;

public class Persona implements Serializable{
	private String nombre;
	private int edad;
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}


}