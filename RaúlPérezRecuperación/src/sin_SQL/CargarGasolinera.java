package sin_SQL;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import sin_SQL.Gasolinera;

public class CargarGasolinera {
	public static ArrayList<Gasolinera> leerGasolinera(String ruta) {
		ArrayList<Gasolinera> gasolineras = new ArrayList<Gasolinera>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
			 gasolineras = (ArrayList<Gasolinera>) ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return gasolineras;
	}
}
