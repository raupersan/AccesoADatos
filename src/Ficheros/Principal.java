package Ficheros;

import java.util.Scanner;
import java.io.*;

public class Principal {
	public static Scanner sc = new Scanner(System.in);

	public static void crearFichero(File fichero) {
		try {
			if (!fichero.exists()) {
				// Creamos físicamente el fichero
				if (fichero.createNewFile())
					System.out.println("Fichero creado");
				else
					System.out.println("Fichero no creado");
			} else {
				System.out.println("El fichero ya existe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void verPermisos(File f) {
		String permisos = "";
		if (f.canRead()) {
			permisos = permisos + "r";
		} else
			permisos = permisos + "-";

		if (f.canWrite()) {
			permisos = permisos + "w";
		} else
			permisos = permisos + "-";

		if (f.canRead()) {
			permisos = permisos + "x";
		} else
			permisos = permisos + "-";
		System.out.println("Los permisos del fichero son " + permisos);
	}

	public static void cambiarPermisos(File f) {
		System.out.println("Cambia los permisos de lectura");
		f.setReadable(sc.nextBoolean());
		System.out.println("los permisos de lectura son ahora " + f.canRead());
		System.out.println("Cambia los permisos de escritura");
		f.setWritable(sc.nextBoolean());
		System.out.println("los permisos de escritura son ahora " + f.canWrite());
		System.out.println("Cambia los permisos de ejecución");
		f.setExecutable(sc.nextBoolean());
		System.out.println("los permisos de ejecución son ahora " + f.canExecute());

	}
	public static void listarFicheros(File d) {
		File [] ficheros=d.listFiles();
			if(d.isFile())
				System.out.println(d.getName()+ " es un fichero");
			
	}
	public static void comprobarDirectorio(File f) {
		if (f.isDirectory()) {
			listarFicheros(f);
		}
		else {
			if(f.isFile())
				System.out.println("Es un fichero, no se puede recorrer");
		}
			
	}
	public static void main(String[] args) {

		// Se escrible el nombre del fichero que se guarda físicamente
		String nombreFichero = "ficheroNuevo.txt";
		String nombreDirectorio = ".\\datos\\";
		File fichero = new File(nombreFichero);
		File directorio = new File(nombreDirectorio + nombreFichero);
		directorio.delete();
		if (!directorio.exists()) {
			if (directorio.mkdirs()) {
				crearFichero(fichero);
			}
		} else {
			System.out.println("El directorio ya existe");
	}
		comprobarDirectorio(directorio);
		verPermisos(fichero);
		//cambiarPermisos(fichero);
		//verPermisos(fichero);
	}
}