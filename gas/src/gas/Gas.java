package gas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;



public class Gas {
	private static Scanner sc = new Scanner(System.in);
	
	private static void escribirGasolinera(Gasolinera g, String ficheroBin) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroBin));
		oos.writeObject(g);
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String ficheroBin = "gasolinera.bin";
		System.out.println("Introduce el nombre de la nueva gasolinera");
		String nombre = sc.nextLine();
		System.out.println("Introduce la ubicación de la nueva gasolinera");
		String ubicacion = sc.nextLine();
		System.out.println("Introduce la cantidad de litros de gasolina");
		double litros95 = sc.nextDouble();
		System.out.println("Introduce la cantidad de litros de diésel");
		double litrosDiesel = sc.nextDouble();
		System.out.println("Introduce el precio de la gasolina");
		double precio95 = sc.nextDouble();
		System.out.println("Introduce el precio del diésel");
		double precioDiesel = sc.nextDouble();
		Gasolinera g = new Gasolinera(nombre, ubicacion, litros95, litrosDiesel, precio95, precioDiesel);
		escribirGasolinera(g, ficheroBin);
	}

}
