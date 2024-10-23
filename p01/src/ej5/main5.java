package ej5;

import java.io.*;
import java.util.Scanner;

public class main5 {
	public static Scanner sc = new Scanner(System.in);

	public static void comprobarPermisos(File fichero) {
		String permisos = " ";
		char cambiarPermisos;
		if (fichero.canRead())
			permisos = permisos + "r";
		else
			permisos = permisos + "_";

		if (fichero.canWrite()) {
			permisos = permisos + "w";
		} else
			permisos = permisos + "_";

		if (fichero.canExecute()) {
			permisos = permisos + "x";
		} else
			permisos = permisos + "_";

		System.out.println("Los permisos del fichero son " + permisos);
		if (fichero.canRead() && fichero.canWrite() && fichero.canExecute()) {
			System.out.println("¿Quieres cambiar los permisos?");
			System.out.println("s");
			System.out.println("n");
			cambiarPermisos = sc.next().charAt(0);
			if (cambiarPermisos == 's')
				cambiarPermisos(fichero);
		}
	}

	private static void cambiarPermisos(File fichero) {
		char a;
		System.out.println("Escribe r para quitar los permisos de lectura");
		a = sc.next().charAt(0);
		if (a == 'r')
			fichero.setReadable(false);
		else
			System.out.println("ERR");
		System.out.println("Escribe w para quitar los permisos de escritura");
		a = sc.next().charAt(0);
		if (a == 'w')
			fichero.setWritable(false);
		else
			System.out.println("ERR");
		System.out.println("Escribe x para quitar los permisos de ejecución");
		a = sc.next().charAt(0);
		if (a == 'x')
			fichero.setExecutable(false);
		else
			System.out.println("ERR");

	}

	public static void main(String[] args) {
		String fichero = "";
		File fichero2 = new File(fichero);
		if (fichero2.exists())
			comprobarPermisos(fichero2);
	}

}
