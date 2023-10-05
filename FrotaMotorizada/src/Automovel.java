
public class Automovel extends Veiculo {

	private double motor;
	
	public Automovel(String marca, String modelo, int ano, double quilometragem, String placa, double motor) {
		super(marca, modelo, ano, quilometragem, placa);
		this.motor = motor;
	}

	public double getMotor() {
		return motor;
	}

	public void setMotor(double motor) {
		this.motor = motor;
	}

	public String toString() {
		String retorno = super.toString();
		retorno += "Motor: " + this.motor + "\n";
		return retorno;
	}
	
}
