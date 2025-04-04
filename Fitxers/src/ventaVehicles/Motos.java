package ventaVehicles;

class Motos extends Vehicles {

	private int cilindrada;

	public Motos(String matricula, double km, int cilindrada) throws MatriculaInvalidaException {
		super(matricula, km);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "\nMotos [matricula=" + getMatricula() + ", km=" + getKm() + ", cilindrada=" + cilindrada + "]";
	}

	public double calcularDescompte() {
		double perDesc = 0.0;
		if (cilindrada <= 125) {
			perDesc = (getKm() / 5000.0) * 2;
			if (perDesc > 20.0) {
				perDesc = 20.0;
			}
		} else {
			perDesc = getKm() / 10000.0;
			if (perDesc > 20.0) {
				perDesc = 20.0;
			}
		}
		return (int) perDesc;
	}
}
