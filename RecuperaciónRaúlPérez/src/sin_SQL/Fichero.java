package sin_SQL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
	        String linea = Files.readString(ruta).trim();
	        String[] partes = linea.split(", ");
	        String numeroCliente = partes[0].split(":")[1];
	        String nombre = partes[1].split("=")[1];
	        String direccion = partes[2].split("=")[1];
	        for (int i = 3; i < partes.length - 1; i++) {
	            direccion += ", " + partes[i];
	        }
	        boolean activo = Boolean.parseBoolean(partes[partes.length - 1].split("=")[1]);

	        return new Cliente(numeroCliente, nombre, direccion, activo);

	    } catch (IOException e) {
	        System.out.println("Error leyendo el archivo del cliente: " + e.getMessage());
	        return null;
	    } catch (Exception e) {
	        System.out.println("Error al interpretar los datos del cliente: " + e.getMessage());
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
	public void guardarGasolineras(Gasolinera[] gasolineras) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of("gasolinera.bin")))) {
	        oos.writeObject(gasolineras);
	    } catch (IOException e) {
	        System.out.println("Error al guardar gasolineras: " + e.getMessage());
	    }
	}
	public void generarTicket(Cliente cliente, String nombreGasolinera, int tipo, double litros, double precioLitro) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatterNombre = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String nombreArchivo = "TICKETS/ticket_" + cliente.getNumero() + "_" + ahora.format(formatterNombre) + ".txt";
        double total = litros * precioLitro;

        String contenido = """
                ----- TICKET DE COMPRA -----
                Fecha: %s
                Cliente: %s (%s)
                Gasolinera: %s
                Tipo de Gasolina: %s
                Litros: %.2f
                Precio por litro: %.2f €
                ----------------------------
                TOTAL: %.2f €
                ----------------------------
                """.formatted(
                ahora.format(formatterFecha),
                cliente.getNombre(), cliente.getNumero(),
                nombreGasolinera,
                tipo,
                litros,
                precioLitro,
                total
        );

        try {
            Files.writeString(Path.of(nombreArchivo), contenido);
            System.out.println("Ticket generado correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el ticket: " + e.getMessage());
        }
    }
	public void generarInformeCliente(Cliente cliente) {
	    File carpeta = new File("TICKETS");
	    File[] tickets = carpeta.listFiles((dir, name) -> name.startsWith(cliente.getNumero() + "_ticket_"));

	    if (tickets == null || tickets.length == 0) {
	        System.out.println("No se encontraron tickets para el cliente " + cliente.getNumero());
	        return;
	    }

	    double totalLitros = 0;
	    double totalGastado = 0;

	    System.out.println("📋 Informe del Cliente: " + cliente.getNombre() + " (Nº " + cliente.getNumero() + ")");
	    System.out.println("--------------------------------------------------");

	    for (File ticket : tickets) {
	        try {
	            List<String> lineas = Files.readAllLines(ticket.toPath());

	            for (String linea : lineas) {
	                System.out.println(linea);

	                if (linea.startsWith("Litros:")) {
	                    String[] partes = linea.split(":");
	                    totalLitros += Double.parseDouble(partes[1].trim());
	                }

	                if (linea.startsWith("Total a pagar:")) {
	                    String[] partes = linea.split(":");
	                    totalGastado += Double.parseDouble(partes[1].trim().replace("€", "").trim());
	                }
	            }

	            System.out.println("--------------------------------------------------");

	        } catch (IOException e) {
	            System.out.println("Error leyendo ticket: " + ticket.getName());
	        }
	    }

	    System.out.printf("Total litros consumidos: %.2f L%n", totalLitros);
	    System.out.printf("Gasto total: %.2f €%n", totalGastado);
	}

}
