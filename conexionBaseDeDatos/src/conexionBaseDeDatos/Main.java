package conexionBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		String URL="jdbc.mysql://localhost/nba";
		String usuario="root";
		String password="cfgs";
		String controlador="com.mysql.cj.jdbc.Driver";
		//Conexion JDBC conector de Java con SQL
		
		try {
			Class.forName(controlador);
			Connection conexion =  DriverManager.getConnection(URL);
			if(conexion!=null) {
				
			}
			else{
				System.out.println("Ha habido un error de conexion");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
