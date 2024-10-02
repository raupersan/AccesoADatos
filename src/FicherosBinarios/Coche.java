package FicherosBinarios;

import java.io.Serializable;

public class Coche implements Serializable{
	private int numPuertas;
	private String marca;
	private String modelo;
	private int numeroCaballos;
	private int cilindrada;
	private double precio;
	
	
	public Coche() {
		
	}
	
	public Coche(int numPuertas, String marca, String modelo, int numeroCaballos, int cilindrada, double precio) {
		super();
		this.numPuertas = numPuertas;
		this.marca = marca;
		this.modelo = modelo;
		this.numeroCaballos = numeroCaballos;
		this.cilindrada = cilindrada;
		this.precio = precio;
	}

	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumeroCaballos() {
		return numeroCaballos;
	}
	public void setNumeroCaballos(int numeroCaballos) {
		this.numeroCaballos = numeroCaballos;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Coche [numPuertas=" + numPuertas + ", marca=" + marca + ", modelo=" + modelo + ", numeroCaballos="
				+ numeroCaballos + ", cilindrada=" + cilindrada + ", precio=" + precio + "]";
	}
	
}
