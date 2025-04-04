package ventaVehicles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Concessionaris {

	public void compDesc() {
		Iterator<Vehicles> iter = vehicles.iterator();
		while (iter.hasNext()) {
			Vehicles v = iter.next();
			System.out.println("El descompte es de: " + v.calcularDescompte() + "%");
		}
	}

	public double calculMitj() {
		double totalKm = 0;
		Iterator<Vehicles> iter = vehicles.iterator();
		while (iter.hasNext()) {
			totalKm += iter.next().getKm();
		}
		return totalKm / vehicles.size();
	}

	@Override
	public String toString() {
		return "Concessionaris [vehicles=" + vehicles + "]";
	}

	public static final int limitVehiclesConcesionarios = 10;
	private String adreca;
	private static TreeSet<Vehicles> vehicles;

	public static void sumaVehic(Vehicles vehicle) {
		if (vehicles.size() < limitVehiclesConcesionarios) {
			vehicles.add(vehicle);
		} else {
			System.out.println("Està ple");
		}
	}

	public Vehicles treureVehic(String matricula) {
		Iterator<Vehicles> iter = vehicles.iterator();
		while (iter.hasNext()) {
			Vehicles v = iter.next();
			if (matricula.equals(v.getMatricula())) {
				iter.remove();
				System.out.println("El vehiculo " + matricula + " se ha eliminado.");
				return v;
			}
		}
		System.out.println("No existe el vehiculo " + matricula);
		return null;
	}

	public Concessionaris(String adreca) throws MatriculaInvalidaException {
		this.adreca = adreca;
		this.vehicles = new TreeSet<Vehicles>();
	}

	public int totalVehic() {
		return vehicles.size();
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public TreeSet<Vehicles> getVehicles() {
		return vehicles;
	}

	public void setVehicles(TreeSet<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}

	public static int getLimitvehiclesconcesionarios() {
		return limitVehiclesConcesionarios;
	}

	public static void Main(String[] args) {

	}

	public static boolean leerFichero(String fichero) throws MatriculaInvalidaException {
		File file = new File(fichero);
		{
			if (file.exists()) {
				System.out.println("el fitxer existeix");
				try (BufferedReader bReader = new BufferedReader(new FileReader(fichero))) {
					String linea = "";
					String[] palabras = linea.split("; ");
					int total = 0;
					Vehicles v;
					while ((linea = bReader.readLine()) != null) {
						try {
							if (linea.startsWith("#")) {
								System.out.println("Es un # asi que no se añade");
								if (palabras[0].equals("cotxe")) {
									vehicles.add(new Cotxes(palabras[1], Integer.parseInt(palabras[2]),
											Boolean.parseBoolean(palabras[3])));
								}
								if (palabras[0].equals("cotxe")) {
									vehicles.add(new Motos(palabras[1], Integer.parseInt(palabras[2]),
											Integer.parseInt(palabras[3])));
								}
							} /*
								 * else { palabras = linea.split("; "); for (int i = 0; i < palabras.length;
								 * i++) { System.out.print(palabras[i] + " "); } System.out.println(""); }
								 */

						} catch (NumberFormatException e) {
							System.out.println("");
						} catch (MatriculaInvalidaException e) {
							System.out.println();
						}
					}
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
