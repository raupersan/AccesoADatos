package sin_SQL;

import java.nio.file.Files;
import java.nio.file.Path;
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
			System.out.println("5 Visualizar los datos de las gasolineras");
			System.out.println("6. Visualizar los datos de las gasolineras según su ubicación");
			System.out.println("7. Mostrar las gasolineras según los precios de las gasolinas");
			System.out.println("8. Añadir gasolineras");
			System.out.println("9. Realizar ventas generando tickets");
			System.out.println("10. Mostrar estadísiticas de todos los clientes");
			
		} while (opcion != 10);
	}

	private static void menuUsuario() {
		// TODO: Implementar menú del usuario
		System.out.println("[USUARIO] Menú del Usuario (en desarrollo)");
	}

}
