package ej3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ej2.Libros;

public class Main {

	
	static Scanner sc = new Scanner(System.in);

	public static void escribirAlumnos(List<Libros> l, String ruta) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));
			oos.writeObject(l);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Alumno> leerAlumnos(String ruta) {
		List<Alumno> alumnos = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));
			alumnos = (List<Alumno>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	public static void main(String[] args) {
		String nombre, apellido;
		int nota;
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		System.out.println("Introduce el nombre del alumno");
		nombre=sc.nextLine();
		System.out.println("Introduce su apellido");
		apellido=sc.nextLine();
		System.out.println("Introduce su nota");
		nota=sc.nextInt();
		listaAlumnos.add(new Alumno(nombre, apellido, nota));
		for (int i=0; i<listaAlumnos.size(); i++) {
			if(listaAlumnos.get(i).getNota()<5) {
				System.out.println(listaAlumnos.get(i).getNombre()+ " ha suspendido");
			}
			else
				System.out.println(listaAlumnos.get(i).getNombre()+ " ha aprobado");
		}
	}

}
