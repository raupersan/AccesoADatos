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
			System.out.print("Selecciona una opción: \n");
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
		// TODO: Implementar menú del administrador
		System.out.println("[ADMIN] Menú del Administrador (en desarrollo)");
	}

	private static void menuUsuario() {
		// TODO: Implementar menú del usuario
		System.out.println("[USUARIO] Menú del Usuario (en desarrollo)");
	}

}
