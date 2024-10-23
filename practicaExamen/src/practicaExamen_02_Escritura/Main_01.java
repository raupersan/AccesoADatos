package practicaExamen_02_Escritura;

import java.io.*;
import java.util.Scanner;
public class Main_01 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String ruta = "C:\\Users\\Raul\\Desktop\\Segundo\\aad\\AccesoADatos\\primos.txt";
		File file = new File(ruta);
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(sc.nextLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
