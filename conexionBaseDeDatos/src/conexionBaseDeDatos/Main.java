package conexionBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String nombre="";
		String URL="jdbc:mysql://localhost:3306/nba";
		String usuario="root";
		String password="cfgs";
		String controlador="com.mysql.cj.jdbc.Driver";
		String consulta = "select*from equipos where Nombre=?or Conferencia=?" ;
		//Conexion JDBC conector de Java con SQL
		System.out.println("Introduce el nombre del equipo que quieres visualizar");
		nombre = sc.nextLine();
		try {
			Class.forName(controlador);
			Connection conexion =  DriverManager.getConnection(URL,usuario,password);
			if(conexion!=null) {
				/*
				System.out.println("Conexión con éxito");
				Statement s = conexion.createStatement();
				ResultSet rs = s.executeQuery();
				*/
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1,nombre);
				sentencia.setString(2, "East");
				ResultSet rs = sentencia.executeQuery();

				while(rs.next()) {
				
					System.out.print(rs.getString("Nombre"));
					System.out.print(",");
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
