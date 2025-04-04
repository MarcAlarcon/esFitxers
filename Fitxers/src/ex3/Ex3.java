package ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {
	public static void Main(String[] args) {

	}

	public boolean vehicle(String fichero) {
		File file = new File(fichero);
		{
			if (file.exists()) {
				System.out.println("el fitxer existeix");
				try (BufferedReader bReader = new BufferedReader(new FileReader(fichero))) {
					String linea;
					int total = 0;
					while ((linea = bReader.readLine()) != null) {
						try {
							String[] vehicles;
							total = total + Integer.parseInt(linea);
							System.out.println(linea);
						} catch (NumberFormatException e) {
							System.out.println("Esto no es un numero: " + linea);
						}
					}
					System.out.println("El total es: " + total);
				} catch (FileNotFoundException e) {
					System.out.println("Fitxer no existeix");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				return true;
			}
			System.out.println("el fitxer NO existeix, no s'ha pogut llegir");
			return false;
		}
	}
}
