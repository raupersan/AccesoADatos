package clientes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
	
	private static void crearDirectorio(Path directorio) throws IOException {
		if (!Files.exists(directorio)) {
			Files.createDirectory(directorio);
			System.out.println("Se ha creado el directorio en " + directorio.toAbsolutePath());
		}
	}
	public static void main(String[] args) {
		Path directorio = Paths.get("Clientes");
		try {
			crearDirectorio(directorio);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
