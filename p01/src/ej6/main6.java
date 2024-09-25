package ej6;

import java.io.*;
import java.util.Scanner;

public class main6 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String fichero1 = "";

		System.out.println("Introduce el nombre del fichero que quieres crear");
		fichero1 = sc.nextLine();
		File fichero2 = new File(fichero1);
		comprobarFichero(fichero2);

	}

	private static void comprobarFichero(File fichero) {
		try {
			if (!fichero.exists()) {
				fichero.createNewFile();
				System.out.println("Fichero creado");
				fichero.setWritable(true);
				fichero.setReadable(false);
				fichero.setExecutable(false);
				System.out.println("Cambiados los permisos a sólo lectura");

			} else {
				System.out.println("El fichero ya existe y esta es su ruta: " +fichero.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
