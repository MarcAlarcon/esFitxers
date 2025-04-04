package ventaVehicles;

class Cotxes extends Vehicles {

	private boolean classic = false;

	public Cotxes(String matricula, double km, boolean classic) throws MatriculaInvalidaException {
		super(matricula, km);
		this.classic = classic;
	}

	public boolean isClassic() {
		return classic;
	}

	public void setClassic(boolean classic) {
		this.classic = classic;
	}

	@Override
	public String toString() {
		return "\nCotxes [matricula=" + getMatricula() + ", km=" + getKm() + ", classic=" + classic + "]";
	}

	public double calcularDescompte() {
		if (classic) {
			return 0.0;
		} else {
			double perDesc = getKm() / 10000.0;
			if (perDesc > 10.0) {
				perDesc = 10.0;
			}
			return (int) perDesc;
		}
	}
}