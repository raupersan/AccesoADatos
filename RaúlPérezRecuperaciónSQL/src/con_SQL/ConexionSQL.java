package con_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexionSQL {

	public ConexionSQL() {
	}

	public static void conexion(String accion, String colum, String tabla, String extra, int numParam) {
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = accion+ " " + colum + " from " + tabla + " " + extra;
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
	public static void añadir(String tabla, String valores) {
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = "insert into " + tabla + valores;
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, "root", "cfgs");
			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();
			
			} else {
				System.out.println("Ha habido un error de conexion");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void actualizar( String colum, String tabla, String condicion) {
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = "update" + colum  +" set " + tabla + condicion;
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, "root", "cfgs");
			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();
			
			} else {
				System.out.println("Ha habido un error de conexion");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void eliminar(String tabla, String condicion) {
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = "delete from " + tabla + " where "+condicion;
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, "root", "cfgs");
			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();
			
			} else {
				System.out.println("Ha habido un error de conexion");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static int sacarRol(String colum, String tabla, String extra, int numParam) {
		int rol; 
		
		String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = "select " + colum + " from " + tabla + " " + extra;
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, "root", "  ");
			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();
				while (rs.next()) {
				//role=rs.getString(numParam);
				}
			} else {
				System.out.println("Ha habido un error de conexion");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
		 return 1;
	}
}
