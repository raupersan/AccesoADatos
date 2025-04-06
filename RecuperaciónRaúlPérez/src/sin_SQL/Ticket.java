package sin_SQL;

public class Ticket {
	private static int contador = 1;
	private int numero;
	private Cliente cliente;
	private Gasolinera gasolinera;
	private String tipoCombustible;
	private double litros;
	private double precioTotal;

	public Ticket(Cliente cliente, Gasolinera gasolinera, String tipoCombustible, double litros, double precioTotal) {
		this.numero = contador++;
		this.cliente = cliente;
		this.gasolinera = gasolinera;
		this.tipoCombustible = tipoCombustible;
		this.litros = litros;
		this.precioTotal = precioTotal;
	}
}
