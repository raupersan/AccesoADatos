package sin_SQL;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import sin_SQL.Cliente;
import sin_SQL.Gasolinera;

public class Main {
	public static void main(String[] args) {
		Path dir = Paths.get("Clientes");
		Path tickets = Paths.get("Tickets");
		String ruta = "clientes.xml";
		String ficheroBin = "gasolinera.bin";
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Gasolinera> listaGasolineras = new ArrayList<Gasolinera>();
		try {
			Directorio.crearDirectorio(dir);
			Directorio.crearDirectorio(tickets);
			listaClientes = CargarClientes.carga(ruta, dir);
			listaGasolineras = CargarGasolinera.leerGasolinera(ficheroBin);
			Menu.menu(listaClientes, listaGasolineras, tickets);
			Login.login(listaClientes, listaGasolineras, tickets, dir, ficheroBin);
		} catch (ParserConfigurationException | IOException | SAXException | InvalidPathException e) {
			e.printStackTrace();
		}
	}
}
