package Practica_Final_SQL;

import java.util.Scanner;

public class Menu {
	private static Scanner sc = new Scanner(System.in);

	public Menu() {

	}

	public void admin() {
		char opcion;
		String opcion2;
		System.out.println("¿Qué quieres hacer?");
		System.out.println("a. Insertar/modificar/eliminar clientes.");
		System.out.println("b. Insertar/modificar/eliminar empleados.");
		System.out.println("c. Insertar/modificar/eliminar productos.");
		opcion = sc.next().charAt(0);
		switch (opcion) {
		case 'a': {
			System.out.println("¿Que quieres hacer?");
			System.out.println("i.   Insertar");
			System.out.println("ii.  Modificar");
			System.out.println("iii. Eliminar");

			opcion2 = sc.nextLine();

			switch (opcion2) {
			case "i": {
				System.out.println("Introduce el nombre del cliente");
				String nombre = sc.nextLine();
				System.out.println("Introduce su dirección");
				String direccion = sc.nextLine();
				insertarCliente(nombre, direccion);
				break;
			}
			case "ii": {
				mostrarClientes();
				System.out.println("Introduce el código del cliente");
				String cod = sc.nextLine();
				System.out.println("¿Qué dato quieres modificar?");
				System.out.println("1. nombre");
				System.out.println("2. direccion");
				int opc3 = sc.nextInt();
				if (opc3 == 1)
					cambiarNombreCliente(cod);
				else
					cambiarDirCliente(cod);
				break;
			}
			case "iii": {
				mostrarClientes();
				System.out.println("Introduce el codigo del cliente que quieres eliminar");
				String cod = sc.nextLine();
				eliminarCliente(cod);
				break;
			}
			}
			break;
		}
		case 'b': {
			System.out.println("¿Que quieres hacer?");
			System.out.println("i.   Insertar");
			System.out.println("ii.  Modificar");
			System.out.println("iii. Eliminar");

			opcion2 = sc.nextLine();

			switch (opcion2) {
			case "i": {
				System.out.println("Introduce el nombre del empleado");
				String nombre = sc.nextLine();
				System.out.println("Introduce su puesto");
				String puesto = sc.nextLine();
				insertarEmpleado(nombre, puesto);
				break;
			}
			case "ii": {
				mostrarEmpleados();
				System.out.println("Introduce el código del empleado");
				String cod = sc.nextLine();
				System.out.println("¿Qué dato quieres modificar?");
				System.out.println("1. nombre");
				System.out.println("2. puesto");
				int opc3 = sc.nextInt();
				if (opc3 == 1)
					cambiarNombreEmpleado(cod);
				else
					cambiarPuesto(cod);
				break;
			}
			case "iii": {
				mostrarEmpleados();
				System.out.println("Introduce el codigo del empleado que quieres eliminar");
				String cod = sc.nextLine();
				eliminarEmpleado(cod);
				break;
			}
			}
			break;
		}
		case 'c': {
			System.out.println("¿Que quieres hacer?");
			System.out.println("i.   Insertar");
			System.out.println("ii.  Modificar");
			System.out.println("iii. Eliminar");

			opcion2 = sc.nextLine();

			switch (opcion2) {
			case "i": {
				System.out.println("Introduce el nombre del producto");
				String nombre = sc.nextLine();
				System.out.println("Introduce el precio unitario");
				double precio = sc.nextDouble();
				System.out.println("Introduce la cantidad que hay en stock");
				int stock = sc.nextInt();
				insertarProducto(nombre, precio, stock);
				break;
			}
			case "ii": {
				mostrarProductos();
				System.out.println("Introduce el código del producto");
				String cod = sc.nextLine();
				System.out.println("¿Qué dato quieres modificar?");
				System.out.println("1. nombre");
				System.out.println("2. precioUnitario");
				System.out.println("3. stock");
				int opc3 = sc.nextInt();
				if (opcion == 1)
					cambiarNombreProd(cod);
				else if (opc3 == 2)
					cambiarPrecioProd(cod);
				else
					cambiarStockProd(cod);
				break;
			}
			case "iii": {
				mostrarProductos();
				System.out.println("Introduce el codigo del producto que quieres eliminar");
				String cod = sc.nextLine();
				eliminarProducto(cod);
				break;
			}
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Opción no contemplada: " + opcion);
		}
	}

	private void eliminarProducto(String cod) {
		// TODO Auto-generated method stub

	}

	private void mostrarProductos() {
		// TODO Auto-generated method stub

	}

	private void eliminarEmpleado(String cod) {
		// TODO Auto-generated method stub

	}

	private void mostrarEmpleados() {
		// TODO Auto-generated method stub

	}

	private void cambiarStockProd(String cod) {
		// TODO Auto-generated method stub

	}

	private void cambiarPrecioProd(String cod) {
		// TODO Auto-generated method stub

	}

	private void cambiarNombreProd(String cod) {
		// TODO Auto-generated method stub

	}

	private void insertarProducto(String nombre, double precio, int stock) {
		// TODO Auto-generated method stub

	}

	private void cambiarPuesto(String cod) {
		// TODO Auto-generated method stub

	}

	private void cambiarNombreEmpleado(String cod) {
		// TODO Auto-generated method stub

	}

	private void insertarEmpleado(String nombre, String puesto) {
		// TODO Auto-generated method stub

	}

	private void eliminarCliente(String cod) {
		// TODO Auto-generated method stub

	}

	private void cambiarDirCliente(String cod) {
		// TODO Auto-generated method stub

	}

	private void cambiarNombreCliente(String cod) {
		// TODO Auto-generated method stub

	}

	private void eliminarEmpleadp(String codigo) {
		// TODO Auto-generated method stub
	}

	private void insertarCliente(String nombre, String direccion) {
		// TODO Auto-generated method stub
	}

	private void mostrarClientes() {
		ConexionSQLazo.conexion("*", "cliente", " ", 4);

	}

	public void empleado() {
		String opcion2;
		System.out.println("¿Qué quieres hacer?");
		System.out.println("a. Visualizar productos");
		System.out.println("b. Realizar ventas para un cliente");
		System.out.println("c. Cliente");
		char opcion = sc.next().charAt(0);
		switch (opcion) {
		case 'a': {
			System.out.println("¿Cómo quieres visualizar los productos?");
			System.out.println("i.     Por inicial");
			System.out.println("ii.    Por precio");
			System.out.println("iii.   Por stock");
			opcion2 = sc.nextLine();
			opcion2 = sc.nextLine();
			switch (opcion2) {
			case "i": {
				productoPorInicial();
				break;
			}
			case "ii": {
				System.out.println("¿Quieres verlo en orden ascendente o descendente?");
				System.out.println("1. Asc");
				System.out.println("2. Desc");
				int opc3 = sc.nextInt();
				if (opcion == 1)
					productoPorPrecioAsc();
				else
					productoPorPrecioDesc();
				break;
			}
			case "iii": {
				productoPorStock();
				break;
			}
			}
			break;
		}
		case 'b': {
			System.out.println("Introduce el código del cliente");
			String cod = sc.nextLine();
			cod = sc.nextLine();
			break;
		}
		case 'c': {
			verTicketsEmpleado();
			break;
		}
		default:
			System.out.println();
			break;
		}
	}

	private void verTicketsEmpleado() {
		ConexionSQLazo.conexion("*", "ticket", " having 	'PrecioUnitario'", 4);
	}

	private void productoPorPrecioDesc() {
		ConexionSQLazo.conexion("*", "producto", "order by 'PrecioUnitario' desc", 4);
	}

	private void productoPorStock() {
		ConexionSQLazo.conexion("*", "producto", "order by 'Stock'", 4);
	}

	private void productoPorPrecioAsc() {
		ConexionSQLazo.conexion("*", "producto", "order by 'PrecioUnitario'", 4);
	}

	private void productoPorInicial() {
		ConexionSQLazo.conexion("*", "producto", "order by 'Nombre'", 4);
	}

	public void cliente() {
	}

}
