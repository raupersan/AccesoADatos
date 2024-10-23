package practicaExamen_02_Lectura;


import java.io.*;
public class Main_01 {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\Raul\\Desktop\\Segundo\\aad\\AccesoADatos\\frutas.txt";
		File fichero = new File(ruta);
		char [] texto = new char[1000];
		try {
			FileReader fr = new FileReader(fichero);
			fr.read(texto,0,8);
			System.out.println(fr.getEncoding());
			
			System.out.println(texto);
			
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
