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
		String usuario = sc.nextLine();
		System.out.println("Introduce tu contraseña");
		String contra = sc.nextLine();
		comprobarCredenciales(usuario, contra, URL, controlador);
	
	}

	private static void comprobarCredenciales(String usuario, String contra, String URL, String controlador) {
		String consulta = "select*from equipos where Nombre=?or Conferencia=?";
		String aux="";
		Rol.rol rol;
		try{
			Class.forName(controlador);
		Connection conexion =  DriverManager.getConnection(URL,usuario,contra);
		if(conexion!=null) {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1,aux);

			ResultSet rs = sentencia.executeQuery();

			while(rs.next()) {
			
				System.out.print(rs.getString("Nombre"));
				System.out.print(",");
			}
			switch (rol) {
			case ADMINISTRADOR -> (new Menu()).admin();
			case EMPLEADO ->  (new Menu()).empleado();
			case CLIENTE -> (new Menu()).cliente();
			default -> throw new IllegalArgumentException("El rol " + role + " no existe");
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
