
public class Caminhao extends Veiculo {

	private double cargaMax;
	
	public Caminhao(String marca, String modelo, int ano, double quilometragem, String placa, double cargaMax) {
		super(marca, modelo, ano, quilometragem, placa);
		this.cargaMax = cargaMax;
	}

	public double getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(double cargaMax) {
		this.cargaMax = cargaMax;
	}

	public String toString() {
		String retorno = super.toString();
		retorno += "Carga Máxima: " + this.cargaMax + "\n";
		return retorno;
	}
}
