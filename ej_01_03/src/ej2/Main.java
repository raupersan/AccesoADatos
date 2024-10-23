package ej2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ej1.Persona;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void escribirLibros(List<Libros> l, String ruta) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));
			oos.writeObject(l);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Libros> leerLibros(String ruta) {
		List<Libros> libros = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));
			libros = (List<Libros>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public static void main(String[] args) {
		String titulo, autor;
		int precio;
		
		List<Libros> listaLibros = new ArrayList<Libros>();
		System.out.println("Introduce los datos del libro");
		System.out.println("Titulo");
		titulo = sc.nextLine();
		System.out.println("Autor");
		autor = sc.nextLine();
		System.out.println("Precio");
		precio = sc.nextInt();
		listaLibros.add(new Libros(titulo, autor, precio));
	}

}
