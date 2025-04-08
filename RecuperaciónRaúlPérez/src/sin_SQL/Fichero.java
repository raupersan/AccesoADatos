package sin_SQL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.*;
import java.nio.file.*;

public class Fichero {

	public Fichero() {

	}

	public void leerFicheros() {
		String ruta = "clientes.xml";
		String ficheroBin = "gasoliera.bin";
		leerXML(ruta);
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

	private void guardarClienteEnFichero(Cliente cliente) {
		try {
			Path ruta = Path.of("clientes", cliente.getNumero() + ".txt");
			Files.writeString(ruta, cliente.toString());
		} catch (IOException e) {
			System.out.println("Error guardando cliente: " + e.getMessage());
		}
	}
}
