package practica_final;

import java.nio.file.*;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;
public class Main {
	private static void crearDirectorio(Path dir) throws IOException {
		if(!Files.exists(dir)) {
			Files.createDirectories(dir);
		}
	}

	private static ArrayList<Cliente> cargarEmpleados(String ruta) throws ParserConfigurationException, IOException ,  SAXException {
        // Lista para almacenar las líneas que escribiremos en el archivo
        ArrayList<String> clientes= new ArrayList<>();
        ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
        String numCliente = null;
        String nombre;
        String direccion;
        String linea;
        // Parsear el archivo XML
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(Paths.get(ruta).toFile());
        // Normalizar el XML
        doc.getDocumentElement().normalize();
        NodeList listaClientes = doc.getElementsByTagName("Clientes");
        // Recorrer cada nodo <empleado>
        for(int i=0; i< listaClientes.getLength(); i++) {
        	Node nodo = listaClientes.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            	Element cliente = (Element) nodo;
                // Extraer los datos de cada <empleado>
            	numCliente= cliente.getElementsByTagName("numerodecliente").item(i).getTextContent();
            	nombre= cliente.getElementsByTagName("nombre").item(i).getTextContent();
            	direccion = cliente.getElementsByTagName("calle").item(i).getTextContent() +", " +cliente.getElementsByTagName("Ciudad").item(i).getTextContent() + ", " +cliente.getElementsByTagName("calle").item(i).getTextContent();
            	Cliente clienteNuevo = new Cliente(numCliente, nombre, direccion);
            	arrayCliente.add(clienteNuevo);
            	linea = "numerodecliente:" + numCliente + "\nombre: " + nombre + "\ndirección: " + direccion;
            	clientes.add(linea);
            }
        }
        //guardamos en un fichero cuyo nombre sea el número del cliente y que esté en formato txt
        Path salida= Paths.get(numCliente + ".txt");
        Files.write(salida, clientes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        return arrayCliente;
	}
	private static void leerFicheroBinario(Path bin) throws IOException {
		byte [] bytes= Files.readAllBytes(bin);
		List lista = Files.readAllLines(bin);
		for (Object f : lista) {
			System.out.println(f);
		}
	}


	public static void main(String[] args) {
			Path dir = Paths.get("Clientes");
			String ruta = "clientes.xml";
			String ficheroBin="gasolinera.bin";	
			Path bin = Paths.get(ficheroBin);
	        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	        try {
		        crearDirectorio(dir);
			listaClientes = cargarEmpleados(ruta);
				leerFicheroBinario(bin);
			} catch (ParserConfigurationException | IOException | SAXException e) {
				e.printStackTrace();
			}

	}



}
