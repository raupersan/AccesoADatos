package practicaExamen_01;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Main_05 {
	static Scanner sc = new Scanner(System.in);
	
	private static void permisos(File f) {
		if(f.canRead())
			System.out.print("r");
		else
			System.out.print("_");
		if(f.canWrite()) 
			System.out.print("w");
		else
			System.out.print("_");
		if(f.canExecute())
			System.out.println("x");
		else
			System.out.println("_");
		if(f.canExecute()&&f.canRead()&&f.canWrite())
			cambiarPermisos(f);
	}
	private static File cambiarPermisos(File f) {
		char var;
		System.out.println("Escribe r si quieres quitar los permisos de lectura");
		var=sc.next().charAt(0);
		if(var=='r')
			f.setReadable(false);
		System.out.println("Escribe w si quieres quitar los permisos de escritura");
		var=sc.next().charAt(0);
		if(var=='w')
			f.setWritable(false);
		System.out.println("Escribe x si quieres quitar los permisos de ejecución");
		var=sc.next().charAt(0);
		if(var=='x')
			f.setExecutable(false);
		return f;
	}
	public static void main(String[] args) {
		String fichero;
		System.out.println("Introduce la ruta del fichero que quieres leer");
		fichero = sc.nextLine();
		File f = new File(fichero);
		if (f.isFile()) {
			System.out.println("La ruta absoluta es " + f.getAbsolutePath());
			permisos(f);
		}
	}
	

}
