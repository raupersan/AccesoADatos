package ej3;

import java.io.File;
import java.util.Scanner;

public class main3 {
	
	public static Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
		String fichero, directorio;
		System.out.println("Escribe el nombre del directorio");
		directorio=sc.nextLine();
		System.out.println("Introduce el nombre del fichero");
		fichero=sc.nextLine();
		File fichero1 =new File(fichero);
		File directorio1= new File(directorio+fichero);
		System.out.println("Fichero y directorios creados");
	}

}
