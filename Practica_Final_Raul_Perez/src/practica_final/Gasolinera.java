package practica_final;

import java.io.Serializable;

public class Gasolinera implements Serializable {
	private String nombre;
	private String ubicacion;
	private double litros95;
	private double litrosDiesel;
	private double precio95;
	private double precioDiesel;
	
	public Gasolinera(String nombre, String ubicacion, double litros95, double litrosDiesel, double precio95,
			double precioDiesel) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.litros95 = litros95;
		this.litrosDiesel = litrosDiesel;
		this.precio95 = precio95;
		this.precioDiesel = precioDiesel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getLitros95() {
		return litros95;
	}

	public void setLitros95(double litros95) {
		this.litros95 = litros95;
	}

	public double getLitrosDiesel() {
		return litrosDiesel;
	}

	public void setLitrosDiesel(double litrosDiesel) {
		this.litrosDiesel = litrosDiesel;
	}

	public double getPrecio95() {
		return precio95;
	}

	public void setPrecio95(double precio95) {
		this.precio95 = precio95;
	}

	public double getPrecioDiesel() {
		return precioDiesel;
	}

	public void setPrecioDiesel(double precioDiesel) {
		this.precioDiesel = precioDiesel;
	}
	@Override
	public String toString() {
		return "Tienes: " + getLitrosDiesel()+ "l de diesel y el resto te lo imaginas";
	}
	 
}
