package FicherosAccesoAleatorio;

import java.io.*;

public class Main {

	public static void escrituraFicheroAleatorio(String fichero, String cadena, RandomAccessFile raf) {
		try {
			raf = new RandomAccessFile(fichero, "rw");
			//Tamaño del fichero
			long size =raf.length();
			//Me posiciono en el fichero con seek
			raf.seek(size);
			raf.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: No se ha encontrado el fichero");
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Error: No se ha podido escribir el fichero");
			System.out.println(e.getMessage());
		}
	}
	public static void lecturaFicheroAleatorio(String nombreFichero, long posicion, int longitud){
		String resultado= "";
		try(RandomAccessFile raf= new RandomAccessFile(nombreFichero, "r")){
			raf.seek(posicion);
			byte[] bytes = new byte[longitud];
			raf.readFully(bytes);
			resultado=new String(bytes).trim();
			System.out.println(resultado);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String nombreFichero = "FicheroAccesoAleatorio.txt";
		String cadena= "Esto es una prueba de escritura";
		RandomAccessFile raf = null;
		escrituraFicheroAleatorio(nombreFichero, cadena, raf);
	}

}
