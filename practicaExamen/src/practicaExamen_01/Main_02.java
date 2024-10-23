package practicaExamen_01;

import java.util.Scanner;
import java.io.*;
public class Main_02 {
	
	static Scanner sc = new Scanner(System.in);
	
	static void comprobarFichero(String ruta) {
		File fichero =new File(ruta);
		if(fichero.exists()) {
			String nombre =fichero.getName();
			fichero.delete();
			System.out.println("Fichero " +nombre + " borrado");
		}
	}
	public static void main(String[] args) {
		String ruta = "";
		
		System.out.println("Introduce la ruta del fichero que quieras comprobar:");
		ruta=sc.nextLine();
		comprobarFichero(ruta);
	}

}
