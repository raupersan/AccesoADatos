package con_SQL;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public Menu() {
        menuInicio();
    }

    public void menuInicio() {
        int opcion;
        do {
            System.out.println("1. Ver todos los clientes");
            System.out.println("2. Insertar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("0. Salir");

            while (!sc.hasNextInt()) {
                System.out.println("Introduce un número válido:");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    mostrarClientes();
                    break;
                case 2:
                    System.out.print("Introduce nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce dirección: ");
                    String direccion = sc.nextLine();
                    insertarCliente(nombre, direccion);
                    break;
                case 3:
                    System.out.print("Introduce el código del cliente a actualizar: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduce nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    actualizarCliente(codigo, nuevoNombre);
                    break;
                case 4:
                    System.out.print("Introduce el código del cliente a eliminar: ");
                    int codigoEliminar = sc.nextInt();
                    sc.nextLine();
                    eliminarCliente(codigoEliminar);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }

    private void mostrarClientes() {
        ConexionSQL.conexion("SELECT", "*", "cliente", "", 3);
    }

    private void insertarCliente(String nombre, String direccion) {
        ConexionSQL.añadir("cliente", "VALUES (51, '" + nombre + "', '" + direccion + "')");
    }

    private void actualizarCliente(int codigo, String nuevoNombre) {
        ConexionSQL.actualizar("cliente", "nombre = '" + nuevoNombre + "'", "WHERE codigoCliente = " + codigo);
    }

    private void eliminarCliente(int codigo) {
        ConexionSQL.eliminar("cliente", "codigoCliente = " + codigo);
    }
}
