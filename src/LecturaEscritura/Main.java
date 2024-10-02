package LecturaEscritura;

import java.io.*;

public class Main {
	public static void lecturaBuffer (File fichero) {
		try {
		FileReader salida = new FileReader(fichero);
		BufferedReader buffer = new BufferedReader(salida);
		String texto;
		while((texto=buffer.readLine())!=null) {
			System.out.println(texto);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void escritura2(String ruta) {
		try {
			FileWriter fichero =new FileWriter(ruta);
			BufferedWriter bw = new BufferedWriter(fichero);
			for(int i=0; i<10; i++){
				bw.write(" "+i);
			}
			bw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void escritura(String ruta) {
		try {
			FileWriter fichero =new FileWriter(ruta);
			PrintWriter pw = new PrintWriter(fichero);
			for(int i=0; i<10; i++) {
			;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void lectura(File fichero) {
		char [] texto= new char[100];
		try {
		FileReader salida = new FileReader(fichero);
		System.out.println("La codificación es: "+ salida.getEncoding());
		salida.read(texto);
		System.out.print("\"El texto es: \"");
		System.out.println(texto);
		salida.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String ruta = "C:\\Users\\CFGS.LAB-35-PC04\\Desktop\\AAD\\OperacionesFicheros\\datos\\fichero.txt";
		File fichero = new File(ruta);
		if (fichero.exists()) {
			System.out.println("Leyendo...");
			//Llamamos a la función de lectura
		} else {
			System.out.println("No existe el fichero " + fichero.getAbsolutePath());
			try {
				if (fichero.createNewFile()) {
					System.out.println("Se ha creado el fichero "+ fichero.getAbsolutePath());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//lectura(fichero);
		lecturaBuffer(fichero);
	}

}
