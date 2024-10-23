package practicaExamen_01;

import java.util.Scanner;
import java.io.*;
public class Main_01 {
	
	static Scanner sc = new Scanner(System.in);
	
	static void listarDirectorio(String ruta) {
		File directorio =new File(ruta);
		File [] ficheros=directorio.listFiles();
		for(File f: ficheros) {
			System.out.println(f.getName());
		}
	}
	public static void main(String[] args) {
		String ruta = "";
		
		System.out.println("Introduce la ruta del directorio que quieras listar:");
		ruta=sc.nextLine();
		listarDirectorio(ruta);
	}

}
