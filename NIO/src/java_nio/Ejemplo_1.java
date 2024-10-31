package java_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ejemplo_1 {
	
	public static void crearDirectorio(Path dir) throws IOException {
		if(!Files.exists(dir)) {
			Files.createDirectories(dir);
			System.out.println("Directorio creado en: " + dir.toAbsolutePath() + " y mi directorio padre es: " + dir.getParent()); 
		}
	}
	private static void leerArchivoCompleto(Path fichero) throws IOException {
		String contenidoCompleto= Files.readString(fichero);
		System.out.println(contenidoCompleto);
	}
	private static void leerArchivoLinea(Path fichero) throws IOException {
		byte [] bytes= Files.readAllBytes(fichero);
		List lista = Files.readAllLines(fichero);
		for (Object f : lista) {
			
		}
	}
	private static void escribirArchivo(Path fichero, String texto) throws IOException {
		Files.writeString(fichero, texto);
		System.out.println("Crea el archivo y escribe");
	}
	private static void copiarArchivos(Path fichero, Path ficheroCopia) throws IOException {
		Files.copy(fichero, ficheroCopia);
	}
	private static void moverArchivos(Path fichero, Path ficheroCopia) throws IOException {
		Files.move(fichero, ficheroCopia);
	}
	public static void main(String [] args) {
		Path directorio = Paths.get("Carpeta");
		Path directorioCopia = Paths.get("Carpeta2");
		Path fichero = directorio.resolve("ficheriJavaNIO.txt");
		Path ficheroCopia= directorio.resolve("ficheroJavaNIOCopia");
		try {
			crearDirectorio(directorio);
			escribirArchivo(fichero, "hola qué tal");
			leerArchivoCompleto(fichero);
			leerArchivoLinea(fichero);
			copiarArchivos(fichero,ficheroCopia);
			moverArchivos(fichero, ficheroCopia);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	
}
