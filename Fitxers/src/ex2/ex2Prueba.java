package ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class ex2Prueba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriu el nom del fitxer:");
		String fitxer = sc.nextLine();

		escribirLetra(fitxer);

		sc.close();
	}

	public static boolean escribirLetra(String fichero) {
		boolean append = false;
		try (PrintWriter pWriter = new PrintWriter(new FileWriter(fichero, append))) {
			Scanner sc = new Scanner(System.in);
			String nuevaLinea;
			System.out.println("Escriu una paraula o linea: ");
			nuevaLinea = sc.nextLine();
			while (!nuevaLinea.equals("fi")) {
				pWriter.println(nuevaLinea);
				System.out.println("Afegit.");
				nuevaLinea = sc.nextLine();
			}
			System.out.println("fi");
		} catch (IOException e) {
			System.out.println("Error");
		}
		LinkedList<String> palabras = new LinkedList<String>();
		File file = new File(fichero);
		{
			if (file.exists()) {
				System.out.println("El fichero existe.");
				try (BufferedReader bReader = new BufferedReader(new FileReader(fichero))) {
					String linea;
					int totalPalabras = 0;
					while ((linea = bReader.readLine()) != null) {
						if (!linea.isEmpty()) {
							palabras.add(linea);
						} else {
							System.out.println("Línea vacía encontrada.");
						}
					}
					try (PrintWriter pWriter = new PrintWriter(new FileWriter(fichero, true))) {
						for (String c : palabras) {
							pWriter.print(c + " ");
							totalPalabras++;
							System.out.print(c + " ");
						}
						pWriter.print(" (Té " + totalPalabras + " paraules)");
					} catch (IOException e) {

					}
					System.out.println("(Té " + totalPalabras + " paraules)");
				} catch (FileNotFoundException e) {
					System.out.println("Fichero no existe.");
				} catch (IOException e) {
					System.out.println("Error al leer el fichero: " + e.getMessage());
				}
				return true;
			}
			System.out.println("El fichero NO existe, no se ha podido leer.");
			return false;
		}
	}
}
