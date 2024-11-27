package Practica_Final_SQL;

import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Rol.rol rol;
		System.out.println("Introduce tu rol");
		String role = sc.nextLine().toUpperCase();
		rol = Rol.rol.valueOf(role);
		switch (rol) {
		case ADMINISTRADOR -> (new Menu()).admin();
		case EMPLEADO ->  (new Menu()).empleado();
		case CLIENTE -> (new Menu()).cliente();
		default -> throw new IllegalArgumentException("El rol " + role + " no existe");
		}

	}

}
