package con_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionSQL {

    private static final String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "cfgs";
    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";

    public ConexionSQL() {
    }

    public static void conexion(String accion, String colum, String tabla, String extra, int numParam) {
        String consulta = accion + " " + colum + " FROM " + tabla + " " + extra;
        try {
            Class.forName(CONTROLADOR);
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            if (conexion != null) {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                ResultSet rs = sentencia.executeQuery();
                while (rs.next()) {
                    for (int i = 1; i <= numParam; i++) {
                        System.out.print(" " + rs.getString(i));
                    }
                    System.out.println("");
                }
            } else {
                System.out.println("Ha habido un error de conexión");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void añadir(String tabla, String valores) {
        String consulta = "INSERT INTO " + tabla + " " + valores;
        try {
            Class.forName(CONTROLADOR);
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            if (conexion != null) {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.executeUpdate(); // CORREGIDO
            } else {
                System.out.println("Ha habido un error de conexión");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizar(String tabla, String setClause, String condicion) {
        String consulta = "UPDATE " + tabla + " SET " + setClause + " " + condicion;
        try {
            Class.forName(CONTROLADOR);
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            if (conexion != null) {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.executeUpdate(); // CORREGIDO
            } else {
                System.out.println("Ha habido un error de conexión");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminar(String tabla, String condicion) {
        String consulta = "DELETE FROM " + tabla + " WHERE " + condicion;
        try {
            Class.forName(CONTROLADOR);
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            if (conexion != null) {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.executeUpdate(); // CORREGIDO
            } else {
                System.out.println("Ha habido un error de conexión");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static int sacarRol(String colum, String tabla, String extra) {
        int rol = 1;
        String consulta = "SELECT " + colum + " FROM " + tabla + " " + extra;
        try {
            Class.forName(CONTROLADOR);
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            if (conexion != null) {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                ResultSet rs = sentencia.executeQuery();
                if (rs.next()) {
                    rol = rs.getInt(1);
                }
            } else {
                System.out.println("Ha habido un error de conexión");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }
    public static int sacarRol(String alias, String clave) {
        int rol = -1;
        String consulta = "SELECT rol FROM usuario WHERE Alias = ? AND Clave = ?";
        try {
            Class.forName(CONTROLADOR);
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            if (conexion != null) {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.setString(1, alias);
                sentencia.setString(2, clave);
                ResultSet rs = sentencia.executeQuery();
                if (rs.next()) {
                    rol = rs.getInt("rol");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }

}
