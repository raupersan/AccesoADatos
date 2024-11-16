package practica_final;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Base64;
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
			throws ParserConfigurationException, IOException, SAXException {
		// Lista para almacenar las líneas que escribiremos en el archivo
		ArrayList<String> clientes = new ArrayList<>();
		ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
		String numCliente = null;
		String nombre = null;
		String direccion = null;
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
				NodeList clientesCompleto = cliente.getChildNodes();
				for (int j = 0; j < clientesCompleto.getLength(); j++) {
					Node datosCliente = clientesCompleto.item(j);
					numCliente = numCliente + clientesCompleto.item(j).getNodeType()
							+ clientesCompleto.item(j).getTextContent();
					nombre = nombre + clientesCompleto.item(j).getNodeType()
							+ clientesCompleto.item(j).getTextContent();
					direccion = direccion + clientesCompleto.item(j).getNodeType()
							+ clientesCompleto.item(j).getTextContent();
					linea = "numerodecliente:" + numCliente + "\nnombre: " + nombre + "dirección: " + direccion;
					arrayCliente.add(new Cliente(numCliente, nombre, direccion));
					Path fichero = dir.resolve(numCliente + ".txt");
					Files.writeString(fichero, linea);

				}
			}
		}
		return arrayCliente;
	}

	private static ArrayList<Gasolinera> leerGasolinera(String ruta) throws IOException, ClassNotFoundException {
		ArrayList<Gasolinera> gasolineras = new ArrayList<Gasolinera>();
		Path path = Paths.get(ruta);
		List<String> lineas = Files.readAllLines(path);
		for (String linea : lineas) {
			byte[] bytes = Base64.getDecoder().decode(linea);
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
			Gasolinera gasolinera = (Gasolinera) ois.readObject();
			gasolineras.add(gasolinera);
		}
		return gasolineras;
	}

	private static void menu(ArrayList<Cliente> listaClientes, ArrayList<Gasolinera> listaGasolineras) {
		String usuario;
		System.out.println("Introduce tu número de usuario");
		usuario= sc.nextLine();
		System.out.println("Se te sugiere la gasolinera " + listaGasolineras.get(0) + " pero a continuación podrás filtrar por la"
				+ "que necesites");
		
	}

	private static void menuGasolinera(Gasolinera gasolinera, Path tickets, ArrayList<Cliente> listaClientes, ArrayList<Gasolinera> listaGasolineras) {
		int opcion;
		int litros;
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Repostar Gasolina");
		System.out.println("2. Repostar Diesel");
		opcion = sc.nextInt();
		System.out.println("¿Cuántos litros quieres repostar?");
		litros = sc.nextInt();
		if(opcion == 1 && litros < gasolinera.getLitros95()) {
			
		}
		
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
			menu(listaClientes,listaGasolineras);
			menuGasolinera(listaGasolineras.get(0), tickets, listaClientes,listaGasolineras);
		} catch (ParserConfigurationException | IOException | SAXException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
