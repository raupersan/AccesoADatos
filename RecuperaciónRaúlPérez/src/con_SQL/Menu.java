package con_SQL;

import java.util.Scanner;

public class Menu {
	private static final Scanner sc = new Scanner(System.in);

	public void admin() {
		System.out.println("\n-- MENÚ ADMINISTRADOR --");
		System.out.println("a. Insertar/modificar/eliminar clientes");
		System.out.println("b. Insertar/modificar/eliminar empleados");
		System.out.println("c. Insertar/modificar/eliminar productos");
		System.out.print("Selecciona una opción: ");
		char opcion = sc.next().charAt(0);
		sc.nextLine();

		switch (opcion) {
		case 'a' -> menuGestionClientes();
		case 'b' -> menuGestionEmpleados();
		case 'c' -> menuGestionProductos();
		default -> System.out.println("Opcion no válida");
		}
	}

	public void empleado() {
		System.out.println("\n-- MENú EMPLEADO --");
		System.out.println("a. Visualizar productos");
		System.out.println("b. Realizar ventas para un cliente");
		System.out.println("c. Ver tickets generados por ese empleado");
		System.out.print("Selecciona una opción: ");
		char opcion = sc.next().charAt(0);
		sc.nextLine();

		switch (opcion) {
		case 'a' -> menuVisualizarProductos();
		case 'b' -> realizarVenta();
		case 'c' -> verTicketsEmpleado();
		default -> System.out.println("Opcion no válida");
		}
	}

	public void cliente() {
		System.out.println("\n-- MENú CLIENTE --");
		System.out.println("a. Visualizar productos");
		System.out.println("b. Realizar compras de productos");
		System.out.println("c. Visualizar historial de compras");
		System.out.println("d. Canjear puntos");
		System.out.print("Selecciona una opción: ");
		char opcion = sc.next().charAt(0);
		sc.nextLine();

		switch (opcion) {
		case 'a' -> menuVisualizarProductos();
		case 'b' -> realizarCompraWeb();
		case 'c' -> verHistorialCompras();
		case 'd' -> canjearPuntos();
		default -> System.out.println("Opcion no válida");
		}
	}

	private void menuGestionClientes() {
		System.out.println("\n-- Gestión de Clientes --");
		System.out.println("1. Insertar cliente");
		System.out.println("2. Modificar cliente");
		System.out.println("3. Eliminar cliente");
		System.out.print("Selecciona una opción: ");
		int opcion = sc.nextInt();
		sc.nextLine();

		switch (opcion) {
		case 1 -> insertarCliente();
		case 2 -> modificarCliente();
		case 3 -> eliminarCliente();
		default -> System.out.println("Opcion no válida");
		}
	}

	private void menuGestionEmpleados() {
		System.out.println("\n-- Gestión de Empleados --");
		System.out.println("1. Insertar empleado");
		System.out.println("2. Modificar empleado");
		System.out.println("3. Eliminar empleado");
		System.out.print("Selecciona una opción: ");
		int opcion = sc.nextInt();
		sc.nextLine();

		switch (opcion) {
		case 1 -> insertarEmpleado();
		case 2 -> modificarEmpleado();
		case 3 -> eliminarEmpleado();
		default -> System.out.println("Opcion no válida");
		}
	}

	private void menuGestionProductos() {
		System.out.println("\n-- Gestión de Productos --");
		System.out.println("1. Insertar producto");
		System.out.println("2. Modificar producto");
		System.out.println("3. Eliminar producto");
		System.out.print("Selecciona una opción: ");
		int opcion = sc.nextInt();
		sc.nextLine();

		switch (opcion) {
		case 1 -> insertarProducto();
		case 2 -> modificarProducto();
		case 3 -> eliminarProducto();
		default -> System.out.println("Opcion no válida");
		}
	}

	private void menuVisualizarProductos() {
		System.out.println("\n-- Visualizar Productos --");
		System.out.println("1. Por inicial del nombre");
		System.out.println("2. Por precio (ascendente)");
		System.out.println("3. Por precio (descendente)");
		System.out.println("4. Por stock");
		System.out.print("Selecciona una opción: ");
		int opcion = sc.nextInt();
		sc.nextLine();

		switch (opcion) {
		case 1 -> ConexionSQL.conexion("SELECT", "*", "producto", "ORDER BY nombre", 3);
		case 2 -> ConexionSQL.conexion("SELECT", "*", "producto", "ORDER BY precio ASC", 3);
		case 3 -> ConexionSQL.conexion("SELECT", "*", "producto", "ORDER BY precio DESC", 3);
		case 4 -> ConexionSQL.conexion("SELECT", "*", "producto", "ORDER BY stock DESC", 3);
		default -> System.out.println("Opcion no válida");
		}
	}

	// ----- Operaciones -----

	private void insertarCliente() {
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Dirección: ");
		String direccion = sc.nextLine();
		System.out.print("Alias: ");
		String alias = sc.nextLine();
		System.out.print("Contraseña: ");
		String clave = sc.nextLine();

		ConexionSQL.añadir("usuario", "(Alias, Clave, rol) VALUES ('" + alias + "', '" + clave + "', 3)");
		ConexionSQL.añadir("cliente",
				"(nombre, direccion, Usuario_Alias) VALUES ('" + nombre + "', '" + direccion + "', '" + alias + "')");
	}

