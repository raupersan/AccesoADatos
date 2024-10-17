package repasoExamen;

import java.io.*;
public class Main_01 {

	private static void leerVentas(String nombreFichero, String [][] datos) {
		String linea;
		int numeroProductos= datos.length;
		try(BufferedReader bf = new BufferedReader (new FileReader(nombreFichero))) {
			while((linea=bf.readLine())!=null) {
				String[]partesLinea=linea.split(",");
				//partesLinea[0] tiene el nombre del producto
				//partesLinea[1] tiene la cantidad en forma de String
				
				int indice =0;
				boolean encontrado = false;
				while(indice<numeroProductos && !encontrado) {
					if(datos[indice][0].equals(partesLinea[0])) {
						encontrado=true;
					}
					else
						indice++;
				}
				if(encontrado) {
					//ya existe el producto por lo que índice apunta a su posición
					int cantidad = Integer.parseInt(datos[indice][1])+Integer.parseInt(datos[indice][2]);
				}
				else {
					//Añadiríamos el elementos
					//En dinamico add
					datos[numeroProductos][0]=partesLinea[0];
					datos[numeroProductos][1]=partesLinea[1];
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String [][] datos = new String [100][2]; //Max 100 productos
		String nombreFichero="ventasProductos.txt";
	}

}
