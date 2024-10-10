package FicheroAleatorio;

import java.io.*;

public class Main {

	public static void escribirFicheroAleatorio(RandomAccessFile raf, int id, String nombre, double nota) throws IOException{
		raf.writeInt(id);
		raf.writeUTF(nombre);
		raf.writeDouble(nota); 
	}
	public static Estudiante leerEstudiantesFicheroAleatorio(RandomAccessFile raf) throws IOException{
		Estudiante e =new Estudiante(raf.writeInt(),raf.readUTF(), raf.readDouble());
		
		
		return e;
	} 
	public static void anadirEstudiante(String nombreFichero, int id, double nota) {
		try(RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw")) {
		raf.seek(raf.length());
		escribirFicheroAleatorio();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void listarEstudiantes(String nombreFichero) {
		try(RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw")){
			while(raf.getFilePointer()<raf.length());
			Estudiante estudiante = leerEstudiantesFicheroAleatorio(raf);
			System.out.println(estudiante);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void buscarEstudiantePorID(String nombreFichero) {
		try(RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw")){
			while(raf.getFilePointer()<raf.length());{
			Estudiante estudiante = leerEstudiantesFicheroAleatorio(raf);
			System.out.println(estudiante);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String nombreFichero="Estudiantes.dat";
		
		añadirEstudiante(nombreFichero, 1, "Dionisio", 10.00);
		listarEstudiantes(nombreFichero);
		Estudiante e = buscarEstudiantePorID(nombreFichero, 2);
		if(e!=null) {
			System.out.println("Se ha encontrado el estudiante " + e);
			}
		else
			System.out.println("No existe un estudiante con ese ID");
		
	}

}
