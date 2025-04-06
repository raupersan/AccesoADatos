package sin_SQL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CrearTicket {

	public static void crear(Cliente cli, Gasolinera gasolinera, double litros)throws IOException {
		Path tickets = Paths.get("Tickets");
		Integer contador = 1;
		String linea;
		double total = litros * gasolinera.getPrecio95();

		if (!Files.exists(tickets)) {
			Files.createDirectory(tickets);
		}
		linea = "Número de Ticket:" + contador + "\n" + cli.getNumCliente() + "\n" + cli.getNombre() + "\n"
				+ gasolinera.getNombre() + gasolinera.getUbicacion() + "\n\n" + "Gasolina 95 ("
				+ gasolinera.getPrecio95() + ")--------" + litros + "total: " + total + " Euros";
		Path ticket = tickets.resolve("Ticket" + contador.toString() + ".txt");
		Files.writeString(ticket, linea);
	}
}
