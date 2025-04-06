package sin_SQL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import sin_SQL.Cliente;

public class Login {
	static Scanner sc = new Scanner(System.in);

	public static void login(ArrayList<Cliente> listaClientes, ArrayList<Gasolinera> listaGasolineras, Path tickets,
			Path dir, String ficheroBin) throws FileNotFoundException, IOException {
		String num;
		String contra;
		System.out.println("Introduce tu número de cliente");
		num = sc.nextLine();
		System.out.println("Introduce tu contraseña");
		contra = sc.nextLine();
		if (num.equals("1"))
			Menu.menuAdmin(listaClientes, listaGasolineras, tickets, dir, ficheroBin);
		else {
			for (Cliente c : listaClientes) {
				if (c.getNombre().equals(num)) {
					Menu.menuUsuario(listaGasolineras, c, tickets, dir, listaClientes);
				}
			}
		}		
	}

}
