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
		} catch (IOException e) {

			e.getStackTrace();
		}
	}

	public static void lecturaBinario(String ruta) {
		File fichero = new File(ruta);
		try {
			FileInputStream fis = new FileInputStream(fichero);
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}
			fis.close();
		} catch (IOException e) {

			e.getStackTrace();
		}
	}

	public static void escribirCoches(String ruta) {
		//Creo el descriptor fichero
		File fichero = new File(ruta);

		try {
			//Indico que abro el fichero para escritura
			FileOutputStream fos = new FileOutputStream(fichero);
			//Indico que lo que voy a escribit son objetos
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Coche c1 = new Coche(5, "Opel", "Astra", 500, 200, 2000);
			Coche c2 = new Coche(5, "Opel", "Astra", 500, 200, 2000);
		
			oos.writeObject(c1);
			oos.writeObject(c2);
			
			}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void lecturaObjetos(String ruta) {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File (ruta)));
			
			Coche c1 = new Coche(5, "Opel", "Astra", 500, 200, 2000);
			Coche c2 = new Coche(5, "Opel", "Astra", 500, 200, 2000);
		
		
			
			}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		String ruta = "fichero.bin";
		String ruta2= "fichero2.bin";
		escribirBinario(ruta);
		escribirCoches(ruta2);
	}

}
