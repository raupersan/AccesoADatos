package sin_SQL;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Fichero fichero = new Fichero();
		crearCarpetasBase();
		fichero.leerFicheros();
		mostrarMenuPrincipal();
	}

	private static void crearCarpetasBase() {
		try {
			Files.createDirectories(Path.of("clientes"));
			Files.createDirectories(Path.of("clientesAntiguos"));
			Files.createDirectories(Path.of("TICKETS"));
		} catch (Exception e) {
			System.out.println("Error creando carpetas: " + e.getMessage());
		}
	}

	private static void mostrarMenuPrincipal() {
		int opcion;
		do {
			System.out.println("Selecciona una opción: ");
			System.out.println("1. Menú Administrador");
			System.out.println("2. Menú Usuario");
			System.out.println("3. Salir");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1 -> menuAdministrador();
			case 2 -> menuUsuario();
			case 3 -> System.out.println("Saliendo de la aplicación...");
			default -> System.out.println("Opción inválida");
			}
		} while (opcion != 3);
	}

	private static void menuAdministrador() {
		int opcion;
		do {
			System.out.println("¿Qué quieres hacer?");
			System.out.println("1. Ver todos los datos de los clientes");
			System.out.println("2. Añadir clientes");
			System.out.println("3. Eliminar clientes");
			System.out.println("4. Visualizar los datos de un cliente");
			System.out.println("5. Visualizar los datos de las gasolineras");
			System.out.println("6. Visualizar los datos de las gasolineras según su ubicación");
			System.out.println("7. Mostrar las gasolineras según los precios de las gasolinas");
			System.out.println("8. Añadir gasolineras");
			System.out.println("9. Realizar ventas generando tickets");
			System.out.println("10. Mostrar estadísiticas de todos los clientes");
			System.out.println("11. Salir");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1 -> mostrarClientes();
			case 2 -> agregarCliente();
			case 3 -> eliminarCliente();
			case 4 -> mostrarUnCliente();
			case 5 -> mostrarGasolineras();
			case 6 -> mostrarPorUbicacion();
			case 7 -> mostrarPorPrecio();
			// case 8 -> agregarGasolinera();
			// case 9 -> realizarVenta();
			// case 10 -> mostrarEstadisticas();
			case 11 -> System.out.println("Saliendo del menú de administrador...");
			default -> System.out.println("Opción inválida");
			}

		} while (opcion != 11);
	}

	private static void mostrarPorPrecio() {
		Fichero fichero = new Fichero();
		Gasolinera[] gasolineras = fichero.cargarGasolineras();
		Arrays.sort(gasolineras, Comparator.comparing(Gasolinera::getPrecio95));
		listarGasolineras(gasolineras);
	}

	private static void mostrarPorUbicacion() {
		Fichero fichero = new Fichero();
		Gasolinera[] gasolineras = fichero.cargarGasolineras();
		Arrays.sort(gasolineras, Comparator.comparing(Gasolinera::getUbicacion));
		listarGasolineras(gasolineras);
	}

	private static void mostrarGasolineras() {
		Fichero fichero = new Fichero();
		Gasolinera[] gasolineras = fichero.cargarGasolineras();
		if (gasolineras.length == 0) {
			System.out.println("No hay gasolineras registradas.");
			return;
		}
		listarGasolineras(gasolineras);
	}

	private static void listarGasolineras(Gasolinera[] gasolineras) {
		System.out.println("Lista de Gasolineras: ");
		for (Gasolinera g : gasolineras) {
			System.out.print("Nombre: " + g.getNombre());
			System.out.print("Ubicación: " + g.getUbicacion());
			System.out.print("Gasolina 95: " + g.getLitros95() + "L | Precio: " + g.getPrecio95() + " €/L");
			System.out.println("Diesel: " + g.getLitrosDiesel() + "L | Precio: " + g.getPrecioDiesel() + " €/L");
		}
	}

	private static void mostrarUnCliente() {
		System.out.print("Introduce el número del cliente que quieres visualizar: ");
		sc.nextLine();
		String numero = sc.nextLine();
		File archivo = new File("clientes/" + numero + ".txt");
		if (!archivo.exists()) {
			System.out.println("El cliente no existe.");
			return;
		}

		try {
			String contenido = Files.readString(archivo.toPath());
			System.out.println(contenido);
		} catch (IOException e) {
			System.out.println("Error leyendo el archivo del cliente: " + e.getMessage());
		}
	}

	private static void eliminarCliente() {
		System.out.print("Introduce el número del cliente que quieres eliminar: ");
		String numero = sc.nextLine();
		Path origen = Path.of("clientes", numero + ".txt");
		Path destino = Path.of("clientesAntiguos", numero + ".txt");
		if (!Files.exists(origen)) {
			System.out.println("El cliente no existe.");
			return;
		}
		try {
			Files.move(origen, destino);
			System.out.println("El cliente " + numero + " ha sido eliminado correctamente");
		} catch (IOException e) {
			System.out.println("Error al eliminar al cliente: " + e.getMessage());
		}
	}

	private static void agregarCliente() {
		System.out.print("Introduce el número del cliente: ");
		String numero = sc.nextLine();
		System.out.println("Introduce el nombre del cliente: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce la dirección del cliente: ");
		String direccion = sc.nextLine();
		Cliente cliente = new Cliente(numero, nombre, direccion, true);
		Fichero.guardarClienteEnFichero(cliente);
	}

	private static void mostrarClientes() {
		File clientes = new File("clientes");
		File[] archivos = clientes.listFiles((dir, name) -> name.endsWith(".txt"));
		if (archivos == null || archivos.length == 0) {
			System.out.println("No hay clientes registrados.");
			return;
		}

		System.out.println("Lista de Clientes: ");
		for (File archivo : archivos) {
			try {
				String contenido = Files.readString(archivo.toPath());
				System.out.println("\n" + contenido);
			} catch (IOException e) {
				System.out.println("Error leyendo archivo " + archivo.getName() + ": " + e.getMessage());
			}
		}
	}

	private static void menuUsuario() {
		// TODO: Implementar menú del usuario
		System.out.println("[USUARIO] Menú del Usuario (en desarrollo)");
	}

}