	private void modificarCliente() {
		System.out.print("Introduce el ID del cliente a modificar: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nuevo nombre: ");
		String nuevoNombre = sc.nextLine();
		System.out.print("Nueva dirección: ");
		String nuevaDireccion = sc.nextLine();

		ConexionSQL.actualizar("cliente", "nombre = '" + nuevoNombre + "', direccion = '" + nuevaDireccion + "'",
				"WHERE id = " + id);
	}

	private void eliminarCliente() {
		System.out.print("Introduce el ID del cliente a eliminar: ");
		int id = sc.nextInt();
		sc.nextLine();

		ConexionSQL.eliminar("cliente", "id = " + id);
	}

	private void insertarEmpleado() {
		System.out.print("Alias del empleado: ");
		String alias = sc.nextLine();
		System.out.print("Contraseña: ");
		String clave = sc.nextLine();

		ConexionSQL.añadir("usuario", "(Alias, Clave, rol) VALUES ('" + alias + "', '" + clave + "', 2)");
	}

	private void modificarEmpleado() {
		System.out.print("Introduce el alias del empleado a modificar: ");
		String alias = sc.nextLine();
		System.out.print("Nueva contraseña: ");
		String nuevaClave = sc.nextLine();

		ConexionSQL.actualizar("usuario", "Clave = '" + nuevaClave + "'", "WHERE Alias = '" + alias + "'");
	}

	private void eliminarEmpleado() {
		System.out.print("Introduce el alias del empleado a eliminar: ");
		String alias = sc.nextLine();

		ConexionSQL.eliminar("usuario", "Alias = '" + alias + "'");
	}

	private void insertarProducto() {
		System.out.print("Nombre del producto: ");
		String nombre = sc.nextLine();
		System.out.print("Precio: ");
		double precio = sc.nextDouble();
		System.out.print("Stock: ");
		int stock = sc.nextInt();
		sc.nextLine();

		ConexionSQL.añadir("producto",
				"(nombre, precio, stock) VALUES ('" + nombre + "', " + precio + ", " + stock + ")");
	}

	private void modificarProducto() {
		System.out.print("Introduce el ID del producto a modificar: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nuevo nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Nuevo precio: ");
		double precio = sc.nextDouble();
		System.out.print("Nuevo stock: ");
		int stock = sc.nextInt();
		sc.nextLine();

		ConexionSQL.actualizar("producto", "nombre = '" + nombre + "', precio = " + precio + ", stock = " + stock,
				"WHERE id = " + id);
	}

	private void eliminarProducto() {
		System.out.print("Introduce el ID del producto a eliminar: ");
		int id = sc.nextInt();
		sc.nextLine();

		ConexionSQL.eliminar("producto", "id = " + id);
	}

	private void realizarVenta() {
		System.out.print("Alias del cliente: ");
		String aliasCliente = sc.nextLine();
		System.out.print("ID del producto: ");
		int idProducto = sc.nextInt();
		System.out.print("Cantidad: ");
		int cantidad = sc.nextInt();
		sc.nextLine();

		double precioUnitario = 10.0; // Simulado o sacado de la BD
		double total = precioUnitario * cantidad;
		int puntos = (int) (total * 0.10);

		ConexionSQL.añadir("ticket", "(cliente_alias, empleado_alias, total, puntos) VALUES ('" + aliasCliente
				+ "', 'empleado123', " + total + ", " + puntos + ")");
		ConexionSQL.añadir("cantidadProducto", "(id_producto, cantidad) VALUES (" + idProducto + ", " + cantidad + ")");

		System.out.println("Venta realizada. Total: " + total + ", Puntos generados: " + puntos);
	}

	private void realizarCompraWeb() {
		System.out.print("Alias del cliente: ");
		String aliasCliente = sc.nextLine();
		System.out.print("ID del producto: ");
		int idProducto = sc.nextInt();
		System.out.print("Cantidad: ");
		int cantidad = sc.nextInt();
		System.out.print("Puntos a canjear: ");
		int puntosUsados = sc.nextInt();
		sc.nextLine();

		double precioUnitario = 10.0;
		double total = precioUnitario * cantidad - puntosUsados;

		ConexionSQL.añadir("ticket", "(cliente_alias, empleado_alias, total, puntos_usados) VALUES ('" + aliasCliente
				+ "', 'web', " + total + ", " + puntosUsados + ")");
		ConexionSQL.añadir("cantidadProducto", "(id_producto, cantidad) VALUES (" + idProducto + ", " + cantidad + ")");

		System.out.println("Compra web realizada. Total con descuento: " + total);
	}

	private void verTicketsEmpleado() {
		System.out.print("Alias del empleado: ");
		String alias = sc.nextLine();
		ConexionSQL.conexion("SELECT", "*", "ticket", "WHERE empleado_alias = '" + alias + "'", 4);
	}

	private void verHistorialCompras() {
		System.out.print("Alias del cliente: ");
		String alias = sc.nextLine();
		ConexionSQL.conexion("SELECT", "*", "ticket", "WHERE cliente_alias = '" + alias + "'", 4);
	}

	private void canjearPuntos() {
		System.out.print("Alias del cliente: ");
		String alias = sc.nextLine();
		System.out.print("Puntos a canjear: ");
		int puntos = sc.nextInt();
		sc.nextLine();

		System.out.println("Puntos canjeados: " + puntos + ". Serán descontados en la próxima compra.");
	}
}
