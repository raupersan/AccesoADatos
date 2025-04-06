package sin_SQL;

import java.io.*;
import java.util.ArrayList;

public class CreateGasolineraFile {
    public static void main(String[] args) {
        ArrayList<Gasolinera> gasolineras = new ArrayList<>();
        gasolineras.add(new Gasolinera("Station A", null, 1.99, 0, 0, 0));
        gasolineras.add(new Gasolinera("Station B", null, 2.29, 0, 0, 0));

        String filePath = "gasolinera.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // Serialize the ArrayList
            oos.writeObject(gasolineras);
            System.out.println("File created successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("IO Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
