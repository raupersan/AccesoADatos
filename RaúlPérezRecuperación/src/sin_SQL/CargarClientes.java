package sin_SQL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sin_SQL.Cliente;

public class CargarClientes {

	public static ArrayList<Cliente> carga(String ruta, Path dir)throws ParserConfigurationException, IOException, SAXException, InvalidPathException  {
		ArrayList<String> clientes = new ArrayList<>();
		ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
		String numCliente;
		String nombre;
		String direccion;
		String linea;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(Paths.get(ruta).toFile());
		doc.getDocumentElement().normalize();
		NodeList listaClientes = doc.getElementsByTagName("cliente");
		for (int i = 0; i < listaClientes.getLength(); i++) {
			Node nodo = listaClientes.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element cliente = (Element) nodo;
				numCliente = cliente.getElementsByTagName("numerodecliente").item(0).getTextContent();
				nombre = cliente.getElementsByTagName("Nombre").item(0).getTextContent();
				direccion = cliente.getElementsByTagName("Direccion").item(0).getTextContent();
				arrayCliente.add(new Cliente(numCliente, nombre, direccion));
				escribirCliente(numCliente, nombre, direccion, dir);
			}
		}
		return arrayCliente;
	}
	public static void escribirCliente(String numCliente, String nombre, String direccion, Path dir)
			throws IOException {
		String linea = "numerodecliente:" + numCliente + "\nnombre: " + nombre + "\ndirección:" + direccion;
		Path fichero = dir.resolve(numCliente + ".txt");
		Files.writeString(fichero, linea);
	}

}
