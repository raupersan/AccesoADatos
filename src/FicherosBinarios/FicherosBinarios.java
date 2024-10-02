package FicherosBinarios;

import java.io.*;

public class FicherosBinarios {
	public static void escribirBinario(String ruta) {
		File fichero = new File(ruta);

		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			String datos = "Vamos a escribir una prueba de datos";
			fos.write(datos.getBytes());
			fos.close();
		}
		catch(IOException e) {
			
			e.getStackTrace();
		}
	}
	public static void lecturaBinario(String ruta) {
		File fichero = new File(ruta);
		try {
			FileInputStream fis = new FileInputStream(fichero);
			int i;
			while ((i=fis.read())!=-1) {
				System.out.print((char)i);
			}
			fis.close();
		}
		catch(IOException e) {
			
			e.getStackTrace();
		}
	}
	public static void main(String[] args) {
		String ruta ="fichero.bin";
		escribirBinario(ruta);
	}

}
