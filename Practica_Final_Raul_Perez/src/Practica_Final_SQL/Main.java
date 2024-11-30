package Practica_Final_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Practica_Final_SQL.Rol.rol;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Rol.rol rol;
		System.out.println("Introduce tu usuario");
		String nombre = sc.nextLine();
		System.out.println("Introduce tu contraseña");
		String contra = sc.nextLine();
		comprobarCredenciales(nombre, contra);

	}

	private static void comprobarCredenciales(String nombre, String contra) {
		Rol.rol rol = ConexionSQLazo.sacarRol("rol", "usuario", "where Alias='" + nombre + "' and Clave='" + contra + "'", 1);

		switch (rol) {
		case Administrador -> (new Menu()).admin();
		case Empleado -> (new Menu()).empleado();
		case Cliente -> (new Menu()).cliente();
		default -> throw new IllegalArgumentException("El rol " + rol + " no existe");
		}
	}

}
