package Practica_Final_SQL;

import java.util.Scanner;


public class Menu {
	private String URL = "jdbc:mysql://localhost:3306/PracticaFinal";
	private String controlador = "com.mysql.cj.jdbc.Driver";
	private static Scanner sc = new Scanner(System.in);

	public Menu() {
		
	}

	public void admin() {
		
	}

	public void empleado() {
		System.out.println("¿Qué quieres hacer?");
		System.out.println("a. Visualizar productos");
		System.out.println("b. Realizar ventas para un cliente");
		System.out.println("c. Cliente");
		char opcion = sc.next().charAt(0);
		switch (opcion) {
		case 'a':{
			System.out.println("¿Cómo quieres visualizar los productos?");
			System.out.println("i.    Por inicial");
			System.out.println("ii.	  Por precio");
			System.out.println("iii.  Por stock");

			visualizarProd();
		} 
		case 'b' :{
			System.out.println();
		}
		case 'c' : System.out.println();
		default  : System.out.println();
		}
	}

	public void cliente() {
	}
	private void visualizarProd() {
		ConexionSQLazo.conexion( "*", "producto", "order by 'Nombre'", 4);
	}
}
