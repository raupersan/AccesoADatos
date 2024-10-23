package modeloExamen_01;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void crearFichero(File file) throws IOException {
		// Este método comprueba primero si el fichero existe, en caso contrario lo crea
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("Fichero creado");
		} else
			System.out.println("El fichero ya existe");
	}

	public static ArrayList<Persona> leerFichero(File fichero) throws IOException {
		/*
		 * Este método recibe el fichero de clase File y lee línea a línea del buffer, y
		 * de cada línea crea un objeto de la clase persona que guardará en una lista de
		 * personas
		 */
		String regex = "[;\\:]";
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		String[] texto;
		String linea;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		while ((linea = br.readLine()) != null) {
			texto = linea.split(regex);
			personas.add(new Persona(texto[0], texto[1], texto[2]));
		}
		System.out.println(personas);
		br.close();
		return personas;
	}

	public static void menuPersonas(ArrayList<Persona> personas) throws FileNotFoundException, IOException {
		String nombre, contraseña, rol;
		boolean nombreEncontrado = false;
		boolean contraseñaEncontrado = false;
		int indice = 0;
		System.out.println("Introduce tu nombre de Usuario");
		do {
			nombre = sc.nextLine();
			for (int i = 0; i < personas.size(); i++) {

				if (!nombre.equals(personas.get(i).getNombre()))
					nombreEncontrado = false;
				else {
					nombreEncontrado = true;
					indice = i;
					i = personas.size();
				}
			}
			if (!nombreEncontrado)
				System.out.println("No se ha encontrado el usuario, prueba otra vez");

		} while (nombreEncontrado == false);// Ejecutará esta parte hasta que introduzca un nombre de usuario que se
											// encuentre en el fichero
		System.out.println("Introduce tu contraseña");
		do {
			contraseña = sc.nextLine();
			if (contraseña.equals(personas.get(indice).getContraseña()))
				contraseñaEncontrado = true;
			else
				System.out.println("Contraseña incorrecta, prueba otra vez");
		} while (!contraseñaEncontrado);
		System.out.println("Eres el usuario " + personas.get(indice).getNombre());
		switch (personas.get(indice).getRol()) {

		case "administrador":
			funAdmin(personas);
			break;
		case "usuario":
			funUsuario();
			break;
		case "lector":
			System.out.println("Bienvenido");
			break;
		default:
			System.out.println("La has cagado");
			break;
		}

	}

	public static void funAdmin(ArrayList<Persona> personas) throws FileNotFoundException, IOException {
		int opcion;
		Persona persona;
		do {
			System.out.println("¿Qué quieres hacer?");
			System.out.println("1.Añadir un nuevo usuario");
			System.out.println("2.Ver datos de un usuario");
			System.out.println("3.Salir");
			opcion = sc.nextInt();
			if (opcion == 1) {
				 persona = crearUsuario(personas);
				 escribirPersona(persona ,"usuarios.txt", personas);
			}
		} while (opcion != 3);
	}

	public static void funUsuario() {
	}

	public static Persona crearUsuario(ArrayList <Persona> personas) {
		String nombre, contraseña, rol;
		boolean rolCorrecto = false;
		System.out.println("Introduce el nombre del usuario a añadir");
		sc.next();
		nombre = sc.nextLine();
		System.out.println("Introduce la contraseña");
		contraseña = sc.nextLine(); 
		System.out.println("Introduce su rol");

		do {
			rol = sc.nextLine();
			if (rol.equals("administrador")|| (rol.equals("usuario")) || (rol.equals("lector")))
				rolCorrecto = true;
			else
				System.out.println("Ese rol no existe, prueba otra vez");
		} while (!rolCorrecto);
		return new Persona(nombre, contraseña, rol);
	}
	public static ArrayList<Persona> escribirPersona(Persona persona, String ruta, ArrayList<Persona> personas) throws FileNotFoundException, IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Raul\\Desktop\\Segundo\\aad\\AccesoADatos\\modeloExamen\\usuarios.txt", true));
		bw.write("\n"+persona.getNombre()+ ";"+persona.getContraseña()+";"+persona.getRol());
		bw.close();
		personas.add(persona);
		return personas;
	}
	public static void main(String[] args) {
		String fichero = "usuarios.txt";
		File file = new File(fichero);
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			crearFichero(file);
			personas = leerFichero(file);
			menuPersonas(personas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
