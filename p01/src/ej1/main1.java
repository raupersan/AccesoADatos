package ej1;

import java.io.*;
import java.util.Scanner;
public class main1 {

	public static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Introduce la ruta del directorio que quieres listar");
		File directorio= new File (sc.nextLine());
		System.out.println(directorio.listFiles());
	}

}
