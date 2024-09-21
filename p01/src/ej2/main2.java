package ej2;

import java.io.File;
import java.util.Scanner;

public class main2 {
	public static Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
		String fichero;
		System.out.println("Introduce el nombre del fichero del cual quieres comprobar su existencia");
		fichero=sc.nextLine();
		File ficheroComprobar = new File(fichero);
		if (ficheroComprobar.exists()) {
			ficheroComprobar.delete();
			System.out.println("Fichero borrado");
		}
		else
			System.out.println("El fichero no existe");
	}

}
