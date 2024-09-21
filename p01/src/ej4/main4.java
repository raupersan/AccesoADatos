package ej4;

import java.io.File;
import java.util.Scanner;

public class main4 {
	public static Scanner sc = new Scanner(System.in);

	public static void listarFicheros(File d) {
		File[] ficheros = d.listFiles();
		if (d.isFile())
			System.out.println(d.getName() + " es un fichero");
		else
			(ficheros);

	}

	public static void main(String[] args) {
		String directorio1;
		System.out.println("Introduce el nombre del directorio");
		directorio1 = sc.nextLine();
		File directorio2 = new File(directorio1);
		if (directorio2.isDirectory()) {
			listarFicheros(directorio2);

		} else
			System.out.println("El nombre introducido no es un directorio");
	}
}
