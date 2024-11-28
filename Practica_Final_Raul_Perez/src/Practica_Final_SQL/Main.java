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
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		Rol.rol rol;
		System.out.println("Introduce tu usuario");
		String nombre = sc.nextLine();
		System.out.println("Introduce tu contraseña");
		String contra = sc.nextLine();
		comprobarCredenciales(nombre, contra, URL, controlador);
	
	}

	private static void comprobarCredenciales(String nombre, String contra, String URL, String controlador) {
		String consulta = "select rol from usuario where Alias='" + nombre + "' and Clave='" + contra + "'";
		String aux="";
		Rol.rol rol = null;
		String role ="";
		try{
			Class.forName(controlador);
			Connection conexion =  DriverManager.getConnection(URL,"root","cfgs");
		if(conexion!=null) {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			//sentencia.setString(1,nombre);

			ResultSet rs = sentencia.executeQuery();

			while(rs.next()) {
			role = rs.getString("rol");
			rol = Rol.rol.valueOf(role);	
			}
			switch (rol) {
			case Administrador -> (new Menu()).admin();
			case Empleado ->  (new Menu()).empleado();
			case Cliente -> (new Menu()).cliente();
			default -> throw new IllegalArgumentException("El rol " + rol + " no existe");
			}

		}
		else{
			System.out.println("Ha habido un error de conexion");
		}
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}		
	}

}
