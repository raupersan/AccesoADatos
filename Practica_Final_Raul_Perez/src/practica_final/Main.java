package practica_final;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	private static void crearDirectorio(Path dir) throws IOException {
		if (!Files.exists(dir)) {
			Files.createDirectories(dir);
		}
	}
	private static ArrayList<Cliente> cargarEmpleados(String ruta, Path dir)
			throws ParserConfigurationException, IOException, SAXException, InvalidPathException {
		// Lista para almacenar las líneas que escribiremos en el archivo
		ArrayList<String> clientes = new ArrayList<>();
		ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
		String numCliente;
		String nombre;
		String direccion;
		String linea;
		// Parsear el archivo XML
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(Paths.get(ruta).toFile());
		// Normalizar el XML
		doc.getDocumentElement().normalize();
		NodeList listaClientes = doc.getElementsByTagName("cliente");
		// Recorrer cada nodo cliente
		for (int i = 0; i < listaClientes.getLength(); i++) {
			Node nodo = listaClientes.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element cliente = (Element) nodo;
				numCliente = cliente.getElementsByTagName("numerodecliente").item(0).getTextContent();
				nombre = cliente.getElementsByTagName("Nombre").item(0).getTextContent();
				direccion = cliente.getElementsByTagName("Direccion").item(0).getTextContent();
				linea = "numerodecliente:" + numCliente + "\nnombre: " + nombre + "dirección: " + direccion;
				arrayCliente.add(new Cliente(numCliente, nombre, direccion));

				Path fichero = dir.resolve("a" + ".txt");
				Files.writeString(fichero, linea);
			}
		}
		return arrayCliente;
	}
	private static ArrayList<Gasolinera> leerGasolinera(String ruta) throws IOException, ClassNotFoundException, StreamCorruptedException {
		ArrayList<Gasolinera> gasolineras = null;		
		Path path = Paths.get("gasolinera.bin");

			byte[] bytes = Files.readAllBytes(path);
			
				try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
				 gasolineras = (ArrayList<Gasolinera>) objectInputStream.readObject();
				System.out.println("Contenido del archivo: " + gasolineras);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
		return gasolineras;
	}
	private static void menu(ArrayList<Cliente> listaClientes, ArrayList<Gasolinera> listaGasolineras, Path tickets) {
		String usuario;
		String direccion = null;
		Gasolinera gas = null;
		Cliente cli = null;
		System.out.println("Introduce tu número de usuario");
		usuario = sc.nextLine();
		for (Cliente aux : listaClientes) {
			if (aux.getNumCliente() == usuario) {
				direccion = aux.getDireccion();
				cli = aux;
			}
		}
		for (Gasolinera aux : listaGasolineras) {
			if (aux.getUbicacion() == direccion) {
				System.out.println("Se te sugiere la gasolinera " + aux.getNombre()
						+ " pero a continuación podrás filtrar por la" + "que necesites");
			}
		}
		System.out.println("Qué quieres hacer?");
		System.out.println("1.Elegir gasolinera sugerida");
		System.out.println("2. Cambiar de gasolinera");
		int opcion = sc.nextInt();
		if (opcion == 2) {
			System.out.println("Elige el criterio por el cuál quieres filtrar las gasolineras");
			System.out.println("1. Por ubicación");
			System.out.println("2. Por precio");
			System.out.println("3. Por ubicación primero, luego por precio");
			System.out.println("4. Mostrar todas sin filtrar");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1: {
				Collections.sort(listaGasolineras, Comparator.comparing(g -> g.getUbicacion()));
				listaGasolineras.forEach(System.out::println);
				break;
			}
			case 2: {
				Collections.sort(listaGasolineras, Comparator.comparingDouble(g -> g.getLitros95()));
				listaGasolineras.forEach(System.out::println);
				break;
			}
			case 3: {
				Collections.sort(listaGasolineras, Comparator.comparing(g -> g.getUbicacion()));
				Collections.sort(listaGasolineras, Comparator.comparingDouble(g -> g.getLitros95()));
				listaGasolineras.forEach(System.out::println);
				break;
			}
			case 4: {
				listaGasolineras.forEach(System.out::println);
			}
			default:
				System.out.println("Esa no es una opción válida");
			}
			System.out.println("Introduce el nombre de la gasolinera deseada");
			String nombre = sc.nextLine();
			for (Gasolinera gasolinera : listaGasolineras) {
				if (gasolinera.getNombre() == nombre) {
					gas = gasolinera;
				}
			}
		}
		menuGasolinera(gas, cli, tickets, listaGasolineras);
	}
	private static void menuGasolinera(Gasolinera gasolinera, Cliente cli, Path tickets,
			ArrayList<Gasolinera> listaGasolineras) {
		int opcion;
		int litros;
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Repostar Gasolina");
		System.out.println("2. Repostar Diesel");
		opcion = sc.nextInt();
		System.out.println("¿Cuántos litros quieres repostar?");
		litros = sc.nextInt();
		if (opcion == 1 && litros < gasolinera.getLitros95()) {
			System.out.println("No queda suficiente gasolina en esta gasolinera");
		} else if (opcion == 2 && litros < gasolinera.getLitrosDiesel()) {
			System.out.println("No queda suficiente diésel en esta gasolinera");
		} else {
			if (opcion == 1) {
				System.out.println("Operación aceptada. Coste: " + litros * gasolinera.getPrecio95() + "€");
				gasolinera.setLitros95(gasolinera.getLitros95() - litros);
			} else {
				System.out.println("Operación aceptada. Coste: " + litros * gasolinera.getPrecioDiesel() + "€");
				gasolinera.setLitrosDiesel(gasolinera.getLitrosDiesel() - litros);
			}
			try {
				crearTicket(cli, gasolinera, litros);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void crearTicket(Cliente cli, Gasolinera gasolinera, int litros) throws IOException {
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
	private static void login() {
		String num;
		String contra;
		System.out.println("Introduce tu número de cliente");
		num = sc.nextLine();
		System.out.println("Introduce tu contraseña");
		contra = sc.nextLine();
	}
	public static void main(String[] args) {
		Path dir = Paths.get("Clientes");
		Path tickets = Paths.get("Tickets");
		String ruta = "clientes.xml";
		String ficheroBin = "gasolinera.bin";
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Gasolinera> listaGasolineras = new ArrayList<Gasolinera>();
		try {
			crearDirectorio(dir);
			crearDirectorio(tickets);
			listaClientes = cargarEmpleados(ruta, dir);
			listaGasolineras = leerGasolinera(ficheroBin);
			menu(listaClientes, listaGasolineras, tickets);
			login();
		} catch (ParserConfigurationException | IOException | SAXException | ClassNotFoundException
				| InvalidPathException e) {
			e.printStackTrace();
		}
	}
}
