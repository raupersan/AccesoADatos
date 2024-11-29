package Practica_Final_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Practica_Final_SQL.Rol.rol;

public class ConexionSQLazo {

	public ConexionSQLazo() {
	}

	public static void conexion(String colum, String tabla, String extra, int numParam) {
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = "select " + colum + " from " + tabla + " " + extra;
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, "root", "cfgs");
			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();
				while (rs.next()) {
					for(int i = 1; i <= numParam; i++) {
						System.out.print(" "+rs.getString(i));
					}
					System.out.println("");
				}
			} else {
				System.out.println("Ha habido un error de conexion");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static rol sacarRol(String colum, String tabla, String extra, int numParam) {
		String role = "";
				
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = "select " + colum + " from " + tabla + " " + extra;
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, "root", "cfgs");
			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();
				while (rs.next()) {
				role=rs.getString(numParam);
				}
			} else {
				System.out.println("Ha habido un error de conexion");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
		Rol.rol rol = Rol.rol.valueOf(role);

		return rol;
	}
}
