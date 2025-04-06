package con_SQL;

import java.util.Scanner;


public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce tu usuario");
		String nombre = sc.nextLine();
		System.out.println("Introduce tu contraseña");
		String contra = sc.nextLine();
		try {
			comprobarCredenciales(nombre, contra);
		} catch (ClassNotFoundException e) {
		}

	}

	private static void comprobarCredenciales(String nombre, String contra) throws ClassNotFoundException {
		int rol = ConexionSQL.sacarRol("rol", "usuario", "where Alias='" + nombre + "' and Clave='" + contra + "'", 1);
		switch (rol) {
		case 1 -> (new Menu()).admin();
		case 2 -> (new Menu()).empleado();
		case 3 -> (new Menu()).cliente();
		default -> throw new IllegalArgumentException("El rol " + rol + " no existe");
		}
	}
}
