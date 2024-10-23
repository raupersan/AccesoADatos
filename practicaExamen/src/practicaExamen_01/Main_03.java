package practicaExamen_01;

import java.util.Scanner;
import java.io.*;
public class Main_03 {
	static Scanner sc = new Scanner(System.in);

	static void crearFichero(String fichero, String ruta) {
		File f = new File(ruta+fichero);
		try {
			f.createNewFile();
			System.out.println("Fichero "+f.getName() + " creado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String fichero, ruta;
		System.out.println("Introduce el nombre del fichero que quieres crear");
		fichero=sc.nextLine();
		System.out.println("Introduce la ruta donde quieres crear tu fichero");
		ruta=sc.nextLine();
		crearFichero(fichero, ruta);
	}

	

}
