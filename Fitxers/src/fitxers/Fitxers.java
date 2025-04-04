package fitxers;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Fitxers {
	public static void main(String[] args) {
		File file = new File("fitxer");
		{
			if (file.exists()) {
				System.out.println("el fitxer existeix");
			} else {
				System.out.println("el fitxer NO existeix, el creem");
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("path: " + file.getPath()); // fitxer
			System.out.println("path absolut: " + file.getAbsolutePath()); // {path_to_file}/fitxer
			System.out.println("ultima modificació : " + new Date(file.lastModified()));
			System.out.println("longitud : " + file.length());

			file.setExecutable(true);

			if (file.canExecute()) {
				System.out.println("execució");
			}
			if (file.canRead()) {
				System.out.println("lectura");
			}
			if (file.canWrite()) {
				System.out.println("escriptura");
			}
			if (file.isFile()) {
				System.out.println("fitxer");
			}
			if (file.isDirectory()) {
				System.out.println("directori");
			}
			if (file.isHidden()) {
				System.out.println("ocult");
			}

			File dir = new File("directori");
			if (dir.exists()) {
				System.out.println("el directori existeix");
			} else {
				System.out.println("el directori NO existeix, el creem");
				dir.mkdir();
			}
			if (dir.isDirectory()) {
				System.out.println("directori");
			}

			String[] fitxers = dir.list();
			for (int i = 0; i < fitxers.length; i++) {
				System.out.println("fitxer " + fitxers[i]);
			}
		}
	}

} //Hola
