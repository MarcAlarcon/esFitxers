package ventaVehicles;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Vehicles implements Comparable<Vehicles> {
	private String matricula;
	protected double km;

	public Vehicles(String matricula, double km) throws MatriculaInvalidaException {
		if (!compMatricula(matricula)) {
			throw new MatriculaInvalidaException("Matricula invalida: " + matricula);
		}
		this.matricula = matricula;
		this.km = km;
	}

	private static final List<String> CP = Arrays.asList("A", "AB", "AL", "AV", "B", "BA", "BI", "BU", "C", "CA", "CC",
			"CS", "CR", "CO", "CU", "GE", "GR", "GU", "H", "HU", "J", "L", "LE", "LO", "LU", "M", "MA", "MU", "O", "OR",
			"P", "NA", "PM", "PO", "S", "SA", "SS", "SG", "SE", "SO", "T", "TE", "GC", "TF", "TO", "V", "VA", "VI", "Z",
			"ZA", "CE", "ML", "GI", "OU", "IB");

	public static boolean compMatricula(String matricula) {
		String cadena = CP + "{1,2}-[0-9]{4}-[A-Z]{2}||[0-9]{4}-[BCDFGHJKLMNPRSTVWXYZ]{3}";
		boolean mat = Pattern.matches(cadena, matricula);
		return mat;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (!compMatricula(matricula)) {
			throw new IllegalArgumentException("Matricula invalida: " + matricula);
		}
		this.matricula = matricula;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Vehicles [matricula=" + matricula + ", km=" + km + "]";
	}

	@Override
	public int compareTo(Vehicles other) {
		return this.matricula.compareTo(other.matricula);
	}

	public abstract double calcularDescompte();
}