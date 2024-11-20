package conexionBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String URL="jdbc:mysql://localhost:3306/nba";
		String usuario="root";
		String password="cfgs";
		String controlador="com.mysql.cj.jdbc.Driver";
		//Conexion JDBC conector de Java con SQL
		
		try {
			Class.forName(controlador);
			Connection conexion =  DriverManager.getConnection(URL,usuario,password);
			if(conexion!=null) {
				System.out.println("Conexión con éxito");
				Statement s = conexion.createStatement();
				ResultSet rs = s.executeQuery("select*from equipos where nombre like 'B%'");
				while(rs.next()) {
					System.out.println("Introduce el nombre del equipo que quieres visualizar");
					String nombre = sc.nextLine();
					System.out.println(rs.getString(1));
					System.out.println(rs.getString("Nombre"));
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
