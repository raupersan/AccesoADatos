package practicaExamen_01;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Main_04 {
	static Scanner sc = new Scanner(System.in);

	private static void listarDirectorio(File ruta) {
		File [] f =ruta.listFiles();
	
		for(File lorencin: f) {
			if(lorencin.isDirectory())
			{
				System.out.println("Listando directorio: " + lorencin);
				listarDirectorio(lorencin);
			
			}
			else
				System.out.println(lorencin.getName());
		}
	}
	public static void main(String[] args) {
		String directorio;
		System.out.println("Introduce el nombre del directorio que quieres leer");
		directorio = sc.nextLine();
		File d = new File(directorio);
		listarDirectorio(d);
	}


}
