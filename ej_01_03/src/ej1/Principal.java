package ej1;
import java.io.*;
import java.util.*;

public class Principal {
	public static void escribirPersonas(List<Persona> p, String ruta) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));
			oos.writeObject(p);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Persona> leerPersonas(String ruta) {
		List<Persona> personas = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));
			personas = (List<Persona>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return personas;
	}

	public static void main(String[] args) {
		String nombre = "";
		String ruta = "ficheroPeronas.bin";
		int opcion = 1;
		int edad = 0;
		List<Persona> persona = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce ");

		while (opcion != 0) {
			System.out.println("Introduce tu nombre");
			nombre = sc.nextLine();
			System.out.println("Introduce tu edad");
			edad = sc.nextInt();

			persona.add(new Persona(nombre, edad));
			System.out.println("Quieres continuar?");
			opcion = sc.nextInt();
			escribirPersonas(persona, nombre);
		}

	}

}