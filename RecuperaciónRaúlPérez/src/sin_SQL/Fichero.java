package sin_SQL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Fichero {
	private final String ubicacionGasolineras = "gasolineras.bin";
	private final String ubicacionClientes = "clientes.xml";

	public Fichero() {

	}

	public void leerFicheros() {
		leerXML(ubicacionClientes);
		Gasolinera[] gasolineras = cargarGasolineras();

	}

	public Gasolinera[] cargarGasolineras() {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of(ubicacionGasolineras)))) {
			return (Gasolinera[]) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer gasolineras: " + e.getMessage());
			return new Gasolinera[0];
		}
	}

	public void agregarGasolinera(Gasolinera nueva) {
		try {
			Gasolinera[] existentes = cargarGasolineras();

			Gasolinera[] actualizadas = Arrays.copyOf(existentes, existentes.length + 1);
			actualizadas[existentes.length] = nueva;

			try (ObjectOutputStream oos = new ObjectOutputStream(
					Files.newOutputStream(Path.of(ubicacionGasolineras)))) {
				oos.writeObject(actualizadas);
				System.out.println("Gasolinera añadida correctamente.");
			}

		} catch (Exception e) {
			System.out.println("Error al agregar gasolinera: " + e.getMessage());
		}
	}

	public void leerXML(String ruta) {
		File xml = new File(ruta);
		if (!xml.exists()) {
			System.out.println("El fichero xml no existe");
			return;
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(xml);
			document.getDocumentElement().normalize();
			NodeList listaClientes = document.getElementsByTagName("cliente");
			for (int i = 0; i < listaClientes.getLength(); i++) {
				Node nodo = listaClientes.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					String numero = elemento.getElementsByTagName("numerodecliente").item(0).getTextContent();
					String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
					Element direccionEl = (Element) elemento.getElementsByTagName("Direccion").item(0);
					String calle = direccionEl.getElementsByTagName("Calle").item(0).getTextContent();
					String ciudad = direccionEl.getElementsByTagName("Ciudad").item(0).getTextContent();
					String codigoPostal = direccionEl.getElementsByTagName("Codigo_Postal").item(0).getTextContent();
					String pais = direccionEl.getElementsByTagName("Pais").item(0).getTextContent();
					String direccionCompleta = calle + ", " + ciudad + ", " + codigoPostal + ", " + pais;
					Cliente cliente = new Cliente(numero, nombre, direccionCompleta);
					guardarClienteEnFichero(cliente);
				}
			}

			System.out.println("Clientes cargados y guardados correctamente.");

		} catch (Exception e) {
			System.out.println("Error al leer XML: " + e.getMessage());
		}

	}
	public Cliente cargarClienteDesdeFichero(String numero) {
	    Path ruta = Path.of("clientes", numero + ".txt");

	    if (!Files.exists(ruta)) {
	        System.out.println("El cliente con número " + numero + " no existe.");
	        return null;
	    }

	    try {
	        String contenido = Files.readString(ruta);
	        String[] lineas = contenido.split("\n");

	        String nombre = lineas[1].split(": ")[1];
	        String direccion = lineas[2].split(": ")[1];

	        return new Cliente(numero, nombre, direccion);

	    } catch (IOException e) {
	        System.out.println("Error leyendo el archivo del cliente: " + e.getMessage());
	        return null;
	    }
	}

	public static void guardarClienteEnFichero(Cliente cliente) {
		try {
			Path ruta = Path.of("clientes", cliente.getNumero() + ".txt");
			Files.writeString(ruta, cliente.toString());
		} catch (IOException e) {
			System.out.println("Error guardando cliente: " + e.getMessage());
		}
	}
}
