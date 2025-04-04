package ventaVehicles;

public class Main {
	public static void main(String[] args) {
		try {

			Concessionaris.leerFichero("cotxe");

		} catch (MatriculaInvalidaException ex) {
			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}

	}
}