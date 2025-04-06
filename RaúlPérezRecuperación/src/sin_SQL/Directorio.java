package sin_SQL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Directorio {
	public static void crearDirectorio(Path dir) throws IOException {
		if (!Files.exists(dir)) {
			Files.createDirectories(dir);
		}
	}
}
