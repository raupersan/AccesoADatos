package sin_SQL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import sin_SQL.Cliente;
import sin_SQL.Gasolinera;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	
	public static void menu(ArrayList<Cliente> listaClientes, ArrayList<Gasolinera> listaGasolineras, Path tickets) {
		String usuario;
		String direccion = null;
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
				Collections.sort(listaGasolineras, Comparator.comparingDouble(g -> g.getPrecio95()));
				listaGasolineras.forEach(System.out::println);
				break;
			}
			case 3: {
				Collections.sort(listaGasolineras, Comparator.comparing(g -> g.getUbicacion()));
				Collections.sort(listaGasolineras, Comparator.comparingDouble(g -> g.getPrecio95()));
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
					Gasolinera gas =  gasolinera;
					menuGasolinera(gas, cli, tickets, listaGasolineras);
				}
			}
		}
		
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
				CrearTicket.crear(cli, gasolinera, litros);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void menuUsuario(ArrayList<Gasolinera> gas, Cliente c, Path tickets, Path dir,
			ArrayList<Cliente> cli) throws IOException {
		int opcion = 0;
		Gasolinera g = new Gasolinera(null, null, opcion, opcion, opcion, opcion);
		do {
			System.out.println("¿Qué quieres hacer?");
			System.out.println("1. Visualizar datos del cliente");
			System.out.println("2. Visualizar lista de gasolineras");
			System.out.println("3. Visualizar gasolineras según ubicación");
			System.out.println("4. Mostrar gasolineras según precios");
			System.out.println("5. Realizar venta (repostaje)");
			System.out.println("6. Informe del dinero invertido por el usuario");
			System.out.println("7. Salir");
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1 -> System.out.println(c); 
			case 2 -> mostrarGasolineras(gas);
			case 3 -> filtrarGasolUbicacion(gas);
			case 4 -> filtrarGasPorPrecio(gas);
			case 5 -> realizarVenta(cli, gas, tickets);
			case 6 -> estadisticas(cli, tickets);
			case 7 -> System.out.println("Saliendo del menú de usuario...");
			default -> System.out.println("Opción no válida.");
			}
		} while (opcion != 7);
	}
	public static void menuAdmin(ArrayList<Cliente> cli, ArrayList<Gasolinera> gas, Path tickets, Path dir,
			String ficheroBin) throws FileNotFoundException, IOException {
		int opcion;
		do {
			System.out.println("Eres el administrador, ¿qué quieres hacer?");
			System.out.println("1. Visualizar todos los clientes");
			System.out.println("2. Añadir cliente");
			System.out.println("3. Eliminar cliente");
			System.out.println("4. Visualizar datos de un cliente");
			System.out.println("5. Visualizar todas las gasolineras");
			System.out.println("6. Visualizar gasolineras según ubicación");
			System.out.println("7. Mostrar gasolineras según precios");
			System.out.println("8. Añadir gasolinera");
			System.out.println("9. Realizar ventas (generar ticket)");
			System.out.println("10. Estadísticas de dinero gastado (global y por cliente)");
			System.out.println("11. Salir");
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1 -> mostrarClientes(cli);
			case 2 -> cli = agregarCliente(cli, tickets, dir);
			case 3 -> eliminarCliente(cli, tickets);
			case 4 -> visualizarCliente(cli);
			case 5 -> mostrarGasolineras(gas);
			case 6 -> filtrarGasolUbicacion(gas);
			case 7 -> filtrarGasPorPrecio(gas);
			case 8 -> agregarGasolinera(gas, ficheroBin);
			case 9 -> realizarVenta(cli, gas, tickets);
			case 10 -> estadisticas(cli, tickets);
			case 11 -> System.out.println("Saliendo del menú administrador...");
			default -> System.out.println("Opción no válida.");
			}
		} while (opcion != 11);
	}
	private static void realizarVenta(ArrayList<Cliente> cli, ArrayList<Gasolinera> gas, Path tickets)
			throws IOException {
		System.out.println("Introduce el número del usuario que quieres que realice la venta");
		String num = sc.nextLine();
		Cliente aux = null;
		for (Cliente c : cli) {
			if (num.equals(c.getNumCliente())) {
				aux = c;
			}
		}
		System.out.println("Introduce el nombre de la gasolinera en la que se realizará la compra");
		String nombre = sc.nextLine();
		for (Gasolinera g : gas) {
			if (num.equals(g.getNombre())) {
				// lo hago solo para la gasolina, sería igual para el diesel pero habría que
				// controlar cuando quieres una y cuando otra
				System.out.println("Introduce los litros de gasolina que quieres comprar");
				double litros = sc.nextDouble();
				double coste = litros * g.getPrecio95();
				CrearTicket.crear(aux, g, litros);
			}
		}

	}

	private static ArrayList<Gasolinera> agregarGasolinera(ArrayList<Gasolinera> gas, String ficheroBin)
			throws FileNotFoundException, IOException {
		System.out.println("Introduce el nombre de la nueva gasolinera");
		String nombre = sc.nextLine();
		System.out.println("Introduce la ubicación de la nueva gasolinera");
		String ubicacion = sc.nextLine();
		System.out.println("Introduce la cantidad de litros de gasolina");
		double litros95 = sc.nextDouble();
		System.out.println("Introduce la cantidad de litros de diésel");
		double litrosDiesel = sc.nextDouble();
		System.out.println("Introduce el precio de la gasolina");
		double precio95 = sc.nextDouble();
		System.out.println("Introduce el precio del diésel");
		double precioDiesel = sc.nextDouble();
		Gasolinera g = new Gasolinera(nombre, ubicacion, litros95, litrosDiesel, precio95, precioDiesel);
		gas.add(g);

		escribirGasolinera(gas, g, ficheroBin);

		return gas;
	}

	private static void escribirGasolinera(ArrayList<Gasolinera> gas, Gasolinera g, String ficheroBin) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroBin));
		oos.writeObject(gas);
	}

	private static void filtrarGasPorPrecio(ArrayList<Gasolinera> gas) {
		Collections.sort(gas, Comparator.comparingDouble(g -> g.getPrecio95()));
		gas.forEach(System.out::println);
	}

	private static void mostrarGasolineras(ArrayList<Gasolinera> gas) {
		gas.forEach(System.out::println);
	}

	private static void visualizarCliente(ArrayList<Cliente> cli) {
		System.out.println("Introduce el nombre del cliente cuyos datos quieres visualizar");
		String n = sc.nextLine();
		for (Cliente c : cli) {
			if (c.getNumCliente().equals(c.getNombre()))
				System.out.println(c);
		}
	}

	private static ArrayList<Cliente> eliminarCliente(ArrayList<Cliente> cli, Path tickets) {
		System.out.println("Introduce el id del usuario que quieras eliminar");
		String id = sc.nextLine();
		for (Cliente c : cli) {
			if (c.getNumCliente().equals(c.getNumCliente()))
				cli.remove(c);
		}
		// No contemplo eliminar su fichero porque no queremos pérdida de datos, aunque
		// supongo que es decisión de implementación
		return cli;
	}

	private static ArrayList<Cliente> agregarCliente(ArrayList<Cliente> cli, Path tickets, Path dir)
			throws IOException {
		System.out.println("Introduce el número del usuario");
		String num = sc.nextLine();
		System.out.println("Introduce su nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce su dirección completa");
		String direccion = sc.nextLine();
		cli.add(new Cliente(sc.nextLine(), sc.nextLine(), sc.nextLine()));
		CargarClientes.escribirCliente(num, nombre, direccion, tickets);
		return cli;
	}

	private static void mostrarClientes(ArrayList<Cliente> cli) {
		cli.forEach(System.out::println);
	}

	private static void filtrarGasolUbicacion(ArrayList<Gasolinera> gas) {
		Collections.sort(gas, Comparator.comparing(g -> g.getUbicacion()));
		gas.forEach(System.out::println);
	}

	private static void estadisticas(ArrayList<Cliente> cli, Path tickets) {

	}
}
