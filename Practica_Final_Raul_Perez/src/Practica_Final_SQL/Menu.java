package Practica_Final_SQL;

import java.util.Scanner;

public class Menu {
	private String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
	private String controlador = "com.mysql.cj.jdbc.Driver";
	private static Scanner sc = new Scanner(System.in);

	public Menu() {

	}

	public void admin() {
		char opcion;
		String opcion2;
		System.out.println("¿Qué quieres hacer?");
		System.out.println("a. Insertar/modificar/eliminar clientes.");
		System.out.println("a. Insertar/modificar/eliminar empleados.");
		System.out.println("a. Insertar/modificar/eliminar productos.");
		opcion=sc.next().charAt(0);
		switch (opcion) {
		case 'a': {
			System.out.println("¿Que quieres hacer?");
			System.out.println("i.   Insertar");
			System.out.println("ii.  Modificar");
			System.out.println("iii. Eliminar");
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
		}
		case 'b': {
			System.out.println("Introduce el código del cliente");
			String cod = sc.nextLine();
			break;
		}
		case 'c':{
			verTicketsEmpleado();
			break;
		}
		default:
			System.out.println();
			break;
		}
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
		}
		case 'b': {
			System.out.println("Introduce el código del cliente");
			String cod = sc.nextLine();
			break;
		}
		case 'c':{
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
