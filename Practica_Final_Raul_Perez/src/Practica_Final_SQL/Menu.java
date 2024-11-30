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
				else if (opc3 == 2) {
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
	
	public void empleado() {
		String opcion2;
		System.out.println("¿Qué quieres hacer?");
		System.out.println("a. Visualizar productos");
		System.out.println("b. Realizar ventas para un cliente");
		System.out.println("c. Ver tickets generados por un cliente");
		char opcion = sc.next().charAt(0);
		switch (opcion) {
		case 'a': {
			System.out.println("¿Cómo quieres visualizar los productos?");
			System.out.println("i.    Por inicial");
			System.out.println("ii.   Por precio");
			System.out.println("iii.  Por stock");
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
			int sino;
			do {
				System.out.println("Introduce el código del cliente");
				String cod = sc.nextLine();
				cod = sc.nextLine();
				mostrarClientes();
				System.out.println("Estás seguro de que quieres usar el cliente " + cod);
				System.out.println("1. si");
				System.out.println("2. no");
				sino = sc.nextInt();
			} while (sino == 2);
			System.out.println("Introduce el nombre del producto");
			String nombre = sc.nextLine();
			System.out.println("Introduce la cantidad de producto");
			int stock = sc.nextInt();
			// TODO

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

	public void cliente() {
		char opcion;
		String opcion2;
		System.out.println("¿Qué quieres hacer?");
		System.out.println("a. Mostrar productos");
		System.out.println("b. Realizar compras de productos");
		System.out.println("c. Ver historial de compras");
		System.out.println("d. Canjear puntos");
		opcion = sc.next().charAt(0);
		switch (opcion) {
		case 'a': {
			mostrarProductos();
			break;
		}
		case 'b': {
			// TODO
			break;
		}
		case 'c': {
			verHistorialCompras();
			break;
		}
		case 'd': {
			canjearPuntos();
			break;
		}
		default:
			throw new IllegalArgumentException("Opción no contemplada: " + opcion);
		}
	}

	private void eliminarProducto(String cod) {
		ConexionSQLazo.conexion("delete","", "producto", " where Nombre='" +cod+"'", 4);

	}

	private void mostrarProductos() {
		ConexionSQLazo.conexion("select","*", "producto", " ", 4);

	}

	private void eliminarEmpleado(String cod) {
		ConexionSQLazo.eliminar("empleado", " codigoEmpleado='" + cod +"'");

	}

	private void mostrarEmpleados() {
		ConexionSQLazo.conexion("select","*", "empleado", " ", 5);

	}

	private void cambiarStockProd(String cod) {
		System.out.println("Introduce la nueva cantidad de stock");
		int stock = sc.nextInt();
		ConexionSQLazo.actualizar("producto", "stock = " + stock, " where idProducto='"+cod+"'");
	}

	private void cambiarPrecioProd(String cod) {
		System.out.println("Introduce el nuevo precio");
		double precio = sc.nextDouble();
		ConexionSQLazo.actualizar("producto", "PrecioUnitario = " + precio, " where idProducto='"+cod+"'");
	}

	private void cambiarNombreProd(String cod) {
		System.out.println("Introduce el nuevo nombre del producto");
		String nombre = sc.nextLine();
		ConexionSQLazo.actualizar("producto", "Nombre = " + nombre, " where idProducto='"+cod+"'");
	}

	private void insertarProducto(String nombre, double precio, int stock) {
		ConexionSQLazo.añadir("producto"," values("+15+", '"+nombre+"', "+ precio+","+stock+")");
	}

	private void cambiarPuesto(String cod) {
		System.out.println("¿Que rol quieres que tenga?");
		String rol = sc.nextLine();
		ConexionSQLazo.actualizar("empleado", "puesto='"+ rol + "' ", "where codigoEmpleado='"+cod+"'");
	}

	private void cambiarNombreEmpleado(String cod) {
		System.out.println("Introduce el nuevo nombre para el empleado");
		String nombre = sc.nextLine();
		ConexionSQLazo.actualizar("empleado", "Nombre='"+ nombre + "' ", "where codigoEmpleado='"+cod+"'");
	}

	private void insertarEmpleado(String nombre, String puesto) {
		ConexionSQLazo.añadir("empleado", "values(51,"+ nombre+"," + puesto + ")");
	}

	private void eliminarCliente(String cod) {
		ConexionSQLazo.eliminar("cliente", " codigoEmpleado='"+cod+"'");
	}

	private void cambiarDirCliente(String cod) {
		System.out.println("Indica la nueva dirección del cliente");
		String direccion = sc.nextLine();
		ConexionSQLazo.actualizar("cliente", " Direccion='"+direccion+"'", "where numerodecliente='"+cod+"'");
	}

	private void cambiarNombreCliente(String cod) {
		System.out.println("Escribe el nuevo nombre del cliente");
		String nombre = sc.nextLine();
		ConexionSQLazo.actualizar("cliente", "Nombre='"+ nombre + "' ", "where numerodecliente='"+cod+"'");
	}

	private void eliminarEmpleadp(String codigo) {
		ConexionSQLazo.eliminar("empleado", " codigoEmpleado='"+codigo+"'");
	}

	private void insertarCliente(String nombre, String direccion) {
		ConexionSQLazo.añadir("cliente", "values(51,"+ nombre+"," + direccion + ")");
	}

	private void mostrarClientes() {
		ConexionSQLazo.conexion("select","*", "cliente", " ", 4);

	}

	
	private void verTicketsEmpleado() {
		ConexionSQLazo.conexion("select","*", "ticket", " having 	'PrecioUnitario'", 4);
	}

	private void productoPorPrecioDesc() {
		ConexionSQLazo.conexion("select","*", "producto", "order by 'PrecioUnitario' desc", 4);
	}

	private void productoPorStock() {
		ConexionSQLazo.conexion("select","*", "producto", "order by 'Stock'", 4);
	}

	private void productoPorPrecioAsc() {
		ConexionSQLazo.conexion("select","*", "producto", "order by 'PrecioUnitario'", 4);
	}

	private void productoPorInicial() {
		ConexionSQLazo.conexion("select","*", "producto", "order by 'Nombre'", 4);
	}


	private void canjearPuntos() {
		// TODO Auto-generated method stub

	}

	private void verHistorialCompras() {
		// TODO Auto-generated method stub

	}

}
