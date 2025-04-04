package ex1;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriu el nom del fitxer:");
		String fitxer = sc.nextLine();

		Metodos.leerFichero(fitxer);

		sc.close();
	}

}
