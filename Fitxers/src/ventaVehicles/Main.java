package ventaVehicles;

public class Main {
	public static void main(String[] args) {
		try {
			Concessionaris c = new Concessionaris("Caracola");
			c.leerFichero("cotxe");
		} catch (MatriculaInvalidaException e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
