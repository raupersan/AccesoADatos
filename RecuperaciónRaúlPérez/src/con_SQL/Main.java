package con_SQL;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce tu alias:");
        String alias = sc.nextLine();
        System.out.println("Introduce tu contraseña:");
        String clave = sc.nextLine();
        try {
            comprobarCredenciales(alias, clave);
        } catch (Exception e) {
            System.out.println("Error al comprobar credenciales: " + e.getMessage());
        }
    }

    private static void comprobarCredenciales(String alias, String clave) {
        int rol = ConexionSQL.sacarRol(alias, clave);
        Menu menu = new Menu();

        switch (rol) {
            case 1 -> menu.admin();
            case 2 -> menu.empleado();
            case 3 -> menu.cliente();
            default -> System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}
