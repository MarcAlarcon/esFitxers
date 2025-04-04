package ventaVehicles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Concessionaris {

	public void compDesc() {
		for (Vehicles v : vehicles) {
			System.out.println("El descompte es de: " + v.calcularDescompte() + "%");
		}
	}

	public double calculMitj() {
		double totalKm = 0;
		for (Vehicles v : vehicles) {
			totalKm += v.getKm();
		}
		return vehicles.isEmpty() ? 0 : totalKm / vehicles.size();
	}

	@Override
	public String toString() {
		return "Concessionaris [vehicles=" + vehicles + "]";
	}

	public static final int limitVehiclesConcesionarios = 10;
	private String adreca;
	private TreeSet<Vehicles> vehicles;

	public void sumaVehic(Vehicles vehicle) {
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

	public Concessionaris(String adreca) {
		this.adreca = adreca;
		this.vehicles = new TreeSet<>();
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

	public boolean leerFichero(String fichero) throws MatriculaInvalidaException {
		File file = new File(fichero);
		if (file.exists()) {
			System.out.println("El fitxer existeix");
			try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
				String linea;
				while ((linea = bReader.readLine()) != null) {
					if (!linea.startsWith("#")) {
						String[] palabras = linea.split("; ");
						try {
							if (palabras[0].equals("cotxe")) {
								vehicles.add(new Cotxes(palabras[1], Integer.parseInt(palabras[2]),
										Boolean.parseBoolean(palabras[3])));
							} else if (palabras[0].equals("moto")) {
								vehicles.add(new Motos(palabras[1], Integer.parseInt(palabras[2]),
										Integer.parseInt(palabras[3])));
							}
						} catch (NumberFormatException | MatriculaInvalidaException e) {
							System.out.println(e.getMessage());
						}
					} else {
						System.out.println("Es un comentario con #, no se añade");
					}
				}
			} catch (IOException e) {
				System.out.println("Error leyendo el archivo: " + e.getMessage());
			}
			return true;
		} else {
			System.out.println("El fitxer no existeix, no s'ha pogut llegir");
			return false;
		}
	}
}
