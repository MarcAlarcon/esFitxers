package ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriu el nom del fitxer:");
		String fitxer = sc.nextLine();

		escribirLetra(fitxer);
	}

	public static boolean escribirLetra(String fichero) {
		boolean append = false;
		try (PrintWriter pWriter = new PrintWriter(new FileWriter(fichero, append))) {
			Scanner sc = new Scanner(System.in);
			String nuevaLinea;
			int totalPalabras = 0;

			System.out.println("Escriu una paraula o linea, per acabar posa 'fi': ");
			nuevaLinea = sc.nextLine();
			while (!nuevaLinea.equals("fi")) {
				// palabras le asignamos espacios para que cuente los espacios
				String[] palabras = nuevaLinea.split(" ");

				// contamos la longitud (espacios)
				totalPalabras += palabras.length;

				// escribir en el archvio
				pWriter.println(nuevaLinea);

				System.out.println("Afegit.");
				nuevaLinea = sc.nextLine();
			}
			System.out.println("Total de paraules escrites: " + totalPalabras);
			System.out.println("fi");
		} catch (IOException e) {
			System.out.println("Error");
		}
		return true;
	}
}